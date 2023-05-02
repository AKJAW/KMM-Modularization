import de.fayard.refreshVersions.core.versionFor

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlinx-serialization")
}

android {
    compileSdkVersion(Versions.compile_sdk)
    defaultConfig {
        minSdkVersion(Versions.min_sdk)
        targetSdkVersion(Versions.target_sdk)
    }

    lint {
        warningsAsErrors = true
        abortOnError = true
    }
}

version = "1.0"

kotlin {
    android()
    ios()

    version = "1.1"

    sourceSets["commonMain"].dependencies {
        implementation(project(":kmm:todos:todos-count-api"))
        implementation(project(":kmm:todos:todos-list-api"))
        implementation(project(":kmm:core:core-common"))
        implementation(Deps.Coroutines.common)
        implementation(Deps.kotlinxDateTime)
        implementation(Deps.koinCore)
        implementation(Deps.kermit)
    }

    sourceSets["commonTest"].dependencies {
        implementation(project(":kmm:core:core-test"))
        implementation(Deps.KotlinTest.common)
        implementation(Deps.KotlinTest.annotations)
        implementation(Deps.turbine)
    }

    sourceSets["androidMain"].dependencies {
        implementation(Deps.Coroutines.android)
    }

    sourceSets["androidTest"].dependencies {
        implementation(Deps.KotlinTest.jvm)
        implementation(Deps.KotlinTest.junit)
    }

    sourceSets["iosMain"].dependencies {
        implementation(Deps.Coroutines.common) {
            version {
                strictly(versionFor(KotlinX.Coroutines.core))
            }
        }
    }
}

