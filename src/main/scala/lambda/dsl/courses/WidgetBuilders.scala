package lambda.dsl.courses

import lambda.domain.courses.InteractiveCodeWidget.{SimpleScala2CodeWidget, TabbedScala2CodeWidget}
import lambda.domain.courses.MultipleChoices.{Answer, Question}
import lambda.domain.courses.{MarkdownText, MultipleChoices, WidgetId}


trait WidgetBuilders {
  def markdown(id: String, content: String): MarkdownText =
    MarkdownText(WidgetId(id), content)

  def mk(id: String, content: String): MarkdownText = markdown(id, content)

  def multipleChoices(id: String, question: String, rightAnswer: String, otherPropositions: String*): MultipleChoices = MultipleChoices(
    WidgetId(id),
    required = false,
    question = Question(
      question,
      rightAnswer = Answer(0, rightAnswer),
      otherPropositions = otherPropositions.zipWithIndex.map({
        case (p, i) => Answer(i + 1, p)
      }).toList
    )
  )

  def simpleScala(id: String): SimpleScala2CodeWidget = SimpleScala2CodeWidget(
    WidgetId(id),
    baseFiles = Nil,
    defaultValue = ""
  )

  def scala(id: String): SimpleScala2CodeWidget = simpleScala(id)

  def tabbedScala(id: String): TabbedScala2CodeWidget = TabbedScala2CodeWidget(
    id = WidgetId(id),
    tabs = Nil,
    baseFiles = Nil,
  )
}
