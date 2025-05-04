import 'dart:io';

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



class SettingScreen extends StatefulWidget {
  const SettingScreen({super.key});

  @override
  State<SettingScreen> createState() => _SettingScreenState();
}

class _SettingScreenState extends State<SettingScreen> {
  bool visibleCurrent = false;
  bool visibleNew = false;
  bool visibleConfirm = false;

  FocusNode FocusNodeCurrent = FocusNode(); // "shift focus to next" field
  FocusNode FocusNodeNew = FocusNode();
  FocusNode FocusNodeConfirm = FocusNode();

GlobalKey<FormState> formKey = GlobalKey<FormState>(); 




  @override
  Widget build(BuildContext context) {
    return  Scaffold(
        body : Container(
          color: Colors.grey,
          height: double.infinity,
          width: double.infinity,
          child: ListView(
            children: [
              getItem(label: "Edit Profile", icon: Icons.edit, ),
              getItem(label: "Security", icon: Icons.security, ontap: (){
                return showModalBottomSheet(
                  context: context, 
                  builder: (BuildContext content){
                    return StatefulBuilder(builder: (BuildContext context, StateSetter setModalState){
                      return Container(
                      decoration: BoxDecoration(
                        borderRadius: BorderRadius.only(topLeft: Radius.circular(20), topRight: Radius.circular(20)),
                      // color: Colors.green,
                      ),
                      height: 600,
                      width: double.infinity,
                      child: SingleChildScrollView(
                       scrollDirection: Axis.vertical,
                        child: Form(
                          key: formKey,
                          child: Column(
                            children: [
                              SizedBox(
                                height: 20,
                              ),
                              Container(
                                padding: EdgeInsets.symmetric(horizontal: 10),
                                decoration: BoxDecoration(
                                  borderRadius: BorderRadius.circular(10),
                                  color: Colors.grey.shade300,
                                  border: Border(bottom: BorderSide(color: Colors.black))
                                ),
                                margin: EdgeInsets.all(10),
                                child: TextFormField(
                                  focusNode: FocusNodeCurrent,
                                  onFieldSubmitted: (value) {
                                    FocusScope.of(context).requestFocus(FocusNodeNew);
                                  },
                                  validator: (value) {
                                    return null;
                                  },
                                  keyboardType: TextInputType.text,
                                  textInputAction: TextInputAction.next,
                                  obscureText: visibleCurrent,
                                  decoration: InputDecoration(
                                    label: Text("Current Password"),
                                    border: InputBorder.none,
                                    suffixIcon:
                                    IconButton(
                                      onPressed: (){ 
                                        setModalState(() { // the setModalState work in "showModalBottomSheet"
                                          setState(() { // the setstate work in main page
                                            
                                          });
                                          visibleCurrent = !visibleCurrent;
                                        });
                                      }, 
                                      icon: visibleCurrent? Icon(Icons.visibility) : Icon(Icons.visibility_off),
                                    ),
                                  ),
                                ),
                              ),
                              Container(
                                padding: EdgeInsets.symmetric(horizontal: 10),
                                decoration: BoxDecoration(
                                  borderRadius: BorderRadius.circular(10),
                                  color: Colors.grey.shade300,
                                  border: Border(bottom: BorderSide(color: Colors.black))
                                ),
                                margin: EdgeInsets.all(10),
                                child: TextFormField(
                                  focusNode: FocusNodeNew,
                                  onFieldSubmitted: (value){
                                    FocusScope.of(context).requestFocus(FocusNodeConfirm);
                                  },
                                  textInputAction: TextInputAction.next,
                                  obscureText: visibleNew,
                                  keyboardType: TextInputType.text,
                                  validator: (value) {
                                    return null;
                                  },
                                  decoration: InputDecoration(
                                    label: Text("New Password"),
                                    border: InputBorder.none,
                                    suffixIcon:
                                    IconButton(
                                      onPressed: (){ 
                                        setModalState(() { // the setModalState work in "showModalBottomSheet"
                                          setState(() { // the setstate work in main page
                                            
                                          });
                                          visibleNew = !visibleNew;
                                        });
                                      }, 
                                      icon: visibleNew? Icon(Icons.visibility) : Icon(Icons.visibility_off),
                                    ),
                                  ),
                                ),
                              ),
                              Container(
                                padding: EdgeInsets.symmetric(horizontal: 10),
                                decoration: BoxDecoration(
                                  borderRadius: BorderRadius.circular(10),
                                  color: Colors.grey.shade300,
                                  border: Border(bottom: BorderSide(color: Colors.black))
                                ),
                                margin: EdgeInsets.all(10),
                                child: TextFormField(
                                  focusNode: FocusNodeConfirm,
                                  onFieldSubmitted: (value){
                                    FocusScope.of(context).unfocus();
                                  },
                                  textInputAction: TextInputAction.done,
                                  obscureText: visibleConfirm,
                                  keyboardType: TextInputType.text,
                                  validator: (value) {
                                    return null;
                                  },
                                  decoration: InputDecoration(
                                    label: Text("Confirm Password"),
                                    border: InputBorder.none,
                                    suffixIcon:
                                    IconButton(
                                      onPressed: (){ 
                                        setModalState(() { // the setModalState work in "showModalBottomSheet"
                                          setState(() { // the setstate work in main page
                                            
                                          });
                                          visibleConfirm = !visibleConfirm;
                                        });
                                      }, 
                                      icon: visibleConfirm? Icon(Icons.visibility) : Icon(Icons.visibility_off),
                                    ),
                                  ),
                                ),
                              ),
                              SizedBox(
                                height: 20,
                              ),
                              TextButton(
                                onPressed: (){}, 
                                child: Text("Forgot Passwprd?", style: TextStyle(color: Colors.blue, fontSize: 16),
                                ),
                              ),
                              SizedBox(
                                height: 20,
                              ),
                              getButton()
                            ],
                          ),
                        ),
                      ),
                    );
                    });
                });
              },
              ),
              getItem(label: "Logout", icon: Icons.logout, ),
            ],
          ),
        ),
    );
  }
}

Widget getItems({required String label, required IconData icon, Function()? ontap ,required bool selected}) {
  return GestureDetector(
    onTap: ontap ?? () {},
    child: Container(
      margin: EdgeInsets.all(5),
      padding: EdgeInsets.symmetric(horizontal: 5, vertical: 5),
      decoration: BoxDecoration(
        color: Colors.grey,
        borderRadius: BorderRadius.circular(5),
      ),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Expanded(  // 💡 Let the whole row use max width if needed
            child: Row(
              children: [
                Icon(icon, size: 25),
                SizedBox(width: 8),
                Expanded(  // 💡 This makes text wrap or ellipsis
                  child: Text(
                    label,
                    style: TextStyle(fontSize: 18),
                    overflow: TextOverflow.ellipsis, // or .fade or .clip
                  ),
                ),
              ],
            ),
          ),
          selected ? Icon(Icons.ads_click, size: 20) : SizedBox.shrink(),
        ],
      ),
    ),
  );
}


Widget getItem({required String label, required IconData icon, Function()? ontap }){
  return GestureDetector(
    onTap: ontap??(){},
      child: Container(
        margin: EdgeInsets.symmetric(horizontal: 5),
        child: Card(
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Icon(icon),
                Text(label)
              ]
            ),
          ),
        ),
      ),
  );
}

Widget bazer(){
  return Container(
        color: Colors.grey,
        height: double.infinity,
        width: double.infinity,
        child: ListView(
          children: [
            
          ],
        ),
      );
}


Widget getButton(){
  return MaterialButton(
    onPressed: (){},
    shape: RoundedRectangleBorder(
      borderRadius: BorderRadius.circular(50),
    ),
    height: 50,
    color: Colors.grey,
    child: Text("submit", style: TextStyle(fontSize: 25),),);
}

-------------------  2nd Example ------------------------------------------------------------------------
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
    if(formKey.currentState!.validate()){
      // save data form
      formKey.currentState!.save();

      UserCredential? userCredential = await context.read<AuthanticationProvider>().createUserWithEmailAndPassword(
        email: emailAddress,
        password: password,
      );
      if(userCredential!=null){
        // user has been created- now we save the user to firestore
        print("signup Success");
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
    popDialog();
    if(croppedFile!=null){
      print("get Croped Image");
      setState(() {
        finalFileImage = File(croppedFile.path);
      });
    }
  }

  void popDialog(){
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
  void dispose() {
    // nameController.dispose();
    // emailController.dispose();
    // passwordController.dispose();
    super.dispose();
  }

  bool emailValid(String value){
    return RegExp(r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$').hasMatch(value);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Form(
        key: formKey,
        child: SingleChildScrollView(
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
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
                  keyboardType: TextInputType.text,
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
                    fullName  = value.trim();
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
                MainAuthButton(
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
                  Navigator.pop(context);
                }),
              ],
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
        TextButton(onPressed:onPressed, child: Text(actionLabel, style: TextStyle(color: Colors.orange, fontSize: 18, fontWeight: FontWeight.bold),)),
      ],
    );
  }
}
