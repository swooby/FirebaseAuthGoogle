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
        vectorDrawables {
            useSupportLibrary = true
        }

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

    val androidxComposeBom = platform(libs.androidx.compose.bom)
    implementation(androidxComposeBom)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.percentlayout)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.wear.compose.foundation)
    implementation(libs.androidx.wear.compose.material)
    implementation(libs.androidx.wear.tiles)
    implementation(libs.androidx.wear.tiles.material)
    implementation(libs.androidx.wear.watchface.complications.data.source.ktx)
    implementation(libs.google.android.gms.play.services.auth)
    implementation(libs.google.android.gms.play.services.wearable)
    implementation(libs.google.android.horologist.compose.tools)
    implementation(libs.google.android.horologist.tiles)

    androidTestImplementation(androidxComposeBom)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)

    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth.ktx)
    implementation(libs.firebase.firestore.ktx)

    wearApp(project(":wear"))
}