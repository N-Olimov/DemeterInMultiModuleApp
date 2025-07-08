pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven("https://groovy.jfrog.io/artifactory/plugins-release/") {
            content {
                includeGroup("com.reddit")
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://groovy.jfrog.io/artifactory/plugins-release/") {
            content {
                includeGroup("com.reddit")
            }
        }
    }
}

rootProject.name = "DemeterInMultiModuleApp"
include(":app")
include(":app:mylibrary")
