package com.bloomtech.welcomeletter.fileIO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class FileManager {
    public FileManager() {
    }

    public String getTextFromFile(String filename) throws IOException {
        File file = new File("src/resources/" + filename + ".txt");

        if (!file.exists()) {
            throw new FileNotFoundException();
        }

//        return Files.readString(file.toPath());

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String returnString = "";

        String line = bufferedReader.readLine();
        while (line != null) {
            returnString += line + "\n";
            line = bufferedReader.readLine();
        }
        bufferedReader.close();


        return returnString;
    }

    public void writeTextToFile(String outFileName, String text) throws IOException {
        File file = new File("src/resources/out/" + outFileName + ".txt");


        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(text);
        bufferedWriter.close();

    }
}