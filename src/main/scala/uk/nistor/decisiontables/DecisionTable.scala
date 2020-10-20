package uk.nistor.decisiontables

class DecisionTable[T] (rules : List[DecisionRule[T]]) {

  def execute(thing: T) : Map[String, Object] = {
    Map()
  }

  override def toString: String = rules.toString
}

object DecisionTable {
  def main(arg : Array[String]): Unit = {
    val dec = new BooleanDecisionRule[String](_ => true)

    println(new DecisionTable(List(dec, dec)))
    println(dec.test("irrelevant"))
    println(dec.test(null))
  }
}


