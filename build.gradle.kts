plugins {
    kotlin("multiplatform") version "1.4.20"
    `maven-publish`
}

group = "me.etienne"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()

    maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
        }
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    
    js(LEGACY) {
        useCommonJs()
        nodejs {
            binaries.executable()
        }
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
        val nativeMain by getting
        val nativeTest by getting
        val jsMain by getting{
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-nodejs:0.0.7")
            }
        }
        val jsTest by getting{
            dependencies{
                implementation(kotlin("test-js"))
            }
        }
        configure(listOf(targets["metadata"], jvm(), js())) {
            mavenPublication {
                val targetPublication = this@mavenPublication
                groupId  = "kotlin.multiplatform"
                artifactId = "kotlin-dextop-standard-library"
                version  = "0.1.0"
                pom{

                }
                tasks.withType<AbstractPublishToMaven>()
                    .matching { it.publication == targetPublication }
                    .all { onlyIf { findProperty("isMainHost") == "true" } }
            }
        }
    }
}
