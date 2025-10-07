import 'dart:convert';

import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:weather_application/core/util/constats/all_enum.dart';
import 'package:weather_application/core/util/constats/constants.dart';
import 'package:weather_application/core/util/constats/env.dart';

/// we have to passed full url as end point if we hit on different URL.
class DioServices {
  static final DioServices instance = DioServices._indernal();
  String? _accessToken;
  String? _refreshToken;
  final Dio _dio;
  Dio get dio  => _dio;

  DioServices._indernal()
    //execute after the constructor is called and before constractor-body
    : _dio = Dio(
        BaseOptions(
          baseUrl: ENV.baseUrl,
          connectTimeout: Duration(seconds: 10),
          receiveTimeout: Duration(seconds: 10),
          headers: {"Content-Type": "application/json"},
        ),
      ){
    // this is constractory body
    // in here there are few interceptor class,
    // for request execute as top-buttom/forword 
    // for responce execute as buttom-top/reverse 
    _dio.interceptors.addAll([
      LoggingInterceptor(), // will print log
      InterceptorsWrapper(
        onRequest: (options, handler) {
          // 👉 Add Authorization header if token exists
          if(_accessToken!=null){
            options.headers["Authorization"] = "Bearer $_accessToken";
          }
          debugPrint("👉 [ ${options.method}] ${options.uri}");
          handler.next(options);
        },
        onResponse: (response, handler){
          debugPrint("✅ [${response.statusCode}] ${response.data}");
          handler.next(response);
        },
        onError: (DioException error, handler) async{
          debugPrint("❌ Error [${error.response?.statusCode}] ${error.message}");

          // 👉 if Unauthorized (401) try referesh token
          if(error.response?.statusCode == 401 && _refreshToken != null){
            try{
              final refreshResponse = await _dio.post(
                "/auth/refresh", // token refresh endpoint
                data: {"refresh_token": _refreshToken},
              );
              _accessToken = refreshResponse.data["access_token"];

              // 🔁 retry orginial request with new token
              final newRequest = error.requestOptions;
              newRequest.headers["Authorization"] = "Bearer $_accessToken";
              final retryResponse = await _dio.fetch(newRequest);
              
              return handler.resolve(retryResponse);
            }catch(e)
            {
                return handler.reject(error);
            }
          }
          handler.next(error);
        },
      )
    ]);
  }

  /// 🔑 Set tokens after login
  void setTokens(String accessToken, String refreshToken) {
    _accessToken = accessToken;
    _refreshToken = refreshToken;
  }

  /// 🗑️ Clear tokens (logout)
  void clearTokens() {
    _accessToken = null;
    _refreshToken = null;
  }

}


  /// common request function 
  /// use try catch from where want to called this function.
  Future<Response> makeRequest(
    String endpoint, 
    {dynamic data, 
    required HTTPMethod method, 
    Map<String, dynamic>? queryParams
  }) async {
  final dio = DioService.instance.dio;

      switch (method){
        case HTTPMethod.get:
          return await dio.get(endpoint, queryParameters: queryParams);
        case HTTPMethod.post:
          return await dio.post(endpoint, data: data);
        case HTTPMethod.put:
          return await dio.put(endpoint, data: data);
        case HTTPMethod.delete:
          return await dio.delete(endpoint, data: data);
      }
  }


// Custom logging interceptor
class LoggingInterceptor extends Interceptor {
  @override
  void onRequest(RequestOptions options, RequestInterceptorHandler handler) {
    debugPrint("🚀 Requesting: ${options.method} ${options.uri}");
    debugPrint("Headers: ${json.encode(options.headers)}");

    if (options.data is FormData) {
      final formData = options.data as FormData;
      debugPrint("Payload (FormData): Fields - ${formData.fields}");
      if (formData.files.isNotEmpty) {
        debugPrint("Payload (FormData): Files - ${formData.files.map((file) => file.key).toList()}");
      }
    } else {
      debugPrint("Payload: ${json.encode(options.data)}");
    }

    super.onRequest(options, handler);
  }

  @override
  void onResponse(Response response, ResponseInterceptorHandler handler) {
    debugPrint("✅ StatusCode [${response.statusCode}] from ${response.requestOptions.uri}");
    debugPrint("Response: ${json.encode(response.data)}");
    super.onResponse(response, handler);
  }

  @override
  void onError(DioException err, ErrorInterceptorHandler handler) {
    debugPrint("❌ Error [${err.response?.statusCode}] from ${err.requestOptions.uri}");
    debugPrint("Error Message: ${json.encode(err.message)}");
    debugPrint("Error Data: ${json.encode(err.response?.data)}");
    super.onError(err, handler);
  }
}