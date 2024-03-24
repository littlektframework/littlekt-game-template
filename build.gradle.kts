plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }

    group = "com.game.template"
    version = "1.0"
}

plugins.withType<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin> {
    the<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension>().apply {
        yarnLockMismatchReport = org.jetbrains.kotlin.gradle.targets.js.yarn.YarnLockMismatchReport.WARNING
    }
}
