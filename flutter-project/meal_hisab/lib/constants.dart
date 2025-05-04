class Constants {
  static const String LandingScreen = "/landingScreen";



  // bazer
  static const String bazerList = "Bazer List";
  static const String bazerEntry = "Bazer Entry";
  
}

enum BazerScreenMenu{
  bazerList,
  bazerEntry,
}

enum BazerEntry{
  description,
  price,
  member,
  slNo,
  date,
  time,
}

enum Fand{
  fand,
  addDiposite,
  addCost,
}
enum DrawerItem{
  Home,
  Meal,
  Members,
  Fand,
  Notice_And_Announcements,
  Bazer,
  Mess,
  Settings
}

void main() {
  print(BazerScreenMenu.bazerList.name);
}