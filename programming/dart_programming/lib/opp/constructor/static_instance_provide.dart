class ServiceProvider {
  static final ServiceProvider _instance = ServiceProvider._internal();
  String _url = "https://www.google.com/";

  // ServiceProvider();
  
  // first way.
  factory ServiceProvider.getInstance() {
    return _instance;
    // return ServiceProvider();
  }

  // 2nd way.
  static ServiceProvider instance = _instance;


  ServiceProvider._internal();

  void setUrl({required String url}) {
    _url = url;
  }

  String getUrl() {
    return _url;
  }
}


main(){
  // Note : may we can see more propartis because we are in same page. we should try from another file/class 

  // ServiceProvider s = ServiceProvider._internal();  //mean ServiceProvider();
  ServiceProvider s = ServiceProvider.getInstance();  
  ServiceProvider s1 = ServiceProvider.getInstance(); // mean ServiceProvider._instance;

  s.setUrl(url: "sdfkslakdf");
  print(s.getUrl()); // sdfkslakdf
  print(s1.getUrl()); // sdfkslakdf
}