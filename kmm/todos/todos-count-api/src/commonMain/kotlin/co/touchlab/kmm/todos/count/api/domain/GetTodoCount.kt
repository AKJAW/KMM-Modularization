package co.touchlab.kmm.todos.count.api.domain

import co.touchlab.kmm.todos.count.api.data.TodoCount
import kotlinx.coroutines.flow.Flow

interface GetTodoCount {

    operator fun invoke(): Flow<TodoCount>
}
