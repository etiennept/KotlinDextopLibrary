package posix

import kotlinx.cinterop.staticCFunction
import platform.posix.atexit

private lateinit var a : () -> Unit
fun atExit( onExit :  ()->Unit  ){
    a = onExit
    atexit(staticCFunction<Unit>{a( )})
}
