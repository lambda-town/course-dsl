import sbtghpackages.TokenSource.Environment

ThisBuild / scalaVersion := "2.12.10"
ThisBuild / version := "0.2.8"
ThisBuild / organization := "lambda"
ThisBuild / organizationName := "Lambdacademy"

githubOwner := "lambdacademy-dev"
resolvers += Resolver.githubPackages("lambdacademy-dev")
githubRepository := "course-dsl"
githubTokenSource :=  TokenSource.Environment("GITHUB_TOKEN") || TokenSource.GitConfig("github.token")

lazy val root = (project in file("."))
  .settings(
    name := "course-dsl",
    githubOwner := "lambdacademy-dev",
    libraryDependencies ++= Seq(
      "lambda" %% "domain" % "0.4.6",
      "org.scalatest" %% "scalatest" % "3.1.1" % Test
    )
  )
