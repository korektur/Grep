package ru.ifmo.ctddev.Akhundov.task6;


public class TaskImpl1<X, Y> implements Task<X, Y> {

    public X run(Y value) {
        return (X) value;
    }
}
