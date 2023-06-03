plugins {
    kotlin("plugin.jpa")
}

version = "0.0.1"

allprojects {
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-data-redis")
        runtimeOnly("com.mysql:mysql-connector-j")
    }
}
