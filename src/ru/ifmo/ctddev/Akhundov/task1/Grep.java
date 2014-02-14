package ru.ifmo.ctddev.Akhundov.task1;

import java.io.*;

public class Grep {

    public static void main(String[] args){
        if (args.length == 1){
            System.out.print("Wrong parameters");
        } else if (args.length == 2 && "-".equals(args[1])){
            try {
                Reader in = new BufferedReader(new InputStreamReader(System.in));
            }
        }
    }
}
