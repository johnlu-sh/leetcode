package com.luyq;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串 (Medium)
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例：
 * Input: "abcabcbb"
 * Output: 3 (abc)
 * Input: "bbbbb"
 * Output: 1 (b)
 * Input: "pwwkew"
 * Output: 3 (wke)
 */
public class P003 {
    public static void main(String[] args) {
        Solution3_1 s1 = new Solution3_1();
        Solution3_2 s2 = new Solution3_2();
        Solution3_3 s3 = new Solution3_3();
        System.out.println(s1.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s2.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s3.lengthOfLongestSubstring("abcabcbb"));
    }
}

// 暴力法
class Solution3_1 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    // 如果子字符串中的字符都是唯一的，它会返回 true，否则会返回 false。
    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<Character>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }
}

// 滑动窗口算法
class Solution3_2 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<Character>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}

// 优化的滑动窗口算法
class Solution3_3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
