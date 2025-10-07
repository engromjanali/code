import 'package:e_commarce_site/controller/count_controller.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:get/get.dart';

class CounterController extends GetxController {
  int count1 = 0; // without called update function it's dose not update ui automitically.
  var count2 = 0.obs;// when the value will be change it update ui automitacilly.

    void increment1() {
    count1++;
    update(); // must call manually
  }
    void increment2() {
    count2++;
    // update(); // we don't need to call update
  }
}



class CounterPage extends StatelessWidget {
  // we should create instance of controller globally like this.
  // because if called setState or reubild inside Builder decleared "init: CounterController()" duplicat every time.
  
  late final CHome cHome;

  @override
  void initState() {
    super.initState();
    // Create controller only once
    cHome = Get.put(CHome());
  }

  @override
  void dispose() {
    // Proper way to remove controller
    Get.delete<CHome>();
    super.dispose();
  }

  // for stateless
  // Get.to(() => SHome())!.then((_) {
  //   Get.delete<CHome>();
  // });

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      
      appBar: AppBar(),
      body: Center(
        child: Column(
          children: [
            
            // when we called update the inside getbuilder whole section will be updated.
            GetBuilder<CounterController>(
              init: CounterController(), // we have to init if we did not decleare "final controller = Get.put(CounterController());"
              builder: (controller) => Text("Count: ${controller.count1}"),
            ),
            
            // it binded with ".obs" type variable, when the value will be change it will triger automatically.
            Obx(()=>Text("Count: ${controller.count2}")), 
            // Obx(()=>Text("Count: ${Get.find<CounterController>().count2}")), 
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        // we can find if we already used "init: CounterController()" or "final controller = Get.put(CounterController());" otherwise we get an error!,
        // onPressed: ()=> Get.find<CounterController>().increment2(),
        
        // we know.
        onPressed: (){
          controller.increment1();
          controller.increment2();
        },
        child: Icon(Icons.add),
      ),
    );
  }
}
