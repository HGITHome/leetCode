package com.leetcode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: create by xiake
 * @version: v1.0
 * @description: 寻找两个有序数组的中位数
 * @date:2020/3/14
 **/
public class LeetCode3 {

    public static void main(String[] args) {
        Integer[] num1 = new Integer[]{2,3,5};
        Integer[] num2 = new Integer[]{4,6,7};
        List<Integer> nums = new ArrayList<Integer>();
        nums.addAll(Arrays.asList(num1));
        nums.addAll(Arrays.asList(num2));
        Collections.sort(nums);
        if(nums.size() % 2 == 0){
            int i = (nums.size() / 2) - 1;
            int j = (nums.size() / 2);
            Integer firstNum = nums.get(i);
            Integer secondNum = nums.get(j);
            System.out.println((firstNum + secondNum) / 2.0);
        } else {
            System.out.println(nums.get(nums.size() / 2));
        }
        merge();
    }

    //归并算法
    private static void merge(){
        Integer[] num1 = new Integer[]{3,10,11};
        Integer[] num2 = new Integer[]{4,6,8};
        if(num1.length > num2.length){
            Integer[] temp = num1;
            num1 = num2;
            num2 = temp;
        }
        Integer[] sum = new Integer[num1.length + num2.length];
        int j = 0 ;
        int o = 0;
        for(int i = 0 ; i < num1.length ; i ++){
            for(;j < num2.length ; j ++){
                if(num1[i] >= num2[j]){
                    sum[o] = num2[j];
                    o ++;
                } else {
                    sum[o] = num1[i];
                    o ++;
                    break;
                }
            }
            if(i <  num1.length  && j == num2.length){
                sum[o] = num1[i];
                o ++;
            }
        }
        if(j <= num2.length -1){
            for(;j < num2.length ; j ++){
                sum[o] = num2[j];
                o ++;
            }
        }
        System.out.println(sum);
    }
}
