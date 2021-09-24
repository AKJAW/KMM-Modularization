package co.touchlab.kmm.todos.count.dependency.composition

import co.touchlab.kmm.todos.count.api.domain.GetTodoCount
import co.touchlab.kmm.todos.count.dependency.domain.GetTodoCountFromList
import org.koin.dsl.module

val todoCountDependencyModule = module {
    factory<GetTodoCount> { GetTodoCountFromList(get(), get()) }
}