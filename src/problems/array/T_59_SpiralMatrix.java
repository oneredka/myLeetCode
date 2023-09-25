package problems.array;

/**
 * @className: T_59_SpiralMatrix
 * @description: Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * @tag 数组
 * @author: louis
 * @date: 2023/3/17
 **/
public class T_59_SpiralMatrix {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1, maxNum = n * n;
        int leftStart = 0, rightEnd = n - 1, topStart = 0, buttonEnd = n - 1;
        // 转圈添加，每一圈改变边界，圈圈会越来越小。
        while (num <= maxNum) {
            // 填充上  左到右。 行不变，列++
            for (int i = leftStart; i <= rightEnd; i++) {
                res[topStart][i] = num++;
            }
            topStart++;

            // 填充右 上到下。 列不变，行++
            for (int i = topStart; i <= buttonEnd; i++) {
                res[i][rightEnd] = num++;
            }
            rightEnd--;

            // 填充下 右到左。 行不变， 列--
            for (int i = rightEnd; i >= leftStart; i--) {
                res[buttonEnd][i] = num++;
            }
            buttonEnd--;

            // 填充右 从下到上。 列不变，行--
            for (int i = buttonEnd; i >= topStart; i--) {
                res[i][leftStart] = num++;
            }
            leftStart++;
        }

        return res;
    }



    public static void main(String[] args) {
        generateMatrix(3);
    }
}
