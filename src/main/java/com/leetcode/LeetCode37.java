package com.leetcode;

/**
 * @ClassName LeetCode37
 * @Description
 * @Author yutang
 * @Date 2021/6/6 14:29
 * @Version V1.0
 **/

/**
 * 合并两个有序数组
 */
public class LeetCode37 {

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3};
        int[] B = new int[]{3,4,5};
        merge(A,3,B,3);
    }

    public static void merge(int A[], int m, int B[], int n) {
        int[] nums = new int[m + n];
        int i = 0 , j = 0;
        int k = 0;
        while (i < m && j < n){
            if(A[i] <= B[j]) {
                nums[k] = A[i];
                i ++;
                k++;
                continue;
            }
            if(A[i] > B[j]){
                nums[k] = B[j];
                j ++;
                k ++;
                continue;
            }
        }
        if (i == m && j < n) {
            for (int l = j; j < n ; j ++) {
                nums[k] = B[j];
                k ++;
            }
        }
        if(i < m && j == n) {
            for (int l = i ; i < m ; i ++) {
                nums[k] = A[i];
                k ++;
            }
        }
        A = nums;
        System.out.println(A);
    }
}
