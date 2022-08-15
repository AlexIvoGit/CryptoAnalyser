package ru.javarush.ivoylovsky.cryptoanalyser.constant;


public class Alphabetic {

    private final static String RU_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private final static String SPECIAL_SYMBOLS = ".,”:-!? ";
    private final static String NUMERIC = "1234567890";

    public final static String ALPHABETIC = RU_ALPHABET + RU_ALPHABET.toUpperCase() + NUMERIC + SPECIAL_SYMBOLS + System.lineSeparator();
    public final static char[] ALPHABETIC_CHARS = ALPHABETIC.toCharArray();

}
