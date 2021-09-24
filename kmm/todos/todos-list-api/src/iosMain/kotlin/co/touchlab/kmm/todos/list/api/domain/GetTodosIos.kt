package co.touchlab.kmm.todos.list.api.domain

import co.touchlab.core.ios.FlowWrapper
import co.touchlab.kmm.todos.list.api.data.Todo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class GetTodosIos(
    private val getTodos: GetTodos
) {

    fun invoke(): FlowWrapper<List<Todo>> =
        FlowWrapper(
            scope = CoroutineScope(SupervisorJob() + Dispatchers.Main),
            flow = getTodos()
        )
}
