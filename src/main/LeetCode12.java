public class LeetCode12 {
    /**
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     *
     * 示例 1：
     *
     * 输入: s = "leetcode"
     * 输出: false
     * 示例 2：
     *
     * 输入: s = "abc"
     * 输出: true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/is-unique-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        String s = "rutie";
        if(null == s){
            System.out.println(false);
        }
        StringBuffer sb = new StringBuffer();
        String[] array = s.split("");
        for(int i = 0 ; i < array.length ; i ++){
            if(sb.toString().contains(array[i])){
                System.out.println(false);
                break;
            } else {
                sb.append(array[i]);
            }
        }
    }
}
