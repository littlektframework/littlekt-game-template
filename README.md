## A Starter Game Template for the LittleKt Game Framework

This template repository contains a base project for creating games with [LittleKt](https://littlekt.com). It contains
the bare necessities to get a LittleKt project up and running. This includes the necessary plugins, dependencies and
source set structure.

This project is set up to use all the available platforms that LittleKt currently supports: **JVM**, **Web**, and *
*Android**.
If a certain platform isn't needed, simply deleting the source directory and the source sets in
the `build.gradle.kts` file will get rid of it.

## Usage

Clone this repo and open up in IntelliJ to get started. Each platform target contains a class to execute for their
respective platform.

### JVM

#### Running

Run `LwjglApp` to execute on the desktop.

#### Deploying

A custom deploy task is created specifically for JVM. Run the `package/packageFatJar` gradle task to create a fat
executable JAR. This task can be tinkered with in the `build.gradlek.kts` file.

If and when the packages are renamed from `com.game.template.LwjglApp` to whatever, ensure to update the `jvm.mainClass`
property in the `gradle.properties` file to ensure that the `packageFatJar` task will work properly.

A jar will be outputted in the build directory. To run this JAR, use the following
command, replacing the name of the JAR, if needed: `java -jar --enable-preview game-1.0-all.jar`

If you are running on Mac OS, then the following command can be
used: `java -jar -XstartOnFirstThread --enable-preview game-1.0-all.jar`

### JS

#### Running

Run the `kotlin browser/jsBrowserRun` gradle task like any other **Kotlin/JS** project to run in development mode.

#### Deploying

Run the `kotlin browser/jsBrowserDistribution` gradle task to create a distribution build. This build will require a
webserver in order to run.
