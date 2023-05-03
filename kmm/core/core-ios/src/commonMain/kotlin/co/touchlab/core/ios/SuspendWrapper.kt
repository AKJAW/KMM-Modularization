package co.touchlab.core.ios

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SuspendWrapper<T : Any>(
    private val scope: CoroutineScope,
    private val suspender: suspend () -> T
) {

    fun subscribe(
        onSuccess: (item: T) -> Unit,
        onThrow: (error: Throwable) -> Unit
    ): Job = scope.launch {
        try {
            onSuccess(suspender())
        } catch (error: Throwable) {
            onThrow(error)
        }
    }
}