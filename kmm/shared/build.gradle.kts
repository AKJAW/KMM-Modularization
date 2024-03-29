import de.fayard.refreshVersions.core.versionFor

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("kotlinx-serialization")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

android {
    compileSdk = Versions.compile_sdk
    defaultConfig {
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    lint {
        warningsAsErrors = false
        abortOnError = false
    }
}

version = "1.0"

android {
    configurations {
        create("androidTestApi")
        create("androidTestDebugApi")
        create("androidTestReleaseApi")
        create("testApi")
        create("testDebugApi")
        create("testReleaseApi")
    }
}

kotlin {
    android()
    ios()

    version = "1.1"

    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlin.RequiresOptIn")
                optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
            }
        }
    }

    sourceSets["commonMain"].dependencies {
        api(project(":kmm:core:core-common"))
        api(project(":kmm:todos:todos-list-api"))
        implementation(project(":kmm:todos:todos-list-dependency"))
        api(project(":kmm:todos:todos-count-api"))
        implementation(project(":kmm:todos:todos-count-dependency"))
        implementation(Deps.SqlDelight.runtime)
        implementation(Deps.SqlDelight.coroutinesExtensions)
        implementation(Deps.Ktor.commonCore)
        implementation(Deps.Ktor.commonJson)
        implementation(Deps.Ktor.commonLogging)
        implementation(Deps.Coroutines.common)
        implementation(Deps.multiplatformSettings)
        implementation(Deps.koinCore)
        implementation(Deps.Ktor.commonSerialization)
        implementation(Deps.kotlinxDateTime)
        implementation(Deps.kermit)
    }

    sourceSets["commonTest"].dependencies {
        implementation(project(":kmm:core:core-test"))
        implementation(Deps.multiplatformSettingsTest)
        implementation(Deps.KotlinTest.common)
        implementation(Deps.KotlinTest.annotations)
        implementation(Deps.koinTest)
        implementation(Deps.turbine)
    }

    sourceSets.matching { it.name.endsWith("Test") }
        .configureEach {
            languageSettings.optIn("kotlin.time.ExperimentalTime")
        }

    sourceSets["androidMain"].dependencies {
        implementation(kotlin("stdlib", "_"))
        implementation(Deps.SqlDelight.driverAndroid)
        implementation(Deps.Coroutines.android)
        implementation(Deps.Ktor.androidCore)
    }

    sourceSets["androidTest"].dependencies {
        implementation(Deps.KotlinTest.jvm)
        implementation(Deps.KotlinTest.junit)
        implementation(Deps.AndroidXTest.core)
        implementation(Deps.AndroidXTest.junit)
        implementation(Deps.AndroidXTest.runner)
        implementation(Deps.AndroidXTest.rules)
        implementation(Deps.Coroutines.test)
        implementation(Deps.robolectric)
    }

    sourceSets["iosMain"].dependencies {
        api(project(":kmm:core:core-ios"))
        implementation(Deps.SqlDelight.driverIos)
        implementation(Deps.Ktor.ios)

        implementation(Deps.Coroutines.common) {
            version {
                strictly(versionFor(KotlinX.Coroutines.core))
            }
        }
    }

    cocoapods {
        summary = "The umbrella framework for the KMM codebase"
        homepage = "https://github.com/AKJAW/KMM-Modularization"
        framework {
            isStatic = false
            export(project(":kmm:core:core-common"))
            export(project(":kmm:core:core-ios"))
            export(project(":kmm:todos:todos-list-api"))
            export(project(":kmm:todos:todos-count-api"))
            export(Deps.Coroutines.common)
            export(Deps.koinCore)
        }
    }
}

sqldelight {
    database("KaMPKitDb") {
        packageName = "co.touchlab.kampkit.db"
    }
}
