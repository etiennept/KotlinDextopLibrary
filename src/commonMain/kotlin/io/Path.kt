package io

class Path private constructor(name: Any ) {
     constructor(path : String) : this(name = path)
     private var path  = when(name){
          is String  ->  name
          else -> throw Exception()
     }
     val name
          get() = Path(baseName( path) )
     val parent
          get() = Path(dirName( path ) )
     fun rename(path: Path){
          rename(this.path , path.toString() )
     }
     val absolutePath
          get()= Path(realPath( path ))
     fun read() = readFile(path)
     fun write( string: String ) = writeFile(path  , string )
     fun append( string: String ) = appendFile(path , string )
     fun list() = readDir(path).toList().map {Path(it)}.toTypedArray()
     fun mkdir( )= mkdir(path)
     val isFile
          get() = isFile(path)
     val isDirectory
          get() =  isDirectory(path)
     val exist
          get() = exist(path)
     override fun toString() = path
}