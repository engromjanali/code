import 'dart:io';

import 'package:chess_game/models/user_model.dart';
import 'package:chess_game/providers/authantication_provider.dart';
import 'package:chess_game/widgets/widgets.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:image_cropper/image_cropper.dart';
import 'package:provider/provider.dart';

import '../constants.dart';
import '../helper/helper_method.dart';
import '../services/assets_manager.dart';
import '../widgets/SocialButton.dart';
import '../widgets/main_auth_button.dart';

class SignUpScreen extends StatefulWidget {
  const SignUpScreen({super.key});

  @override
  State<SignUpScreen> createState() => _SignUpScreenState();
}

class _SignUpScreenState extends State<SignUpScreen> {
  File? finalFileImage;
  String fileImageUrl = "";
  late String fullName;
  late String emailAddress;
  late String password;
  bool hidePasswprd = true;

  GlobalKey<FormState> formKey = GlobalKey<FormState>();


  void selectImage({
    required bool fromCamera,
  })async{
    File? takeImage =
      await pickImage(
        context: context,
        fromCamera: fromCamera,
        onFail: (e){
          // show error message
          showSnackBar(context: context, content: e.toString());
        },
      );
    if(takeImage!=null){
      cropImage(takeImage.path);
    }
    // popDialog();
  }


  void signUp()async{
    final authProvider = context.read<AuthenticationProvider>();
    if(formKey.currentState!.validate()){
      // save data form
      formKey.currentState!.save();

      UserCredential? userCredential = await authProvider.createUserWithEmailAndPassword(
        email: emailAddress,
        password: password,
      );
      if(userCredential!=null){
        // user has been created- now we save the user to fireStore
        // send Email Verification


        print("signup Success");
        print("user id : ${userCredential.user!.uid}");

        UserModel userModel = UserModel(
          email: emailAddress,
          name: fullName,
          image: "",
          createdAt: "",
          uId: userCredential.user!.uid,
          userRating: 1200,
        );

        authProvider.saveUserDataToFireStore(
          currentUser: userModel,
          fileImage: finalFileImage,
          onSuccess: ()async{
            formKey.currentState!.reset();
            ScaffoldMessenger.of(context).showSnackBar(SnackBar(content:Text("Sign Up Successfully")));

            await authProvider.signOutUser();
            popCurrentContext();
          },
          onFail: (error){
            showSnackBar(context: context, content: error.toString()); // using function
            // ScaffoldMessenger.of(context).showSnackBar(SnackBar(content:Text(error.toString()))); // direct
          },
        );
      }
      else{
        showSnackBar(context: context, content: "SignUp Fail");
      }
    }
    else{
      // showSnackBar(context: context, content: "Please, Fill all fields");
      ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text("Please, Fill all fields")));
    }
  }

  void cropImage(String path)async{
    print("image get");
    CroppedFile? croppedFile = await ImageCropper().cropImage(
      sourcePath: path,
      maxHeight: 800,
      maxWidth: 800,
    );
    popCurrentContext();
    if(croppedFile!=null){
      print("get Croped Image");
      setState(() {
        finalFileImage = File(croppedFile.path);
      });
    }
  }

  void popCurrentContext(){
    Navigator.pop(context);
  }

  void showImagePickerDialog(){
    showDialog(
      context: context,
      builder: (context){
        return AlertDialog(
          title: Text("choose from -"),
          content: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            mainAxisSize: MainAxisSize.min,
            children: [
              ListTile(
                leading: Icon(Icons.camera_alt),
                title: Text("Camera"),
                onTap: (){
                  // choose image from Camera
                  selectImage(fromCamera: true);
                },
              ),
              ListTile(
                leading: Icon(Icons.image),
                title: Text("Gallery"),
                onTap: (){
                  //  choose image from Gallery
                  selectImage(fromCamera: false);
                },
              ),
            ],
          ),
        );
      }
    );
  }





  @override
  Widget build(BuildContext context) {
    final AuthenticationProvider authProvider = context.watch<AuthenticationProvider>();
    return Scaffold(
      body: Center(
        child: Form(
          key: formKey,
          child: SingleChildScrollView(
            child: Padding(
              padding: const EdgeInsets.all(8.0),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.end,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Text("Sign In", style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold),),
                  SizedBox(
                    height: 10,
                  ),
                  Stack(
                    children: [
                      CircleAvatar(
                        radius: 50,
                        foregroundImage: finalFileImage==null? AssetImage(AssetsManager.userIcon) : FileImage(File(finalFileImage!.path)),
                        backgroundColor: Colors.red,
                        foregroundColor: Colors.black,
                      ),
                      Positioned(
                        bottom: 0,
                        right: 0,
                        child: Container(
                          decoration: BoxDecoration(
                            border : Border.all(color: Colors.white, width: 2),
                            color: Colors.lightBlue,
                            shape: BoxShape.circle,
                          ),
                          child: IconButton(
                            icon: const Icon(
                              Icons.camera_alt,
                              color: Colors.white,
                              size: 30,
                            ),
                            onPressed: () {
                              // pick image from camera or galery
                              showImagePickerDialog();
                            },
                          ),
                        ),
                      ),
                    ],
                    ),

                  SizedBox(
                    height: 20,
                  ),
                  TextFormField(
                    maxLines: 1,// default , remember for single line we can write new line. but for 2 line or above we can write multiline with scrollview.
                    maxLength: 50,
                    textInputAction: TextInputAction.next,
                    textCapitalization: TextCapitalization.words,
                    onChanged: (value){
                      fullName  = value.trim();
                    },
                    onSaved: (value){
                      print(value);
                    },
                    // controller: nameController, // for set name
                    validator: (value){
                      if(value!.isEmpty){
                        return "Name Can't be Empty!";
                      }
                      else if(value.length<3){
                        return "Name Must Be At-least 3 Character";
                      }
                      return null;
                    },
                    decoration: textFormDecoration.copyWith(
                      counterText: "",
                      labelText: "Full Name",
                      hintText: "Enter Your Name Here...",
                    ),
                  ),

                  SizedBox(
                    height: 20,
                  ),
                  TextFormField(
                    textInputAction: TextInputAction.next,
                    validator: (value){
                      if(value!.isEmpty){
                        return "Please Enter Your Email here.";
                      }
                      else if(!emailValid(value)){
                        return "Invalid Email!";
                      }
                      return null;
                    },
                    onChanged: (value){
                      emailAddress =value.trim();
                    },
                    decoration: textFormDecoration.copyWith(

                        labelText: "Email",
                        hintText: "Enter Your Email Here..."
                    ),
                  ),
                  SizedBox(
                    height: 30,
                  ),
                  TextFormField(
                    maxLength: 25,
                    textCapitalization: TextCapitalization.words,
                    onChanged: (value){
                      password  = value.trim();
                    },
                    validator: (value){
                      if(value!.isEmpty){
                        return "Password Can't be Empty!";
                      }
                      else if(value.length<8){
                        return "Password Must Be At-least 8 Character";
                      }
                      else if(value.length>20){
                        return "Password Can Contain maximum 20 Character";
                      }
                      return null;
                    },
                    textInputAction: TextInputAction.done,
                    decoration: textFormDecoration.copyWith(
                      hintText: "Enter Your Password Here...",
                      labelText: "Password",
                      suffixIcon: IconButton(
                        onPressed: (){
                          setState(() {
                          hidePasswprd = !hidePasswprd;
                          });
                        },
                        icon: Icon(hidePasswprd?Icons.visibility_off:Icons.visibility),
                      ),
                    ),
                    obscureText: hidePasswprd,
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  authProvider.isLoading
                      ?  CircularProgressIndicator()
                  : MainAuthButton(
                    label:"Sign Up",
                    onPressed: (){
                      signUp();
                    },
                    fontSize: 20,),
                  SizedBox(
                    height: 30,
                  ),
                  Text("-OR-",textAlign: TextAlign.center,style: TextStyle(fontWeight: FontWeight.w500,color: Colors.grey, fontSize: 16),),
                  SizedBox(
                    height: 20,
                  ),
                  HaveAccountWidget(label: "Have An Account? ", actionLabel: "Sign In Here", onPressed: (){
                    // navigate to login screen
                    authProvider.setIsLoading(value: false);
                    Navigator.pop(context);
                  }),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}


class HaveAccountWidget extends StatelessWidget {
  const HaveAccountWidget({
    super.key,
    required this.label,
    required this.actionLabel,
    required this.onPressed});
  final String label;
  final String actionLabel;
  final Function() onPressed;

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(label, style: TextStyle(color: Colors.black, fontSize: 18, fontWeight: FontWeight.bold),),
        TextButton(onPressed:onPressed, child: Text(actionLabel, style: TextStyle(color: Colors.orange, fontSize: 18, fontWeight: FontWeight.bold),)),
      ],
    );
  }
}

