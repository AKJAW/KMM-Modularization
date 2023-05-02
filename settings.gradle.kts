plugins {
    id("de.fayard.refreshVersions") version "0.40.0"
////                            # available:"0.40.1"
////                            # available:"0.40.2"
////                            # available:"0.50.0"
////                            # available:"0.50.1"
////                            # available:"0.50.2"
////                            # available:"0.51.0"
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
