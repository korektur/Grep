package ru.ifmo.ctddev.Akhundov.task6;


/**
 * Starts Clients and TaskRunners
 */
public class Main {
    /**
     * Starts clients. Amount of clients are equal to the first argument from args.
     *
     * @param args input arguments.
     */
    public static void main(String[] args) {
        int numOfThreads = Integer.parseInt(args[0]);
        startClient(startTaskRunner(numOfThreads));
    }

    private static TaskRunnerImpl startTaskRunner(int numOfThreads) {
        TaskRunnerImpl runner = new TaskRunnerImpl(numOfThreads);
        runner.startSolvingTasks();
        return runner;
    }

    private static void startClient(TaskRunnerImpl runner) {
        Client client = new Client(runner);
        Thread clientThread = new Thread(client);
        clientThread.start();
    }

}
