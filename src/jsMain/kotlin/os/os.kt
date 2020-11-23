package os

import process

actual val  OsName
    get() = type()
actual val  HostName
    get() = hostname()
actual val  UserDir
    get() = homedir()
actual val  UserName
    get() = userInfo().username
actual val  UserLang
    get() = process.env.asDynamic().lang
