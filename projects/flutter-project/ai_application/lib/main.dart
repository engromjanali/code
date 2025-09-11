

import 'package:ai_application/hello_screen.dart';
import 'package:ai_application/providers/user_provider.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
void main()async {
  WidgetsFlutterBinding.ensureInitialized();

  
  runApp(
    MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (_)=>UserProvider()),
      ],
      child: const MyApp(),
    )
  );
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      scaffoldMessengerKey: rootScaffoldMessengerKey,

      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),

      home:  HelloScreen(),
    );
  }
}

final GlobalKey<ScaffoldMessengerState> rootScaffoldMessengerKey =
    GlobalKey<ScaffoldMessengerState>();