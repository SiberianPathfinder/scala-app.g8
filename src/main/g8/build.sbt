lazy val root = (project in file("."))
  .settings(
    scalaVersion := Versions.scala,
    name         := "$name$",
    version      := "0.0.1",
    scalacOptions ++= Seq(
      "-Xfatal-warnings",
      "-Wunused:imports,privates,locals,patvars",
      "-Wconf:src=src_managed/.*:silent",
      "-Wdead-code",
      "-Xlint:infer-any",
      "-feature",
      "-language:existentials"
    ),
    semanticdbEnabled          := true,
    semanticdbVersion          := scalafixSemanticdb.revision,
    assembly / assemblyJarName := s"\${name.value}-\${version.value}.jar",
    assembly / mainClass       := Some("io.siberianpathfinder.Main"),
    testFrameworks += new TestFramework("weaver.framework.CatsEffect"),
    libraryDependencies ++= Dependencies.all
  )
