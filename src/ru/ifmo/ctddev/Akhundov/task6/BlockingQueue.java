package ru.ifmo.ctddev.Akhundov.task6;

import java.util.ArrayDeque;
import java.util.Queue;

public class BlockingQueue<E> {

    private final Queue<E> queue;

    public BlockingQueue() {
        queue = new ArrayDeque<>();
    }

    public void push(E e) {
        synchronized (queue) {
            queue.add(e);
            queue.notify();
        }
    }

    public E pop() {
        synchronized (queue) {
            while (queue.size() == 0) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    //never used
                }
            }
            return queue.poll();

        }
    }
}
