package com.abbe.canary.flutter

import android.app.Activity
import com.abbe.canary.CanaryApp
import io.flutter.FlutterInjector
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel

interface EngineBindingsDelegate {
    fun onNavigateTo()
}

class EngineBindings(
    activity: Activity,
    val delegate: EngineBindingsDelegate,
    entrypoint: String = "main") {

    private val channel: MethodChannel
    val engine: FlutterEngine

    init {
        val app = activity.applicationContext as CanaryApp
        val dartEntrypoint = DartExecutor.DartEntrypoint(
            FlutterInjector.instance().flutterLoader().findAppBundlePath(), entrypoint,
        )
        engine = app.engines.createAndRunEngine(activity, dartEntrypoint)

        channel = MethodChannel(engine.dartExecutor.binaryMessenger, "native-flutter-channel")
    }

    fun attach() {
        channel.setMethodCallHandler { call, result ->
            when (call.method) {
                "navigateTo" -> {
                    this.delegate.onNavigateTo()
                    result.success(null)
                }
                else -> result.notImplemented()
            }
        }
    }

    fun detach() {
        channel.setMethodCallHandler(null)
    }


}