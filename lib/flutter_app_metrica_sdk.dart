import 'dart:async';
import 'package:flutter/services.dart';

class FlutterAppMetricaSdk {
  static const MethodChannel _channel =
      const MethodChannel('flutter_app_metrica_sdk');

  static Future<String?> get platformVersion async {
    final String? version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<void> initYa(String apikey) async {
    await _channel.invokeMethod('initYa', {"apiKey": apikey});
  }

  static Future<String?> getAMID() async {
    final String? amid = await _channel.invokeMethod('getAMID');
    return amid;
  }
}
