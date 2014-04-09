package ru.ifmo.ctddev.Akhundov.task7;

import java.util.concurrent.BlockingQueue;

/**
 * @author Руслан
 *         Publishes results of the <tt>Task</tt> executing.
 * @see ru.ifmo.ctddev.Akhundov.task7.Task
 * @see java.lang.Runnable
 */
public class Publisher implements Runnable {

    private BlockingQueue<?> resultsToPublish;

    /**
     * Creates a new <tt>Publisher</tt>
     *
     * @param resultsToPublish queue with results to be published.
     * @see java.util.concurrent.BlockingQueue
     */
    public Publisher(BlockingQueue<?> resultsToPublish) {
        this.resultsToPublish = resultsToPublish;
    }

    /**
     * Starts <tt>Publisher</tt>. Prints results from tasks.
     *
     * @see java.lang.Runnable
     * @see java.lang.Thread
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(resultsToPublish.take());
            } catch (InterruptedException e) {
                System.out.println("Publisher was interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }
}
