import 'package:flutter/material.dart';

class ThreeBounchingDot extends StatefulWidget {
  final Color color;
  final double size;
  final Duration duration;
  const ThreeBounchingDot({
    super.key,  
    this.color = Colors.red,  
    this.size = 10.0,  
    this.duration = const Duration(seconds: 2),
    });

  @override
  State<ThreeBounchingDot> createState() => _ThreeBounchingDotState();
}

class _ThreeBounchingDotState extends State<ThreeBounchingDot>  with SingleTickerProviderStateMixin{

  late AnimationController _controller;

  @override
  void initState() {
    _controller = AnimationController(
      vsync: this,
      duration: widget.duration * 3,
      
    )..repeat();
    // TODO: implement initState
    super.initState();
  }

  @override
  void dispose() {
    // TODO: implement dispose
    _controller.dispose();
    super.dispose();
  }
  
  Widget _buildBot(int index){
    return ScaleTransition(
      scale: CurvedAnimation(
        parent: _controller, 
        curve: Interval(index/3, (index+1)/3, curve: Curves.easeInOut),
      ),
      child: Container(
        height: widget.size,
        width: widget.size,
        decoration: BoxDecoration(
          color: widget.color,
          shape: BoxShape.circle
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return  Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: List.generate(3, _buildBot).map((dot)=> Padding(
          padding: EdgeInsets.symmetric(horizontal: 2),
          child: dot,
        )
      ).toList(),
    );
  }
}