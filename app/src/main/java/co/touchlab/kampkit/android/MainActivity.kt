package co.touchlab.kampkit.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.touchlab.kampkit.android.ui.BottomBar
import co.touchlab.kampkit.android.ui.TodosCountScreen
import co.touchlab.kampkit.android.ui.TodosListScreen
import co.touchlab.kampkit.android.ui.theme.KaMPKitTheme
import co.touchlab.kmm.todos.list.api.domain.AddTodo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivity : ComponentActivity(), KoinComponent {

    // TODO move to ViewModel
    private val addTodo: AddTodo by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            KaMPKitTheme {
                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { GlobalScope.launch { addTodo() } },
                        ) {
                            Icon(Icons.Default.Add, contentDescription = "Add")
                        }
                    },
                    bottomBar = { BottomBar(navController) }
                ) { paddingValues ->
                    Surface(Modifier.padding(paddingValues)) {
                        NavHost(navController = navController, startDestination = "list") {
                            composable("list") { TodosListScreen() }
                            composable("count") { TodosCountScreen() }
                        }
                    }
                }
            }
        }
    }
}
