// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.7.0" apply false
}
buildscript {
    extra.apply {
        set("lifecycle_version", "2.6.1")
    }
}