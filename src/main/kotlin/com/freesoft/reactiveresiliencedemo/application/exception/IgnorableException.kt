package com.freesoft.reactiveresiliencedemo.application.exception

import java.lang.RuntimeException

class IgnorableException(override val message: String) : RuntimeException()