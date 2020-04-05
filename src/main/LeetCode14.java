public class LeetCode14 {
    /**
     * 该算法，判断字符串s1通过字符串s循环位移，是否可得到
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(ajuest("ddjhjaa","aa4dd"));
    }

    private static Boolean ajuest(String s,String s1){
        String[] array  = s.split("");
        for (int i = 0 ; i < s.length() ; i ++){
            StringBuffer sb = new StringBuffer();
            sb.append(array[array.length - 1]);
            for (int j = 0 ; j < s.length() - 1 ; j ++){
                sb.append(array[j]);
            }
            if(sb.toString().contains(s1)){
                return true;
            } else {
                s = sb.toString();
            }
        }
        return false;
    }
}
