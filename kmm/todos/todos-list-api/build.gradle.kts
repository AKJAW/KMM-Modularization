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

    lintOptions {
        isWarningsAsErrors = true
        isAbortOnError = true
    }
}

version = "1.0"

kotlin {
    android()
    // Revert to just ios() when gradle plugin can properly resolve it
    val onPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos") ?: false
    if (onPhone) {
        iosArm64("ios")
    } else {
        iosX64("ios")
    }

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
        implementation(Deps.koinCore)
    }

    sourceSets["androidTest"].dependencies {
    }

    sourceSets["iosMain"].dependencies {
        implementation(project(":kmm:core:core-ios"))
        implementation(Deps.koinCore)
        implementation(Deps.Coroutines.common) {
            version {
                strictly(Versions.coroutines)
            }
        }
    }
}

