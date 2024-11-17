plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.gms.google.services)
    id("kotlin-kapt")
}

android {
    namespace = "ru.elkael.momento"
    compileSdk = 34

    configurations.all {
        exclude(group = "com.google.protobuf", module = "protobuf-java")
    }

    defaultConfig {
        applicationId = "ru.elkael.momento"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.tools.core)

    // Dagger 2
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    // Firebase
    implementation(platform(libs.firebase.bom)) {
        exclude("com.google.protobuf", "protobuf-java")

    }
    implementation(libs.firebase.auth) {
        exclude("com.google.protobuf", "protobuf-java")
    }
    implementation(libs.google.firebase.firestore) {
        exclude("com.google.protobuf", "protobuf-java")
    }

    // Modules
    implementation(project(":ui"))
    implementation(project(":resources"))
    implementation(project(":utils"))
    implementation(project(":auth_domain"))
    implementation(project(":feature_authorization"))
    implementation(project(":firebase_auth_data"))

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}