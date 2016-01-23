package unlimited_works.terminal

import java.nio.charset.Charset
import com.googlecode.lanterna.TerminalFacade
import com.googlecode.lanterna.input.Key
import com.googlecode.lanterna.terminal._
//import com.googlecode.lanterna.terminal.ansi.UnixTerminal

/**
  *
  */
object MyTerminal extends App {
  val terminal = TerminalFacade.createTextTerminal()
  val screen = TerminalFacade.createScreen(terminal)
  screen.startScreen()
//  printTip("size", terminal.getTerminalSize.getColumns + "," + terminal.getTerminalSize.getRows)
  def reader: Unit = {
    var key = screen.readInput()
    while(key == null) {
      key = screen.readInput()
    }
    key.getKind match {
      case Key.Kind.ArrowUp =>
        println("ArrowUp - " + key.getCharacter)
        screen.refresh()
      case Key.Kind.NormalKey =>
        println("NormalKey - " + key.getCharacter)
        screen.putString(10,20, "aaaaa", Terminal.Color.WHITE, Terminal.Color.WHITE)
        screen.refresh()
      case Key.Kind.ArrowUp =>
        for (i <- 20 to 50) {
          terminal.putCharacter('c')
          Thread.sleep(100)
          terminal.flush()
        }
      case other =>
        terminal.flush()
    }
    reader
  }

  reader
}
