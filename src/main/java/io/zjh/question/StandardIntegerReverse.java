package io.zjh.question;

/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * -2^31 <= x <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author onlyonezhongjinhui
 */
public class StandardIntegerReverse {
    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-123));
    }

    static class Solution {
        public int reverse(int x) {
            int result = 0;
            while (x != 0) {
                int p = x % 10;
                x /= 10;
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && p > 7)) {
                    return 0;
                }
                if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && p < -8)) {
                    return 0;
                }
                result = result * 10 + p;
            }
            return result;
        }
    }
}
