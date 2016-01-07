package org.unlimitedcode.helloworld.util.io

import java.io.{EOFException, IOException}

trait ReadWithAttention {
  def readIntWithDefault(default: Int): Int = try {
    scala.io.StdIn.readLine() match {
      case "" => default
      case other => other.toInt
    }

  } catch {
    case e: EOFException =>
      println("EOF error, try again please >_<")
      readIntWithDefault(default)
    case e: NumberFormatException =>
      println("number format error, try again please >_<")
      readIntWithDefault(default)
    case e: IOException =>
      println("number format error, try again please >_<")
      readIntWithDefault(default)
  }

  def readStringWithDefault(default: String): String = try {
    scala.io.StdIn.readLine() match {
      case "" => default
      case other => other
    }
  } catch {
    case e: IOException =>
      println("number format error, try again please >_<")
      readStringWithDefault(default)
  }

  //user could choice refuse
  def readStringOption(refuseMark: String): Option[String] = try {
    val Refuse = refuseMark
    scala.io.StdIn.readLine() match {
      case Refuse => None
      case other => Some(other)
    }
  } catch {
    case e: IOException =>
      println("number format error, try again please >_<")
      readStringOption(refuseMark)
  }

}

object ReadHelper extends ReadWithAttention