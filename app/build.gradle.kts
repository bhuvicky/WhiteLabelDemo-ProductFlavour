plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.whitelabeldemo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.whitelabeldemo"
        minSdk = 28
        targetSdk = 35
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
    flavorDimensions += listOf("brand", "environment")  // Define dimensions

    productFlavors {
        // Brand dimension
        create("clientA") {
            dimension = "brand"
            applicationIdSuffix  = ".clientA"
            resValue("string", "app_name", "Client A")
        }
        create("clientB") {
            dimension = "brand"
            applicationIdSuffix = ".clientB"
            resValue("string", "app_name", "Client B")
        }

        // Environment dimension
        create("staging") {
            dimension = "environment"
            resValue("string", "api_url", "https://staging.api.com")
        }
        create("production") {
            dimension = "environment"
            resValue("string", "api_url", "https://api.com")
        }
    }
    sourceSets {
        matching {
            listOf("clientA", "clientB").contains(it.name)
        }.configureEach {
            manifest.srcFile("src/shared/")
            java.srcDir("src/shared/kotlin")
            res.srcDir("src/shared/res")
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
    }
}

dependencies {
    implementation(project(":whitelabel"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.compose.pager)
//    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Hilt
    implementation(libs.hilt.dagger.android)
    ksp(libs.hilt.dagger.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}