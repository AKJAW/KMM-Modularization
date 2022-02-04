object Versions {
    val min_sdk = 21
    val target_sdk = 30
    val compile_sdk = 31
    val ktlint_gradle_plugin = "10.0.0"
    val buildToolsVersion = "30.0.3"
}

object Deps {
    val android_gradle_plugin = "com.android.tools.build:gradle:_"
    val junit = "junit:junit:_"
    val material = "com.google.android.material:material:_"
    val desugarJdkLibs = "com.android.tools:desugar_jdk_libs:_"
    val kermit = "co.touchlab:kermit:_"
    val koinAndroid = "io.insert-koin:koin-android:_"
    val koinCore = "io.insert-koin:koin-core:_"
    val koinCompose = "io.insert-koin:koin-androidx-compose:_"
    val koinTest = "io.insert-koin:koin-test:_"
    val multiplatformSettings =
        "com.russhwolf:multiplatform-settings:_"
    val multiplatformSettingsTest =
        "com.russhwolf:multiplatform-settings-test:_"
    val robolectric = "org.robolectric:robolectric:_"
    val stately = "co.touchlab:stately-common:_"
    val kotlinxDateTime = "org.jetbrains.kotlinx:kotlinx-datetime:_"
    val turbine = "app.cash.turbine:turbine:_"

    object AndroidX {
        val core_ktx = "androidx.core:core-ktx:_"

        val lifecycle_runtime =
            "androidx.lifecycle:lifecycle-runtime-ktx:_"
        val lifecycle_viewmodel =
            "androidx.lifecycle:lifecycle-viewmodel:_"
        val lifecycle_viewmodel_extensions =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:_"
    }

    object AndroidXTest {
        val core = "androidx.test:core:_"
        val junit = "androidx.test.ext:junit:_"
        val runner = "androidx.test:runner:_"
        val rules = "androidx.test:rules:_"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:_"
        const val uiTooling = "androidx.compose.ui:ui-tooling:_"
        const val foundation = "androidx.compose.foundation:foundation:_"
        const val material = "androidx.compose.material:material:_"
        const val materialIcons =
            "androidx.compose.material:material-icons-core:_"
        const val activityCompose =
            "androidx.activity:activity-compose:_"
        const val navigation = "androidx.navigation:navigation-compose:_"

        object Accompanist {
            const val swipeRefresh =
                "com.google.accompanist:accompanist-swiperefresh:_"
        }
    }

    object KotlinTest {
        val common = "org.jetbrains.kotlin:kotlin-test-common:_"
        val annotations = "org.jetbrains.kotlin:kotlin-test-annotations-common:_"
        val jvm = "org.jetbrains.kotlin:kotlin-test:_"
        val junit = "org.jetbrains.kotlin:kotlin-test-junit:_"
    }

    object Coroutines {
        val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core:_"
        val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:_"
        val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:_"
    }

    object SqlDelight {
        val gradle = "com.squareup.sqldelight:gradle-plugin:_"
        val runtime = "com.squareup.sqldelight:runtime:_"
        val coroutinesExtensions =
            "com.squareup.sqldelight:coroutines-extensions:_"
        val runtimeJdk = "com.squareup.sqldelight:runtime-jvm:_"
        val driverIos = "com.squareup.sqldelight:native-driver:_"
        val driverAndroid = "com.squareup.sqldelight:android-driver:_"
    }

    object Ktor {
        val commonCore = "io.ktor:ktor-client-core:_"
        val commonJson = "io.ktor:ktor-client-json:_"
        val commonLogging = "io.ktor:ktor-client-logging:_"
        val androidCore = "io.ktor:ktor-client-okhttp:_"
        val ios = "io.ktor:ktor-client-ios:_"
        val commonSerialization = "io.ktor:ktor-client-serialization:_"
    }
}
