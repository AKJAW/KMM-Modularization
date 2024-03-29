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
        warningsAsErrors = false
        abortOnError = false
    }
}

version = "1.0"

kotlin {
    android()
    ios()

    version = "1.1"

    sourceSets["commonMain"].dependencies {
        implementation(Deps.Coroutines.common)
        implementation(Deps.kotlinxDateTime)
        implementation(Deps.koinCore)
        implementation(Deps.kermit)
    }

    sourceSets["commonTest"].dependencies {
    }

    sourceSets["androidMain"].dependencies {
        implementation(Deps.Coroutines.android)
    }

    sourceSets["androidTest"].dependencies {
    }

    sourceSets["iosMain"].dependencies {
        implementation(Deps.Coroutines.common) {
            version {
                strictly(versionFor(KotlinX.Coroutines.core))
            }
        }
    }
}

