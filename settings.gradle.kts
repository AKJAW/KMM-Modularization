plugins {
    id("de.fayard.refreshVersions") version "0.40.0"
}

include(
    ":app",
    ":kmm:shared",
    ":kmm:core:core-common",
    ":kmm:core:core-ios",
    ":kmm:core:core-test",
    ":kmm:todos:todos-list-dependency",
    ":kmm:todos:todos-list-api",
    ":kmm:todos:todos-count-api",
    ":kmm:todos:todos-count-dependency",
)
rootProject.name = "KaMPKit"
