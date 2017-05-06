name := "mu-extract"

organization := "extract"

version := "0.1"

scalaVersion := "2.11.0"

libraryDependencies ++= Seq("org.apache.spark" %% "spark-core"  % "2.1.0",
                            "org.apache.spark" %% "spark-sql"  % "2.1.0",
                            "org.apache.spark" %% "spark-catalyst"  % "2.1.0",
                            "org.scala-lang" % "scala-library" % "2.11.0")