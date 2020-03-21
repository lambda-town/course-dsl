package lambda.dsl.courses

trait DSL
  extends CourseBuilders
    with CourseOps
    with PageBuilders
    with PageOps
    with WidgetBuilders
    with ResourceBuilders
    with WidgetOps
    with Ids
