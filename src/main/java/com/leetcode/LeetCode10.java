package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by xiake
 * @version: v1.0
 * @description: PACKAGE_NAME
 * @date:2020/3/17
 **/
public class LeetCode10 {

    public static void main(String[] args) {
        getLargestNumber();
    }

    private static void largestNumber(int[] nums){
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.toString());
    }

    private static void getLargestNumber(){
        int[] nums = new int[]{824,938,1399,5607,6973,5703,9609,4398,8247};
        StringBuffer sb  = new StringBuffer();
        List<Integer> arrays = new ArrayList<Integer>();
        for(int i : nums){
            arrays.add(Integer.valueOf(i));
        }
        for(int i = 0 ; i < nums.length ; i ++){
            for(int j = 0 ; j < arrays.size() - i - 1 ; j ++){
                Integer first = arrays.get(j);
                Integer second = arrays.get(j + 1);
                if(first < second){
                    String[] firstStr = first.toString().split("");
                    String[] secondStr = second.toString().split("");
                    int size = firstStr.length >= secondStr.length ? secondStr.length : firstStr.length;
                    for (int k = 0 ; k < size ; k ++){
                        if(Integer.valueOf(firstStr[k]) > Integer.valueOf(secondStr[k])){
                            arrays.set(j,second);
                            arrays.set(j + 1 ,first);
                            break;
                        } else if(Integer.valueOf(firstStr[k]) < Integer.valueOf(secondStr[k])){
                            break;
                        } else if(Integer.valueOf(firstStr[k]).equals(Integer.valueOf(secondStr[k]))){
                            if ((k + 1) == firstStr.length && (k + 1 ) < secondStr.length){
                                for(int h = k ; h < secondStr.length - 1 ; h ++) {
                                    if ((Integer.valueOf(firstStr[k]) > Integer.valueOf(secondStr[h + 1])) || ((Integer.valueOf(firstStr[0]) > Integer.valueOf(secondStr[h + 1])) && (Integer.valueOf(firstStr[k]) < Integer.valueOf(secondStr[0])))) {
                                        arrays.set(j, second);
                                        arrays.set(j + 1, first);
                                        break;
                                    }
                                }
                                break;
                            }
                            if ((k + 1) == secondStr.length && firstStr.length > (k + 1)){
                                for(int h = k ; h < firstStr.length - 1 ; h ++) {
                                    if ((Integer.valueOf(secondStr[k]) < Integer.valueOf(firstStr[k + 1])) || ((Integer.valueOf(secondStr[0]) > Integer.valueOf(firstStr[k + 1])))) {
                                        arrays.set(j, second);
                                        arrays.set(j + 1, first);
                                        break;
                                    }
                                }
                                break;
                            }
                            continue;
                        }
                        break;
                    }
                }
                if(first > second){
                    String[] firstStr = first.toString().split("");
                    String[] secondStr = second.toString().split("");
                    int size = firstStr.length >= secondStr.length ? secondStr.length : firstStr.length;
                    for (int k = 0 ; k < size ; k ++){
                        if(Integer.valueOf(firstStr[k]) > Integer.valueOf(secondStr[k])){
                            arrays.set(j,second);
                            arrays.set(j + 1 ,first);
                            break;
                        } else if(Integer.valueOf(firstStr[k]) > Integer.valueOf(secondStr[k])){
                            break;
                        } else if(Integer.valueOf(firstStr[k]).equals(Integer.valueOf(secondStr[k]))){
                            if ((k + 1) == firstStr.length && (k + 1) < secondStr.length){
                                for(int h = k ; h < secondStr.length - 1 ; h ++) {
                                    if ((Integer.valueOf(firstStr[k]) > Integer.valueOf(secondStr[h + 1])) || ((Integer.valueOf(firstStr[0]) > (Integer.valueOf(secondStr[k])) && (Integer.valueOf(firstStr[h + 1]) > (Integer.valueOf(secondStr[k])))) )) {
                                        arrays.set(j, second);
                                        arrays.set(j + 1, first);
                                        break;
                                    }
                                }
                                break;
                            }
                            if ((k + 1) == secondStr.length && (k +  1) < firstStr.length){
                                for(int h = k ; h < firstStr.length - 1 ; h ++) {
                                    if ((Integer.valueOf(secondStr[k]) < Integer.valueOf(firstStr[h + 1])) ||((Integer.valueOf(firstStr[0]) > (Integer.valueOf(secondStr[k])) && (Integer.valueOf(firstStr[h + 1]) > (Integer.valueOf(secondStr[k])))) )) {
                                        arrays.set(j, second);
                                        arrays.set(j + 1, first);
                                        break;
                                    }
                                }
                                break;
                            }
                            continue;
                        }


                        break;
                    }
                }
                if(first.equals(second)){
                    continue;
                }
            }
        }
       for(int n = arrays.size() - 1 ; n >= 0 ; n --){
           if(Integer.valueOf(arrays.get(n)) == 0){
               arrays.remove(arrays.get(n));
           }else {
               break;
           }
       }
       if(arrays.size() == 0){
           System.out.println("0");
       } else {
           for(int n = arrays.size() - 1 ; n >= 0 ; n --){
             sb.append(arrays.get(n));
           }
       }
        System.out.println(sb.toString());
    }

    //冒泡排序算法
    private static int[] bubleSort(int[] sortNums){
        int[] n = new int[0];
        for(int i = 0 ; i < sortNums.length ; i ++){
            for (int j = 0 ; j < sortNums.length - i - 1; j ++){
                if(sortNums[j] < sortNums[j +1]){
                    int tempt = sortNums[j];
                    sortNums[j]= sortNums[j + 1];
                    sortNums[j + 1] = tempt;
                }
            }
        }
        return sortNums;
    }
}
