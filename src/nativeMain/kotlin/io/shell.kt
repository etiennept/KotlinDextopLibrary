package io

import platform.posix.fgetc
import platform.posix.pclose
import platform.posix.popen

actual fun execute (command : String) :String{
    val a = popen(command, "r")
    var x = ""
    while ( true){
        val e =  fgetc( a   )
        @Suppress("SENSELESS_NULL_IN_WHEN")
        when(e){
            null -> break
            else ->{
                x  += e.toChar().toString()
            }
        }
    }
    pclose(a)
    return x
}