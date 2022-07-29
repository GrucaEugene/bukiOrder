package com.company;

import static java.lang.Integer.*;

public class ReverseInteger {

    public static int reverse(int x) {
        if(x == 0) return 0;
        while (x % 10 == 0) {
            x /= 10;
        }
        boolean positive = x >= 0;
        long input = Math.abs((long) x);
        StringBuilder stringBuilder = new StringBuilder(Long.toString(input));
        stringBuilder.reverse();
        long result = Long.parseLong(stringBuilder.toString());
        if ((result > (long) MAX_VALUE) || (result < (long) MIN_VALUE)) {
            return 0;
        } else {
            return positive? (int) result : (int) result * -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));

    }
}
