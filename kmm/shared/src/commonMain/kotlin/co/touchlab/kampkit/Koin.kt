package co.touchlab.kampkit

import co.touchlab.core.common.composition.commonModule
import co.touchlab.kmm.todos.count.dependency.composition.todoCountDependencyModule
import co.touchlab.kmm.todos.list.dependency.composition.todoListDependencyModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initKoin(appModule: Module): KoinApplication {
    val koinApplication = startKoin {
        modules(
            appModule,
            commonModule,
            todoListDependencyModule,
            todoCountDependencyModule
        )
    }

    return koinApplication
}
