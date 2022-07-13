package com.company;

import java.math.BigDecimal;
import java.util.Stack;

public class AddTwoNumbersSolution {
    public static AddTwoNumbers.ListNode addTwoNumbers(AddTwoNumbers.ListNode l1, AddTwoNumbers.ListNode l2) {
        String number1 = "";
        number1 = getNumber(l1, number1);
        StringBuilder stringBuilder1 = new StringBuilder(number1);
        number1 = stringBuilder1.reverse().toString();
        String number2 = "";
        number2 = getNumber(l2, number2);
        StringBuilder stringBuilder2 = new StringBuilder(number2);
        number2 = stringBuilder2.reverse().toString();
        BigDecimal result = new BigDecimal(number1).add(new BigDecimal(number2));
        char[] digits = result.toString().toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char digit : digits) {
            stack.add(digit);
        }
        AddTwoNumbers.ListNode node = new AddTwoNumbers.ListNode();
        return fillListNode(node, stack);
    }

    private static AddTwoNumbers.ListNode fillListNode(AddTwoNumbers.ListNode node, Stack<Character> stack) {
        if (stack.size() == 1) {
            node.val = Character.getNumericValue(stack.pop());
            return node;
        } else {
            node.val = Character.getNumericValue(stack.pop());
            node.next = fillListNode(new AddTwoNumbers.ListNode(), stack);
            return node;
        }
    }

    public static String getNumber(AddTwoNumbers.ListNode node, String result) {
        if (node.next == null) {
            return result.concat(String.valueOf(node.val));
        } else {
            return result + node.val + (getNumber(node.next, result));
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        AddTwoNumbers.ListNode result = addTwoNumbers(
                new AddTwoNumbers.ListNode(2, new AddTwoNumbers.ListNode(4, new AddTwoNumbers.ListNode(9))),
                new AddTwoNumbers.ListNode(5, new AddTwoNumbers.ListNode(6, new AddTwoNumbers.ListNode(4))));
        System.out.println(result.val);
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }

}
