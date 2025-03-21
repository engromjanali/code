import 'dart:convert';
import 'dart:io';

import 'package:chess_game/constants.dart';
import 'package:chess_game/models/user_model.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:firebase_storage/firebase_storage.dart';
import 'package:flutter/cupertino.dart';
import 'package:shared_preferences/shared_preferences.dart';

class AuthenticationProvider extends ChangeNotifier{
  bool _isLoading = false;
  bool _isSignedIn = false;
  String? _uId;
  UserModel? _userModel;

  // getters
  bool get isLoading => _isLoading;
  bool get isSignedIn => _isSignedIn;

  UserModel? get userModel => _userModel;
  String? get uId => _uId;

  //setter
  void setIsLoading({required bool value}){
    _isLoading = value;
    notifyListeners();
  }


  final FirebaseAuth firebaseAuth = FirebaseAuth.instance;
  final FirebaseFirestore firebaseFirestore = FirebaseFirestore.instance;
  final FirebaseStorage firebaseStorage = FirebaseStorage.instance;

  // create user with email and password
  Future<UserCredential?> createUserWithEmailAndPassword({
    required String email,
    required String password,
  }) async{
    _isLoading =true;
    notifyListeners();
    UserCredential userCredential = await firebaseAuth.createUserWithEmailAndPassword(email: email, password: password);
    _uId = userCredential.user!.uid;
    notifyListeners();
    return userCredential;
  }

  // Sign In user with email and password
  Future<UserCredential?> signInUserWithEmailAndPassword({
    required String email,
    required String password,
  }) async{
    _isLoading =true;
    notifyListeners();
    UserCredential userCredential = await firebaseAuth.signInWithEmailAndPassword(email: email, password: password);
    _uId = userCredential.user!.uid;
    notifyListeners();
    return userCredential;
  }

  // save user data to fireStore
  void saveUserDataToFireStore({
    required UserModel currentUser,
    required File? fileImage,
    required Function() onSuccess,
    required Function(String) onFail,
  })async{
    try{
      // check current user photo is not null
      if(fileImage!=null){
        // upload the image to fireStore storage
        // String imageUrl = await storeFileImageToStorage(
        //   ref: "${Constants.userImages}/$uId.jpg",
        //   file: fileImage,
        // );
        // currentUser.image = imageUrl;
        currentUser.image = "";
      }else{
        // that's mean image dose not given
        currentUser.image = "";
      }

      currentUser.createdAt = DateTime.now().microsecondsSinceEpoch.toString();

      _userModel = currentUser;

      //save Data to fireStore
      await firebaseFirestore
          .collection(Constants.users)
          .doc(uId)
          .set(currentUser.toMap());

      onSuccess();
      _isLoading = false;
      notifyListeners();
    }on FirebaseException catch(e){
      _isLoading = false;
      notifyListeners();
      onFail(e.toString());
    }
  }

  // store image ro storage and return the download url
  Future<String> storeFileImageToStorage({
    required String ref,
    required File file,
  })async{
    UploadTask uploadTask = firebaseStorage.ref().child(ref).putFile(file);
    TaskSnapshot taskSnapshot =await uploadTask;
    String downloadUrl = await taskSnapshot.ref.getDownloadURL();
    return downloadUrl;
  }

  // sign out user
  Future<void>signOutUser()async{
    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
    await firebaseAuth.signOut();
    _isSignedIn = false;
    sharedPreferences.clear();
    notifyListeners();
  }

  // check user is Exist
  Future<bool> checkUserExist()async{
    DocumentSnapshot documentSnapshot =
        await firebaseFirestore.collection(Constants.users).doc(uId).get();

    if(documentSnapshot.exists){
      return true;
    }
    else{
      return false;
    }
  }

  // get user data from fireStore
  Future getUserDataFromFireStore()async{
    await firebaseFirestore
        .collection(Constants.users)
        .doc(firebaseAuth.currentUser!.uid)
        .get()
        .then((DocumentSnapshot documentSnapshot){
      _userModel = UserModel.fromMap(documentSnapshot.data() as Map<String, dynamic>); // documentSnapshot.data() can be null
      _uId = _userModel!.uId;
      notifyListeners();
      }
    );
  }

  // store user data to sharedPreferences
  Future saveUserDataToSharedPref()async{
    SharedPreferences sharedPreferences   = await SharedPreferences.getInstance();
    await sharedPreferences.setString(Constants.userModel, jsonEncode(userModel!.toMap())); // jsonEncode convert (Map => plain Encoded Text)
  }

  // get user data to sharedPreferences
  Future getUserDataToSharedPref()async{
    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
    String data = sharedPreferences.getString(Constants.userModel) ?? "";
    _userModel = UserModel.fromMap(jsonDecode(data)); // jsonDecode convert (plain Encoded text => Map)

    _uId = _userModel!.uId;
    notifyListeners();
  }

  // set user as signIn
  Future setSignedIn()async{
    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
    await sharedPreferences.setBool(Constants.isSignedIn, true);
    _isSignedIn = true;
    notifyListeners();
  }

  // check userSignedIn
  Future<bool> checkIsSignedIn()async{
    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
    _isSignedIn =sharedPreferences.getBool(Constants.isSignedIn) ?? false;
    notifyListeners();
    return _isSignedIn;
  }

}

