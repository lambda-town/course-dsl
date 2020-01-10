package lambda.dsl.courses

import lambda.domain.courses.{InteractiveCodeWidget, Page}
import lambda.domain.courses.Page.{CodePage, PageId, SimplePage}

trait PageBuilders {

  def simplePage(
      id: String,
      title: String
  ): SimplePage = SimplePage(
    PageId(id),
    title,
    Nil
  )

  def simplePage(title: String): Page  = simplePage(slug(title), title)

  def codePage(
      id: String,
      title: String,
      code: InteractiveCodeWidget
  ): CodePage = CodePage(
    PageId(id),
    title,
    Nil,
    code
  )
}
