class SignUpScreen extends StatefulWidget {
  const SignUpScreen({super.key});

  @override
  State<SignUpScreen> createState() => _SignUpScreenState();
}

class _SignUpScreenState extends State<SignUpScreen> {
  String fileImageUrl = "";
  late String fullName;
  late String emailAddress;
  late String password;
  bool hidePasswprd = true;

  GlobalKey<FormState> formKey = GlobalKey<FormState>();

  
  void signUp()async{
    if(formKey.currentState!.validate()){
      // save data form
      formKey.currentState!.save(); // trigared an function in TextFormField

    }
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
                  maxLength: 20,
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
              ],
            ),
          ),
        ),
      ),
    );
  }
}


