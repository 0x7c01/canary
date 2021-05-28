package com.abbe.canary

import androidx.multidex.MultiDexApplication
import io.flutter.embedding.engine.FlutterEngineGroup

class CanaryApp: MultiDexApplication() {

    lateinit var engines: FlutterEngineGroup

    override fun onCreate() {
        super.onCreate()
        engines = FlutterEngineGroup(this)
    }
}