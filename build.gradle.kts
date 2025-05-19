buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.50") // ✅ Última versión
    }
}

plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "2.0.0" apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

