package co.touchlab.core.ios

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*

class FlowWrapper<T>(
    private val scope: CoroutineScope,
    private val flow: Flow<T>,
) {

    fun subscribe(
        onEach: (item: T) -> Unit,
        onThrow: (error: Throwable) -> Unit,
    ): Job = subscribe(onEach, onThrow, {})

    fun subscribe(
        onEach: (item: T) -> Unit,
        onThrow: (error: Throwable) -> Unit,
        onComplete: () -> Unit,
    ): Job = flow
        .onEach { onEach(it) }
        .catch { onThrow(it) }
        .onCompletion { onComplete() }
        .launchIn(scope)
}