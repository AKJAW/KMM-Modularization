package co.touchlab.kampkit.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import co.touchlab.kampkit.android.ui.theme.KaMPKitTheme
import co.touchlab.kermit.Kermit
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity(), KoinComponent {

    private val log: Kermit by inject { parametersOf("MainActivity") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KaMPKitTheme {
                Text("Cool")
            }
        }
    }
}
