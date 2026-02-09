package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class App {


    //java stage6.Main -mode enc -key 5 -alg unicode -data "Welcome to hyperskill!"

    // we have to run maven project with this command
    //     ./mvnw exec:java -Dexec.args="-mode enc -key 5 -in src/main/java/org/example/in.txt -out src/main/java/org/example/out.txt"
    public static void main(String[] args) {

        String operation = "enc";
        String algorithm = "shift";
        String message = "";
        int key = 0;
        String inputFile = null;
        String outputFile = null;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode" -> operation = args[++i];
                case "-key" -> key = Integer.parseInt(args[++i]);
                case "-data" -> message = args[++i];
                case "-in" -> inputFile = args[++i];
                case "-out" -> outputFile = args[++i];
                case "-alg" -> algorithm = args[++i];
            }
        }

        if (message.isEmpty() && inputFile != null) {
            try {
                message = Files.readString(Path.of(inputFile));
            } catch (IOException e) {
                System.out.println("Error: cannot read input file");
                return;
            }
        }

        String result;

        if (algorithm.equals("unicode")) {
//            if (operation.equals("dec")) {
//                result = decryptUnicode(message, key);
//            } else {
//                result = encryptUnicode(message, key);
//            }
            result =   (operation.equals("dec")) ? decryptUnicode(message, key):encryptUnicode(message, key);
        } else {
//            if (operation.equals("dec")) {
//                result = decryptShift(message, key);
//            } else {
//                result = encryptShift(message, key);
//            }
            result= (operation.equals("dec"))?decryptShift(message, key):encryptShift(message, key);
        }

        if (outputFile != null) {
            try {
                Files.writeString(Path.of(outputFile), result);
            } catch (IOException e) {
                System.out.println("Error: cannot write output file");
            }
        } else {
            System.out.println(result);
        }
    }

    // from here it started Unicode algo
    private static String encryptUnicode(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            result.append((char) (text.charAt(i) + key));
        }
        return result.toString();
    }

    private static String decryptUnicode(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            result.append((char) (text.charAt(i) - key));
        }
        return result.toString();
    }


    //  from here it started Shift algo
    private static String encryptShift(String text, int key) {
        StringBuilder result = new StringBuilder();
        key = key % 26;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                result.append((char) ('a' + (ch - 'a' + key) % 26));
            } else if (ch >= 'A' && ch <= 'Z') {
                result.append((char) ('A' + (ch - 'A' + key) % 26));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    private static String decryptShift(String text, int key) {
        StringBuilder result = new StringBuilder();
        key = key % 26;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                result.append((char) ('a' + (ch - 'a' - key + 26) % 26));
            } else if (ch >= 'A' && ch <= 'Z') {
                result.append((char) ('A' + (ch - 'A' - key + 26) % 26));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
