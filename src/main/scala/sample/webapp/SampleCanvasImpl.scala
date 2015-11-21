package sample.webapp

import org.scalajs.dom
import org.scalajs.dom.html
import sample.webapp.element.{ Point, Line, Element }

case class SampleCanvasImpl(canvas: html.Canvas) extends SampleCanvas {

  private val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]

  override def clear() = {
    ctx.fillStyle = "rgb(255, 245, 227)"
    ctx.fillRect(0, 0, 1000, 600)
  }

  override def render(elements: Element*) = elements.foreach { element =>
    element match {
      case p: Point => renderPoint(p)
      case l: Line  => renderLine(l)
    }
  }

  private def renderPoint(point: Point): Unit = {
    point match { case Point(x, y) =>
      ctx.beginPath()
      ctx.fillStyle = "rgb(87, 177, 150)"
      ctx.arc(x, y, 10, 0, Math.PI*2)
      ctx.fill()
    }
  }

  private def renderLine(line: Line): Unit = {
    line match { case Line(from, to) =>
      ctx.beginPath()
      ctx.strokeStyle = "rgb(255, 131, 123)"
      ctx.lineWidth = 10
      ctx.moveTo(from.x, from.y)
      ctx.lineTo(to.x, to.y)
      ctx.closePath()
      ctx.stroke()
    }
  }
}
