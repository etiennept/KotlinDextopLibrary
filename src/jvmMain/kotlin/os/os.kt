package os

import java.net.InetAddress

actual val  OsName
    get() = System.getProperty("os.name")!!
actual val  HostName
    get  () = InetAddress.getLocalHost().hostName!!
actual val  UserDir
    get () = System.getProperty("user.home")!!
actual val  UserName
    get ( ) = System.getProperty("user.name")!!
actual val UserLang: String
    get() = System.getProperty("user.language")