//
//  ContentView.swift
//  Canary
//
//  Created by zenozhengs on 2021/5/27.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            Button("SwiftUI", action: {
                print("SwiftUI")
            }).padding()
            Button("Flutter", action: {
                print("Flutter")
            }).padding()
            Button("mPaaS", action: {
                print("mPaaS")
            }).padding()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
