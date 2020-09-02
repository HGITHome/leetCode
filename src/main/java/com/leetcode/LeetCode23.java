package com.leetcode;

/**
 * @author snail
 * @Title:
 * @Package
 * @Description:
 * @Company
 * @date 2020/8/19 14:10
 */

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 */
public class LeetCode23 {

    public static void main(String[] args) {
        System.out.println(fib(10));
    }

   private static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1 ) + fib(n - 2);
    }
}
