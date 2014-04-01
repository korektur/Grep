package ru.ifmo.ctddev.Akhundov.task6;

/**
 * Created by Руслан on 01.04.2014.
 */
public interface TaskRunner {

    <X, Y> X run(Task<X, Y> task, Y value);

}
