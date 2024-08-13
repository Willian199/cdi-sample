package br.com.will.thread.queue.manager.runtime.service;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionStage;

public interface ThreadQueueManager {

    public abstract <T> CompletionStage<T> executeTasks(Callable<T> task);

    public abstract Boolean completed();
}
