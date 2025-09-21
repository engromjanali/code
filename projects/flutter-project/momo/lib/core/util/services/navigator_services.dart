import 'package:get/get.dart';
import 'package:momo/data/model/one_shot/oneshot_item_model.dart';
import 'package:momo/prsentation/screens/photos_without_prompt.dart';
import 'package:momo/prsentation/screens/photos_with_prompt.dart';

class NServices {
  void onseShotToApply({required OSItemModel osItem}) {
      print(osItem.toMap());
    // with prompt
    if (osItem.prompt?.isNotEmpty?? false) {
      Get.to(() => PhotosWithPrompt(osItem: osItem,));
      // switch (osItem.imageBehaildText.length) {
      //   case 1:
      //     // navigate to prompt with one image
      //     Get.to(() => PhotosWithPrompt(osItem: null,));
      //   case 2:
      //     // navigate to prompt with two image
      //     Get.to(() => PhotosWithPrompt(osItem: osItem,));
      // }
    }
    // without prompt
    else {
      Get.to(() => PhotosWithOutPrompt(osItem: osItem,));
    }
  }
}
