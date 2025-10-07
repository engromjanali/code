
import 'package:echogpt_app/core/util/constants/dimension_theme.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:intl/intl.dart';

extension DateExtension on DateTime {
  static const String dayMonthYear = 'dd MMM yyyy';
  static const String hourMinuteAmPm = 'hh:mm a';

  String get toPrimaryFormat => DateFormat(dayMonthYear).format(this);
  String get teleTimeOnly => DateFormat(hourMinuteAmPm).format(this);
}


Widget gapY(double pt) => SizedBox(height: pt.h);
Widget gapX(double pt) => SizedBox(width: pt.w);

extension ThemeExtension on Widget {
  Widget get pAll =>
      Padding(padding: EdgeInsets.symmetric(horizontal: PTheme.paddingX, vertical: PTheme.paddingY), child: this);
  Widget pH({double? value}) => Padding(padding: EdgeInsets.symmetric(horizontal: value ?? PTheme.spaceX), child: this);
  Widget pT({double? value}) => Padding(padding: EdgeInsets.only(top: value?.h ?? PTheme.spaceY), child: this);
  Widget pB({double? value}) => Padding(padding: EdgeInsets.only(bottom: value?.h ?? PTheme.spaceY), child: this);
  Widget pBLong({double? value}) => Padding(padding: EdgeInsets.only(bottom: value?.h ?? PTheme.spaceLY), child: this);
  Widget pL({double? value}) => Padding(padding: EdgeInsets.only(left: value?.w ?? PTheme.spaceX), child: this);
  Widget get paddingExceptBottom => Padding(
      padding: EdgeInsets.only(top: PTheme.paddingY, right: PTheme.paddingX, left: PTheme.paddingX), child: this);
  Widget pR({double? value}) => Padding(padding: EdgeInsets.only(right: value?.w ?? PTheme.spaceX), child: this);
}


extension SentenceCaseExtension on String {
  String get sentenceCase {
    if (trim().isEmpty) return '';
    final trimmed = trimLeft();
    return trimmed.length == 1
        ? trimmed.toUpperCase()
        : '${trimmed[0].toUpperCase()}${trimmed.substring(1).toLowerCase()}';
  }
}


// in here for padding we has used a package and rest thing default.
// when we create extension it's mean we can use it as extra poparty of this widget type.

class test{
  String a = " romjan";

  void fun(){
    String x = a.sentenceCase;
    Widget y  = Container().pAll;
  }
}