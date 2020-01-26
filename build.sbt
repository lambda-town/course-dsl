import sbtghpackages.TokenSource.Environment

ThisBuild / scalaVersion := "2.12.10"
ThisBuild / version := "0.2.2"
ThisBuild / organization := "lambda"
ThisBuild / organizationName := "Lambdacademy"

ThisBuild / githubUser := sys.env.getOrElse("GITHUB_USER", "REPLACE_ME")
ThisBuild / githubOwner := "lambdacademy-dev"
ThisBuild / githubTokenSource := Some(Environment("GITHUB_TOKEN"))
ThisBuild / githubRepository := "course-dsl"

ThisBuild / resolvers ++= Seq("domain").map(Resolver.githubPackagesRepo("lambdacademy-dev", _))

lazy val root = (project in file("."))
  .settings(
    name := "course-dsl",
    githubOwner := "lambdacademy-dev",
    libraryDependencies ++= Seq(
      "lambda" %% "domain" % "0.4.0",
      "org.scalatest" %% "scalatest" % "3.0.8" % Test
    )
  )
