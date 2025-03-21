
import 'package:bishop/bishop.dart';
import 'package:chess_game/constants.dart';
import 'package:chess_game/widgets/main_auth_button.dart';
import 'package:chess_game/widgets/widgets.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../helper/helper_method.dart';
import '../models/user_model.dart';
import '../providers/authantication_provider.dart';
import '../services/assets_manager.dart';
import '../widgets/SocialButton.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  GlobalKey<FormState> formKey = GlobalKey<FormState>();
  late String emailAddress;
  late String password;
  bool passHide=true;


  // sign in user
  void signIn()async{
    final authProvider = context.read<AuthenticationProvider>();
    if(formKey.currentState!.validate()){
      // save data form
      formKey.currentState!.save();
      UserCredential? userCredential;
      try{
        userCredential = await authProvider.signInUserWithEmailAndPassword(
          email: emailAddress,
          password: password,
        );
      }on FirebaseAuthException catch(e){
        authProvider.setIsLoading(value: false);
        if (e.code == 'user-not-found') {
          print("No user found with this email.");
          showSnackBar(context: context, content: "No user found with this email.");
        } else if (e.code == 'wrong-password') {
          print("Wrong password! Please try again.");
          showSnackBar(context: context, content: "wrong-password.");
        } else {
          print("Error: ${e.message}");
          showSnackBar(context: context, content: e.toString());
        }
      } catch (e) {
        authProvider.setIsLoading(value: false);
        print("Unexpected error: $e");
        showSnackBar(context: context, content: "Something Wrong!");
      }
      if(userCredential!=null){
        print("signIn Success");
        // check user exist in fireStore
        bool userExist = false;
        try{
           userExist = await authProvider.checkUserExist();
        }catch(e){
          showSnackBar(context: context, content: e.toString());
          print(e.toString());
        }
        if(userExist){
          // get user data from sharedPreference
          try{
            await authProvider.getUserDataFromFireStore();
          }catch(e){
            print(e.toString());
            showSnackBar(context: context, content: e.toString());
          }

          // save user data to sharedPreferences
          await authProvider.saveUserDataToSharedPref();

          // save this user as SignedIn
          await authProvider.setSignedIn();
          formKey.currentState!.reset();

          authProvider.setIsLoading(value: false);

          // navigate to homeScreen
          navigate(isSignedIn : true);
        }
        else{
          navigate(isSignedIn: false);
          authProvider.setIsLoading(value: false);
          ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text("Data Not Found in Database!\n Try Again", textAlign: TextAlign.center,)));
        }
      }
      else{
        // for wrong user id or pass we get exception!
      }
    }
    else{
      ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text("Please, Fill all fields")));
    }
  }

  void navigate({ required bool isSignedIn}){
    if(isSignedIn){
      Navigator.pushNamedAndRemoveUntil(
          context, Constants.homeScreen, (route) =>false);
    }
    else{
      // navigate to user Information Screen
    }
  }

  @override
  Widget build(BuildContext context) {
    final authProvider = context.watch<AuthenticationProvider>();
    return Scaffold(
      body: Form(
        key: formKey,
        child: Center(
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: SingleChildScrollView(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  CircleAvatar(
                    radius: 50,
                    foregroundImage: AssetImage('assets/images/Chess_image_1y.jpg'),
                    backgroundColor: Colors.red,
                    foregroundColor: Colors.black,
                  ),
                  SizedBox(
                    height: 10,
                  ),
                  Text("Sign In", style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold),),

                  SizedBox(
                      height: 20,
                  ),
                  TextFormField(
                    decoration: textFormDecoration.copyWith(
                      labelText: "Email",
                      hintText: "Enter Your Email Here...",
                      counterText: "",
                    ),
                    onChanged: (value) {
                      emailAddress = value.trim();
                    },
                    validator: (value){
                      if(value!.isEmpty){
                        return "Please Enter Your Email here.";
                      }
                      else if(!emailValid(value)){
                        return "Invalid Email!";
                      }
                      return null;
                    },
                  ),
                  SizedBox(
                    height: 30,
                  ),
                  TextFormField(
                    decoration: textFormDecoration.copyWith(
                      hintText: "Enter Your Password Here...",
                      labelText: "Password",
                      suffixIcon: IconButton(onPressed: (){
                          passHide = !passHide;
                          setState(() {

                          });
                        },
                        icon: passHide? Icon(Icons.visibility_off) : Icon(Icons.visibility),
                      )
                    ),
                    obscureText: passHide,
                    onChanged: (value){
                      password = value.trim();
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
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  Align(
                    alignment: Alignment.centerRight,
                    child: TextButton(onPressed: (){}, child: Text("Forgot password?")),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  authProvider.isLoading? CircularProgressIndicator()
                  :
                  MainAuthButton(
                    label: "Sign In",
                    onPressed: (){
                      signIn();
                      print("jhii");

                    },
                    fontSize: 20,
                  ),
                  SizedBox(
                    height: 30,
                  ),
                  Text("-OR-\nSign In With",textAlign: TextAlign.center,style: TextStyle(fontWeight: FontWeight.w500,color: Colors.grey, fontSize: 16),),
                  const SizedBox(
                    height: 20,
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      SocialButton(label: "Guest",height: 55, width: 55, onTap: (){}, assetsImage: AssetsManager.userIcon),
                      SocialButton(label: "Google", height: 55, width: 55, onTap: (){}, assetsImage: AssetsManager.googleIcon),
                      SocialButton(label: "Facebook", height: 55, width: 55, onTap: (){}, assetsImage: AssetsManager.facebookIcon),
                    ],
                  ),
                  const SizedBox(
                    height: 20,
                  ),
                  HaveAccountWidget(
                    label: "Don't Have Account? ",
                    actionLabel: "Sign Up Here",
                    onPressed: (){
                      // Navigate to sugnUp Screen
                      authProvider.setIsLoading(value: false);
                      Navigator.pushNamed(context, Constants.signUpScreen,);
                    },
                  ),
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
    required this.onPressed,
  });
  final String label;
  final String actionLabel;
  final Function() onPressed;

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(label, style: TextStyle(color: Colors.black, fontSize: 18, fontWeight: FontWeight.bold),),
        TextButton(onPressed:onPressed , child: Text(actionLabel, style: TextStyle(color: Colors.orange, fontSize: 18, fontWeight: FontWeight.bold),)),
      ],
    );
  }
}

