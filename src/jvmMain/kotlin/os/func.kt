package os

import com.sun.jdi.event.MethodExitEvent
import java.lang.Runtime.getRuntime
import kotlin.system.exitProcess

actual val RuntimeDir
             get (  ) =  System.getProperty("user.dir")!!
actual fun  exit (  int  : Int ) {
     exitProcess(int )
}
actual fun onExit(onExit : ()->Unit ){
     getRuntime().addShutdownHook(
          object : Thread() {
               override fun run() {
                    onExit()
               }
          }
     )
}
actual val Runtime
     get() = RuntimeType.JVM
actual fun version() =System.getProperty("java.version")!!
