package thread

import __filename
import worker_threads.*


actual class Thread {
    private val thread =  MessageChannel()
    init {
        thread.port2.on("message"){message ->  print("eeeeee" )    }
    }
    actual fun run(){
        thread.port1.apply {
            postMessage("" )
            close()
        }
    }
}
fun ttt ( any: Any , lam : (Any) -> Unit    ) {
    if (isMainThread){
        Worker(__filename).apply {
            once("message"){message -> lam( message) }
        }.postMessage(any)
    }else parentPort?.once("message"){ message -> parentPort?.postMessage(message);}
}
