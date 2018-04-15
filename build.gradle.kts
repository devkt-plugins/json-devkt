import java.io.*

val kotlinVersion = "1.2.31"

group = "com.intellij.devkt.json"
version = "v1.0-SNAPSHOT"

plugins { java }

java {
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
}

java.sourceSets {
	"main" {
		java.setSrcDirs(listOf("src"))
		resources.setSrcDirs(listOf("res"))
	}
}

repositories {
	mavenCentral()
	jcenter()
}

dependencies {
	compileOnly(kotlin("compiler-embeddable", kotlinVersion))
	compileOnly(files(*File("lib").listFiles()))
}

