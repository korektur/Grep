package ru.ifmo.ctddev.Akhundov.task7;


public class TaskImpl1<X, Y> implements Task<X, Y> {

    public X run(Y value) {
        return (X)(value.toString() + " or ride");
    }
}
