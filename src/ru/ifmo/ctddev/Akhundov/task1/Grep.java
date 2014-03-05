package ru.ifmo.ctddev.Akhundov.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Grep {

    private static ArrayList<String> stringsToFind;
    private static final int READ_LENGTH = 2000;
    private static final String[] CHAR_SETS = {"UTF-8", "KOI8-R", "CP1251", "CP866"};

    private static void checkFile(File f) {
        try (RandomAccessFile in = new RandomAccessFile(f, "r")) {
            byte[] oldBytes = new byte[READ_LENGTH];
            int oldLength = in.read(oldBytes);
            byte[] newBytes = new byte[READ_LENGTH];
            int newLength = in.read(newBytes);
            while (oldLength != 0) {
                for (String charSet : CHAR_SETS) {
                    String s = (new String(oldBytes, 0, oldLength, charSet)) +
                            (new String(newBytes, 0, newLength, charSet));
                    for (String toFind : stringsToFind) {
                        if (s.contains(toFind)) {
                            System.out.println(f.getAbsolutePath() + ": " + s);
                        }
                    }
                }
                oldLength = newLength;
                oldBytes = newBytes;
                newLength = in.read(newBytes);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void bypassFiles(File file) {
        File[] listOfFiles = file.listFiles();
        if (listOfFiles == null) {
            return;
        }
        for (File f : listOfFiles) {
            if (f.isDirectory()) {
                bypassFiles(f);
            } else {
                checkFile(f);
            }
        }
    }

    public static void main(String[] args) {
        stringsToFind = new ArrayList<>();
        if (args.length == 0) {
            System.out.print("Wrong parameters");
        } else if (args.length == 1 && "-".equals(args[0])) {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                String[] input = in.readLine().split(" ");
                Collections.addAll(stringsToFind, input);

                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Collections.addAll(stringsToFind, args);
        }
        File f = new File(Grep.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        bypassFiles(f);
    }
}
