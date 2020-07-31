package java.com.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 动态规划以及字符串处理
 */
public class LeetCode13 {

    public static void main(String[] args) {
        String str = "iiuiui";
        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //下面这种情况是，从本身开始向两边进行扩展和判断
            int len1 = expandAroundCenter(s, i, i);
            //下面这种场景是相邻两边都是相同的情况
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                //记录回文字符串在整个字符串的起始位置和结束位置的下标
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    //从中间向两边进行扩展
    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        //向两边进行扩展和比较，
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        //返回长度
        return R - L - 1;
    }

}
