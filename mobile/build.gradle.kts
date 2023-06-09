@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.googleDaggerHiltAndroid)
    alias(libs.plugins.googleGmsGoogleServices)
    alias(libs.plugins.kotlinAndroid)
    // Dagger/Hilt still need [slower] kapt per:
    // https://kotlinlang.org/docs/ksp-overview.html#supported-libraries
    //  https://github.com/google/dagger/issues/2349
    //  https://issuetracker.google.com/issues/179057202
    kotlin("kapt")
}

android {
    namespace = "com.swooby.FirebaseAuthGoogle"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.swooby.FirebaseAuthGoogle"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

hilt {
    enableAggregatingTask = true
}

dependencies {
    implementation(libs.google.dagger.hilt.android)
    kapt(libs.google.dagger.hilt.android.compiler)
    kapt(libs.androidx.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    val androidxComposeBom = platform(libs.androidx.compose.bom)
    implementation(androidxComposeBom)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.google.android.gms.play.services.wearable)
    implementation(libs.google.android.material)

    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.test.ext.junit)
    testImplementation(libs.junit)

    wearApp(project(":wear"))
}