package co.touchlab.kmm.todos.count.api.domain

import co.touchlab.core.ios.FlowWrapper
import co.touchlab.kmm.todos.count.api.data.TodoCount
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class GetTodoCountIos(
    private val getTodoCount: GetTodoCount
){

    fun invoke(): FlowWrapper<TodoCount> =
        FlowWrapper(
            scope = CoroutineScope(SupervisorJob() + Dispatchers.Main),
            flow = getTodoCount()
        )
}
