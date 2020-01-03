package com.luyq;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. 两数之和 (Easy)
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 示例：
 * Input: nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]
 */
public class P001
{
    public static void main( String[] args )
    {
        Solution1_1 s1 = new Solution1_1();
        Solution1_2 s2 = new Solution1_2();
        Solution1_3 s3 = new Solution1_3();
        System.out.println(Arrays.toString(s1.twoSum(new int[] {2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(s2.twoSum(new int[] {2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(s3.twoSum(new int[] {2, 7, 11, 15}, 9)));
    }
}

// 暴力法
class Solution1_1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("no result");
    }
}

// 二遍哈希表
class Solution1_2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            maps.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (maps.containsKey(comp)) {
                return new int[] {i, maps.get(comp)};
            }
        }
        throw new IllegalArgumentException("no result");
    }
}

// 一遍哈希表
class Solution1_3 {
    public int[] twoSum(int[] sums, int target) {
        HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
        for (int i = 0; i < sums.length; i++) {
            int comp = target - sums[i];
            if (maps.containsKey(comp)) {
                return new int[] {maps.get(comp), i};
            }
            maps.put(sums[i], i);
        }
        throw new IllegalArgumentException("no result");
    }
}
