// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Deps.android_gradle_plugin)
        classpath(Deps.SqlDelight.gradle)
        classpath("org.jetbrains.kotlin:kotlin-serialization:_")

        classpath(kotlin("gradle-plugin", "_"))
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
