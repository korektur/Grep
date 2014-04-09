package ru.ifmo.ctddev.Akhundov.task7;

import java.util.concurrent.BlockingQueue;

/**
 * @author Руслан
 *         Produces tasks for Publisher
 */
public class Producer<X, Y> implements Runnable {


    private final BlockingQueue<TaskAndInput<X, Y>> taskQueue;

    /**
     * @param taskQueue queue in which producer will put new tasks for Workers
     * @see java.util.concurrent.BlockingQueue
     * @see ru.ifmo.ctddev.Akhundov.task7.TaskAndInput
     */
    public Producer(BlockingQueue<TaskAndInput<X, Y>> taskQueue) {
        this.taskQueue = taskQueue;
    }

    /**
     * Creates new tasks and puts them in queue
     *
     * @see java.util.concurrent.BlockingQueue
     * @see ru.ifmo.ctddev.Akhundov.task7.Task
     * @see java.lang.Runnable
     * @see java.lang.Thread
     */
    @SuppressWarnings("unchecked")
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Task<X, Y> task = new TaskImpl1<>();
                Y value = (Y) ("task");
                taskQueue.put(new TaskAndInput<>(task, value));
            } catch (InterruptedException e) {
                System.out.println("Interrupting Producer");
                Thread.currentThread().interrupt();
            }
        }
    }
}
