package com.company;

public class ReverseInteger {

    public static int reverse(int x) {
        if (x == 0) return 0;
        while (x % 10 == 0) {
            x /= 10;
        }
        boolean positive = x >= 0;
        long input = Math.abs((long) x);
        long reverse = 0;
        while (input != 0) {
            long remainder = input % 10;
            reverse = reverse * 10 + remainder;
            input = input / 10;
        }
        if ((reverse > (long) 0x7fffffff || (reverse < (long) 0x80000000))) {
            return 0;
        } else {
            return positive ? (int) reverse : (int) reverse * -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147));

    }
}
