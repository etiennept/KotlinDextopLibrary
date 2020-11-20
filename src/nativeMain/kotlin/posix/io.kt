package posix


import kotlinx.cinterop.*
import platform.posix.*


fun openFilePointer(path: String, mode : String) = fopen(path , mode ) ?: throw Exception("$path file  is not open" )
fun read( file : CPointer<FILE>): String {
    var text  =""
    while (true){
        when(val int  = fgetc(file )){
            EOF -> break
            else -> text+= int.toChar().toString()
        }
    }
    fclose(file)
    return text
}
fun write (file : CPointer<FILE>, string: String){
    string.forEach {
        fputc(it.toInt() , file )
    }
    fclose(file)
}
fun list(path : String ): Array<String> {
    val array = arrayListOf<String>()
    val dir = opendir(path) ?: throw Exception("$path is not open")
    while (true){
        when(val name = readdir(dir)){
            null ->{
                break
            }
            else ->{
                array.add(name.pointed.d_name.toKString())

            }
        }
    }
    closedir(dir )
    return array.toTypedArray()
}
