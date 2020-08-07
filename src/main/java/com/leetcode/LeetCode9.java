package com.leetcode;

/**
 * ClassName: LeetCode8
 *
 * @description: ${description}
 * Date:      2020/3/16 10:35
 * author     xiake
 * version    V1.0
 *
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
示例1:
输入："aabcccccaaa"
输出："a2b1c5a3"
示例2:
输入："abbccd"
输出："abbccd"
解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 */
public class LeetCode9 {

    public static void main(String[] args) {
        compressString("");
    }

    public static void compressString(String S) {
        StringBuffer sb = new StringBuffer();
        String[] strArray = S.split("");
        Integer count = 0;
        String str = null;
        for (int i = 0 ; i < strArray.length ; i ++){
            if(i == 0){
                str = strArray[i];
                count ++;
            }
            if(str.equals(strArray[i]) && i > 0){
                str = strArray[i];
                count ++;
            }
            if(!str.equals(strArray[i]) && i > 0){
                sb.append(str + count);
                str = strArray[i];
                count = 1;
                //判断此时最后一个的时候，刚好与前面一个不相同时，拼上去
                if(i == strArray.length - 1){
                    sb.append(str + count);
                    str = "#";
                }
            }
            //判断最后一个都是相同情况，拼上
            if(i == strArray.length - 1 && str.equals(strArray[i])){
                sb.append(str + count);
            }
        }
        if(S.length() <= sb.toString().length()){
            System.out.println(S);
        } else {
            System.out.println(sb.toString());
        }
    }
}
