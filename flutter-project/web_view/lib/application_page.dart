
import 'package:flutter/material.dart';
import 'package:flutter_inappwebview/flutter_inappwebview.dart';
import 'package:web_view/service_provider.dart';

class ApplicationPage extends StatefulWidget {
  const ApplicationPage({super.key});

  @override
  State<ApplicationPage> createState() => _ApplicationPageState();
}

class _ApplicationPageState extends State<ApplicationPage> {
  InAppWebViewController ? webViewController;
  PullToRefreshController? refreshController;
  late var url;
  var initialUrl = "https://www.google.com/";
  var urlController = TextEditingController();
  double progress = 0;
  bool isLoading = false;
  ServiceProvider s = ServiceProvider();


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
        }     
        else{
          if(Navigator.canPop(context)){
            Navigator.pop(context);
          }
          print("romjana 2------------");
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
                      url: WebUri(s.getUrl()),
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
}

// class ApplicationPage extends StatefulWidget {
//   const ApplicationPage({super.key});

//   @override
//   State<ApplicationPage> createState() => _ApplicationPageState();
// }

// class _ApplicationPageState extends State<ApplicationPage> {
//   @override
//   Widget build(BuildContext context) {
//     return Container(
//       color: Colors.amber,
//     );
//   }
// }