package co.touchlab.core.common.composition

import co.touchlab.core.common.KotlinDateTimeTimestampProvider
import co.touchlab.core.common.TimestampProvider
import org.koin.dsl.module

val commonModule = module {
    single<TimestampProvider> { KotlinDateTimeTimestampProvider() }
}