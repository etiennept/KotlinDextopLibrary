package os

import kotlinx.cinterop.pointed
import kotlinx.cinterop.toKString
import platform.posix.getenv
import platform.posix.getpwuid
import platform.posix.getuid
import posix.OsType

actual val OsName
    get() = OsType.osName
actual val HostName
    get() = OsType.machineName
actual val UserDir
    get() = getpwuid(getuid())!!.pointed.pw_dir!!.toKString()
actual val UserName
    get() = getenv("USER")?.toKString() ?: throw Exception()
actual val UserLang: String
    get() = getenv("LANG")!!.toKString().split(Regex("_")).first()