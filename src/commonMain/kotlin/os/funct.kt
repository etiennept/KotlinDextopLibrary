package os

expect fun currentDir( ) :  String
expect fun exit(int: Int)
fun exit(   ){ exit(0 ) }
expect fun onExit(onExit: () -> Unit)
expect fun runtime() : String
expect fun version(): String
/*expect fun sdterr( )
expect fun sdtin( )
expect fun sdtout( ) */