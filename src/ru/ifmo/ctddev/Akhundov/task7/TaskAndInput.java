package ru.ifmo.ctddev.Akhundov.task7;

import java.util.concurrent.Callable;

/**
 * @param <X> output parameter type
 * @param <Y> input parameter type
 * @author Руслан
 * @see java.util.concurrent.Callable
 */
public class TaskAndInput<X, Y> implements Callable<X> {

    private Task<X, Y> task;

    private Y value;

    /**
     * Creates new <tt>TaskAndInput</tt> frome <tt>Task</tt> and Value
     *
     * @param task  task which needs to be done
     * @param value input value for the task
     * @see ru.ifmo.ctddev.Akhundov.task7.Task
     */
    public TaskAndInput(Task<X, Y> task, Y value) {
        this.task = task;
        this.value = value;
    }


    /**
     * calls <tt>Task</tt> to start executing
     *
     * @return result of the <tt>Task</tt>
     */
    @Override
    public X call() {
        return task.run(value);
    }
}
