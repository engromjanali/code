import 'package:flutter/material.dart';
import 'package:get/route_manager.dart';
import 'package:momo/core/helper/assets/images.dart';
import 'package:momo/prsentation/screens/home_page.dart';
import 'package:momo/core/widgets/bottom_button.dart';

class PurcheseScreen extends StatefulWidget {
  const PurcheseScreen({super.key});

  @override
  State<PurcheseScreen> createState() => _PurcheseScreenState();
}

class _PurcheseScreenState extends State<PurcheseScreen> {
  int selectedPlain = 1;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      extendBody: true,
      backgroundColor: Colors.black,
      bottomNavigationBar: getBottomRoundedButton(
        label: "Continue",
        margin:EdgeInsets.only(bottom: 60, left: 20, right: 20),
        ontap: () {
          
        },
      ),
      appBar: AppBar(
        backgroundColor: Colors.black,
        foregroundColor: Colors.white,
        actions: [Text("Restore Purchase", style: TextStyle(fontSize: 14))],
        leading: IconButton(
          onPressed: () {
            Get.back();
          },
          icon: Icon(Icons.cancel_rounded, color: Colors.white54, size: 35),
        ),
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          CircleAvatar(
            backgroundImage: AssetImage(Images.myPhoto),
            radius: 70,
            // child: Image.asset(Images.myPhoto),
          ),

          SizedBox(height: 20),

          Text(
            "Get Full Access.",
            style: TextStyle(
              fontSize: 28,
              fontWeight: FontWeight.w600,
              color: Colors.white,
            ),
            textAlign: TextAlign.center,
          ),

          GestureDetector(
            onTap: () {
              setState(() {
                selectedPlain = 1;
              });
            },
            child: Container(
              padding: EdgeInsets.all(2.5),
              margin: EdgeInsets.all(10),
              decoration: BoxDecoration(
                color: selectedPlain != 1 ? Colors.white30 : null,
                gradient: selectedPlain == 1
                    ? LinearGradient(colors: [Colors.blue, Colors.pinkAccent])
                    : null,
                borderRadius: BorderRadius.circular(10),
              ),
              child: Container(
                // height: 50,
                // width: 200,
                padding: EdgeInsets.all(5),
                decoration: BoxDecoration(
                  color: Colors.black.withAlpha(210),
                  borderRadius: BorderRadius.circular(10),
                ),
                child: Row(
                  children: [
                    Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: Icon(
                        selectedPlain == 1
                            ? Icons.check_circle
                            : Icons.circle_outlined,
                        color: selectedPlain == 1 ? Colors.white : Colors.grey,
                      ),
                    ),
                    Expanded(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            "7-Day Full Access",
                            style: TextStyle(
                              color: Colors.white,
                              fontSize: 18,
                              fontWeight: FontWeight.w600,
                            ),
                          ),
                          Text(
                            "Then BDT 1,400/week",
                            style: TextStyle(
                              color: Colors.blueAccent,
                              fontSize: 14,
                              fontWeight: FontWeight.normal,
                            ),
                          ),
                        ],
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: Text(
                        "BDT 950",
                        style: TextStyle(
                          color: Colors.white,
                          fontSize: 18,
                          fontWeight: FontWeight.w600,
                        ),
                      ),
                    ),
                  ],
                ),
              ),
            ),
          ),

          GestureDetector(
            onTap: () {
              setState(() {
                selectedPlain = 2;
              });
            },
            child: Stack(
              children: [
                Container(
                  padding: EdgeInsets.all(2.5),
                  margin: EdgeInsets.all(10),
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(10),
                    gradient: selectedPlain == 2
                        ? LinearGradient(
                            colors: [Colors.blue, Colors.pinkAccent],
                          )
                        : null,
                    color: selectedPlain != 2 ? Colors.white30 : null,
                  ),
                  child: Container(
                    // height: 50,
                    // width: 200,
                    padding: EdgeInsets.all(5),
                    decoration: BoxDecoration(
                      color: Colors.black.withAlpha(210),
                      borderRadius: BorderRadius.circular(10),
                    ),
                    child: Row(
                      children: [
                        Padding(
                          padding: const EdgeInsets.all(8.0),
                          child: Icon(
                            selectedPlain == 2
                                ? Icons.check_circle
                                : Icons.circle_outlined,
                            color: selectedPlain == 2
                                ? Colors.white
                                : Colors.grey,
                          ),
                        ),
                        Expanded(
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                "Yearly Access",
                                style: TextStyle(
                                  color: Colors.white,
                                  fontSize: 18,
                                  fontWeight: FontWeight.w600,
                                ),
                              ),
                            ],
                          ),
                        ),
                        Padding(
                          padding: const EdgeInsets.all(8.0),
                          child: Text(
                            "BDT 5,100",
                            style: TextStyle(
                              color: Colors.white,
                              fontSize: 18,
                              fontWeight: FontWeight.w600,
                            ),
                          ),
                        ),
                      ],
                    ),
                  ),
                ),
                Positioned(
                  right: 30,
                  child: Container(
                    padding: EdgeInsets.symmetric(horizontal: 4, vertical: 2),
                    decoration: BoxDecoration(
                      color: Colors.white,
                      borderRadius: BorderRadius.circular(10),
                    ),
                    child: Text(
                      "SAVE 94%",
                      style: TextStyle(
                        fontSize: 12,
                        fontWeight: FontWeight.w600,
                      ),
                    ),
                  ),
                ),
              ],
            ),
          ),

          Spacer(),

          Row(
            children: [
              Spacer(),
              Column(
                mainAxisAlignment: MainAxisAlignment.start,
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  getFun(Icons.image, "Ultra Realistic HD"),
                  getFun(Icons.lock, "Unlock Ai Photos"),
                  getFun(Icons.person, "Create One Ai Profile"),
                  getFun(Icons.key, "Access to All Style"),
                ],
              ),
              Spacer(),
            ],
          ),

          Spacer(),

          SizedBox(height: 100),
          Align(
            alignment: AlignmentGeometry.center,
            child: Text(
              "Auto-renews at Bdt 1400/week. No Commitment.\nCancel anytime.",
              style: TextStyle(color: Colors.white70),
              textAlign: TextAlign.center,
            ),
          ),
          SizedBox(height: 10),
        ],
      ),
    );
  }
}

Widget getFun(IconData icon, String label) {
  return Row(
    children: [
      Icon(icon, color: Colors.white),
      SizedBox(width: 10),
      Text(label, style: TextStyle(color: Colors.white, fontSize: 18)),
    ],
  );
}
