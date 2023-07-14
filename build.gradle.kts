import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("io.ktor.plugin") version "2.2.1"
	kotlin("jvm") version "1.6.21"
	id("org.jetbrains.kotlin.plugin.allopen") version "1.3.41"

}



application {
	mainClass.set("br.MainKt")
}


group = "br"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
//	flatDir {
//		dirs("lib/")
//	}
}


dependencies {
	implementation(files(
		"lib/sboapi.jar",
		"lib/sbowrapper.jar"))
//	runtimeOnly(files("lib/sboapi.jar", "lib/sbowrapper.jar"))
}




tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
//
//tasks.getByName<Jar>("jar") {
//	enabled = false
//}



