package io

import Path
import fs.*


actual fun baseName(path :String) = Path().basename(path)
actual fun dirName( path : String )  = Path().dirname(path)
actual fun readFile( path: String ): String = readFileSync(path , "utf8"  )
actual fun writeFile(path: String , string: String ) = writeFileSync(path , string ,"utf8") as Unit
actual fun appendFile(path : String , string: String) = appendFileSync(path ,  string ,  "utf8" ) as Unit
actual fun readDir(path :String ) = readdirSync(path , "utf8") as Array<String>
actual fun realPath( path: String) = realpathSync(path , "utf8" ) as String
actual fun rename(oldPath: String  , newPath: String) = renameSync( oldPath , newPath )
actual fun mkdir(path: String) = mkdirSync( path  , "0o777" ) as Unit
actual fun exist(path: String) = existsSync( path  )
actual fun isFile(path : String) =  lstatSync(path).isFile()
actual fun isDirectory(path: String ) = lstatSync(path).isDirectory()
