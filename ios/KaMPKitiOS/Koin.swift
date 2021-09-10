//
//  KoinApplication.swift
//  KaMPStarteriOS
//
//  Created by Russell Wolf on 6/18/20.
//  Copyright © 2020 Touchlab. All rights reserved.
//

import Foundation
import shared

func startKoin() {
    // You could just as easily define all these dependencies in Kotlin, but this helps demonstrate how you might pass platform-specific dependencies in a larger scale project where declaring them in Kotlin is more difficult, or where they're also used in iOS-specific code.
    
    let iosAppInfo = IosAppInfo()
    
    let koinApplication = KoinIOSKt.doInitKoinIos(appInfo: iosAppInfo)
    _koin = koinApplication.koin
}

private var _koin: Koin? = nil
var koin: Koin {
    return _koin!
}

class IosAppInfo : AppInfo {
    let appId: String = Bundle.main.bundleIdentifier!
}
