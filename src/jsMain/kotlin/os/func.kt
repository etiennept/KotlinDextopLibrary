package os

import process

actual fun currentDir() = process.cwd()
actual fun exit (int: Int) { process.exit(int )}
actual fun onExit(onExit :   ()-> Unit  ) {
    process.on("beforeExit" ){
        ee -> onExit()
    }
}
actual fun runtime () = "NodeJs"
actual fun version() =  process.version
