tasks.getByName<Jar>("jar") {
    enabled = false
}
tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = true
}

plugins{
    kotlin("kapt")
}


dependencies {
    implementation(project(":domain"))

    implementation("org.springframework.boot:spring-boot-starter-webflux")
}
