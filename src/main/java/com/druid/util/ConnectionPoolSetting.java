package com.druid.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionPoolSetting {
    public static ExecutorService executorService;
    // 连接池大小
    private static final int poolSize = 5;
    static {
        executorService = Executors.newFixedThreadPool(poolSize);
    }
}
