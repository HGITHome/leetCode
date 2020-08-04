package com.leetcode;

/**
 * @author snail
 * @Title:
 * @Package
 * @Description:
 * @Company
 * @date 2020/8/3 15:26
 */

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 */
public class LeetCode18 {

    public static void main(String[] args) {
        System.out.println(addStrings("0","0"));
    }

    public static String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        StringBuffer result = new StringBuffer();
        int temp = 0;
        // 判断大小，防止下标越界
        int j = num1.length() >= num2.length() ? num2.length() - 1 : num1.length() - 1;
        if (num1.length() >= num2.length()) {
            for (int i = num1.length() - 1 ; i >= 0 ; i -- ){
                Boolean b = true;
                if (j >= 0) {
                    Integer r = Integer.parseInt(String.valueOf(num1.charAt(i))) + Integer.valueOf(String.valueOf(num2.charAt(j))) + temp;
                    // 获取和的个位数
                    result.append((r % 10));
                    // 获取进位数
                    temp = r / 10;
                    b = false;
                    j --;
                }
                if (b) {
                    Integer r = Integer.valueOf(String.valueOf(num1.charAt(i))) + temp;
                    // 获取和的个位数
                    result.append((r % 10));
                    // 获取进位数
                    temp = r / 10;
                }
                // 当时最后一个数时，判断是否有进位数
                if (i == 0 && temp > 0) {
                    result.append(temp);
                }
            }
        } else {
            for (int i = num2.length() - 1 ; i >= 0 ; i -- ){
                Boolean b = true;
                if (j >= 0) {
                    Integer r = Integer.valueOf(String.valueOf(num2.charAt(i))) + Integer.valueOf(String.valueOf(num1.charAt(j))) + temp;
                    // 获取和的个位数
                    result.append((r % 10));
                    // 获取进位数
                    temp = r / 10;
                    b = false;
                    j --;
                }
                if (b) {
                    Integer r = Integer.valueOf(String.valueOf(num2.charAt(i))) + temp;
                    // 获取和的个位数
                    result.append((r % 10));
                    // 获取进位数
                    temp = r / 10;
                }
                // 当时最后一个数时，判断是否有进位数
                if (i == 0 && temp > 0) {
                    result.append(temp);
                }
            }
        }
        return result.reverse().toString();
    }
}
