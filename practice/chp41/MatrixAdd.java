package chp41;

import java.util.Arrays;

public class MatrixAdd {
	private int[][] matrixA;
	private int[][] matrixB;

	public int[][] getMatrixA() {
		return matrixA;
	}

	public void setMatrixA(int[][] matrixA) {
		this.matrixA = matrixA;
	}

	public int[][] getMatrixB() {
		return matrixB;
	}

	public void setMatrixB(int[][] matrixB) {
		this.matrixB = matrixB;
	}

	@Override
	public String toString() {
		return "MatrixAdd [matrixA=" + Arrays.toString(matrixA) + ", matrixB=" + Arrays.toString(matrixB) + "]";
	}

	public int[][] add() {
		int pos = 0;
		int t = 0;
		int[][] matrixRes = new int[matrixA.length + matrixB.length][3];
		for (int i = 0; (i < matrixA.length) || (pos< matrixB.length); t++) {
			// B矩阵元素已经全部加完了  只用复制A矩阵剩下的即可
			if(pos == matrixB.length) {
				matrixRes[t][0] = matrixA[i][0];
				matrixRes[t][1] = matrixA[i][1];
				matrixRes[t][2] = matrixA[i][2];
				i++;
				continue;
			}
			if (i == matrixA.length) {
				// A矩阵已经加完了  只用复制剩下的B矩阵即可
				matrixRes[t][0] = matrixB[pos][0];
				matrixRes[t][1] = matrixB[pos][1];
				matrixRes[t][2] = matrixB[pos][2];
				pos++;
				continue;
			}
			// 如果行值相等的情况
			if (matrixA[i][0] == matrixB[pos][0]) {
				if (matrixB[pos][1] < matrixA[i][1]) {
					matrixRes[t][0] = matrixB[pos][0];
					matrixRes[t][1] = matrixB[pos][1];
					matrixRes[t][2] = matrixB[pos][2];
					pos++;
					continue;
				} else if (matrixB[pos][1] > matrixA[i][1]) {
					matrixRes[t][0] = matrixA[i][0];
					matrixRes[t][1] = matrixA[i][1];
					matrixRes[t][2] = matrixA[i][2];
					i++;
					continue;
				} else {
					matrixRes[t][0] = matrixA[i][0];
					matrixRes[t][1] = matrixA[i][1];
					matrixRes[t][2] = matrixA[i][2] + matrixB[pos][2];
					i++;
					pos++;
					continue;
				}
			}
			// 按照行序排列 先传行值小的
			// A矩阵的行值比B矩阵小 把A矩阵对应的赋值过去
			else if (matrixA[i][0] < matrixB[pos][0]) {
				matrixRes[t][0] = matrixA[i][0];
				matrixRes[t][1] = matrixA[i][1];
				matrixRes[t][2] = matrixA[i][2];
				i++;
				continue;
			} else {
				// A矩阵的行值大于B矩阵的行值 则直接赋值B矩阵的值
				matrixRes[t][0] = matrixB[pos][0];
				matrixRes[t][1] = matrixB[pos][1];
				matrixRes[t][2] = matrixB[pos][2];
				pos++;
				continue;
			}
		}
		
		return matrixRes;
	}

}
