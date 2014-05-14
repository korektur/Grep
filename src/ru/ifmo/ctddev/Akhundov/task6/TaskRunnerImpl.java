package ru.ifmo.ctddev.Akhundov.task6;

import ru.ifmo.ctddev.Akhundov.task7.Task;

/**
 * @author Ruslan
 *         TaskRunner interface implementation. It puts task in queue and returns result when it's ready
 * @see java.lang.Runnable
 * @see ru.ifmo.ctddev.Akhundov.task6.TaskRunner
 */
public class TaskRunnerImpl implements TaskRunner {


    private final int NUM_OF_THREADS;
    private volatile boolean started;
    private final BlockingQueue<TaskAndInput<?, ?>> tasksQueue;


    private class TaskAndInput<X, Y> {


        private Task<X, Y> task;
        private Y value;
        private volatile X result;

        public TaskAndInput(Task<X, Y> task, Y value) {
            this.task = task;
            this.value = value;
            result = null;
        }

        public void run() {
            result = task.run(value);
        }

        public X call() {
            while(result == null);
            return result;
        }

    }

    /**
     * Default constructor. Creates a new <tt>TaskRunnerImpl</tt> for solving tasks.
     *
     * @param numOfThreads number of threads in which we will execute tasks.
     */
    public TaskRunnerImpl(int numOfThreads) {
        tasksQueue = new BlockingQueue<>();
        NUM_OF_THREADS = numOfThreads;
        started = false;
    }

    private class Worker implements Runnable {

        @Override
        @SuppressWarnings("unchecked")
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                tasksQueue.pop().run();
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
        tasksQueue.push(futureTask);
        return futureTask.call();
    }
}
