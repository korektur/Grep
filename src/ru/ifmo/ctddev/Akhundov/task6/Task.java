package ru.ifmo.ctddev.Akhundov.task6;

/**
 * @author Ruslan
 *         Interface for task which Client will produce and TaskImplementor will solve.
 *         Y - type of input parameter
 *         X - type of output parameter
 */
public interface Task<X, Y> {

    /**
     * function which starts the task.
     *
     * @param value input value.
     * @return result of the task.
     */
    X run(Y value);
}
