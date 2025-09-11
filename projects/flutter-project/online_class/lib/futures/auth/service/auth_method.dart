import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/widgets.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:online_class/constants.dart';

class GoogleSignInService{
  static final FirebaseAuth _auth = FirebaseAuth.instance;
  static final GoogleSignIn _googleSignIn = GoogleSignIn.instance;

  static bool isInitialize = false;


  // init sign-in
  static Future<void> initSignIn()async{
    if(!isInitialize){
      await _googleSignIn.initialize(
        serverClientId: "764491896660-5b01im90hcegs1u75prbletr2sqgha5u.apps.googleusercontent.com",
      );
    }
    isInitialize = true;
  }

  // Sign in with google 
  static Future<UserCredential?> signInWithGoogle()async{
    try{
      await initSignIn();
      final GoogleSignInAccount googleUser = await _googleSignIn.authenticate();
      debugPrint("romjan ali");

      final idToken = googleUser.authentication.idToken;
      final authorizationClint = googleUser.authorizationClient;

      GoogleSignInClientAuthorization? authorization = await authorizationClint
          .authorizationForScopes(["email", "profile"]);

      final accessToken = authorization?.accessToken;
      if(accessToken == null){
        final authorization2 = await authorizationClint.authorizationForScopes(
          ["email" , "profile"],
        );

        if(authorization2?.accessToken == null){
          throw FirebaseAuthException(code: "error", message: "error");
        }

        authorization = authorization2;
      } 

      final credential  = GoogleAuthProvider.credential(
        accessToken: accessToken,
        idToken: idToken,
      );


      final UserCredential userCredential = await FirebaseAuth.instance
          .signInWithCredential(credential);

      final User? user = userCredential.user;
      if(user!= null){
        final userDoc = FirebaseFirestore.instance
            .collection("User")
            .doc(user.uid);

        final docSnapshot = await userDoc.get();

        if(!docSnapshot.exists){
          await userDoc.set({
            Constants.id : user.uid,
            Constants.name : user.displayName??"",
            Constants.email : user.email??"",
            Constants.imageUrl : user.photoURL??"",
            Constants.provider : "google",
            Constants.createdAt : FieldValue.serverTimestamp(),
          });
        }
      } 
      return userCredential;
    }catch(e){
      debugPrint("Error:$e");
      rethrow;
    }
  }

  // Sign Out 
  static Future<void> signOut()async{
    try{
      await _googleSignIn.signOut();
      await _auth.signOut();
    }catch(e){
      debugPrint("Error signing out $e");
      throw e;
    }
  }


  // get current user 
  static User? getCurrentUser(){
    return _auth.currentUser;
  }



}


// Future<bool> getIsSignedIn()async{
//   final sharedPreferences =await SharedPreferences.getInstance();
//   return sharedPreferences.getBool(Constants.isSignedIn)??false;
// }

// Future<void> setIsSignIn(bool value)async{
//   final sharedPreferences =await SharedPreferences.getInstance();
//   sharedPreferences.setBool(Constants.isSignedIn, value);
// }

