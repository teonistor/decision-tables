package uk.nistor.decisiontables

import org.assertj.core.api.Assertions._
import org.mockito.Mock
import org.mockito.Mockito._
import org.mockito.MockitoAnnotations.initMocks
import org.scalatest.BeforeAndAfterEach
import org.scalatest.funsuite.AnyFunSuiteLike

class BooleanDecisionRuleTest extends AnyFunSuiteLike with BeforeAndAfterEach {

  val combinations = List((false, false, "match"), (false, true, "no match"), (true, true, "match"), (true, false, "no match"))

  @Mock var thing: Object =_
  @Mock var extractor: Function[Object, Boolean] =_

  override def beforeEach() {
    initMocks(this)
  }

  combinations.foreach(t => {
    test(s"(${t._1}, ${t._2}) -> ${t._3}") {
      when(extractor.apply(thing)).thenReturn(t._1)

      assertThat(new BooleanDecisionRule(extractor, t._2).test(thing)).isEqualTo(t._1 == t._2)

      verify(extractor).apply(thing)
    }
  })

  override def afterEach() {
    verifyNoMoreInteractions(thing, extractor)
  }
}
