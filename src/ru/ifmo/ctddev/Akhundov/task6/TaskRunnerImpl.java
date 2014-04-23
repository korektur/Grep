package ru.ifmo.ctddev.Akhundov.task6;

import ru.ifmo.ctddev.Akhundov.task7.Task;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * @author Ruslan
 *         TaskRunner interface implementation. It puts task in queue and returns result when it's ready
 * @see java.lang.Runnable
 * @see ru.ifmo.ctddev.Akhundov.task6.TaskRunner
 */
public class TaskRunnerImpl implements TaskRunner {


    private final int NUM_OF_THREADS;
    private volatile boolean started;
    private final Queue<TaskAndInput<?, ?>> tasksQueue;


    protected class TaskAndInput<X, Y> implements Callable<X> {


        private Task<X, Y> task;


        private Y value;

        public TaskAndInput(Task<X, Y> task, Y value) {
            this.task = task;
            this.value = value;
        }

        @Override
        public X call() {
            return task.run(value);
        }
    }

    /**
     * Default constructor. Creates a new <tt>TaskRunnerImpl</tt> for solving tasks.
     *
     * @param numOfThreads number of threads in which we will execute tasks.
     */
    public TaskRunnerImpl(int numOfThreads) {
        tasksQueue = new ArrayDeque<>();
        NUM_OF_THREADS = numOfThreads;
        started = false;
    }

    private class Worker implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (tasksQueue) {


                }
            }
        }
    }

    /**
     * Starts TaskRunner, and begins solving tasks.
     */
    public synchronized void startSolvingTasks() {
        if (started) {
            return;
        }
        started = true;
        for (int i = 0; i < NUM_OF_THREADS; ++i) {
            Thread newWorkerThread = new Thread((new Worker()));
            newWorkerThread.start();
        }
    }

    /**
     * Adds a new task to the <tt>tasksQueue</tt> and returns it result when it's ready.
     *
     * @param task  Task to be solved
     * @param value Input for the task
     * @param <X>   Input task type parameter
     * @param <Y>   Output task type parameter
     * @return result of the task
     */
    public <X, Y> X run(Task<X, Y> task, Y value) {
        TaskAndInput<X, Y> futureTask = new TaskAndInput<>(task, value);
        tasksQueue.add(futureTask);
        return futureTask.call();
    }
}
