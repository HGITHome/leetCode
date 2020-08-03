package com.leetcode;


import java.util.stream.IntStream;

/**
 * @author Tom
 * @Title:
 * @Package
 * @Description: 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @Company
 * @date 2020/7/31 15:05
 */
public class LeetCode17 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,2};
        StringBuffer sb = new StringBuffer();
        int temp = nums[0];
        for (int i = 0 ; i < nums.length - 1; i ++ ) {
            if (temp == nums[i + 1]) {
                sb.append((i + 1) + ",");
            } else {
                temp = nums[i + 1];
            }
        }
//        strs = Arrays.asList(sb.toString().split("")).stream().mapToInt(Integer :: parseInt).toArray();
        System.out.println("重复值的下标：" + sb.deleteCharAt(sb.length() - 1).toString());
    }
}
