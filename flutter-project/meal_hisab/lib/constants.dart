class Constants {
  // pages
  static const String LandingScreen = "/landingScreen";
  static const String HomeScreen = "/homeScreen";
  // static const String HomeScreen = "/homeScreen";
  // static const String HomeScreen = "/homeScreen";

  // bazer
  static const String bazerList = "Bazer List";
  static const String bazerEntry = "Bazer Entry";
  // meal 
  static const String mealEntry = "Meal Entry";
  static const String mealList = "Meal List";
  

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
enum NoticeAndAnnouncement{
  Notices,
  addNotice,
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
  Settings,
  Diposite,
}

enum Meal{
  mealList,
  mealEntry,
  groupMealList,
  
}

enum Diposite{
  myDiposite,
  addDiposite,
  refund,
  historyOfDiposite
}
enum HistoryOfDiposite{
  memberWise,
  allHostory,
}
enum Member{
  members,
  AddMember,
}
enum Mess{
  mess,
  messCreate,
  messDelete,
  messUpdate,
  messInvitations,

}


void main() {
  print(BazerScreenMenu.bazerList.name);
}