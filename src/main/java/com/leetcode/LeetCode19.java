package com.leetcode;

/**
 * @author snail
 * @Title:
 * @Package
 * @Description:
 * @Company
 * @date 2020/8/3 17:34
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 *
 */
public class LeetCode19 {

    public static void main(String[] args) {
        System.out.println(multiply("123456789","0"));
    }

    public static String multiply(String num1, String num2) {
        // 每位数相乘的结果集
        List<String> multyplys = new ArrayList<>();

        int z = 0;
        for (int i = num1.length() - 1 ; i >= 0 ; i --) {
            int temp = 0;
            StringBuffer zero = new StringBuffer();
            for (int k = 0 ; k < z ; k ++) {
                zero.append("0");
            }
            StringBuffer sb = new StringBuffer(zero);
            for (int j = num2.length() - 1 ; j >= 0 ; j --) {
                Integer r = (Integer.parseInt(String.valueOf(num1.charAt(i))) * Integer.valueOf(String.valueOf(num2.charAt(j)))) + temp;
                sb.append((r % 10));
                temp = r / 10;
                if (j == 0) {
                    if (temp > 0) {
                        sb.append(temp);
                    }
                }
            }
            multyplys.add(sb.toString());
            z ++;
        }
        int addTempt = 0;
        StringBuffer result = new StringBuffer();
        for (int i = 0 ; i < multyplys.get(multyplys.size() - 1).length() ; i ++) {
            int addResult = 0;
            for (String sb : multyplys) {
                if (sb.length() >= (i + 1) && sb.charAt(i) > 0) {
                    addResult = addResult + Integer.parseInt(String.valueOf(sb.charAt(i)));
                }
            }
            addResult = addResult + addTempt;
            result.append((addResult % 10));
            addTempt = addResult / 10;
        }
        if (addTempt > 0){
            result.append(addTempt);
        }
        String r = result.reverse().toString();
        try {
            r = String.valueOf(Integer.parseInt(r));
        }catch (Exception e) {
        }
        return r;
    }
}
