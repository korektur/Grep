package ru.ifmo.ctddev.Akhundov.task6;

/**
 * @author Ruslan
 *
 * This class generates tasks in infinite cicle and runs taskRuner which need to complete them
 */
public class Client implements Runnable {

    /**
     *  TaskRunner which will complete tasks
     *  @see ru.ifmo.ctddev.Akhundov.task6.TaskRunner
     */
    TaskRunner taskRunner;

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
        while(true) {
            Task<String, String> newTask = new TaskImpl1<>();
            System.out.println(taskRunner.run(newTask, "let's go"));
        }
    }


}
