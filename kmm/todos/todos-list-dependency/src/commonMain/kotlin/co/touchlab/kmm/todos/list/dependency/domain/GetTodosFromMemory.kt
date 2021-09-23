package co.touchlab.kmm.todos.list.dependency.domain

import co.touchlab.kmm.todos.list.api.domain.GetTodos
import co.touchlab.kmm.todos.list.api.data.Todo
import co.touchlab.kmm.todos.list.dependency.data.InMemoryTodosRepository
import kotlinx.coroutines.flow.Flow

internal class GetTodosFromMemory(
    private val repository: InMemoryTodosRepository
) : GetTodos {

    override fun invoke(): Flow<List<Todo>> = repository.todos
}