object Versions {
    const val ktlint = "0.45.2"
}

object Libs {
    object Gradle {
        const val pluginVersion = "7.2.2"
    }

    object Kotlin {
        const val kotlinVersion = "1.7.10"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:1.7.0"
        const val appcompat = "androidx.appcompat:appcompat:1.5.1"
        const val material = "com.google.android.material:material:1.7.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
    }

    object Navigation {
        const val fragment = "androidx.navigation:navigation-fragment-ktx:2.5.3"
        const val ui = "androidx.navigation:navigation-ui-ktx:2.5.3"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val junitExt = "androidx.test.ext:junit:1.1.4"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.5.0"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:2.9.0"
        const val gson = "com.google.code.gson:gson:2.9.1"
        const val logging = "com.squareup.okhttp3:logging-interceptor:4.8.1"
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:2.44"
        const val compiler = "com.google.dagger:hilt-compiler:2.44"
        const val fragment = "androidx.hilt:hilt-navigation-fragment:1.0.0"
    }

    object Coroutine {
        const val core ="org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4"
        const val android =  "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"
    }

    object Lifecycle {
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"
        const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.5.1"
        const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
        const val savedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:2.5.1"
        const val compiler = "androidx.lifecycle:lifecycle-compiler:2.5.1"
        const val process = "androidx.lifecycle:lifecycle-process:2.5.1"
        const val coreTesting = "androidx.arch.core:core-testing:2.1.0"
    }

    object Lottie {
        const val lottie = "com.airbnb.android:lottie:5.2.0"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:4.13.2"
        const val compiler = "com.github.bumptech.glide:compiler:4.13.2"
    }
}