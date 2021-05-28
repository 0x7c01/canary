//
//  CanaryApp.swift
//  Canary
//
//  Created by zenozhengs on 2021/5/27.
//

import SwiftUI
import Flutter


@main
struct CanaryApp: App {
    
    @UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate: AppDelegate
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
    
}

class AppDelegate: NSObject, UIApplicationDelegate {
    
    let engines = FlutterEngineGroup(name: "flutter-engines", project: nil)
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        print(">> finish launching")
        return true
    }
}
