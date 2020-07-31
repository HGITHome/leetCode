package java.com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by xiake
 * @version: v1.0
 * @description: Z 字形变换
 * @date:2020/3/15
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
    比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
    L   C   I   R
    E T O E S I I G
    E   D   H   N

"ABCDE"
4
 **/
public class leetCode6 {
    public static void main(String[] args) {
        String s = "ABCDE";
        Integer numRows = 4;
        //计算数组的大小
        Integer arraySize = (numRows - 2) + numRows;
        Integer strLen  = s.length();
        //判断数组是否为0
        arraySize = arraySize == 0 ? 1 : arraySize;
        Integer nums = strLen / arraySize;
        List<String[]> strArray = new ArrayList<String[]>();
        //切分数组
        for(int i = 0 ; i < nums ; i ++){
            String str = s.substring(i * arraySize, arraySize * (i + 1));
            strArray.add(str.split(""));
        }
        if((nums * arraySize) < strLen){
            strArray.add(s.substring(nums * arraySize).split(""));
        }
        StringBuffer sb = new StringBuffer();
        //将最后一个数组抽出来单独处理，目的是防止不足一个数组
        String[] lastArray = strArray.get(strArray.size() - 1);
        strArray.remove(strArray.size() - 1);
        for(int i = 0 ; i < numRows ; i ++){
            if(i == 0){
                //拼接每个数组第一行
                for(String[] array : strArray){
                    sb.append(array[i]);
                }
                if(lastArray.length > 0){
                    sb.append(lastArray[i]);
                }
                continue;
            }
            if(i != numRows -1){
                for (String[] array : strArray){
                    sb.append(array[i] + array[array.length - i]);
                }
                if(lastArray.length >= (1 + i)){
                    sb.append(lastArray[i]);
                    //判断是否最后一个数组是否符合条件
                    if(lastArray.length >= numRows + (numRows - (i + 1))){
                        sb.append(lastArray[numRows - 1 + (numRows -1 - i )]);
                    }
                }
            }
            if(i == numRows - 1){
                for (String[] array : strArray){
                    sb.append(array[i]);
                }
                if(lastArray.length >= numRows){
                    sb.append(lastArray[i]);
                }
            }

        }
        System.out.println(sb.toString());
    }
}
