class ServiceProvider {
  static final ServiceProvider _instance = ServiceProvider._internal();
  String _url = "https://www.google.com/";

  // ServiceProvider();
  
  factory ServiceProvider.getInstance() {
    // constractor can't return but fectory constractor can return.


    return _instance;
    // return ServiceProvider();
  }


  ServiceProvider._internal();

  void setUrl({required String url}) {
    _url = url;
  }

  String getUrl() {
    return _url;
  }
}


main(){
  ServiceProvider s = ServiceProvider._internal();  
  // ServiceProvider s = ServiceProvider();  
  ServiceProvider s1 = ServiceProvider.getInstance();

  s.setUrl(url: "sdfkslakdf");
  print(s.getUrl());
  print(s1.getUrl());
}