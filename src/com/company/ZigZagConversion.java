package com.company;

public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if(numRows == 1 || s.length() == 1) return s;
        int lineLength = s.length() <= numRows ? 1 : s.length();
        char[][] arr = new char[numRows][lineLength];
        boolean goingUp = false;
        int k = 0;
        int j = 0;
        int i = 0;
        while(k < s.length()) {
            arr[j][i] = s.charAt(k++);
            if (!goingUp && j == numRows - 1) {
                j--;
                i++;
                goingUp = true;
            } else if (goingUp && j == 0) {
                j++;
                goingUp = false;
            } else if (!goingUp) {
                j++;
            } else {
                j--;
                i++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] chars : arr) {
            for (char subChar : chars) {
                if (subChar != '\u0000') stringBuilder.append(subChar);
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(convert("PAYPALISHIRING", 8));
        long finish = System.currentTimeMillis();
        System.out.println("execution time: " + (finish - start));
    }
}

// 1
// 2
// 3
// 4
// 5
// 6