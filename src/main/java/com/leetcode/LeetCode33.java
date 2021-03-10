package com.leetcode;

/**
 *给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode33 {

    public static void main(String[] args) {
        System.out.println(addBinary("0","0"));
//        System.out.println("11".charAt(8));
    }

    public static String addBinary(String a, String b) {
        int alength = a.length() - 1;
        int blength = b.length() - 1;
        int temp = 0;
        StringBuffer sb = new StringBuffer();
        do {
            int atemp = Integer.valueOf(a.charAt(alength) + "");
            int btemp = Integer.valueOf(b.charAt(blength) + "");
            int t = temp + atemp + btemp;
            if (t == 0) {
                temp = 0;
                sb.append("0");
            } else if (t == 1) {
                temp = 0;
                sb.append("1");
            } else if (t == 2) {
                temp = 1;
                sb.append("0");
            } else if (t == 3) {
                temp = 1;
                sb.append("1");
            }
            alength --;
            blength --;
        } while (alength >= 0 && blength >= 0);
        if (alength >= 0) {
            do {
                int t = temp + Integer.valueOf(a.charAt(alength) + "");
                if (t == 0) {
                    temp = 0;
                    sb.append("0");
                } else if (t == 1) {
                    temp = 0;
                    sb.append("1");
                } else if (t == 2) {
                    temp = 1;
                    sb.append("0");
                }
                alength --;
            } while (alength >= 0);
        }
        if (blength >= 0) {
            do {
                int t = temp + Integer.valueOf(b.charAt(blength) + "");
                if (t == 0) {
                    temp = 0;
                    sb.append("0");
                } else if (t == 1) {
                    temp = 0;
                    sb.append("1");
                } else if (t == 2) {
                    temp = 1;
                    sb.append("0");
                }
                blength --;
            } while (blength >= 0);
        }
        if (temp > 0) {
            sb.append(temp);
        }
        if (sb.toString().equals("0")) {
            return "0";
        }
        return sb.reverse().toString().replaceFirst("^0*", "");
    }
}
