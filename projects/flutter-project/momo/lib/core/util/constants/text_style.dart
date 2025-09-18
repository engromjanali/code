import 'package:flutter/material.dart';
import 'package:momo/core/util/constants/colors.dart';

TextStyle getTitleStyle() {
  return const TextStyle(
    fontSize: 20,
    color: Colors.white,
    fontWeight: FontWeight.w600,
  );
}

TextStyle getTitleStyleExplore() {
  return const TextStyle(
    fontSize: 30,
    color: Color(0xFFFFFFFF),
    fontWeight: FontWeight.w700,
  );
}

TextStyle getTitleStyleOneShot() {
  return const TextStyle(
    fontSize: 32,
    color: Color(0xFFFFFFFF),
    fontWeight: FontWeight.w700,
  );
}

TextStyle getSubtitleStyle() {
  return const TextStyle(
    fontSize: 14,
    color: subTitleColor,
    fontWeight: FontWeight.w600,
  );
}

// {
//         "title" :  "Professional",
//         "dtails" : "details",
//         "services" : [
//           "joyful jumps",
//           "Sunshine Steps",
//           "Pure Mischief",
//           "Tiny Explorer",
//         ],
//         "sample" : [
//           "image_1.png",
//           "image_2.png",
//           "image_3.png",
//           "image_4.png",
//         ],
//       },


var oneShot = [
  {
    "title": "Retake",
    "type": ["Office", "Business", "Street Casual", "Blazer"],
  },
  {
    "title": "Popular",
    "type": [
      "Trendy",
      "Streetwear",
      "Casual Chic",
      "Viral Fashion",
      "Personal",
      "Ideas",
      "Reminders",
    ],
  },
  {
    "title": "LinkedIn",
    "type": [
      "Professional",
      "Business Formal",
      "Corporate",
      "Smart Casual",
      "Work",
      "Projects",
      "Meetings",
    ],
  },
  {
    "title": "Try On",
    "type": [
      "Fashion Haul",
      "Mix and Match",
      "Seasonal Outfits",
      "Athleisure",
      "Shopping",
      "Wardrobe",
      "Accessories",
    ],
  },
  {
    "title": "Travel",
    "type": [
      "Adventure Gear",
      "Bohemian",
      "Travel Casual",
      "Cultural Attire",
      "Journal",
      "Itineraries",
      "Memories",
    ],
  },
  {
    "title": "Lifestyle Moments",
    "type": [
      "Everyday Casual",
      "Cozy Home",
      "Event Ready",
      "Minimalist",
      "Daily",
      "Habits",
      "Reflections",
    ],
  },
];
