This is a Kotlin Multiplatform project targeting Desktop.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…

# SoigneMoi - Desktop App
## Context
The following project is part of the "SoigneMoi" school project,
made for the Studi's "ECF" of the summer 2024 exam session.
### Author
Alexis ANEAS

## Presentation
This App is made to interact with the following back-end:
- SoigneMoi API https://github.com/HalTobin/SoigneMoi_API
  And the others front-end that are also part of the project are the following:
- SoigneMoi Mobile App https://github.com/HalTobin/SoigneMoi_Mobile
- SoigneMoi Web Site https://github.com/HalTobin/SoigneMoi_Web

## Stack
The project is made with KMM using Kotlin.

## Prerequisites
- Java SDK

## Setup
1. Copy the project from Github
2Compile and run the code with the following command
```
./gradlew bootRun
```