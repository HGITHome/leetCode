package java.com.leetcode;

import javax.sound.midi.Soundbank;

/**
 * @author: create by xiake
 * @version: v1.0
 * @description: PACKAGE_NAME
 * @date:2020/3/15
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 **/
public class LeetCode7 {
    public static void main(String[] args) {
        System.out.println(getRiver(120));
    }

    private static int getRiver(int num){
        int newNum = num;
        if(newNum < 0){
            newNum = newNum * (-1);
        }
        String numStr = String.valueOf(newNum);
        String[] str = numStr.split("");
        StringBuffer sb = new StringBuffer();
        for(int i = str.length - 1 ; i >= 0 ; i --){
            sb.append(str[i]);
        }
        String result = sb.toString();
        if(num < 0){
            result = "-" + result;
        }
        try {
            return Integer.valueOf(result);
        }catch (Exception E){
            return 0;
        }
    }
}
