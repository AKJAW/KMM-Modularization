package co.touchlab.kmm.todos.count.dependency.domain

import co.touchlab.core.common.TimestampProvider
import co.touchlab.kmm.todos.count.api.data.TodoCount
import co.touchlab.kmm.todos.count.api.domain.GetTodoCount
import co.touchlab.kmm.todos.list.api.domain.GetTodos
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class GetTodoCountFromList(
    private val getTodos: GetTodos,
    private val timestampProvider: TimestampProvider,
) : GetTodoCount {

    override fun invoke(): Flow<TodoCount> =
        getTodos().map { todos ->
            TodoCount(
                value = todos.count(),
                lastUpdateTimestamp = timestampProvider.getMilliseconds()
            )
        }
}
