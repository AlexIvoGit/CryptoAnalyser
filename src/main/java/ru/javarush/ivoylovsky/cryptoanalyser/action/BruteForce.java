package ru.javarush.ivoylovsky.cryptoanalyser.action;

public class BruteForce {

    public static String decrypt(String source) {
        String s = null;
        for (int i = 0; i < 1000; i++) {
            s = Decrypt.decryptString(source, i);
            String[] split = s.split(" ");
            if (split.length > 1) {
                break;
            }
        }
        return s;
    }
}