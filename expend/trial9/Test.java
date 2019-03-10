package trial9;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

//		System.out.println("------请依次输入罪犯个数n,罪行值和最大上限t,转移人数c名------");
		// 依次输入罪犯个数n,罪行值和最大上限t,转移人数c名
		int n = scanner.nextInt();
		int t = scanner.nextInt();
		int c = scanner.nextInt();
		
//		System.out.println("------请依次输入各个罪犯的罪行值------");
		int[] datas = new int[n];
		for (int i = 0; i < n; i++) {
			datas[i] = scanner.nextInt();
		}
		
		TransferPeople mPeople = new TransferPeople();
		mPeople.initial(n, t, c, datas);
		mPeople.achieve();
		
		scanner.close();
	}

}
