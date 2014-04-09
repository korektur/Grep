package ru.ifmo.ctddev.Akhundov.task7;

import java.util.concurrent.BlockingQueue;

/**
 * @param <X> output parameter type
 * @param <Y> input parameter type
 * @author Руслан
 * @see java.lang.Runnable
 */
public class Worker<X, Y> implements Runnable {

    private final BlockingQueue<X> resultsForPublishing;
    private final BlockingQueue<TaskAndInput<X, Y>> tasksQueue;

    /**
     * Creates new <tt>Worker</tt>
     *
     * @param tasksQueue           queue with tasks needed to be done
     * @param resultsForPublishing queue with results of task executing
     * @see java.util.concurrent.BlockingQueue
     */
    public Worker(BlockingQueue<TaskAndInput<X, Y>> tasksQueue, BlockingQueue<X> resultsForPublishing) {
        this.resultsForPublishing = resultsForPublishing;
        this.tasksQueue = tasksQueue;
    }


    /**
     * Runs <tt>Worker</tt>. Starts tasks executing.
     *
     * @see java.lang.Runnable
     * @see java.lang.Thread
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                TaskAndInput<X, Y> task = tasksQueue.take();
                X res = task.call();
                resultsForPublishing.put(res);
            } catch (InterruptedException e) {
                System.out.println("Worker was interrupted");
                Thread.currentThread().interrupt();
            }
        }

    }
}
