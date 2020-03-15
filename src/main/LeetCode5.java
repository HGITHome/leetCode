import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: create by xiake
 * @version: v1.0
 * @description: 给定一个无序的整数数组，找到其中最长上升子序列的长度
 * @date:2020/3/14
 *
 *  输入: [10,9,2,5,3,7,101,18]
    输出: 4
    解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 **/
public class LeetCode5 {

    public static void main(String[] args) {
        int[] array = new int[]{10,9,2,5,3,7,101,18};
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < array.length ; i ++){
          if(i == 0){
              map.put(array[i],1);
              continue;
          }
          //判断是否出现递增的情况
          Boolean istrue = true;
          List<Integer> keys = new ArrayList<Integer>(map.keySet());
          for (Integer key : keys){
              //这是出现递增的情况
              if(key < array[i]){
                  //目的是判断出现key值相同的情况，会将之前的值给覆盖掉，所以判断之前的值是否小于当前的值，如果小于用现在覆盖之前的
                  if(map.containsKey(array[i])){
                      if(map.get(array[i]) < (map.get(key) + 1)){
                          map.put(array[i],(map.get(key) + 1));
                      }
                  } else
                  {
                      map.put(array[i], (Integer.valueOf(map.get(key).toString()) + 1));
                  }
                istrue = false;
              }
          }
          if(istrue){
              //如果为true，则当前的值作为字符串递增的开始值
              map.put(array[i],1);
          }
        }
        int max = 0 ;
        for(Integer value : map.values()){
            if(max < value){
                max = value;
            }
        }
        System.out.println(max);
    }
}
