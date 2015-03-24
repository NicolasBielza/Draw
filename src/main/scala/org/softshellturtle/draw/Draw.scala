package org.softshellturtle.draw

import java.awt.{Color, Graphics, Dimension}
import javax.swing.{JComponent, JComboBox, JFrame}

case class Point(x: Int, y: Int)

case class Line(a: Point, b: Point, color: Color)

class Draw extends JComponent {
  var lines: List[Line] = List()

  def addLine(l: Line) = lines ::= l

  override def paintComponent(g: Graphics): Unit = {
    super.paintComponent(g)
    for(l <- lines) {
      g.setColor(l.color)
      g.drawLine(l.a.x, l.a.y, l.b.x, l.b.y)
    }
  }
}

object Draw extends App {
  Console.println("Hello Draw !")

  val frame = new JFrame()
  frame.setTitle("Draw")
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

  val draw = new Draw
  draw.setPreferredSize(new Dimension(320, 200))
  val a = Point(100, 40)
  val b = Point(150, 140)
  val c = Point(230, 40)
  draw.addLine(Line(a, b, Color.GREEN))
  draw.addLine(Line(b, c, Color.GREEN))
  draw.addLine(Line(c, a, Color.GREEN))
  frame.add(draw)

  frame.pack()
  frame.setVisible(true)
}
