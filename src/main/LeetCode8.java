import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: create by xiake
 * @version: v1.0
 * @description: PACKAGE_NAME
 * @date:2020/3/15
 **/
public class LeetCode8 {

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(getMaxAreaOfIsland(grid));
    }

    private static int getMaxAreaOfIsland(int[][] grid){
        Map<String,Integer> map = new HashMap<String, Integer>();
        for (int i = 0 ; i < grid.length ; i ++){
            for(int j = 0 ; j < grid[i].length ; j ++){
                if(grid[i][j] == 1) {
                    if(!map.isEmpty()){
                        boolean isTrue = true;
                        Map<String,Integer> newMap = new HashMap<String, Integer>();
                        for(String key : map.keySet()){
                            String[] keyArray = key.split("=");
                            if(i == Integer.valueOf(keyArray[0]) && (Integer.valueOf(keyArray[1]) + 1) == j ){
                                String newkey = getKey(i, j);
                                Integer value = map.get(key);
                                if(null != newMap.get(newkey)){
                                    Integer dupValue = newMap.get(newkey);
                                    newMap.put(newkey,value + dupValue);
                                } else {
                                    newMap.put(newkey,value  + 1);
                                }

                                isTrue = false;
                            }
                            if(i == (Integer.valueOf(keyArray[0]) + 1) && j == Integer.valueOf(keyArray[1])){
                                String newkey = getKey(i, j);
                                Integer value = map.get(key);
                                if(null != newMap.get(newkey)){
                                    Integer dupValue = newMap.get(newkey);
                                    newMap.put(newkey,value  + dupValue);
                                } else {
                                    newMap.put(newkey,value  + 1);
                                }
                                isTrue = false;
                            }
                        }
                        if(isTrue){
                            String key = getKey(i, j);
                            newMap.put(key,1);
                        }
                        map.putAll(newMap);
                    } else {
                        String key = getKey(i, j);
                        map.put(key,1);
                    }

                }
            }
        }
        if(!map.isEmpty()){
            int maxArea = 0;
            for (Map.Entry<String,Integer> m : map.entrySet()){
                if(m.getValue() > maxArea){
                    maxArea = m.getValue();
                }
            }
            return maxArea;
        }
        return 0;
    }

    private static String getKey(int i ,int j){
        return i + "=" + j;
    }
}
