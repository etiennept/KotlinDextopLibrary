package posix

import kotlinx.cinterop.MemScope
import kotlinx.cinterop.alloc
import kotlinx.cinterop.ptr
import kotlinx.cinterop.toKString
import platform.posix.uname
import platform.posix.utsname

object OsType {
    private val utsname= MemScope().alloc<utsname>()
    init{
        if(uname( utsname.ptr) !=0 ){
            throw Exception()
        }
    }
    val osName : String
        get() = utsname.sysname.toKString()
    val realise : String
        get() = utsname.release.toKString()
    val osVersion : String
        get() = utsname.version.toKString()
    val nodeName : String
        get() = utsname.nodename.toKString()
    val machineName :String
        get() = utsname.machine.toKString()
    val __domainName : String
        get() = utsname.__domainname.toKString()
}