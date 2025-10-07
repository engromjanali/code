

import 'package:flutter/material.dart';
import 'package:get/get.dart';

class CTheme extends GetxController {
  int currentIndex = 0;

  late List<ThemeData> themeList = [_lightTheme, _darkTheme];

  ThemeData get currentTheme => themeList[currentIndex];
  Color backGroundColor = Colors.white;
  Color backGroundColorDark = Colors.black;

  void updateTheme(int index) async {
    currentIndex = index;
    debugPrint(currentIndex.toString());
    update();
    // SharedPrefService.instance.setInt(PKeys.themeIndex, index);
  }

  late final ThemeData _lightTheme = ThemeData(
    // ▶️ Core Configuration
    brightness: Brightness.light,
    useMaterial3: true,
    primaryColor: Colors.white,
    scaffoldBackgroundColor: backGroundColor,
    splashColor: const Color(0xFF6F23FD).withValues(alpha: 0.1),
    highlightColor: Colors.transparent,
    splashFactory: InkRipple.splashFactory,
    canvasColor: Colors.black.withValues(alpha: 0.05),
    dividerColor: Colors.grey[300],

    // ▶️ AppBar Theme
    appBarTheme: AppBarTheme(
      iconTheme: const IconThemeData(color: Colors.black),
      // titleTextStyle: TextStyle(
      //   color: Colors.black,
      //   fontWeight: FontWeight.w600,
      //   fontSize: 20.sp,
      // ),
    ),

    // ▶️ Drawer Theme
    drawerTheme: const DrawerThemeData(
      scrimColor: Colors.white,
    ),

    // ▶️ Text Theme
    textTheme: TextTheme(
      // bodyLarge: TextStyle(
      //   color: const Color(0xFF292929),
      //   fontSize: 14.sp,
      //   fontWeight: FontWeight.w400,
      // ),
      // bodyMedium: TextStyle(
      //   color: Colors.white,
      //   fontSize: 14.sp,
      //   fontWeight: FontWeight.w400,
      // ),
      // bodySmall: TextStyle(
      //   color: const Color(0xff34C759),
      //   fontSize: 14.sp,
      //   fontWeight: FontWeight.w400,
      // ),
      // displayLarge: TextStyle(
      //   color: Colors.black54,
      //   fontSize: 14.sp,
      //   fontWeight: FontWeight.w400,
      // ),
      // displaySmall: TextStyle(
      //   color: Colors.black,
      //   fontSize: 14.sp,
      //   fontWeight: FontWeight.w400,
      // ),
    ),

    // ▶️ Input Field Theme
    inputDecorationTheme: InputDecorationTheme(
      filled: true,
      fillColor: Colors.white,
      // hintStyle: TextStyle(
      //   color: const Color(0xFFA0A0A0),
      //   fontSize: 15.sp,
      //   fontWeight: FontWeight.w400,
      // ),
      // errorStyle: TextStyle(
      //   color: Colors.red,
      //   fontSize: 12.sp,
      //   fontWeight: FontWeight.w400,
      // ),
      // border: OutlineInputBorder(
      //   borderRadius: BorderRadius.all(Radius.circular(PDimension.boarderRadius)),
      //   borderSide: const BorderSide(color: Color(0xFF8391A1), width: 0.5),
      // ),
      // focusedBorder: OutlineInputBorder(
      //   borderRadius: BorderRadius.all(Radius.circular(PDimension.boarderRadius)),
      //   borderSide: const BorderSide(color: Color(0xFF8391A1), width: 0.5),
      // ),
      // enabledBorder: OutlineInputBorder(
      //   borderRadius: BorderRadius.all(Radius.circular(PDimension.boarderRadius)),
      //   borderSide: const BorderSide(color: Color(0xFF8391A1), width: 0.5),
      // ),
      // errorBorder: OutlineInputBorder(
      //   borderRadius: BorderRadius.all(Radius.circular(PDimension.boarderRadius)),
      //   borderSide: const BorderSide(color: Color(0xFF8391A1), width: 0.5),
      // ),
      // disabledBorder: OutlineInputBorder(
      //   borderRadius: BorderRadius.all(Radius.circular(PDimension.boarderRadius)),
      //   borderSide: const BorderSide(color: Color(0xFF8391A1), width: 0.5),
      // ),
      // focusedErrorBorder: OutlineInputBorder(
      //   borderRadius: BorderRadius.all(Radius.circular(PDimension.boarderRadius)),
      //   borderSide: const BorderSide(color: Color(0xFF8391A1), width: 0.5),
      // ),
    ),

    // ▶️ Button Theme
    buttonTheme: ButtonThemeData(
      colorScheme: ColorScheme.fromSeed(
        seedColor: const Color(0xFF002E5B),
        secondary: const Color(0xFF3AADE1),
        tertiary: Colors.white,
        shadow: Colors.grey.withValues(alpha: 0.1),
      ),
      highlightColor: Colors.white,
    ),

    // ▶️ Outlined Button Theme
    outlinedButtonTheme: OutlinedButtonThemeData(
      style: ButtonStyle(
        // padding: WidgetStatePropertyAll<EdgeInsetsGeometry>(
        //   EdgeInsets.symmetric(horizontal: 12.w),
        // ),
        side: const WidgetStatePropertyAll<BorderSide>(
          BorderSide(width: 1.0),
        ),
        backgroundColor: const WidgetStatePropertyAll<Color?>(
          Colors.transparent,
        ),
      ),
    ),
  );

  late final ThemeData _darkTheme = ThemeData(
    // ▶️ Core Configuration
    brightness: Brightness.dark,
    scaffoldBackgroundColor: backGroundColorDark,
    splashColor: const Color(0xFF6F23FD).withValues(alpha: 0.1),
    highlightColor: Colors.transparent,
    splashFactory: InkRipple.splashFactory,
    primaryColor: Colors.black,
    dividerColor: Colors.grey[300],
    cardColor: Colors.black,

    // ▶️ Drawer Theme
    drawerTheme: const DrawerThemeData(
      scrimColor: Colors.white,
    ),

    // ▶️ Text Theme
    textTheme: TextTheme(
      // bodyLarge: TextStyle(
      //   color: Colors.white,
      //   fontSize: 14.sp,
      //   fontWeight: FontWeight.w400,
      // ),
      // bodyMedium: TextStyle(
      //   color: Colors.black,
      //   fontSize: 14.sp,
      //   fontWeight: FontWeight.w400,
      // ),
      // bodySmall: TextStyle(
      //   color: const Color(0xff34C759),
      //   fontSize: 14.sp,
      //   fontWeight: FontWeight.w400,
      // ),
      // displayLarge: TextStyle(
      //   color: Colors.white70,
      //   fontSize: 14.sp,
      //   fontWeight: FontWeight.w400,
      // ),
    ),

    // ▶️ Input Decoration Theme
    inputDecorationTheme: InputDecorationTheme(
      hintStyle: const TextStyle(fontWeight: FontWeight.w400, fontSize: 14),
      // errorStyle: TextStyle(
      //   color: Colors.red,
      //   fontSize: 12.sp,
      //   fontWeight: FontWeight.w400,
      // ),
      // contentPadding: EdgeInsets.symmetric(horizontal: PDimension.paddingX),
      // border: OutlineInputBorder(
      //   borderRadius: BorderRadius.circular(PDimension.boxRadius),
      //   borderSide: BorderSide.none,
      // ),
      // focusedBorder: OutlineInputBorder(
      //   borderRadius: BorderRadius.circular(PDimension.boxRadius),
      //   borderSide: BorderSide.none,
      // ),
      // enabledBorder: OutlineInputBorder(
      //   borderRadius: BorderRadius.circular(PDimension.boxRadius),
      //   borderSide: BorderSide.none,
      // ),
    ),

    // ▶️ Button Theme
    buttonTheme: ButtonThemeData(
      colorScheme: ColorScheme.fromSeed(
        seedColor: const Color(0xFF002E5B),
        secondary: const Color(0xFF3AADE1),
        tertiary: Colors.white,
        shadow: Colors.grey.withValues(alpha: 0.1),
      ),
      highlightColor: Colors.white,
    ),

    // ▶️ Outlined Button Theme
    outlinedButtonTheme: OutlinedButtonThemeData(
      style: ButtonStyle(
        backgroundColor: WidgetStatePropertyAll<Color?>(
          const Color(0xFF6F23FD).withValues(alpha: 0.2),
        ),
      ),
    ),
  );
}
