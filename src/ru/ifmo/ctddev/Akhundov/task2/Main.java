package ru.ifmo.ctddev.Akhundov.task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {

    static class A{
        int a;

        public A(int b) {
            a = b;
        }

        @Override
        public String toString() {
            return "" + a;
        }
    }
    public static void main(String[] args) {
        ArrayList<A> a = new ArrayList<>();
        a.add(new A(1));
        a.add(new A(3));
        a.add(new A(2));
        a.add(new A(6));
        a.add(new A(5));
        a.add(new A(0));
        TreeSet<A> x = new TreeSet<>(a);

        for(A b : x ) {
            System.out.println(b);
        }
    }
}
