package ru.javarush.ivoylovsky.cryptoanalyser.action;

import java.io.*;

import static ru.javarush.ivoylovsky.cryptoanalyser.constant.Alphabetic.ALPHABETIC;
import static ru.javarush.ivoylovsky.cryptoanalyser.constant.Alphabetic.ALPHABETIC_CHARS;

public class Decrypt {

    public static String decryptString(String source, int key) {
        StringBuilder result = new StringBuilder();
        char[] chars = source.toCharArray();
        for (char aChar : chars) {
            result.append(decryptChar(aChar, key));

        }
        return result.toString();
    }

    public static void decryptFile(File fromFile, int key) {
        try (
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fromFile)));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fromFile.getParent() + "\\decrypted.txt"))))
        {
            while(bufferedReader.ready()){
                char readChar = (char) bufferedReader.read();
                bufferedWriter.write(decryptChar(readChar, key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Character decryptChar(Character source, int key) {
        int indexOfAlphabetic = ALPHABETIC.indexOf(source);
        if (indexOfAlphabetic != -1) {
            int i = indexOfAlphabetic - key;
            if (i < 0) {
                i = i + ALPHABETIC_CHARS.length;
            }
            return ALPHABETIC_CHARS[i];
        }
        return '?';
    }
}
