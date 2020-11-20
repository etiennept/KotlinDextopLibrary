package os

import kotlinx.cinterop.pointed
import kotlinx.cinterop.toKString
import platform.posix.getenv
import platform.posix.getpwuid
import platform.posix.getuid
import posix.OsType

actual fun osName() = OsType.osName
actual fun hostName() = OsType.machineName
actual fun homeDir(): String = getpwuid(getuid())!!.pointed.pw_dir!!.toKString()
actual fun userName () = getenv("USER")?.toKString() ?: throw Exception()