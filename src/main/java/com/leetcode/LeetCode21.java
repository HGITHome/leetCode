package com.leetcode;

/**
 * @author snail
 * @Title:
 * @Package
 * @Description:
 * @Company
 * @date 2020/8/5 16:04
 */

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class LeetCode21 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<String> sbs = new HashSet<>();
        for (int i = 0 ; i < nums.length - 2 ; i ++) {
            for (int j = i + 1 ; j < nums.length - 1 ; j ++ ) {
                for (int k = j + 1 ; k < nums.length ; k ++ ) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        sbs.add(du(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        sbs.forEach(s -> {
            List<Integer> integers = new ArrayList<>();
            Stream.of(s.split(",")).forEach(d -> integers.add(Integer.valueOf(d)));
            lists.add(integers);
        });
        sbs.forEach(s -> {
            List<Integer> integers = new ArrayList<>();
            String[] ss = s.split(",");
            for (int i = 0 ; i < ss.length ; i ++){
                integers.add(Integer.valueOf(ss[i]));
            }
            lists.add(integers);
        });
        return lists;
    }

    private static String sorted(int num1,int num2,int num3){
        StringBuffer sb = new StringBuffer();
        if (num1 >= num2) {
            if (num1 >= num3) {
                if (num2 >= num3) {
                    sb.append(num1).append(num2).append(num3);
                } else {
                    sb.append(num1).append(num3).append(num2);
                }
            } else if (num2 >= num3){
                sb.append(num1).append(num2).append(num3);
            } else {
                sb.append(num3).append(num1).append(num2);
            }
        } else if (num1 < num2) {
            if (num1 >= num3) {
                sb.append(num2).append(num1).append(num3);
            } else if (num3 >= num2) {
                sb.append(num3).append(num2).append(num1);
            } else if (num3 > num1) {
                sb.append(num2).append(num3).append(num1);
            }
        }
        return sb.toString();
    }

    private static String du(int num1,int num2,int num3) {
        int[] nums = new int[]{num1,num2,num3};
        for (int i = 0 ; i < nums.length ; i ++) {
            for (int j = 0 ; j < nums.length - i - 1 ; j ++) {
                if (nums[j] < nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return Arrays.stream(nums).boxed().map(i -> i.toString())
                .collect(Collectors.joining(","));
    }
}
