package com.freesoft.reactiveresiliencedemo.application.exception

import java.util.function.Predicate

class RecordFailure : Predicate<Throwable> {
    override fun test(t: Throwable): Boolean = t !is IgnorableException
}