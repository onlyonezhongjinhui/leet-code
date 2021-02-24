package io.zjh.question.easy;

/**
 * 832. 翻转图像
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * <p>
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2:
 * <p>
 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 说明:
 * <p>
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 *
 * @author onlyonezhongjinhui
 */
public class FlippingAnImage {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] a1 = new int[][]{{1}};
        Solution solution = new Solution();
        print(solution.flipAndInvertImage(a));
        print(solution.flipAndInvertImage(a1));
    }

    static class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            for (int[] ints : A) {
                for (int i = 0, j = ints.length - 1; i <= j; i++, j--) {
                    if (i != j) {
                        int temp = ints[i];
                        ints[i] = ints[j] > 0 ? 0 : 1;
                        ints[j] = temp > 0 ? 0 : 1;
                    } else {
                        ints[i] = ints[i] > 0 ? 0 : 1;
                    }
                }
            }
            return A;
        }
    }

    private static void print(int[][] a) {
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }
}
