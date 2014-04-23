package ru.ifmo.ctddev.Akhundov.task6;

import ru.ifmo.ctddev.Akhundov.task7.Task;
import ru.ifmo.ctddev.Akhundov.task7.TaskImpl1;

/**
 * @author Ruslan
 *         <p>
 *         This class generates tasks in infinite cicle and runs taskRuner which need to complete them
 */
public class Client implements Runnable {

    private TaskRunner taskRunner;

    /**
     * @param taskRunner this object will be completing tasks
     * @see ru.ifmo.ctddev.Akhundov.task6.TaskRunner
     */
    public Client(TaskRunner taskRunner) {
        this.taskRunner = taskRunner;

    }

    /**
     * Runs Client. In infinite cycle it creates tasks and input values for them,
     * then it gives them to the <tt>TaskRunner</tt> and prints the result when
     * it's ready.
     */
    @Override
    public void run() {
        int i = 0;
        while (true) {
            i++;
            Task<String, String> newTask = new TaskImpl1<>();
            System.out.println(taskRunner.run(newTask, Integer.toString(i)));
        }
    }


}
