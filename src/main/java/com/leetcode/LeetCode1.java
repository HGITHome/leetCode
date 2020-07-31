package java.com.leetcode;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: create by xiake
 * @version: v1.0
 * @description: 求两个数之和等于目标数的数组下的下标
 * @date:2020/3/14
 **/
public class LeetCode1 {

    private static Integer[] array = new Integer[]{2,3,5,9};

    private static int[] getSum(Integer sum){
        for (int i = 0; i < array.length - 1 ; i ++){
            for (int j = i + 1;j < array.length ; j ++){
                if((array[i] + array[j]) == sum){
                    return new int[]{i,j};
                }
            }
        }
      throw new RuntimeException("没有符合!");
    }

    private static int[] getSum2(Integer sum){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < array.length ; i ++){
            map.put(array[i],i);
        }
        for(int i = 0 ; i < array.length ; i ++){
            int second = sum - array[i];
            if(map.containsKey(second) && Integer.valueOf(map.get(second).toString()) != i){
                return new int[]{i,Integer.valueOf(map.get(second).toString())};
            }
        }
        throw new RuntimeException("没有符合的值");
    }


    private static int[] getSum3(Integer target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < array.length ; i ++ ){
            if(map.containsKey((target - array[i]))){
                return new int[]{map.get((target - array[i])),i};
            }
            //这种情况就会覆盖之前的值，所以找出来的符合的是，如果出现相同的值的话，以后最后的那个值的下标为准
            map.put(array[i],i);
        }
        throw new RuntimeException("没有符合的值");
    }

    public static void main(String[] args) {
        int[] result = getSum2(8);
        System.out.println("[" + result[0] + "," + result[1] + "]");

    }
}
