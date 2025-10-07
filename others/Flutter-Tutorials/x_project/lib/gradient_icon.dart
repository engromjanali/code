

class GradientIconDemo extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Gradient Icon Demo")),
      body: Center(
        child: ShaderMask(
          shaderCallback: (bounds) => LinearGradient(
            colors: [Colors.yellow, Colors.black],
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
          ).createShader(bounds),
          child: Icon(
            Icons.person,
            size: 100,
            color: Colors.white, // must be white for gradient to show properly
          ),
        ),
      ),
    );
  }
}
