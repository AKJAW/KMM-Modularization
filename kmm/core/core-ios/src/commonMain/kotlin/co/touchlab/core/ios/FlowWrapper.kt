package co.touchlab.core.ios

import co.touchlab.stately.freeze
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*

class FlowWrapper<T>(
    private val scope: CoroutineScope,
    private val flow: Flow<T>,
) {
    init {
        freeze()
    }

    fun subscribe(
        onEach: (item: T) -> Unit,
        onThrow: (error: Throwable) -> Unit,
    ): Job = subscribe(onEach, onThrow, {})

    fun subscribe(
        onEach: (item: T) -> Unit,
        onThrow: (error: Throwable) -> Unit,
        onComplete: () -> Unit,
    ): Job = flow
        .onEach { onEach(it.freeze()) }
        .catch { onThrow(it.freeze()) }
        .onCompletion { onComplete() }
        .launchIn(scope)
        .freeze()
}