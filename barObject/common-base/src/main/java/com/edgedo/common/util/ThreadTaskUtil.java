package com.edgedo.common.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTaskUtil {
   private int threadNum = 10;
   private ExecutorService executor;

   public ThreadTaskUtil(int threadNum) {
      this.threadNum = threadNum;
      this.executor = Executors.newFixedThreadPool(this.threadNum);
   }

   public Future submit(Callable task) {
      return this.executor.submit(task);
   }

   public void execute(Runnable run) {
      this.executor.execute(run);
   }
}
