
tasks.getByName<Jar>("jar") {
    enabled = true
}
tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = false
}

plugins{
    kotlin("plugin.allopen")
    kotlin("kapt")
}

allOpen {
   annotation("javax.persistence.Entity")
   annotation("javax.persistence.Embeddable")
   annotation("javax.persistence.MappedSuperclass")
   //annotation("com.kotlin.web.common.NoArgs")
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
//    implementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")
    //querydsl
//    api("com.querydsl:querydsl-jpa")
//    api("com.querydsl:querydsl-core")
//    kapt("com.querydsl", name = "querydsl-apt", classifier = "jpa")
}
