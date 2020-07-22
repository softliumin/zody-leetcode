package org.example.bytedance;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1016/
 * 字符串的排列
 * @author zody
 * @since 2020-07-22 09:02
 */
public class Test2 {
    public static void main(String[] args) {

    }

    /**
     * 写一个函数来判断 s2 是否包含 s1 的排列
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        return  s2.contains(s1);
    }

}
