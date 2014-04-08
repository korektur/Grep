package ru.ifmo.ctddev.Akhundov.task6;

/**
 * @author Руслан
 * TaskRunner interface. It takes a task with the input and solves it.
 */
public interface TaskRunner {

    /**
     *
     * @param task Task to be solved
     * @param value Input for the task
     * @param <X> Output type of task
     * @param <Y> Input type of task
     * @return tasks result
     * @see ru.ifmo.ctddev.Akhundov.task6.Task
     */
    <X, Y> X run(Task<X, Y> task, Y value);

}
