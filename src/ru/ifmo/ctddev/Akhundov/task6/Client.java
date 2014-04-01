package ru.ifmo.ctddev.Akhundov.task6;

/**
 * @author Ruslan
 *
 * This class generates tasks in infinite cicle and runs taskRuner which need to complete them
 */
public class Client {

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

    public void start() {

    }
}
