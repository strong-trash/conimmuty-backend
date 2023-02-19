package com.conimmuty.support;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
public class Utility {
    public static String shuffle(String sentence) {
        String[] tokens = sentence.split(" ");
        int length = tokens.length;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String shuffled = shuffleToken(tokens[i]);
            if (i > 0) {
                result.append(" ");
            }
            result.append(shuffled);
        }
        return result.toString();
    }

    private static String shuffleToken(String token) {
        int length = token.length();
        int start = findStart(token);
//        int end = findEnd(token);
//        int start = 0;
        int end = length;
        if (start == -1 || end == -1 || end - start <= 1) {
            return token;
        }
        String substring = token.substring(start, end);
        String prefix = token.substring(0, start);
        String postfix = token.substring(end, length);

        List<String> letters = Arrays.asList(substring.split(""));
        Collections.shuffle(letters);
        StringBuilder result = new StringBuilder(prefix);
        for (String letter : letters) {
            result.append(letter);
        }
        result.append(postfix);
        return result.toString();
    }

    private static int findStart(String token) {
        int length = token.length();
        for (int i = 0; i < length; i++) {
            if (checkKorean(token.charAt(i))) {
                return i + 1;
            }
        }
        return -1;
    }

    private static int findEnd(String token) {
        int length = token.length();
        for (int i = length - 1; i >= 0; i--) {
            if (checkKorean(token.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    private static Boolean checkKorean(char ch) {
        int start = '가';
        int end = '힣';
        int st = 'ㄱ';
        int en = 'ㅎ';
        return start <= ch && ch <= end || st <= ch && ch <= en;
    }
}
