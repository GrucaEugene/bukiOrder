package com.company;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1size = getNodeSize(l1);
        int l2size = getNodeSize(l2);
        ListNode currentResNode = new ListNode();
        ListNode head = currentResNode;
        int remainder = 0;
        ListNode longerNode = l1size >= l2size ? l1 : l2;
        ListNode shorterNode = l2size <= l1size ? l2 : l1;
        int currentSum;
        int currentIterationSize = Math.min(l1size, l2size);
        for (int i = 1; i <= currentIterationSize; i++) {
            currentSum = longerNode.val + shorterNode.val + remainder;
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
            if(i == currentIterationSize && l1size == l2size && remainder == 0) continue;
                currentResNode.next = new ListNode();
                currentResNode = currentResNode.next;
                longerNode = longerNode.next;
                shorterNode = shorterNode.next;


            if (i == currentIterationSize && l1size == l2size) {
                currentResNode.val = remainder;
            } else if (i == currentIterationSize) {
                int abs = Math.abs(l1size - l2size);
                for (int j = 1; j <= abs; j++) {
                    if(longerNode.val + remainder == 10) {
                        currentResNode.val = 0;
                        remainder = 1;
                    } else {
                        currentSum = longerNode.val + remainder;
                        currentResNode.val = currentSum;
                        remainder = 0;
                    }

                    if(j != abs) {
                        currentResNode.next = new ListNode();
                        currentResNode = currentResNode.next;
                        longerNode = longerNode.next;
                    } else if(remainder == 1){
                        currentResNode.next = new ListNode(1);
                    }
                }
            }
        }
        return head;
    }

    private static int getNodeSize(ListNode l1) {
        int size = 0;
        ListNode current = l1;
        while (current.next != null) {
            current = current.next;
            size++;
        }
        return ++size;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode result = addTwoNumbers(
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))),
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        System.out.println(result.val);
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
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
