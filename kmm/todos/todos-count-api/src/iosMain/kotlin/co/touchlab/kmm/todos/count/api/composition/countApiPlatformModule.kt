package co.touchlab.kmm.todos.count.api.composition

import co.touchlab.kmm.todos.count.api.domain.GetTodoCountIos
import org.koin.core.module.Module

actual fun Module.countApiPlatformModule() {
    factory { GetTodoCountIos(get()) }
}
