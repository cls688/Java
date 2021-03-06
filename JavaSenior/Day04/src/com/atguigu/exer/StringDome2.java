package com.atguigu.exer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenglongsheng
 * @create 2021-04-18 13:54
 */
public class StringDome2 {
    /*
    获取两个字符串中最大相同子串。比如：
    str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"//10
    提示：将短的那个串进行长度依次递减的子串与较长的串比较。
     */

    // 两个字符串只能有一个最大相同字串
    public String getMaxSameString(String str1, String str2) {
        if (str1 != null && str2 != null) {
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() <= str2.length()) ? str1 : str2;
            int length = minStr.length();

            for (int i = 0; i < length; i++) {
                for (int x = 0, y = length - i; y <= length; x++, y++) {
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) {
                        return subStr;
                    }
                }
            }
        }
        return null;
    }

    //多个数量相同的字串
    public String[] getMaxSameSubString(String str1, String str2) {
        if (str1 != null && str2 != null) {
            StringBuffer sBuffer = new StringBuffer();
            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() > str2.length()) ? str2 : str1;

            int len = minString.length();
            for (int i = 0; i < len; i++) {
                for (int x = 0, y = len - i; y <= len; x++, y++) {
                    String subString = minString.substring(x, y);
                    if (maxString.contains(subString)) {
                        sBuffer.append(subString + ",");
                    }
                }
//                System.out.println(sBuffer);
                if (sBuffer.length() != 0) {
                    break;
                }
            }
            String[] split = sBuffer.toString().replaceAll(",$", "").split("\\,");
            return split;
        }
        return null;
    }

    @Test
    public void testGetMaxSameString() {
        String str1 = "abcwerthelloyuiodefabcde";
        String str2 = "cvhellobnmabcde";
        String maxSameString = getMaxSameString(str1, str2);
        String[] maxSameSubString = getMaxSameSubString(str1, str2);
        System.out.println(maxSameString);
        System.out.println(Arrays.toString(maxSameSubString));
    }
}
