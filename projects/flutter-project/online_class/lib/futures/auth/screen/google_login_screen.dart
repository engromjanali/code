import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:online_class/futures/auth/service/auth_method.dart';
import 'package:online_class/futures/home/screen/entry_screen.dart';
import 'package:online_class/core/utlity/toast_message.dart';

class GoogleLoginScreen extends StatefulWidget {
  const GoogleLoginScreen({super.key});

  @override
  State<GoogleLoginScreen> createState() => _GoogleLoginScreenState();
}

class _GoogleLoginScreenState extends State<GoogleLoginScreen> {
  bool _isLoading = false;

  Future<void> _signInWithGoogle()async{
    try{
      setState(() {
        _isLoading = true;
      });

      final userCredential = await GoogleSignInService.signInWithGoogle();

      if(!mounted) return;
      if(userCredential != null){
        if(!mounted) return;
        
        // navigate to the next screen if success
        Navigator.push(context, MaterialPageRoute(builder: (context)=>EntryScreen()));

        // login success 
        debugPrint("user login success : ${userCredential.user?.displayName}");

      }
    }catch(e){
      // for error 
      showErrorToast(context: context, description: e.toString());
    }finally{
      if(mounted){
        setState(() {
          _isLoading = false;
        });
      }
    }
  }


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Column(
          children: [
            Image.asset(
              "assets/images/login_screen.png", 
              // height: , 
              // width: 400,
              fit: BoxFit.cover,
            ),
            Spacer(),
            _isLoading? CircularProgressIndicator()
            :
            SizedBox(
              width: double.maxFinite,
              child: ElevatedButton.icon(
                onPressed: _signInWithGoogle, 
                label: Text(
                  "Sign In With Google",
                  style: TextStyle(

                    fontSize: 20,
                    color: Colors.black,
                    fontWeight: FontWeight.w600
                  ),
                ),
                icon: Image.network(
                  errorBuilder: (context, error, stackTrace) => Icon(FontAwesomeIcons.google),
                  "https://scontent.fzyl2-2.fna.fbcdn.net/v/t39.30808-6/490295869_1342466350336950_1132803492906371083_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=6ee11a&_nc_ohc=cBWtCIqEZvQQ7kNvwH_k4t7&_nc_oc=Adn1X_-r_Uh5PzjZN-v_5y_duowUN_VcDvyd9TT0uiWerYG16H2scIvnpTavev9UxI8&_nc_zt=23&_nc_ht=scontent.fzyl2-2.fna&_nc_gid=XoIwul_edtU1UTD9e2j2zA&oh=00_AfYB9H4w0a1ytI_yVsuwDxh8ZFK8g0mfRWGbnwOj_HNC7A&oe=68BF0A87",
                  height: 25,
                  width: 40,
                ),
              ),
            ),

            Spacer(),
            
          ],
        )
      
      ),
    );
  }
}