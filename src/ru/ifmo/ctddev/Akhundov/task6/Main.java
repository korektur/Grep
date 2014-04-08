package ru.ifmo.ctddev.Akhundov.task6;


/**
 * Starts Clients and TaskRunners
 */
public class Main {
    /**
     * Starts clients. Amount of clients are equal to the first argument from args.
     * @param args input arguments.
     */
    public static void main(String[] args) {
        int numOfThreads = Integer.parseInt(args[0]);
        for(int i = 0; i < numOfThreads; ++i) {
            startClient(startTaskRunner());
        }
    }

    /**
     * Creates and starts a new TaskRunner
     * @see ru.ifmo.ctddev.Akhundov.task6.TaskRunner
     * @see ru.ifmo.ctddev.Akhundov.task6.TaskRunnerImpl
     * @return created TaskRunner
     */
    private static TaskRunnerImpl startTaskRunner() {
        TaskRunnerImpl runner = new TaskRunnerImpl();
        Thread thread = new Thread(runner);
        thread.start();
        return runner;
    }

    /**
     * Creates new Client from TaskRunner and starts it.
     * @param runner which will solve task given by the client.
     * @see ru.ifmo.ctddev.Akhundov.task6.TaskRunnerImpl
     * @see ru.ifmo.ctddev.Akhundov.task6.Client
     */
    private static void startClient(TaskRunnerImpl runner) {
        Client client = new Client(runner);
        Thread clientThread  = new Thread(client);
        clientThread.start();
    }

}
