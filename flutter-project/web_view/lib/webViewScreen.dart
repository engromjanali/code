import 'package:flutter/material.dart';
import 'package:flutter_inappwebview/flutter_inappwebview.dart';
import 'package:web_view/home.dart';

class WebViewScreen extends StatefulWidget {
  const WebViewScreen({super.key});

  @override
  State<WebViewScreen> createState() => _WebviewscreenState();
}

class _WebviewscreenState extends State<WebViewScreen> {
  InAppWebViewController ? webViewController;
  PullToRefreshController? refreshController;
  late var url;
  var initialUrl = "https://www.google.com/";
  var urlController = TextEditingController();
  double progress = 0;
  bool isLoading = false;


  @override
  void initState() {
    // TODO: implement initState
    super.initState();

    refreshController = PullToRefreshController(
      onRefresh: () {
        webViewController!.reload();
      },
      settings: PullToRefreshSettings(color: Colors.white, backgroundColor: Colors.black),
    );

  }



  @override
  Widget build(BuildContext context) {

    return PopScope(
      canPop: false,
      onPopInvokedWithResult:((didPop, result)async {
        if(webViewController!=null && await webViewController!.canGoBack()){
          webViewController!.goBack();
          print("md romjan ali1");
        }     
        else{
          if(Navigator.canPop(context))
          {
            Navigator.of(context).pop();
          }
        }
      }),
      child: Scaffold(
      
        appBar: AppBar(
          backgroundColor: Colors.amber,
          leading: IconButton(onPressed: ()async{
            if(webViewController!=null && await webViewController!.canGoBack()){
              webViewController!.goBack();
            }
          }, 
            icon: Icon(Icons.arrow_back, color: Colors.white,),
          ),
          title: Container(
            padding: EdgeInsets.symmetric(horizontal: 4),
            decoration: BoxDecoration(
              color: Colors.white,
              borderRadius: BorderRadius.circular(12),
              
            ),
            child: TextField(
              controller: urlController,
              onSubmitted: (value) {
                saveUrl(value.toString());
                webViewController!.loadUrl(urlRequest: URLRequest(url: WebUri(url)));
              },
              decoration: InputDecoration(
                hintText: "Search here..",
                prefixIcon: Icon(Icons.search),
                border: InputBorder.none,
                
              ),
              textAlign: TextAlign.center,
            ),
          ),
          actions: [
            IconButton( icon: Icon(Icons.refresh),onPressed: (){
              webViewController!.reload();
            },),
          ],
          
        ),
        body: Stack(
          alignment: Alignment.center,
          children: [
            Column(
              children: [
                Expanded(
                  child: InAppWebView(
                    onLoadStart:(controller, url) {
                      var v = url.toString();
                      setState(() {
                        urlController.text = v;
                        isLoading = true;
                      });
                    } ,
                    onLoadStop: (controller, url) {
                      setState(() {
                        refreshController!.endRefreshing();
                        isLoading = false;
                      });
                    },
                    initialUrlRequest: URLRequest( 
                      url: WebUri(initialUrl),
                    ),
                    onWebViewCreated: (controller) {
                      webViewController = controller;
                    },
                    onProgressChanged: (controller, progress) {
                      if(progress ==100){
                        refreshController!.endRefreshing();
                      }
                      setState(() {
                        this.progress = progress/100;
                        
                      });
                    },
                    pullToRefreshController: refreshController,
                    // initialData: InAppWebViewInitialData(data: html),// initial data what we will provide.
                  ),
                ),
              ],
            ),

            Visibility(
              visible: isLoading,
              
              child: CircularProgressIndicator(
                value: progress,
                valueColor: AlwaysStoppedAnimation(Colors.orange)
              ),
            ),
          ],
        ),
      ),
    );
  }


  void saveUrl(String inputurl){
    // add https:// or http:// if messing 
    if(!inputurl.startsWith("http://") && !inputurl.startsWith("https://")){
      url = "${initialUrl}search?q=$inputurl";
    }
    else {
      url = inputurl;
    }
  }


}