package io


import kotlinx.cinterop.*
import platform.posix.*
import posix.openFilePointer
import posix.read
import posix.*



actual fun baseName(path: String) = basename!!(strdup(path) )!!.toKString()
actual fun dirName(path: String) = dirname(strdup(path))?.toKString() ?: ""
actual fun readFile(path: String) = read( openFilePointer(path , "r" ))
actual fun writeFile(path: String , string :String ) = write(openFilePointer(path ,"w") , string )
actual fun appendFile(path: String , string: String ) = write(openFilePointer( path , "a") , string )
actual fun readDir(path: String ) = list(path)
actual fun realPath(path: String) = realpath( path   ,ByteArray(PATH_MAX).toCValues())?.toKString()  ?: throw Exception()
actual fun rename(oldPath : String , newPath: String ){
    if( platform.posix.rename(oldPath , newPath  )!=0 ){
        throw Exception()
    }
}
actual fun mkdir(path: String) {
    mkdir(path)
}
actual fun exist( path: String) = when (fopen( path  ,"r"  )){
        null->{
             when(opendir(path) ){
                  null-> false
                else -> true
             }
        }
        else -> true
    }
actual fun isFile( path: String) = when(fopen( path , "r" )){
    null -> false
    else -> true
}
actual fun isDirectory(path: String) = when(opendir( path  )){
    null -> false
    else -> true
}

