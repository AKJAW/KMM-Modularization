package co.touchlab.kmm.todos.list.dependency.data

import co.touchlab.kmm.todos.list.api.data.Todo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

internal class InMemoryTodosRepository {

    private val mutableTodos: MutableStateFlow<List<Todo>> = MutableStateFlow(listOf())
    val todos: Flow<List<Todo>> = mutableTodos

    fun add(todo: Todo) {
        mutableTodos.value = mutableTodos.value + todo
    }
}