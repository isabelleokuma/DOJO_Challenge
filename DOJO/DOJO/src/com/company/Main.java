package com.company;

import java.util.Scanner;
import java.util.regex.*;
import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.nio.channels.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Locale;
import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            String inputText;
            String entry = "";

            File myFile = new File("C:\\Users\\Raphael\\Desktop\\Jquery.txt");
            Scanner myScanner = new Scanner(myFile);
            while (myScanner.hasNextLine()){
                entry += myScanner.nextLine();
            }

            String[] removeSpaces = entry.split("\\s+|\\t+");

            for (int i = 0; i < removeSpaces.length; i++){
                //removeSpaces[i] = removeSpaces[i].replaceAll("(?:/\\\\*(?:[^*]|(?:\\\\*+[^*/]))*\\\\*+/)|(?://.*)", "");
                removeSpaces[i] = removeSpaces[i].replaceAll("(^(\\/\\*+[\\s\\S]*?\\*\\/)|(\\/\\*+.*\\*\\/)|\\/\\/.*?[\\r\\n])[\\r\\n]*", "");
                removeSpaces[i] = removeSpaces[i].replaceAll("","");
            }

            String str = String.join("", removeSpaces);

            FileWriter fw = new FileWriter(myFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(str);
            bw.close();


        } catch (Exception ex) {
            System.out.println("Exception: "+ ex.getMessage());
        }
    }
}
