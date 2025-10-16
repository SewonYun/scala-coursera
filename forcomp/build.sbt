course := "progfun1"
assignment := "objsets"

scalaVersion := "3.3.0"

scalacOptions ++= Seq("-language:implicitConversions", "-deprecation")

libraryDependencies += "org.scalameta" %% "munit" % "0.7.26" % Test

ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := "4.13.4"  // 최신 안정 버전
ThisBuild / semanticdbIncludeInJar := false

// Scala 3의 경우 컴파일러 내장 SemanticDB가 있으므로 별도 플러그인 필요 없을 수 있음
// 하지만 build.sbt 내에 semanticdb 관련 설정 포함 권장
enablePlugins(BloopPlugin)
