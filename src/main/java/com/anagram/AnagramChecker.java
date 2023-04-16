package com.anagram;

import java.util.Arrays;
import java.util.Locale;

/**
 * @author : Pramod Khalkar
 * description: This file belongs to Anagram-check
 **/
public class AnagramChecker implements Checker {

    @Override
    public boolean check(String w1, String w2) {
        if (w1 != null && w2 != null) {
            w1 = w1.toLowerCase(Locale.ENGLISH);
            w2 = w2.toLowerCase(Locale.ENGLISH);
            if (w1.length() == w2.length()) {
                char[] cw1 = w1.toCharArray();
                char[] cw2 = w2.toCharArray();
                Arrays.sort(cw1);
                Arrays.sort(cw2);
                return Arrays.equals(cw1, cw2);
            }
        }
        return false;
    }
}
