
import 'package:flutter/material.dart';
import 'package:meal_hisab/constants.dart';
import 'package:meal_hisab/helper/ui_helper.dart';
import 'package:meal_hisab/provaiders/authantication_provaider.dart';
import 'package:meal_hisab/services/asset_manager.dart';
import 'package:provider/provider.dart';

class LandingScreen extends StatefulWidget {
  const LandingScreen({super.key});

  @override
  State<LandingScreen> createState() => _LandingScreenState();
}

class _LandingScreenState extends State<LandingScreen> {

  @override
  void initState() {
    // TODO: implement initState
    checkAuthenticationState();
    super.initState();
  }

  void checkAuthenticationState()async{
    final authProvider = context.read<AuthenticationProvider>();
    if(await authProvider.checkIsSignedIn()){
      try{
        // get user data from fireStore
        print("Aaaaaaaaaaaaaaaaaaaaaaa");
        await authProvider.getUserProfileData(onFail: (message) {  showSnackber(context: context, content: message.toString());}, 

        );

        // get user data from shared preference
        print("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        await authProvider.saveUserDataToSharedPref();

        //navigate to home screen
        await Future.delayed(Duration(seconds: 5));
        print("ccccccccccccccccccccccccccccc");
        print(authProvider.userModel!.email);
        navigate(isSignedIn: true);

      }catch(e){
        print("xyz@${e.toString()}");
        showSnackber(context: context, content: e.toString());
      }
    }
    else{
      // Navigate to sigin screen
      navigate(isSignedIn: false);
    }
  }

  void navigate({required bool isSignedIn}){
    if(isSignedIn){
      Navigator.pushReplacementNamed(context, Constants.HomeScreen);
    }
    else{
      Navigator.pushReplacementNamed(context, Constants.logInScreen);
    }
  }


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        color: Colors.white10,
        child: Center(
          child: CircleAvatar(
            radius: 100,
            backgroundColor: Colors.black45,
            backgroundImage: AssetImage(AssetsManager.bbpiLogo),
          ),
        ),
      ),
    );
  }


}
