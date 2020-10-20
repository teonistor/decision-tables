package uk.nistor.decisiontables

import java.util.function.Predicate

trait DecisionRule[T] extends Predicate[T]{
}

class BooleanDecisionRule[T](extractor: Function[T, Boolean], desiredValue: Boolean = true) extends DecisionRule[T] {
  override def test(thing: T): Boolean = extractor.apply(thing) == desiredValue
}
