plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.plugin.dagger)
}

android {
    namespace = "com.example.coremovie"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.coremovie"
        minSdk = 24
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
        debug {
            buildConfigField("String", "BASE_URL", "'https://api.themoviedb.org/3/'")
            buildConfigField("String", "API_KEY", "'34d28168ca773abb8e7098976e940a85'")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //viewmodel
    implementation(libs.dagger)
    implementation(libs.daggerCompiler)
    implementation(libs.viewmodelAct)
    implementation(libs.viewmodelFrg)
    implementation(libs.gson)
    implementation(libs.retrofit)
    implementation(libs.retrofitConverter)
    implementation(libs.loggingInterceptor)
    implementation(libs.lifecycle)
    implementation(libs.livedata)
}