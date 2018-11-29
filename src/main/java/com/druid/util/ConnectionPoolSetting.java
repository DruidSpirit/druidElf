package com.druid.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionPoolSetting {
    public static ExecutorService executorService;
    // ���ӳش�С
    private static final int poolSize = 3;
    static {
        executorService = Executors.newFixedThreadPool(poolSize);
    }
}
