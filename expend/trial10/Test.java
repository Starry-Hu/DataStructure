package trial10;

import java.util.Scanner;

public class Test {

	/**
	 * 检测中位数查找
	 * 特殊情况:两个数组的长度相同
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FindMid fMid = new FindMid();
		Scanner scanner = new Scanner(System.in);
		// System.out.println("------请输入数组长度n------");
		int n = scanner.nextInt();
		int[] data1 = new int[n];
		int[] data2 = new int[n];
		
		// System.out.println("------请输入第一个数组的数据------");
		for (int i = 0; i < n; i++) {
			data1[i] = scanner.nextInt();
		}
		// System.out.println("------请输入第二个数组的数据------");
		for (int i = 0; i < n; i++) {
			data2[i] = scanner.nextInt();
		}

		fMid.initial(data1, data2);
		double mid = fMid.achieve();
		System.out.println(mid);

		scanner.close();
	}

}
