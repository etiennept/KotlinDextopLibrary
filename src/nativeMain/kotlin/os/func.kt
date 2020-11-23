package os

import kotlinx.cinterop.*
import kotlinx.cinterop.internal.CStruct
import platform.linux.statfs
import platform.posix.*
import posix.atExit
import kotlin.native.concurrent.freeze
import kotlinx.cinterop.CFunction as CFunction


actual val RuntimeDir: String
    get() = getwd(ByteArray(PATH_MAX).toCValues())!!.toKString()

actual fun exit(int: Int) {
    exit(int)
}

actual fun onExit(onExit: () -> Unit) = atExit(onExit)

actual val Runtime
    get() = RuntimeType.Native

actual fun version() = ""