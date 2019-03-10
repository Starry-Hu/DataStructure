package chp41;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		int[][] matrixA = new int[m][3];
		int[][] matrixB = new int[n][3];

		for (int i = 0; i < m; i++) {
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			int value = scanner.nextInt();

			matrixA[i][0] = row;
			matrixA[i][1] = col;
			matrixA[i][2] = value;
		}
		for (int i = 0; i < n; i++) {
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			int value = scanner.nextInt();

			matrixB[i][0] = row;
			matrixB[i][1] = col;
			matrixB[i][2] = value;
		}
		scanner.close();
		
		MatrixAdd demo = new MatrixAdd();
		demo.setMatrixA(matrixA);
		demo.setMatrixB(matrixB);
		int[][] matrixRes = demo.add();

		for (int i = 0; i < matrixRes.length; i++) {
			// 如果结果为0时 且是第一个结果  则为空矩阵
			if((matrixRes[i][2] == 0) && (i==0)) {
				System.out.println("-1 -1 -1");
				return;
			}
			// 存在结果矩阵数组表示  多余空位  000 的情况  则返回
			// 即两个矩阵有对应位置的元素相加  节约了空间
			if (matrixRes[i][0] == 0) {
				return;
			}
			System.out.println(matrixRes[i][0] + " " + matrixRes[i][1] + " " + matrixRes[i][2]);

		}
	}

}
