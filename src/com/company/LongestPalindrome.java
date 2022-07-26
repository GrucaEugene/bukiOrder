package com.company;

public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        String longest = s.substring(0, 1);
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        for (int j = leftPointer; j < s.length() - 1; j++) {
            for (int i = rightPointer; i > j; i--) {
                if (arr[j] == arr[i]) {
                    if (checkPalindrome(j, i, arr) && (i - j) >= longest.length()) longest = s.substring(j, i + 1);
                }
            }
        }
        return longest;
    }

    private static boolean checkPalindrome(int leftPointer, int rightPointer, char[] arr) {
        if ((rightPointer - leftPointer) % 2 == 1) {
            return checkEven(leftPointer, rightPointer, arr);
        } else {
            return checkOdd(leftPointer, rightPointer, arr);
        }
    }
// 0 1 2 3 4 5 6 7 8 9 10 11
    private static boolean checkOdd(int leftPointer, int rightPointer, char[] arr) {
        int core = (rightPointer + leftPointer) / 2;
        int left = core - 1;
        int right = core + 1;
        while (left != right) {
            if (arr[left] != arr[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    private static boolean checkEven(int leftPointer, int rightPointer, char[] arr) {
        if (rightPointer - leftPointer == 1) return true;
        int left = leftPointer + 1;
        int right = rightPointer - 1;
        while (right < left) {
            if (arr[left] != arr[right]) return false;
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
    }
}
