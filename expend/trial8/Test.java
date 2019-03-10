package trial8;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		CheckID checkID = new CheckID();
		Scanner scanner = new Scanner(System.in);
		// 输入检测的身份证个数
		// System.out.println("------请输入要检测的身份证个数------");
		int n = scanner.nextInt();
		// System.out.println("------请输入身份证号码------");

		// 全部通过的标志
		boolean allPass = true;
		String[] datas = new String[n];

		for (int i = 0; i < n; i++) {
			String id = scanner.next();
			datas[i] = id;
		}
		for (int i = 0; i < n; i++) {
			// String id = scanner.next();
			// checkID.initial(id);
			checkID.initial(datas[i]);
			boolean flag = checkID.achieve();

			// 存在一个为假，全部都通过置false
			if (!flag) {
				allPass = false;
				System.out.println(datas[i]);
			}
		}

		if (allPass) {
			System.out.println("All passed");
		}

		scanner.close();
	}

}
