import 'package:chess_game/constants.dart';
import 'package:chess_game/providers/authantication_provider.dart';
import 'package:chess_game/services/assets_manager.dart';
import 'package:chess_game/widgets/widgets.dart';
import 'package:flutter/material.dart';
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
        await authProvider.getUserDataFromFireStore();

        // get user data from shared preference
        print("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        await authProvider.saveUserDataToSharedPref();

        //navigate to home screen
        print("ccccccccccccccccccccccccccccc");
        navigate(isSignedIn: true);

      }catch(e){
        print("xyz@${e.toString()}");
        showSnackBar(context: context, content: e.toString());
      }
    }
    else{
      // Navigate to sigin screen
      navigate(isSignedIn: false);
    }
  }

  void navigate({required bool isSignedIn}){
    if(isSignedIn){
      Navigator.pushReplacementNamed(context, Constants.homeScreen);
    }
    else{
      Navigator.pushReplacementNamed(context, Constants.signInScreen);
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
            backgroundImage: AssetImage(AssetsManager.chessIcon),
          ),
        ),
      ),
    );
  }


}
