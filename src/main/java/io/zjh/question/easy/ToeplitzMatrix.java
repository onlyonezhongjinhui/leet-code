package io.zjh.question.easy;

/**
 * 766. 托普利茨矩阵
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * <p>
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true
 * 解释：
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2],[2,2]]
 * 输出：false
 * 解释：
 * 对角线 "[1, 2]" 上的元素不同。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 20
 * 0 <= matrix[i][j] <= 99
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？
 * 如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？
 *
 * @author onlyonezhongjinhui
 */
public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}};
        int[][] matrix1 = new int[][]{
                {1, 2},
                {2, 2}};
        int[][] matrix2 = new int[][]{
                {36, 59, 71, 15, 26, 82, 87},
                {56, 36, 59, 71, 15, 26, 82},
                {15, 0, 36, 59, 71, 15, 26}};
        int[][] matrix3 = new int[][]{
                {1, 2, 3},
                {2, 1}};
        int[][] matrix4 = new int[][]{
                {11, 74, 0, 93},
                {40, 11, 74, 7}};
        System.out.println(new Solution().isToeplitzMatrix(matrix));
        System.out.println(new Solution().isToeplitzMatrix(matrix1));
        System.out.println(new Solution().isToeplitzMatrix(matrix2));
        System.out.println(new Solution().isToeplitzMatrix(matrix3));
        System.out.println(new Solution().isToeplitzMatrix(matrix4));
    }

    static class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            for (int k = 0; k < matrix.length - 1; k++) {
                int[] ints = matrix[k];
                for (int i = 0; i < ints.length - 1; i++) {
                    int n = ints[i];
                    for (int j = 1; j <= matrix.length - 1 - k; j++) {
                        if (matrix[k + j].length <= j + i) {
                            continue;
                        }
                        int m = matrix[k + j][j + i];
                        if (n != m) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
}
