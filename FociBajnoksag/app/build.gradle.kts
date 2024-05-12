plugins {
    alias(libs.plugins.android.application)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.focibajnoksag"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.focibajnoksag"
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
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation (platform("com.google.firebase:firebase-bom:33.0.0"))
    implementation ("com.google.firebase:firebase-auth")
    implementation ("com.android.support:multidex:1.0.3")
    implementation ("com.google.firebase:firebase-firestore:25.0.0")
    implementation ("com.google.android.gms:play-services-auth:21.1.1")


    implementation ("androidx.recyclerview:recyclerview:1.3.2")
    implementation ("androidx.recyclerview:recyclerview-selection:1.1.0")
    //implementation ('com.github.bumptech.glide:glide:3.7.0')

    implementation ("com.github.bumptech.glide:glide:4.16.0")

    implementation ("androidx.cardview:cardview:1.0.0")
}