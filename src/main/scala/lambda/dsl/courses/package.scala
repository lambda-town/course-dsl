package lambda.dsl

import lambda.dsl.courses.{CourseBuilders, CourseOps, Ids, PageBuilders, PageOps, ResourceBuilders, WidgetBuilders, WidgetOps}

trait DSL
  extends CourseBuilders
    with CourseOps
    with PageBuilders
    with PageOps
    with WidgetBuilders
    with ResourceBuilders
    with WidgetOps
    with Ids

package object courses extends DSL
