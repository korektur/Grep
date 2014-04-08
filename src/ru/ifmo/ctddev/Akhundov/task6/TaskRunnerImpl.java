package ru.ifmo.ctddev.Akhundov.task6;

import java.util.concurrent.*;

public class TaskRunnerImpl implements TaskRunner, Runnable {

    private BlockingQueue<FutureTask<?>> tasksQueue;

    private class TaskAndInput<X, Y> implements Callable<X> {
        Task<X, Y> task;
        Y value;

        public TaskAndInput(Task<X, Y> task, Y value) {
            this.task = task;
            this.value = value;
        }

        @Override
        public X call() throws Exception {
            return task.run(value);
        }
    }

    public TaskRunnerImpl() {
        tasksQueue = new LinkedBlockingQueue<>();
    }

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
