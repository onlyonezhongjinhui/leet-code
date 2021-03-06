package io.zjh.question.medium;

/**
 * 1052. 爱生气的书店老板
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 * <p>
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * <p>
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * <p>
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= X <= customers.length == grumpy.length <= 20000
 * 0 <= customers[i] <= 1000
 * 0 <= grumpy[i] <= 1
 *
 * @author onlyonezhongjinhui
 */
public class StandardGrumpyBookstoreOwner {
    public static void main(String[] args) {
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int x = 3;

        int[] customers1 = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy1 = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int x1 = 2;

        int[] customers2 = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy2 = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int x2 = 1;
        Solution solution = new Solution();
        System.out.println(solution.maxSatisfied(customers, grumpy, x));
        System.out.println(solution.maxSatisfied(customers1, grumpy1, x1));
        System.out.println(solution.maxSatisfied(customers2, grumpy2, x2));
    }

    static class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int X) {
            int total = 0;
            for (int i = 0; i < customers.length; i++) {
                if (grumpy[i] == 0) {
                    total += customers[i];
                }
            }
            // 巧妙利用乘法,0乘以任何数都是0,滑动窗口增加的数量就是窗口内原本为grumpy为1的数量
            int increase = 0;
            for (int i = 0; i < X; i++) {
                increase += customers[i] * grumpy[i];
            }

            int maxIncrease = increase;
            for (int i = X; i < customers.length; i++) {
                increase = increase - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
                maxIncrease = Math.max(maxIncrease, increase);
            }

            return maxIncrease + total;
        }
    }
}
