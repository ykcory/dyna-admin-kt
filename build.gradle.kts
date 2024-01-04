import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter:3.2.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.10")
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.0")
    implementation("org.springframework.boot:spring-boot-starter-validation:3.2.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.0")
    implementation("org.springframework.boot:spring-boot-starter-security:3.2.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    developmentOnly("org.springframework.boot:spring-boot-devtools:3.2.0")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
    implementation("com.mysql:mysql-connector-j:8.2.0")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")
    implementation("com.baomidou:mybatis-plus-boot-starter:3.5.4.1")
    implementation("com.alibaba:druid-spring-boot-starter:1.2.20")
    implementation("cn.hutool:hutool-jwt:5.8.23")
    implementation("org.springframework.boot:spring-boot-starter-data-redis:3.2.0")
    implementation("com.alibaba.fastjson2:fastjson2-kotlin:2.0.43")
    implementation("io.minio:minio:8.5.7")
    implementation("cn.hutool:hutool-core:5.8.23")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.bootBuildImage {
    builder.set("paketobuildpacks/builder-jammy-base:latest")
}
