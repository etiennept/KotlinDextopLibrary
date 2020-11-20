package io

import java.io.File


actual fun baseName(path: String) = File(path ).name!!
actual fun dirName(path: String) = File(path).parent!!
actual fun readFile(path: String) = File (path).readText().toString()
actual fun writeFile(path: String, string: String) = File(path).writeText(string)
actual fun appendFile(path: String, string: String) = File(path).appendText(string)
actual fun readDir(path: String) = File(path).list( )!! as Array<String>
actual fun realPath(path: String) = File(path).absolutePath!!
actual fun rename(oldPath: String, newPath: String) {
    if (!File(oldPath).renameTo(File(newPath))){
        throw Exception()
    }
}
actual fun mkdir(path: String) {
    if(!File(path).mkdir() ){
        throw Exception()
    }
}
actual fun exist(path: String) = File(path).exists()
actual fun isFile(path: String) = File(path ).isFile
actual fun isDirectory(path: String) = File(path).isDirectory