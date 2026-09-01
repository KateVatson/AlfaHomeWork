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

    testImplementation("io.cucumber:cucumber-java:7.34.7")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.34.7")
    testImplementation("org.junit.platform:junit-platform-suite:1.13.4")

    implementation("net.datafaker:datafaker:2.5.4")
    implementation("com.github.lalyos:jfiglet:0.0.8")
}

tasks.test {
    useJUnitPlatform()
}