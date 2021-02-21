package io.zjh.question.medium;

/**
 * 1438. 绝对差不超过限制的最长连续子数组
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * <p>
 * 如果不存在满足条件的子数组，则返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 * 示例 3：
 * <p>
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 *
 * @author onlyonezhongjinhui
 */
public class LongestSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1};
        int limit = 10;
        System.out.println(new Solution().longestSubarray(nums, limit));
    }

    static class Solution {
        public int longestSubarray(int[] nums, int limit) {
            int result = 0;

            if (nums.length == 1) {
                return 1;
            }

            for (int i = 0; i < nums.length - 1; i++) {
                int n1 = nums[i];
                int min = n1;
                int max = n1;
                int longest = 1;
                for (int j = i + 1; j < nums.length; j++) {
                    int n2 = nums[j];
                    if (n2 > max) {
                        max = n2;
                    }

                    if (n2 < min) {
                        min = n2;
                    }

                    if (max - min > limit) {
                        break;
                    }

                    longest++;
                }
                if (longest > result) {
                    result = longest;
                }
            }
            return result;
        }
    }
}
