package co.touchlab.kampkit.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.touchlab.core.common.TimestampProvider
import co.touchlab.kampkit.android.ui.theme.KaMPKitTheme
import co.touchlab.kmm.todos.list.api.data.Todo
import co.touchlab.kmm.todos.list.api.domain.AddTodo
import co.touchlab.kmm.todos.list.api.domain.GetTodos
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivity : ComponentActivity(), KoinComponent {

    // TODO move to ViewModel
    private val getTodos: GetTodos by inject()
    private val addTodo: AddTodo by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val todos = getTodos().collectAsState(initial = emptyList()).value
            KaMPKitTheme {
                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { GlobalScope.launch { addTodo() } },
                        ) {
                            Icon(Icons.Default.Add, contentDescription = "Add")
                        }
                    }
                ) { paddingValues ->
                    LazyColumn(
                        Modifier
                            .padding(paddingValues)
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
            }
        }
    }
}
