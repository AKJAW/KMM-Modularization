package co.touchlab.kmm.todos.list.api.domain

import co.touchlab.kmm.todos.list.api.data.Todo
import kotlinx.coroutines.flow.Flow

interface GetTodos {

    operator fun invoke(): Flow<List<Todo>>
}
