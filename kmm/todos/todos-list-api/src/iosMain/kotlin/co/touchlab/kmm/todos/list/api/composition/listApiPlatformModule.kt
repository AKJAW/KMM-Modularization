package co.touchlab.kmm.todos.list.api.composition

import co.touchlab.kmm.todos.list.api.domain.AddTodoIos
import co.touchlab.kmm.todos.list.api.domain.GetTodosIos
import org.koin.core.module.Module

actual inline fun Module.listApiPlatformModule() {
    factory { GetTodosIos(get()) }
    factory { AddTodoIos(get()) }
}