package com.luyq; // https://blog.csdn.net/qq_36426073/article/details/90203633

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 滑动窗口算法 (sliding window algorithm)：该算法可以用以解决数组/字符串的子元素问题，它可以将嵌套的循环问题，转换为单循环问题，降低时间复杂度。
 */
public class P003_Extend {
    public static void main(String[] args) {
        SlidingWindow s1 = new SlidingWindow();
        System.out.println(s1.maxNum(new int[] {1, 4, 2, 10, 1, 0, 20, 2, 3}, 3));
    }
}

/**
 * 给一组大小为n的整数数组，计算长度为k的子数组的最大值。
 * 示例：
 * Input: {1,2,3,4,5,7,6,1,8}, 2
 * Output: 13
 */
class SlidingWindow {
    int maxNum(int[] array, int k) {
        if (array.length < k) {
            return -1;
        }
        int left = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + array[i];
        }
        int tempsum = sum;
        while (left + k <array.length) {
            tempsum = tempsum - array[left] + array[left + k];
            left++;
            sum = Math.max(sum, tempsum);
        }
        return sum;
    }
}

