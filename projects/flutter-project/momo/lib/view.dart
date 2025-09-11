import 'package:flutter/material.dart';

class BackgroundSliderPage extends StatefulWidget {
  @override
  _BackgroundSliderPageState createState() => _BackgroundSliderPageState();
}

class _BackgroundSliderPageState extends State<BackgroundSliderPage> {
  final PageController _pageController = PageController();
  
  final List<String> images = [
    
    "https://picsum.photos/id/1011/800/1600", // replace with your images
    "https://picsum.photos/id/1015/800/1600",
    "https://picsum.photos/id/1016/800/1600",
  ];

  int _currentIndex = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Stack(
        children: [
          // Background slider
          PageView.builder(
            controller: _pageController,
            itemCount: images.length,
            onPageChanged: (index) {
              setState(() {
                _currentIndex = index;
              });
            },
            itemBuilder: (context, index) {
              return Image.network(
                errorBuilder: (context, error, stackTrace) => SizedBox.shrink(),
                images[index],
                fit: BoxFit.cover,
                width: double.infinity,
                height: double.infinity,
              );
            },
          ),

          // Foreground fixed content
          Positioned.fill(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                  "Fixed Foreground Text",
                  style: TextStyle(
                    fontSize: 24,
                    color: Colors.white,
                    fontWeight: FontWeight.bold,
                    shadows: [
                      Shadow(
                        blurRadius: 8,
                        color: Colors.black54,
                        offset: Offset(2, 2),
                      ),
                    ],
                  ),
                ),
                const SizedBox(height: 20),
                ElevatedButton(
                  onPressed: () {},
                  child: const Text("Click Me"),
                ),
              ],
            ),
          ),

          // Dots Indicator (optional)
          Positioned(
            bottom: 40,
            left: 0,
            right: 0,
            child: Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: List.generate(images.length, (index) {
                return Container(
                  margin: const EdgeInsets.symmetric(horizontal: 4),
                  width: _currentIndex == index ? 16 : 8,
                  height: 8,
                  decoration: BoxDecoration(
                    color: _currentIndex == index ? Colors.white : Colors.grey,
                    borderRadius: BorderRadius.circular(8),
                  ),
                );
              }),
            ),
          ),
        ],
      ),
    );
  }
}
