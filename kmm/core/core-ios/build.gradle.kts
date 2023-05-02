plugins {
    kotlin("multiplatform")
}

version = "1.0"

kotlin {
    ios()

    version = "1.1"

    sourceSets["commonMain"].dependencies {
        implementation(Deps.Coroutines.common)
        implementation(Deps.koinCore)
        implementation(Deps.kermit)
    }

    sourceSets["commonTest"].dependencies {
    }

    sourceSets["iosMain"].dependencies {
    }
}

