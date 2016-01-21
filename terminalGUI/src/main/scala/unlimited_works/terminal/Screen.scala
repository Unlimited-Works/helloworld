package unlimited_works.terminal

import com.googlecode.lanterna._
import com.googlecode.lanterna.input.Key.Kind
import com.googlecode.lanterna.terminal.Terminal

//import com.googlecode.lanterna.gui2._
//import com.googlecode.lanterna.terminal.swing.SwingTerminal

/**
  * https://www.youtube.com/watch?v=7Z6eOLCOrRg
  */
object Screen1 extends App {
  val gui = TerminalFacade.createScreen()
  gui.startScreen()
  gui.putString(10, 15, "Hello lanterna", Terminal.Color.WHITE, Terminal.Color.BLACK)
  gui.refresh()
  Thread.sleep(10000)
  gui.stopScreen()
  System.exit(0)
}

//read a Key and look it's Kind
object Screen2 extends App {
  val gui = TerminalFacade.createScreen()
  gui.startScreen()
  gui.putString(10,10,"10 - 10", Terminal.Color.WHITE, Terminal.Color.BLACK)
  gui.refresh()

  val strBuild = new StringBuilder()
  def reader: Unit = {
    var key = gui.readInput()
    while (key == null) {
      key = gui.readInput()
    }
    println(key.getKind.toString)
    key.getKind match {
      case Kind.ArrowDown =>
        gui.putString(9,10,"10 - 10", Terminal.Color.WHITE, Terminal.Color.BLACK)
        gui.putString(10,9,"10===", Terminal.Color.WHITE, Terminal.Color.BLACK)
        gui.refresh()
      case Kind.Escape =>
        gui.stopScreen()
        System.exit(0)
      case Kind.ArrowUp =>
        for (i <- 20 to 50) {
          gui.putString(i, 20, "X", Terminal.Color.MAGENTA,Terminal.Color.MAGENTA)
          Thread.sleep(100)
          gui.refresh()
        }
      case other => other.toString
    }
    reader
  }

  reader
}