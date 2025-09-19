import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class CBase extends ChangeNotifier {
  // ViewState viewState = ViewState.initial;
  Object? _exception;

  Object? get exception => _exception;

  void setException({
    required Object? error,
    required StackTrace? stackTrace,
    bool showSnackbar = true,
    bool setExceptionOnly = false,
  }) {
    // errorPrint("❌ Error: $error");
    _exception = error;

    // if (!setExceptionOnly) {
    //   viewState = ViewState.error;
    //   notifyListeners();
    // }

    final message = _formatException(error);

    // if (showSnackbar) {
    //   showSnackBar(message);
    // }

    // TODO: Add analytics logging (e.g., Sentry.captureException)
  }

  /// Dynamically format the error message
  String _formatException(Object? error) {
    if (error is DioException) {
      final response = error.response;
      final data = response?.data;

      // infoPrint("============== Dio Error ==========");
      // infoPrint("Type: ${error.type}");
      // infoPrint("Message: ${error.message}");
      // infoPrint("Response: $data");
      // infoPrint("============== End ==========");

      switch (error.type) {
        case DioExceptionType.cancel:
          return "Request was cancelled.";
        case DioExceptionType.connectionTimeout:
          return "Connection timeout. Please check your internet.";
        case DioExceptionType.sendTimeout:
        case DioExceptionType.receiveTimeout:
          return "The server took too long to respond.";
        case DioExceptionType.connectionError:
          return "No internet connection. Please try again.";
        case DioExceptionType.badCertificate:
          return "Security certificate error. Please contact support.";
        case DioExceptionType.badResponse:
          return _extractErrorMessage(data);
        default:
          return error.message ?? "An unexpected error occurred.";
      }
    }

    // For other types of exceptions
    return error?.toString() ?? "An unknown error occurred.";
  }

  /// Extracts readable error message from Dio response data
  String _extractErrorMessage(dynamic data) {
    try {
      if (data is Map<String, dynamic>) {
        return data['message'] ??
            data['error'] ??
            data['Message'] ??
            data['error_description'] ??
            "Unexpected error occurred.";
      } else if (data is String) {
        return data;
      }
    } catch (_) {
      // No-op
    }
    return "An unexpected server error occurred.";
  }
}
