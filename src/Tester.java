import org.junit.runner.JUnitCore;

public class Tester {
    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
        }

        System.setProperty("cut", args[1]);
        if ("SortedSet".equalsIgnoreCase(args[0])) {
            JUnitCore.main(SortedSetTest.class.getName());
        } else if ("NavigableSet".equalsIgnoreCase(args[0])) {
            JUnitCore.main(NavigableSetTest.class.getName());
        }
    }

    private static void printUsage() {
        System.out.format(
                "Usage: \n    java %s SortedSet full.class.name\n    java %s NavigableSet full.class.name\n",
                Tester.class.getName(),
                Tester.class.getName()
        );
        System.exit(1);
    }
}
