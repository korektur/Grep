package ru.ifmo.ctddev.Akhundov.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Grep {

    private static ArrayList<String> stringsToFind;

    private static void checkFile(File f){

    }


    private static void bypassFiles(File file) {
        File[] listOfFiles = file.listFiles();
        if (listOfFiles == null) {
            return;
        }
        for(File f: listOfFiles){
            if (f.isDirectory()){
                bypassFiles(f);
            } else {
                checkFile(f);
            }
        }
    }

    public static void main(String[] args) {
        stringsToFind = new ArrayList<String>();
        if (args.length == 0) {
            System.out.print("Wrong parameters");
        } else if (args.length == 1 && "-".equals(args[1])) {
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
