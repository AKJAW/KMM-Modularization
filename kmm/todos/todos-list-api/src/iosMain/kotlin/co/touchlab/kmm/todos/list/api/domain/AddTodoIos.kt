package co.touchlab.kmm.todos.list.api.domain

import co.touchlab.core.ios.SuspendWrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class AddTodoIos(
    private val addTodo: AddTodo
) {

    fun invoke(): SuspendWrapper<Unit> =
        SuspendWrapper(
            scope = CoroutineScope(SupervisorJob() + Dispatchers.Main),
            suspender = addTodo::invoke
        )
}
