name := "Navijson"

version := "1.0"

scalaVersion := "2.13.12"

val antlrVer = "4.13.1"
enablePlugins(Antlr4Plugin)
antlr4Version in Antlr4 := antlrVer
antlr4PackageName in Antlr4 := Some("tech.navicore.navijson.antlr")
antlr4GenListener in Antlr4 := false
antlr4GenVisitor in Antlr4 := true

libraryDependencies ++=
  Seq(

    "org.antlr" % "antlr4-runtime" % antlrVer,
    "org.antlr" % "stringtemplate" % "4.0.2",

    "org.rogach" %% "scallop" % "5.0.1",
    "ch.qos.logback" % "logback-classic" % "1.4.14",
    "com.typesafe" % "config" % "1.4.3",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",

    "org.scalatest" %% "scalatest" % "3.2.17" % "test"

  )

mainClass in assembly := Some("tech.navicore.navijson.Main")
assemblyJarName in assembly := "Navijson.jar"

assemblyMergeStrategy in assembly := {
  case PathList("reference.conf") => MergeStrategy.concat
  case x if x.endsWith("io.netty.versions.properties") => MergeStrategy.first
  case PathList("META-INF", _ @ _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}

