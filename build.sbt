name := "oap-perf-suite"

version := "1.0"

scalaVersion := "2.11.12"

/* For oap 0.5.0 package, there are two guava packages.
 * One is from Spark. The other is from ORC.
 * Use below strategy to select the first matching guava package.
 */
assemblyMergeStrategy in assembly := {
  case PathList("com", "google", "guava", xs @ _*) => MergeStrategy.first
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

unmanagedJars in Compile += file("/home/oap/oap/oap-0.4.0-SNAPSHOT.jar")
unmanagedJars in Compile += file("lib/spark-sql-perf_2.11-0.4.11-SNAPSHOT.jar")

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.1.0" % "provided"
libraryDependencies += "org.reflections" % "reflections" % "0.9.10" % "compile"
