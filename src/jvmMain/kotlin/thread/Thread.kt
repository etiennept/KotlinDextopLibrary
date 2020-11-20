package thread

import java.lang.Thread
fun eee(){
    val thread  = object  : Thread(){
        override fun start() {
            super.start()

        }

        override fun run() {

            println("eeeeee")
            super.run()
        }



    }
}

actual class Thread actual constructor() {
    val thread  = object  : Thread(){


        override fun run() {

        }



    }

    actual fun run() {
        thread.run()
    }




}