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
        if (rightPointer - leftPointer == 1 || rightPointer - leftPointer == 2) return true;
        int left, right;
        left = (rightPointer - leftPointer) % 2 == 1? (leftPointer + rightPointer) / 2 : (leftPointer + rightPointer) / 2 - 1;
        right = (leftPointer + rightPointer) / 2 + 1;
        while(left > leftPointer && right < rightPointer) {
            if(arr[left] != arr[right]) return false;
            left--;
            right++;
        } return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(longestPalindrome("aacabdkacaa"));
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}
