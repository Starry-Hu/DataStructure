package trial4;

import java.util.Scanner;

/**
 * 使用邻接矩阵存储图
 * 
 * @author 葫芦胡
 *
 */
public class GraphMatrix {
	// 图的顶点数据
	private char[] datas;
	// 各顶点的关系;如果数据是int型可省略第一个一维数组
	private int[][] relationships;

	private Scanner scanner = new Scanner(System.in);

	public char[] getDatas() {
		return datas;
	}

	public void setDatas(char[] datas) {
		this.datas = datas;
	}

	public int[][] getRelationships() {
		return relationships;
	}

	public void setRelationships(int[][] relationships) {
		this.relationships = relationships;
	}

	/**
	 * 建立无向图、无权重、字符数据元素的图
	 */
	public void createGraph() {

		// 输入点个数和边个数
		System.out.println("------------请输入顶点数和边数----------");
		int pointNum = scanner.nextInt();
		int sideNum = scanner.nextInt();

		datas = new char[pointNum];
		relationships = new int[pointNum][pointNum];

		System.out.println("------------请输入顶点信息(char类型)----------");
		// 清除系统的syso对nextLine读入的影响
		scanner.nextLine();

		for (int i = 0; i < pointNum; i++) {
			datas[i] = scanner.nextLine().charAt(0);
		}
		
		System.out.println("------------请输入(vi,vj)边的下标i,j----------");
		for (int k = 0; k < sideNum; k++) {
			int i = scanner.nextInt();
			int j = scanner.nextInt();
			relationships[i][j] = relationships[j][i] = 1;
			// 也可以采用一维数组压缩存取对称矩阵
		}

	}

	public void bulidGraph() {

		// 输入点个数和边个数
		System.out.println("------------请输入顶点数和边数----------");
		int pointNum = scanner.nextInt();
		int sideNum = scanner.nextInt();

		relationships = new int[pointNum][pointNum];

		for (int i = 0; i < pointNum; i++) {
			for (int j = 0; j < pointNum; j++) {
				if (i == j) {
					relationships[i][j] = 0;
				} else {
					// 以-1代无穷大
					relationships[i][j] = -1;
				}
			}
		}

		System.out.println("------------请输入(vi,vj)边的下标i,j,权重为w----------");
		for (int k = 0; k < sideNum; k++) {
			int i = scanner.nextInt();
			int j = scanner.nextInt();
			relationships[i][j] = scanner.nextInt();
		}
	}

	/**
	 * 显示邻接矩阵
	 */
	public void show() {
		for (int i = 0; i < relationships.length; i++) {
			for (int j = 0; j < relationships.length; j++) {
				System.out.print(relationships[i][j] + " ");
			}
			System.out.println();
		}
	}
}
