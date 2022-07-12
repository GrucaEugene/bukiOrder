package com.company;

public class ContainerWithTheMostWater {
    public static int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        } else if (height.length == 1) {
            return height[0];
        }
        int maxArea = 0;
        int leftWallIndex = 0;
        int rightWallIndex = height.length - 1;
        while (leftWallIndex != rightWallIndex) {
            if(height[rightWallIndex] >= height[leftWallIndex]) {
                maxArea = Math.max(height[leftWallIndex] * (rightWallIndex - leftWallIndex), maxArea) ;
                leftWallIndex++;
            } else if(height[rightWallIndex] < height[leftWallIndex]) {
                maxArea =  Math.max(height[rightWallIndex] * (rightWallIndex - leftWallIndex), maxArea);
                rightWallIndex--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));

    }
}
