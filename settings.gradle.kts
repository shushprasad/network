pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Movie_Library"
include(":app")
include(":network")

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

