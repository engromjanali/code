import 'package:flutter/material.dart';

class SocialButton extends StatelessWidget {
  const SocialButton({super.key,
    required this.label,
    required this.height,
    required this.width,
    required this.onTap,
    required this.assetsImage,
  });
  final String label;
  final double height;
  final double width;
  final Function() onTap;
  final String assetsImage;
  @override
  Widget build(BuildContext context) {
    return GestureDetector(
        onTap: onTap,
        child: Column(
          children: [
            Container(
              height: height,
              width:width,
              decoration: BoxDecoration(
                  shape: BoxShape.circle,
                  boxShadow: [
                    BoxShadow(
                      color: Colors.black45,
                      offset: Offset(0, 4), // left-right=0 & top,down=2 shadow
                      blurRadius: 6.0,
                    ),
                  ],
                  image: DecorationImage(image: AssetImage(assetsImage))
              ),
            ),
            const SizedBox( height: 20,),
            Text(label, style: TextStyle(color: Colors.grey, fontWeight: FontWeight.bold, fontSize: 12),),
          ],
        )
    );
  }
}

