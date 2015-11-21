package sample.webapp.element

case class Point(x: Int, y: Int) extends Element {
  def +(p: Point) = Point(x + p.x, y + p.y)
}
