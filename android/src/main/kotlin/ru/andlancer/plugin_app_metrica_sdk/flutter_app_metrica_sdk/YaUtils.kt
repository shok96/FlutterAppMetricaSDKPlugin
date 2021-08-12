package ru.andlancer.plugin_app_metrica_sdk.flutter_app_metrica_sdk

import android.app.Application
import android.content.Context
import com.yandex.metrica.AppMetricaDeviceIDListener
import com.yandex.metrica.YandexMetrica

import com.yandex.metrica.YandexMetricaConfig
import io.flutter.plugin.common.MethodChannel.Result


class YaUtils constructor(val context: Context, val api_key: String, val result: Result) {

    init {
        val config = YandexMetricaConfig.newConfigBuilder(api_key).build()
        YandexMetrica.activate(context, config)
        YandexMetrica.enableActivityAutoTracking(context as Application)
        result.success(null)
    }

    fun getDeviceId(result: Result){
        YandexMetrica.requestAppMetricaDeviceID(object : AppMetricaDeviceIDListener {
            override fun onLoaded(s: String?) {
                print(s)
                result.success(s)
            }

            override fun onError(reason: AppMetricaDeviceIDListener.Reason) {
                result.error(reason.name, "error get AMID", null)
            }
        })
    }


}