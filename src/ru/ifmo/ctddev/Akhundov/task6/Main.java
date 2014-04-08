package ru.ifmo.ctddev.Akhundov.task6;


/**
 * Starts Clients and TaskRunners
 */
public class Main {

    public static void main(String[] args) {
        int numOfThreads = Integer.parseInt(args[0]);
        for(int i = 0; i < numOfThreads; ++i) {
            startClient(startTaskRunner());
        }
    }

    private static TaskRunnerImpl startTaskRunner() {
        TaskRunnerImpl runner = new TaskRunnerImpl();
        Thread thread = new Thread(runner);
        thread.start();
        return runner;
    }

    private static void startClient(TaskRunnerImpl runner) {
        Client client = new Client(runner);
        Thread clientThread  = new Thread(client);
        clientThread.start();
    }

}
