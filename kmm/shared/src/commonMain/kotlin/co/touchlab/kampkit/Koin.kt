package co.touchlab.kampkit

import co.touchlab.core.common.composition.commonModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initKoin(appModule: Module): KoinApplication {
    val koinApplication = startKoin {
        modules(
            appModule,
            commonModule,
        )
    }

    return koinApplication
}
