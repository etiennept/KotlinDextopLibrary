package io

actual fun execute(command: String) = Runtime.getRuntime().exec(command)!!.apply {
    waitFor()
    this.errorStream.reader().read()
}.inputStream.reader().readText()
