package com.company;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[][] arr = {nums1, nums2};
        int[] merged = Arrays.stream(arr).flatMapToInt(Arrays::stream).toArray();
        Arrays.sort(merged);
        if (merged.length % 2 == 1) {
            return merged[merged.length / 2];
        } else {
            return (double) (merged[merged.length/2 - 1] + merged[merged.length/2]) / 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));

    }
}
