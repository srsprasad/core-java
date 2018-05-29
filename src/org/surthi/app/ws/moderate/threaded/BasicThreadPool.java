package org.surthi.app.ws.moderate.threaded;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BasicThreadPool extends ThreadPoolExecutor {
  private static final int POOL_SIZE = 10;
  private boolean isPaused;
  private ReentrantLock pauseLock = new ReentrantLock();
  private Condition unPaused = pauseLock.newCondition();

  public BasicThreadPool() {
    super(POOL_SIZE, POOL_SIZE, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(POOL_SIZE));
  }

  @Override
  protected void beforeExecute(Thread t, Runnable r) {
    super.beforeExecute(t, r);
    pauseLock.lock();
    try {
      while (isPaused)
        unPaused.await();
    } catch (InterruptedException iexp) {
      t.interrupt();
    } finally {
      pauseLock.unlock();
    }
  }

  public void pause() {
    pauseLock.lock();
    try {
      isPaused = true;
    } finally {
      pauseLock.unlock();
    }
  }

  public void resume() {
    pauseLock.lock();
    try {
      isPaused = false;
      unPaused.signalAll();
    } finally {
      pauseLock.unlock();
    }
  }
}
