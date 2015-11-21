package sample.webapp

import org.scalajs.dom
import org.scalajs.dom.html
import sample.webapp.element.{ Point, Line }

import scala.scalajs.js.annotation.JSExport

@JSExport
object Application {
  @JSExport
  def main(canvas: html.Canvas): Unit = {
    val sampleCanvas = SampleCanvas.apply(canvas)

    def run = {
      sampleCanvas.clear()
      sampleCanvas.render(
        Point(50, 50),
        Line(Point(10, 30), Point(30, 50)),
        Line(Point(100, 255), Point(100, 50)))
    }

    dom.setInterval(() => run, 100)
  }
}
