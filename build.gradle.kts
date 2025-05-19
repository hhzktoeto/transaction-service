plugins {
    java
    id("org.springframework.boot") version "3.4.5"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "hhz.ktoeto"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_21

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    val lombokVersion = "1.18.38"
    val liquibaseVersion = "4.31.1"
    val postgresDriverVersion = "42.7.5"
    val jacksonDatatypeVersion = "2.19.0"
    val mapstructVersion = "1.6.3"

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonDatatypeVersion")
    implementation("org.liquibase:liquibase-core:$liquibaseVersion")// https://mvnrepository.com/artifact/org.postgresql/postgresql
    implementation("org.postgresql:postgresql:$postgresDriverVersion")
    implementation("org.projectlombok:lombok:$lombokVersion")
    implementation("org.mapstruct:mapstruct:$mapstructVersion")

    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

tasks.bootJar {
    archiveFileName.set("transaction-service.jar")
    destinationDirectory.set(file("./build/"))
}

tasks.compileJava {
    options.encoding = "UTF-8"
}
