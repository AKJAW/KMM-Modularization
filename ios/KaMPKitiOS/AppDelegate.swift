//
//  AppDelegate.swift
//  KaMPKitiOS
//
//  Created by Kevin Schildhorn on 12/18/19.
//  Copyright © 2019 Touchlab. All rights reserved.
//

import SwiftUI
import shared

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
    
    var window: UIWindow?
    
    lazy var timestampProvider = koin.get(objCProtocol: TimestampProvider.self) as! TimestampProvider

    func application(_ application: UIApplication, didFinishLaunchingWithOptions
        launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {

        startKoin()
        
        let viewController = UIHostingController(rootView: Container.init())
        
        self.window = UIWindow(frame: UIScreen.main.bounds)
        self.window?.rootViewController = viewController
        self.window?.makeKeyAndVisible()
        
        return true
    }
}

struct Container: View {
    
    private let addTodo = koin.get(objCClass: AddTodoIos.self) as! AddTodoIos
    
    var body: some View {
        NavigationView {
            TodosList()
            .navigationBarTitle(Text("Todos"))
            // 3.
            .navigationBarItems(trailing: Button(action: {
                addTodo.invoke().subscribe { KotlinUnit in
                    
                } onThrow: { KotlinThrowable in
                    
                }

            }) {
                Image(systemName: "plus")
            })
        }
    }
}

struct TodosList: View {
    
    private let getTodos = koin.get(objCClass: GetTodosIos.self) as! GetTodosIos
    @State private var todos: [Todo] = []
    
    var body: some View {
        List {
            // 2.
            ForEach(todos, id: \.self) { todo in
                HStack {
                    Text(todo.name)
                    Text(String(todo.timestamp))
                }
            }
        }.onAppear(perform: {
            getTodos.invoke().subscribe { todos in
                if (todos != nil){
                    self.todos = todos as! [Todo]
                }
            } onThrow: { KotlinThrowable in
                
            }

        })
    }
}
