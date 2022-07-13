package com.company;

import java.math.BigDecimal;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

//        needs reverse
        ListNode currentResNode = new ListNode();
        int remainder = 0;
        ListNode upPillar = l1;
        ListNode downPillar = l2;
        int currentSum;
        while (upPillar.next != null && downPillar.next != null) {
            currentSum = upPillar.val + downPillar.val + remainder;
            if (currentSum < 10) {
                currentResNode.val = currentSum;
                remainder = 0;
            } else if (currentSum == 10) {
                currentResNode.val = 0;
                remainder = 1;
            } else {
                currentResNode.val = currentSum % 10;
                remainder = 1;
            }
            currentResNode = currentResNode.next;
            upPillar = upPillar.next;
            downPillar = downPillar.next;
        }

        if(remainder > 0) {
            currentResNode.val = remainder;
        }

        return currentResNode;
    }


    public static void main(String[] args) {
        ListNode result = addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(9))),
                new ListNode(5, new ListNode(6, new ListNode(4))));
        System.out.println(result.val);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
