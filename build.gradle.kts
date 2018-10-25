plugins {
    id("org.jetbrains.kotlin.jvm").version("1.2.70")
    application
    idea
}

repositories {
    jcenter()
}

dependencies {
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-stdlib-jdk8")
    implementation(group = "org.fedorahosted.tennera", name = "jgettext", version = "0.15.1")
}

application {
    mainClassName = "po.conv.AppKt"
}
