package uk.nistor.decisiontables

class DecisionTableBuilder(inputs: List[String] = List(), outputs: List[String] = List()) {

  //  private [Main] val inputs : List[String]

  def input(a: String) = new DecisionTableBuilder(inputs :+ a, outputs)

  def output(b: String) = new DecisionTableBuilder(inputs, outputs :+ b)

  override def toString = s"Table($inputs, $outputs)"
}


object Main {
  type Anar = Array[Object]

  def main(args: Array[String]): Unit = {
    val table = new DecisionTableBuilder()
      .input("input 1")
      .input("input 2")
      .output("output")

    println(table)
  }
}
