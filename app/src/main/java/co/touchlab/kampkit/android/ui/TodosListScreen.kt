package co.touchlab.kampkit.android.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.touchlab.kmm.todos.list.api.data.Todo
import co.touchlab.kmm.todos.list.api.domain.GetTodos
import org.koin.androidx.compose.get

@Composable
fun TodosListScreen(
   getTodos: GetTodos = get()
) {
    val todos = remember { getTodos() }
        .collectAsState(initial = emptyList())
        .value
    TodosListScreenContent(todos = todos)
}

@Composable
fun TodosListScreenContent(
    todos: List<Todo>
) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(todos) { todo ->
            Card(
                Modifier.padding(horizontal = 8.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = todo.name,
                        modifier = Modifier.weight(1f),
                        softWrap = true
                    )
                    Text(
                        text = todo.timestamp.toString(),
                        modifier = Modifier.weight(.6f)
                    )
                }
            }
        }
    }
}
