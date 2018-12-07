package tech.navicore.navijson.antlr4

import tech.navicore.navijson.antlr._
import scala.collection.JavaConverters._
import scala.util.Try

class NavijsonVisitorImpl extends NavijsonParserBaseVisitor[Expr] {

  def parseDouble(s: String): Option[Double] = Try(s.toDouble).toOption

  def calculate(op1:Double, op2:Double, operation:String):Option[Double] = {
    operation match {
      case "+" => Some(op1 + op2)
      case "-" => Some(op1 - op2)
      case "*" => Some(op1 * op2)
      case "/" => Try(op1 / op2).toOption
      case _ =>
        println(s"Unsupported operation")
        None
    }
  }

  override def visitExpr(ctx: NavijsonParser.ExprContext): ExprResult = {
    val exprText = ctx.getText

    val operands: Seq[String] = ctx.NUMBER().asScala.map(_.getText)
    val operand1: Double = parseDouble(operands.headOption.getOrElse("0.0")).getOrElse(0.0)
    val operand2: Double = parseDouble(operands.lift(1).getOrElse("0.0")).getOrElse(0.0)

    val operation = visitOperation(ctx.operation())

    ExprResult(calculate(operand1, operand2, operation.name))

  }

  override def visitOperation(ctx: NavijsonParser.OperationContext): Operation = {
    val op = ctx.getText
    Operation(op)
  }

}
