package com.company;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main3 {

    static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList = new ArrayList<>();
        Set<String> allPossibleCombinations = getAllPermutations(words);
        for (String item : allPossibleCombinations) {
            checkMatches(s, item, resultList, allPossibleCombinations);
        } Collections.sort(resultList);
        return resultList;
    }

    private static Set<String> getAllPermutations(String[] words) {
        Set<String> list = Collections.newSetFromMap(new ConcurrentHashMap<>());
        int quantityOfPermutations = words.length * words.length - words.length;
        List<String> items = Arrays.asList(words);
        while (list.size() != quantityOfPermutations) {
            StringBuilder currentCombination = new StringBuilder();
            Collections.shuffle(items);
            items.forEach(currentCombination::append);
            list.add(currentCombination.toString());
        }
        return list;
    }

    private static void checkMatches(String mainline, String testWord, List<Integer> resultList, Set<String> pit) {
        int start = testWord.length() - 1;
        for (int i = start; i < mainline.length(); i++) {
            if (mainline.charAt(i) == testWord.charAt(testWord.length() - 1)) {
                int limit = testWord.length() - 1;
                for (int j = i - 1, k = 0; k < testWord.length() - 1; j--, limit--, k++) {
                    if (mainline.charAt(j) != testWord.charAt(limit - 1)) {
                        break;
                    } else if (limit == 1 && pit.contains(testWord)) {
                        resultList.add(j);
                        pit.remove(testWord);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("foobarfoobar", new String[]{"bar","foo"}));
    }
}
