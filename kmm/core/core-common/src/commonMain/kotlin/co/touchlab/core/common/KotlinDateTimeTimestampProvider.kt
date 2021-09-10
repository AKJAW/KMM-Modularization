package co.touchlab.core.common

import kotlinx.datetime.Clock

internal class KotlinDateTimeTimestampProvider : TimestampProvider {

    override fun getMilliseconds(): Long =
        Clock.System.now().toEpochMilliseconds()
}
