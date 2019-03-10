package chp43;

public class PrintCircle {

	public int[][] calMatrix(int n) {
		// 定义数组大小
		int[][] data = new int[n][n];
		// 定义四个方向
		int right = 1, down = 2, left = 3, up = 4;
		// 定义初始方向
		int direction = right;

		int row = 0, col = 0;
		for (int value = 1; value <= n * n; value++) {
			data[row][col] = value; // 因为这个地方你赋值为1了 哦我明白了！应该判断下一个？4
			// 向右走的情况
			if (direction == right) {
				// 如果下一个还在圈内且还未修改 (自动赋初值0)
				if ((col + 1 < n) && (data[row][col + 1] == 0)) {
					col++;
				} else {
					// 否则改变方向
					direction = down;
					row++;
				}
				continue;
			}

			// 向下走的情况
			if (direction == down) {
				// 如果下一个还在圈内且未修改 否则改变方向
				if ((row + 1 < n) && (data[row + 1][col] == 0)) {
					row++;
				} else {
					direction = left;
					col--;
				}
				continue;
			}

			// 向左走的情况
			if (direction == left) {
				if ((col - 1 > -1) && (data[row][col - 1] == 0)) {
					col--;
				} else {
					direction = up;
					row--;
				}
				continue;
			}

			// 向上走
			// 此时需要考虑换圈(好像也不用怎么考虑)
			if (direction == up) {
				if ((row - 1 > -1) && data[row - 1][col] == 0) {
					row--;
				} else {
					direction = right;
					col++;
				}
				continue;
			}
		}

		return data;
	}
}
