package com.leetcode;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LeetCode15 {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
     int[] nums = new int[] {-1,0,1,2,-1,-4,0,0};
     List<List<Integer>> lists = new ArrayList<>();
     for (int i = 0 ; i < nums.length ; i ++){
         for (int j = i + 1; j < nums.length ; j ++){
             for (int k = j + 1 ; k < nums.length ; k ++){
                 if(nums[i] + nums[j] + nums[k] == 0){
                     if(nums[i] == nums[j] && nums[j] == nums[k] && nums[i] == 0){
                         Boolean isTrue = true;
                         for (List l : lists){
                             if((int)l.get(0) == 0 && (int)l.get(1) == 0 && (int)l.get(2) == 0){
                                 isTrue = false;
                             }
                         }
                         if(isTrue){
                             List<Integer> n = new ArrayList<>();
                             n.add(nums[i]);
                             n.add(nums[j]);
                             n.add(nums[k]);
                             lists.add(n);
                         }
                     } else {
                         Boolean istrue = true;
                         for (List l : lists){
                             if(l.contains(nums[i]) && l.contains(nums[j]) && l.contains(nums[k])){
                                 istrue = false;
                             }
                         }
                         if(istrue) {
                             List<Integer> n = new ArrayList<>();
                             n.add(nums[i]);
                             n.add(nums[j]);
                             n.add(nums[k]);
                             lists.add(n);
                         }
                     }

                 }
             }
         }
     }
        System.out.println(JSON.toJSONString(lists));
    }
}
