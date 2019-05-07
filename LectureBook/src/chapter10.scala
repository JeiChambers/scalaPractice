
object layout extends App{

  abstract class Element {
    def contents: Array[String]
    val height: Int = contents.length
    val width =
      if (height == 0) 0 else contents(0).length
  }

  class ArrayElement(val contents: Array[String]) extends Element{
    val contents: Array[String] = conts
  }

  class LineElements(s: String) extends ArrayElement(Array(s)){
// Super class ArrayElement is expecting an Array so we must explicitly cast an Array type on variable.
    override def width: Int = s.length
    override def height = 1
  }

  class UniformElement(ch: Char, override val width: Int, override height: Int) extends Element{
    private val line = ch.toString * width
    def contents: Array[String] = Array.fill(height)(line)
  }


  val e1: Element = new ArrayElement(Array("hello"))
  val ae: ArrayElement = new LineElement("hello")
  val e2: Element = ae
  val e3: Element = new UniformElement('x', 2, 3)
}
