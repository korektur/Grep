package ru.ifmo.ctddev.Akhundov.task6;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TaskRunnerImplTest extends TestCase {

    ArrayList<Task> tasks;
    ArrayList<Double> values;
    @Before
    public void init() {
        tasks = new ArrayList<>(10);
        values = new ArrayList<>(10);
        for(int i = 0; i < 10; ++i) {
            tasks.add(new TaskImpl1<Integer, Double>());
            values.add(i + 0.1);
        }
    }

    @Test
    public void Test1() {
        ArrayList<Thread> threads = new ArrayList<>(10);
        for(int i = 0; i < threads.size(); ++i) {
            threads.add(new Thread());
        }
        for(int i = 0; i < threads.size();  ++i) {
            TaskRunner taskRunner = new TaskRunnerImpl();
            threads.get(i).run();

        }
    }
}
