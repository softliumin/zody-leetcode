package org.example.bytedance;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1014/
 * 最长公共前缀
 * @author zody
 * @since 2020-07-22 08:58
 */
public class LongestPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = new String();
        for (int j = 0; j < strs[0].length(); ++j) {
            char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; ++i) {
                if (j >= strs[i].length() || strs[i].charAt(j) != c) {
                    return res;
                }
            }
            res += Character.toString(c);
        }
        return res;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        String reg = strs[0];
        for (String s : strs) {
            while (!s.startsWith(reg)) {
                if (reg.length() == 1) {
                    return "";
                }
                reg = reg.substring(0, reg.length() - 1);
            }
        }
        return reg;
    }
}
