class ServiceProvider{

  // String _Url = "";
  // String get getUrl => _Url;
  // void setUrl({required String url}){
  //   _Url = url;
  // }
  static final ServiceProvider _instance = ServiceProvider._internal();
  String _url = "https://www.google.com/";

  factory ServiceProvider() {
    return _instance;
  }

  ServiceProvider._internal();

  void setUrl({required String url}) {
    _url = url;
  }

  String getUrl() {
    return _url;
  }
}


