package ru.javarush.ivoylovsky.cryptoanalyser.action;

import java.io.*;

import static ru.javarush.ivoylovsky.cryptoanalyser.constant.Alphabetic.*;

public class Encrypt {

    public static String encryptString(String source, int key) {
        StringBuilder result = new StringBuilder();
        char[] chars = source.toCharArray();
        for (char aChar : chars) {
            result.append(encryptChar(aChar, key));
        }
        return result.toString();
    }

    public static void encryptFile(File fromFile, int key) {
        try (
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fromFile)));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fromFile.getParent() + "\\encrypted.txt"))))
        {
            while(bufferedReader.ready()){
                char readChar = (char) bufferedReader.read();
                bufferedWriter.write(encryptChar(readChar, key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Character encryptChar(Character source, int key) {
        int indexOfAlphabetic = ALPHABETIC.indexOf(source);
        if (indexOfAlphabetic != -1) {
            int i = indexOfAlphabetic + key;
            if (i > ALPHABETIC_CHARS.length) {
                i = i - ALPHABETIC_CHARS.length;
            }
            return ALPHABETIC_CHARS[i];
        }
        return '?';
    }
}
