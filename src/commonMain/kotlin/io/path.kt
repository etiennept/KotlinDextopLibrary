package io

expect fun baseName(path : String) : String
expect fun dirName( path: String) : String
expect fun readFile(path :String) : String
expect fun writeFile(path :String  , string: String  )
expect fun appendFile(path :String , string: String  )
expect fun readDir(path:String) : Array<String>
expect fun rename(oldPath: String , newPath : String)
expect fun realPath(path: String): String
expect fun mkdir(path: String)
expect fun isFile( path: String) : Boolean
expect fun isDirectory(path: String) : Boolean
expect fun exist(path: String): Boolean