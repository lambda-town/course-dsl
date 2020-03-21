package lambda.dsl.courses

import java.io.{BufferedReader, InputStreamReader}
import java.util.stream.Collectors

import lambda.domain.Media
import lambda.domain.code.SourceFile

trait ResourceBuilders {
  def mediaResource(resource: String) = Media.ClasspathResource(resource)
  def sourceFileResource(resource: String): SourceFile = SourceFile.ClasspathResource(resource)
  def code(rawCode: String): SourceFile = SourceFile.RawText(rawCode)

  def textFromResource(path: String): String = {
    val inputStream = getClass.getResourceAsStream(path)
    new BufferedReader(new InputStreamReader(inputStream))
      .lines().collect(Collectors.joining("\n")).trim
  }
}
