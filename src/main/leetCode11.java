/**
 * @author: create by xiake
 * @version: v1.0
 * @description: PACKAGE_NAME
 * @date:2020/3/20
 *
 * 字符串转换整数 (atoi):https://leetcode-cn.com/problems/string-to-integer-atoi/
 **/
public class leetCode11 {
    public static void main(String[] args) {
      int total = myAtoi("45");
    }

    public static int myAtoi(String str) {
        String constant = "0123456789";
        String fuhao = "-+";
        StringBuffer number = new StringBuffer();
        String newStr = new String();
        for(int i = 0 ; i < str.length() ; i ++){
            if(32 != (int)(str.charAt(i))){
                newStr = str.substring(i);
                break;
            }
        }

        String[] array = newStr.split("");
        for (int i = 0 ; i < array.length; i ++){
            if(constant.contains(array[i])){
                number.append(array[i]);
            } else if(fuhao.contains(array[i]) && number.length() == 0) {
                number.append(array[i]);
            } else {
                break;
            }
        }
        if(number.length() == 0){
            return 0;
        }else if (number.length() == 1 && fuhao.contains( number.toString())){
            return 0;
        }else {
            try {
                return Integer.valueOf(number.toString());
            } catch (Exception e){
                String first = number.toString().substring(0,1);
                if("-".equals(first)){
                    return -2147483648;
                } else {
                    return 2147483647;
                }
            }
        }
    }
}
