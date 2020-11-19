package com.leetcode;

/**
 * @author
 * @Title:
 * @Package
 * @Description:
 * @Company
 * @date 2020/11/19 15:25
 */

/**
 *  给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 */
public class LeetCode26 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        for (int i = 0 ; i < nums.length ; i ++) {
            System.out.println(nums[i]);
        }
    }

    public static void moveZeroes(int[] nums) {
        int length  = nums.length;
        int index = -1;
        for (int i = 0 ; i < length ; i ++) {
            if (nums[i] != 0) {
                index ++;
                nums[index] = nums[i];
            }
        }
        if ((length - (index+1)) > 0 ) {
            for (int j = index + 1 ; j < length ; j ++) {
                nums[j] = 0;
            }
        }
    }
}
