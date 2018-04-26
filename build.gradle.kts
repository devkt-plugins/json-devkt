import java.io.*

val kotlinVersion = "1.2.40"

group = "com.intellij.devkt.json"
version = "v1.0"

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
	maven("https://jitpack.io")
}

dependencies {
	compileOnly(kotlin("compiler-embeddable", kotlinVersion))
	val version = "fffe21c45d"
	compileOnly(group = "com.github.ice1000.dev-kt", name = "common", version = version)
	runtime(group = "com.github.ice1000.dev-kt", name = "swing", version = version)
}

