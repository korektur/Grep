package ru.ifmo.ctddev.Akhundov.task6;

import ru.ifmo.ctddev.Akhundov.task7.Task;

/**
 * @param <X> output parameter type.
 * @param <Y> input parameter type.
 * @author Руслан
 *         Task interface implementation for testing Client and TaskRunner.
 * @see ru.ifmo.ctddev.Akhundov.task7.Task
 */
public class TaskImpl1<X, Y extends Integer> implements Task<X, Y> {

    /**
     * Casts Y to String and  adds " solved" in the end, the result will be casted to X type.
     *
     * @param value input value.
     * @return result of the task
     */
    @SuppressWarnings("unchecked")
    public X run(Y value) {
        return (X) (value.toString() + " solved");
    }
}
