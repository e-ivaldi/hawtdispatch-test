package com.foolver.hawtdispatch;

import org.fusesource.hawtdispatch.Dispatch;

public interface Async {
    default void go(Runnable runnable) {
        Dispatch.getGlobalQueue().execute(runnable);
    }
}
