package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void getStartIndexesOfMatched(String mainline, String[] words) {
        List<Integer> resultList = new ArrayList<>();
        for (String s : words) {
            checkMatches(mainline, s, resultList);
        }
        resultList.stream().sorted().forEach(s -> System.out.print(s + " |"));
    }

    private static void checkMatches(String mainline, String testWord, List<Integer> resultList) {
        int start = testWord.length() - 1;
        for (int i = start; i < mainline.length(); i++) {
            if (mainline.charAt(i) == testWord.charAt(testWord.length() - 1)) {
                int limit = testWord.length() - 1;
                for (int j = i - 1, k = 0; k <= limit; j--, limit--, k++) {
                    if (mainline.charAt(j) != testWord.charAt(limit - 1)) {
                        break;
                    } else if(k == limit) resultList.add(j);
                }
            }
        }
    }

    public static void main(String[] args) {
        getStartIndexesOfMatched("abrbardacabra", new String[]{"abr", "cad", "bra"});
    }
}
