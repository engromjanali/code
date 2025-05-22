import 'package:animated_splash_screen/animated_splash_screen.dart';
import 'package:bbpi/landing.dart';
import 'package:flutter/material.dart';
import 'package:lottie/lottie.dart';

class SplashScreen extends StatelessWidget {
  const SplashScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return AnimatedSplashScreen(
      splash: Center(
        child: Column(
          children: [
            LottieBuilder.asset("assets/lottie_animation/Animation - 1742774709301.json"),
          ],
        ),
      ), 
      nextScreen: const LandingScreen(),
      backgroundColor: Colors.black,
      splashIconSize: 400,
      duration: 1000,
    );
  }
}