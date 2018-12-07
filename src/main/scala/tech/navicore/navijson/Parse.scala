package tech.navicore.navijson

import com.typesafe.scalalogging.LazyLogging
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import tech.navicore.navijson.antlr.{NavijsonLexer, NavijsonParser}
import tech.navicore.navijson.antlr4.{NavijsonVisitorImpl, Expr}

object Parse extends LazyLogging {

  val arithmeticVisitor = new NavijsonVisitorImpl()

  def apply(input: String): Expr = {

    logger.debug("Evaluating expression: " + input)

    val charStream = CharStreams.fromString(input)
    val lexer = new NavijsonLexer(charStream)
    val tokens = new CommonTokenStream(lexer)
    val parser = new NavijsonParser(tokens)
    arithmeticVisitor.visit(parser.expr())
  }

}
