package co.touchlab.kampkit.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import co.touchlab.core.common.TimestampProvider
import co.touchlab.kampkit.android.ui.theme.KaMPKitTheme
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivity : ComponentActivity(), KoinComponent {

    private val timestampProvider: TimestampProvider by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KaMPKitTheme {
                Text("Cool Text ${timestampProvider.getMilliseconds()}")
            }
        }
    }
}
