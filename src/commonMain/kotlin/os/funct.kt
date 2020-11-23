package os
expect val RuntimeDir : String
expect fun exit(int: Int)
fun exit(   ){ exit(0 ) }
expect fun onExit(onExit: () -> Unit)
expect val Runtime: RuntimeType
expect fun version(): String
/*expect fun sdterr( )
expect fun sdtin( )
expect fun sdtout( ) */
enum class RuntimeType(){
    NodeJs ,
    JVM  ,
    Native
}