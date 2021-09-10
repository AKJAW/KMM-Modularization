package co.touchlab.kampkit.android

import android.app.Application
import co.touchlab.kampkit.AppInfo
import co.touchlab.kampkit.initKoin
import org.koin.dsl.module

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(
            module {
                single<AppInfo> { AndroidAppInfo }
            }
        )
    }
}

object AndroidAppInfo : AppInfo {
    override val appId: String = BuildConfig.APPLICATION_ID
}
