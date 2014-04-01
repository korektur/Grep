package ru.ifmo.ctddev.Akhundov.task6;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TaskRunnerImpl implements TaskRunner {
    private BlockingQueue<Pair> tasksQueue;

    private class Pair {
        Task task;
        Object value;

        public <X, Y> Pair(Task<X, Y> task, Y value) {
            this.task = task;
            this.value = value;
        }
    }

    public TaskRunnerImpl() {
        tasksQueue = new ArrayBlockingQueue<>(10);
    }

    public <X, Y> X run(Task<X, Y> task, Y value) {
        return task.run(value);
    }

    public <X, Y> void add(Task<X, Y> task, Y value) {
        try {
            tasksQueue.put(new Pair(task, value));
        } catch (InterruptedException e) {
            System.out.print("cannot put task" + task.toString() + "in queue because of interrupting.");
        }
    }

    @SuppressWarnings("unchecked")
    public void execute() {
        while(!tasksQueue.isEmpty()) {
            try {
                Pair pair = tasksQueue.take();
                System.out.println(run(pair.task, pair.value));
            } catch (InterruptedException e) {
                System.out.print("cannot run task because of interrupting");
            }
        }
    }

}
