package co.touchlab.kampkit.android.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import co.touchlab.kmm.todos.count.api.data.TodoCount
import co.touchlab.kmm.todos.count.api.domain.GetTodoCount
import org.koin.androidx.compose.get

@Composable
fun TodosCountScreen(
    getTodoCount: GetTodoCount = get()
) {
    val count = remember { getTodoCount() }
        .collectAsState(initial = TodoCount(0, 0))
        .value
    TodosCountScreenContent(count)
}

@Composable
private fun TodosCountScreenContent(
    count: TodoCount
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(text = "There are ${count.value} todos")
            Text(text = "Last update: ${count.lastUpdateTimestamp}")
        }
    }
}