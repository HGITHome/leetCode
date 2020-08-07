package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by xiake
 * @version: v1.0
 * @description: 请你找出其中不含有重复字符的 最长子串 的长度
 * @date:2020/3/14
 **/
public class LeetCode2 {

    public static void main(String[] args) {
        String s = " pwwkeuiwh";
        String[] str = s.split("");
        List<String> list = new ArrayList<String>();
        List<Integer> index = new ArrayList<Integer>();
        int len = 0;
        int maxLen = 0 ;
        for(int i = 0 ; i < str.length ; i ++ ){
            if(list.contains(str[i])){
                if(len > maxLen){
                    maxLen = len;
                }
                len = 1;
                list = new ArrayList<String>();
                //将出项相同字符的下标 + 1赋值给遍历i，作为开始的遍历下标值,相当于是移动窗口，出现相同的的字符串时，将第一个出现相同的字符串的下标往后移一位作为遍历开始，重新遍历数组
                i = index.get(0) + 1;
                list.add(str[i]);
                index = new ArrayList<Integer>();
                index.add(i);
            } else {
                //记录每个下标的值，目的是出现有相同的字符时，开始循环下标i变为是出现重复字符的下标加1开始遍历循环
                index.add(i);
                list.add(str[i]);
                len = len + 1;
            }
        }
        if(len > maxLen){
            maxLen = len;
        }
        System.out.println(maxLen);
    }
}
