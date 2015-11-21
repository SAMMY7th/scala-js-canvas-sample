package sample.webapp

import org.scalajs.dom.html
import sample.webapp.element.Element

trait SampleCanvas {
  def clear()
  def render(element: Element*)
}

object SampleCanvas {
  def apply(canvas: html.Canvas): SampleCanvas = SampleCanvasImpl(canvas)
}