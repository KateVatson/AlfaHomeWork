plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("com.codeborne:selenide:7.10.1")

    testImplementation("io.cucumber:cucumber-java:7.34.7")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.34.7")
    testImplementation("org.junit.platform:junit-platform-suite:1.13.4")

    testImplementation("io.rest-assured:rest-assured:5.5.6")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.20.0")

    implementation("net.datafaker:datafaker:2.5.4")
    implementation("com.github.lalyos:jfiglet:0.0.8")

    compileOnly("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")
}

tasks.test {
    useJUnitPlatform()
}
