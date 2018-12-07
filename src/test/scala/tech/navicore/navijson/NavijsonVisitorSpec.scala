package tech.navicore.navijson

import org.scalatest._
import tech.navicore.navijson.antlr4._

class NavijsonVisitorSpec extends FlatSpec with Matchers {

  "addition should" should "add" in {
    Parse("1 + 2") should be(ExprResult(Some(3)))
  }

  "multiplication" should "multiply" in {
    Parse("2 * 3") should be(ExprResult(Some(6)))
  }

  "1 ^ 2" should "fail" in {
    Parse("1 ^ 2") should be(ExprResult(None))
  }

}
