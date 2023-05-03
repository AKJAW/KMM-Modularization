plugins {
    kotlin("multiplatform")
    id("com.android.library")
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
        implementation(Deps.KotlinTest.common)
        implementation(Deps.KotlinTest.annotations)
    }

    sourceSets["commonTest"].dependencies {
    }

    sourceSets["androidMain"].dependencies {
        implementation(Deps.KotlinTest.jvm)
        implementation(Deps.KotlinTest.junit)
        implementation(Deps.AndroidXTest.core)
        implementation(Deps.AndroidXTest.junit)
        implementation(Deps.AndroidXTest.runner)
        implementation(Deps.AndroidXTest.rules)
        implementation(Deps.Coroutines.test)
    }

    sourceSets["androidTest"].dependencies {
    }

    sourceSets["iosMain"].dependencies {
    }
}

