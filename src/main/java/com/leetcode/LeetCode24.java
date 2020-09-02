package com.leetcode;

/**
 * @author snail
 * @Title:
 * @Package
 * @Description:
 * @Company
 * @date 2020/9/2 10:36
 */

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 */
public class LeetCode24 {

    public static void main(String[] args) {
        String s = "-1E-16";
        if(s.endsWith("f")||s.endsWith("D")) {
            System.out.println(false);
        }
        try {
            System.out.println(Double.valueOf(s));
            System.out.println(true);
        }catch (Exception ex){
            System.out.println(false);
        }
    }

    public static boolean isNumber(String s) {
        String[] strs = s.split("");
        Boolean jiajianBoolean = false;
        String jiajian = "+-";
        String yingwene = "Ee";
        Boolean yingwenBoolean = false;
        String xiaoshudian = ".";
        Boolean xiaoshudianBoolean = false;
        for (int i = 0 ; i < strs.length ; i ++) {
            if (jiajian.contains(strs[i])) {
                if (i != (strs.length - 1)) {
                    if (jiajian.contains(strs[i + 1])) {
                        return false;
                    }
                }
            }
            // 重复小数点情况
            if (xiaoshudian.contains(strs[i])) {
                if (xiaoshudianBoolean) {
                    return false;
                } else {
                    xiaoshudianBoolean = true;
                }
            }

            if (yingwene.contains(strs[i])) {
                if (i == strs.length - 1) {
                    return false;
                }
                if (jiajian.contains(strs[i + 1])) {
                    return false;
                }
            }
        }
        return false;
    }
}
