package os

import process

actual val  RuntimeDir
    get() = process.cwd()
actual fun exit (int: Int) { process.exit(int )}
actual fun onExit(onExit :   ()-> Unit  ) {
    process.on("beforeExit" ){
        ee -> onExit()
    }
}
actual val  Runtime
    get() =  RuntimeType.NodeJs
actual fun version() =  process.version
