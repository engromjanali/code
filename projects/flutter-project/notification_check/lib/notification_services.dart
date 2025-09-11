import 'dart:io';
import 'dart:math';

import 'package:firebase_core/firebase_core.dart';
import 'package:firebase_messaging/firebase_messaging.dart';
import 'package:flutter/material.dart';
import 'package:flutter_local_notifications/flutter_local_notifications.dart';

class NotificationServices {
  FirebaseMessaging messaging = FirebaseMessaging.instance;
  final FlutterLocalNotificationsPlugin _flutterLocalNotificationsPlugin = FlutterLocalNotificationsPlugin();

  
  NotificationServices(){
    checkDeviceTockenHasChanged();
  }

  void initLocalNotifications(BuildContext context, RemoteMessage message)async{

    var androidInitializationSettings =  const AndroidInitializationSettings('@mipmap/ic_launcher');
    var iosInitializationSettings = const DarwinInitializationSettings();

    var initializationSettings = InitializationSettings(
      android: androidInitializationSettings,
      iOS: iosInitializationSettings,
    );

    await _flutterLocalNotificationsPlugin.initialize(
      initializationSettings,
      onDidReceiveNotificationResponse: (paylod) {//"paylod" it's called notification responce also, 
        
      },  
    );
  }


  Future<void> firebaseMessageInit() async {
    FirebaseMessaging.onMessage.listen((message)async{
      debugPrint(message.notification!.title.toString());
      debugPrint(message.notification!.body.toString());
      

      if (message.notification != null) {
        showNotification(message);
        debugPrint("showNotification(message);");
        
      }
    });
  
  }

  Future<void> showNotification(RemoteMessage message)async{

    AndroidNotificationChannel channel = AndroidNotificationChannel(
      Random.secure().nextInt(100000).toString(), 
      'High Importance Notification',
      importance: Importance.max
    );

    AndroidNotificationDetails androidNotificationDetails = AndroidNotificationDetails(
      channel.id.toString(),
      channel.name.toString(),
      channelDescription: 'your channel description',
      importance: Importance.max,
      priority: Priority.high,
      ticker: 'ticker',
      icon: '@mipmap/ic_launcher',// required otherwise we get an error.
    );


    const DarwinNotificationDetails darwinNotificationDetails = DarwinNotificationDetails(
      presentAlert: true,
      presentBadge: true,
      presentSound: true,
    );
    
    NotificationDetails notificationDetails = NotificationDetails(
      android: androidNotificationDetails,
      iOS: darwinNotificationDetails,
    );


    Future.delayed(
      Duration.zero,(){

        _flutterLocalNotificationsPlugin.show(
          0, 
          message.notification!.title.toString(), 
          message.notification!.body.toString(), 
          notificationDetails,
        );
          
        
      }
    );
  }

  // void openAppSettings()async {
    
  //   if(Platform.isAndroid){
  //     await AppSettings.openAppSettings(
  //       type: AppSettingsType.notification, // android navigate to notification permision page.
  //       asAnotherTask: true,
  //     );
  //   }

    
  //   // reopen to check has permision or not.
    
  // }

  void requestNotificationPermission()async{
    NotificationSettings settings = await messaging.requestPermission(
      alert: true, // show notificition on display 
      announcement: true, // siri can't read for false,
      badge:  true, // to show index
      carPlay: true, // 
      criticalAlert: true,
      // provisional: true, //Note that on iOS, if [provisional] is set to true, silent notification permissions will be automatically granted. When notifications are delivered to the device, the user will be presented with an option to disable notifications, keep receiving them silently or enable prominent notifications.
      sound: true,
      providesAppNotificationSettings: true,
    );

    if(settings.authorizationStatus == AuthorizationStatus.authorized){
      debugPrint("user authorized: Android");
    }
    else if(settings.authorizationStatus == AuthorizationStatus.provisional){
      debugPrint("user Provisional: IOS");
    }
    else{
      debugPrint("user denaided");
      // openAppSettings();
    }
  }

  // for ios semolator we have to 
  Future<String> getDeviceToken(Function(String) onFail)async{
    String? deviceToken;
    try {
      // // for web
      // final apnsToken = await FirebaseMessaging.instance.getAPNSToken();
      // deviceToken =  await messaging.getToken(vapidKey: apnsToken);

      // for ios or android
      deviceToken =  await messaging.getToken();
    } catch (e) {
      onFail(e.toString());
      debugPrint(e.toString());
    }
    return deviceToken??"";
  }

  // check device token has changed or not 
  void checkDeviceTockenHasChanged (){
    messaging.onTokenRefresh.listen((fcmToken) {
      // Note: This callback is fired at each app startup and whenever a new
      // token is generated.
      debugPrint("device token has changed (new token) : $fcmToken");
    }).onError((err) {
      debugPrint("Error \'checkDeviceTockenHasChanged\' : $err");
    });
  }





}