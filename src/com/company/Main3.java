package com.company;

import java.util.*;

public class Main3 {

    static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList = new ArrayList<>();
        List<String> allPossibleCombinations = getAllPermutations(words);
        allPossibleCombinations.forEach(item -> checkMatches(s, item, resultList));
        Collections.sort(resultList);
        return resultList;
    }

    private static List<String> getAllPermutations(String[] words) {
        List<String> list = new ArrayList<>();
        int quantityOfPermutations = getQuantityOfPermutations(words);
        System.out.println(quantityOfPermutations);
        List<String> items = Arrays.asList(words);
        if (words.length == 1) {
            list.add(words[0]);
            return list;
        }

        while (list.size() != quantityOfPermutations) {
            StringBuilder currentCombination = new StringBuilder();
            Collections.shuffle(items);
            items.forEach(currentCombination::append);
            if (list.contains(currentCombination.toString())) continue;
            list.add(currentCombination.toString());
        }
        return list;
    }

    private static int getQuantityOfPermutations(String[] words) {
        int denominator = countDenominator(words);
        return (countFactorial(words.length) / denominator) > 0?  // just for checking
                (countFactorial(words.length) / denominator): Integer.MAX_VALUE;
    }

    private static int countDenominator(String[] words) {
        Set<String> setOfUniqueWords = new HashSet<>();
        Collections.addAll(setOfUniqueWords, words);
        List<Integer> matches = new ArrayList<>();
        for (String s : setOfUniqueWords) {
            int count = 0;
            for (String word : words) {
                if (s.equals(word)) count++;
            }
            matches.add(count);
        }
        int result = countFactorial(matches.get(0));
        for (int i = 1; i < matches.size(); i++) {
            result *= countFactorial(matches.get(i));
        }
        return result;

    }

    private static int countFactorial(int num) {
        if (num == 1) return 1;
        return num * countFactorial(num - 1);
    }

    private static void checkMatches(String mainline, String testWord, List<Integer> resultList) {
        int start = testWord.length() - 1;
        for (int i = start; i < mainline.length(); i++) {
            if (mainline.charAt(i) == testWord.charAt(testWord.length() - 1)) {
                if (testWord.length() == 1) {
                    resultList.add(i);
                    break;
                }
                int limit = testWord.length() - 1;
                for (int j = i - 1, k = 0; k < testWord.length() - 1; j--, limit--, k++) {
                    if (mainline.charAt(j) != testWord.charAt(limit - 1)) {
                        break;
                    } else if (limit == 1) {
                        resultList.add(j);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findSubstring(
                "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel", new String[]{"dhvf", "sind", "ffsl", "yekr", "zwzq", "kpeo", "tfty"}));
    }
}
