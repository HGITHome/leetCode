package com.leetcode;

public class LeetCode16 {

    public static void main(String[] args) {
        //暴力破解法
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int max = 0,l = 0 , r = height.length - 1;
//        for (int i = 0 ; i < height.length ; i ++){
//            for (int j = i +1 ; j < height.length ; j ++){
//                int min = Math.min(height[j] , height[i]);
//                int indexlen = j - i;
//                int temp = min * indexlen;
//                if(temp > max){
//                    max = temp;
//                }
//            }
//        }
        //双指针法
        while (l < r){
            max = Math.max(max , Math.min(height[l],height[r]) * (r - l));
            if(height[l] < height[r]){
                l ++;
            } else
                r --;
        }
        System.out.println(max);
    }
}