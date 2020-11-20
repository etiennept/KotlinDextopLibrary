package os

import com.sun.jdi.event.MethodExitEvent
import kotlin.system.exitProcess

actual fun currentDir(  ) =  System.getProperty("user.dir")!!
actual fun  exit (  int  : Int ) {
     exitProcess(int )
}
actual fun onExit(onExit : ()->Unit ){
     Runtime.getRuntime().addShutdownHook(
          object : Thread() {
               override fun run() {
                    onExit()
               }
          }
     )
}
actual fun runtime() = "JVM"
actual fun version() =System.getProperty("java.version")!!
