package os

import java.net.InetAddress

actual fun osName() = System.getProperty("os.name")!!
actual fun hostName() = InetAddress.getLocalHost().hostName!!
actual fun homeDir() = System.getProperty("user.home")!!
actual fun userName( ) = System.getProperty("user.name")!!
