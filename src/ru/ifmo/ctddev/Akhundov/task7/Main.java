package ru.ifmo.ctddev.Akhundov.task7;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Руслан
 */
public class Main {

    private static final int NUM_OF_THREADS = 10;

    /**
     * creates and starts workers,producers and publishers.
     *
     * @param args not used
     * @see ru.ifmo.ctddev.Akhundov.task7.Producer
     * @see ru.ifmo.ctddev.Akhundov.task7.Worker
     * @see ru.ifmo.ctddev.Akhundov.task7.Publisher
     */
    public static void main(String[] args) {
        BlockingQueue<TaskAndInput<String, String>> taskQueue = new LinkedBlockingQueue<>();
        BlockingQueue<String> resultQueue = new LinkedBlockingQueue<>();
        for (int i = 0; i < NUM_OF_THREADS; ++i) {
            startProducer(taskQueue);
            startWorker(taskQueue, resultQueue);
            startPublisher(resultQueue);
        }
    }

    private static <X, Y> void startProducer(BlockingQueue<TaskAndInput<X, Y>> taskQueue) {
        Producer<X, Y> producer = new Producer<>(taskQueue);
        createAndStartThread(producer);
    }

    private static <X, Y> void startWorker(BlockingQueue<TaskAndInput<X, Y>> taskQueue, BlockingQueue<X> publishQueue) {
        Worker<X, Y> worker = new Worker<>(taskQueue, publishQueue);
        createAndStartThread(worker);
    }

    private static <Y> void startPublisher(BlockingQueue<Y> queue) {
        Publisher publisher = new Publisher(queue);
        createAndStartThread(publisher);
    }

    private static <E extends Runnable> void createAndStartThread(E o) {
        new Thread(o).start();
    }

}
