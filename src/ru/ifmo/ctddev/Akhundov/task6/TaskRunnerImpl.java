package ru.ifmo.ctddev.Akhundov.task6;

import java.util.concurrent.*;

/**
 * @author Ruslan
 * TaskRunner interface implementation. It puts task in queue and returns result when it's ready
 * @see java.lang.Runnable
 * @see ru.ifmo.ctddev.Akhundov.task6.TaskRunner
 */
public class TaskRunnerImpl implements TaskRunner, Runnable {

    /**
     * Queue of tasks.
     * @see java.util.concurrent.BlockingQueue
     */
    private BlockingQueue<FutureTask<?>> tasksQueue;

    /**
     * class which stores task and input for it.
     * @param <X> Output task parameter type.
     * @param <Y> Input task parameter type.
     * @see java.util.concurrent.Callable
     */
    private class TaskAndInput<X, Y> implements Callable<X> {

        /**
         * task which is need to be stored
         * @see ru.ifmo.ctddev.Akhundov.task6.Task
         */
        private Task<X, Y> task;

        /**
         * Input parameter for the stored task.
         */
        private Y value;

        /**
         * Constructor
         * @param task <tt>Task</tt> which is need to be stored
         * @param value Input value for the task
         * @see ru.ifmo.ctddev.Akhundov.task6.Task
         */
        public TaskAndInput(Task<X, Y> task, Y value) {
            this.task = task;
            this.value = value;
        }


        /**
         * Runs the task
         * @return task result
         * @throws Exception in case of something bad happened while running task
         */
        @Override
        public X call() throws Exception {
            return task.run(value);
        }
    }

    /**
     * Default constructor. Creates a new <tt>TaskRunnerImpl</tt> for solving tasks.
     */
    public TaskRunnerImpl() {
        tasksQueue = new LinkedBlockingQueue<>();
    }

    /**
     * Runs the <tt>TaskRunnerImpl</tt>
     * It takes a new task from the <tt>tasksQueue</tt> and try to run it.
     * Finishes in case of Interrupting while running the task
     * @see java.util.concurrent.FutureTask
     * @see java.util.concurrent.BlockingQueue
     */
    @Override
    public void run() {
        boolean isFinished = false;
        while (!isFinished) {
            try {
                FutureTask<?> task = tasksQueue.take();
                task.run();
            } catch (InterruptedException e) {
                isFinished = true;
                System.out.println("task execution was interrupted");
            }
        }
    }

    /**
     * Adds a new task to the <tt>tasksQueue</tt> and returns it result when it's ready.
     * @param task Task to be solved
     * @param value Input for the task
     * @param <X> Input task type parameter
     * @param <Y> Output task type parameter
     * @return result of the task
     */
    public <X, Y> X run(Task<X, Y> task, Y value) {
        try {
            FutureTask<X> futureTask = new FutureTask<>(new TaskAndInput<>(task, value));
            tasksQueue.put(futureTask);
            return futureTask.get();
        } catch (InterruptedException e) {
            System.out.println("task was interrupted");
        } catch (ExecutionException e) {
            System.out.println("failed to execute task");
        }
        return null;
    }
}
