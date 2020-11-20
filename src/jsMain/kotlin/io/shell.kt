package io

import child_process.execSync

actual fun execute(command: String) :String = execSync(command).toString()
