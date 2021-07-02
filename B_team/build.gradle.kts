import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath( "org.jetbrains.kotlin:kotlin-noarg:1.3.71")
    }
}


plugins {
    id("org.springframework.boot") version "2.3.9.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE"

    kotlin("jvm") version "1.4.31"
    kotlin("plugin.spring") version "1.4.31"
}


repositories {
    mavenCentral()
}

allprojects {
    repositories {
        mavenCentral()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    gradle.projectsEvaluated {
        tasks.withType<JavaCompile> {
            options.compilerArgs.add("-Xlint:unchecked")
            options.compilerArgs.add("-Xlint:deprecation")
        }
    }



    tasks.withType<Test> {
        useJUnitPlatform()
    }

}


subprojects {

    apply {
        plugin("kotlin")
        plugin("kotlin-spring")
        //plugin("kotlin-jpa")
        plugin("idea")
        plugin("eclipse")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        // plugin( "kotlin-allopen")
    }



    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

}

