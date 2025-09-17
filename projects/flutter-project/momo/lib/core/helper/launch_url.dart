
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:get/get.dart';
import 'package:url_launcher/url_launcher.dart';


String? encodeQueryParameters(Map<String, String> params) {
  return params.entries
      .map((MapEntry<String, String> e) =>
          '${Uri.encodeComponent(e.key)}=${Uri.encodeComponent(e.value)}')
      .join('&');
}

Future<void> _launchUrl(Uri url) async {
  if(await canLaunchUrl(url)){
    launchUrl(
      url,
    );
  }
}

// phone
Future<void> dialNumber(String phoneNumber) async {
    final Uri phoneUri = Uri(scheme: 'tel', path: phoneNumber);
    try {
      if (await canLaunchUrl(phoneUri)) {
        await launchUrl(phoneUri);
      } else {
        debugPrint("the number will not open");
      }
    } catch (e) {
      debugPrint("Somthing Want Wrong $e");
    }
  }


// mail
void opemMail({required String to,String subject = '', String body = ''})async{
    final Uri emailLaunchUri = Uri(
    scheme: 'mailto',
    path: to,
    query: encodeQueryParameters(<String, String>{
      'subject': subject,
      'body' :body
    }),
  );

  await launchUrl(emailLaunchUri);
}

// text message
void openTextMessage(
  {
    String phone = "1234",
    String message = "hii",
  }
){
  final Uri smsUri = Uri(
    scheme: 'sms',
    path: phone,
    query: encodeQueryParameters({'body': message}),
  );
  _launchUrl(smsUri);
}

// open url
void openUrl(String url){
  if(!url.contains("http")){
    url = "http://$url";
  }
  _launchUrl(Uri.parse(url));
}