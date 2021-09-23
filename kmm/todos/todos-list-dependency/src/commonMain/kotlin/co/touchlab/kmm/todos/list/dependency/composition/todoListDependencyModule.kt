package co.touchlab.kmm.todos.list.dependency.composition

import co.touchlab.kmm.todos.list.api.domain.AddTodo
import co.touchlab.kmm.todos.list.api.domain.GetTodos
import co.touchlab.kmm.todos.list.dependency.data.InMemoryTodosRepository
import co.touchlab.kmm.todos.list.dependency.domain.AddTodoToMemory
import co.touchlab.kmm.todos.list.dependency.domain.GetTodosFromMemory
import org.koin.dsl.module

val todoListDependencyModule = module {
    single { InMemoryTodosRepository() }
    factory<AddTodo> { AddTodoToMemory(get(), get()) }
    factory<GetTodos> { GetTodosFromMemory(get()) }
}