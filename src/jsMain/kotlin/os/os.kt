package os

actual fun osName(): String = type()
actual fun hostName() = hostname()
actual fun homeDir(): String  = homedir()
actual fun userName () : String = userInfo().username
