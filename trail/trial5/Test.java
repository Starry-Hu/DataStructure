package trial5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException {
		HashTable hashTable = new HashTable();
		hashTable.initial();
		Scanner scanner = new Scanner(System.in);

		boolean out = false;
		while (!out) {
			System.out.println("------输入命令添加(t) 删除(s) 查找(c) 退出(o)------");
			String cmd = scanner.nextLine();

			if (cmd.equals("t")) {
				System.out.println("输入姓名");
				String username = scanner.nextLine();
				System.out.println("输入电话");
				String telephone = scanner.nextLine();
				System.out.println("输入地址");
				String address = scanner.nextLine();

				hashTable.add(username, telephone, address);
			} else if (cmd.equals("s")) {
				System.out.println("输入电话");
				String telephone = scanner.nextLine();

				hashTable.delete(telephone);
			} else if (cmd.equals("c")) {
				System.out.println("输入电话");
				String telephone = scanner.nextLine();

				hashTable.find(telephone);
			} else if (cmd.equals("o")) {
				System.out.println("------退出程序------");
				out = true;
			} else {
				System.out.println("错误指令，请重新输入");
			}
		}
		
		scanner.close();

		// System.out.println("------请依次输入用户名、电话号码以及地址------");
		// // 创建输入流对象
		// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// // 读取一行信息
		// String input = reader.readLine();
		// // 以空格为分隔符，转换成数组
		// String[] datas = input.split(" ");
		// for (int i = 0; i < datas.length; i++) {
		// hashTable.add(datas[i], datas[++i], datas[++i]);
		// }
		//
		//
		// System.out.println("\n------显示全部信息------");
		// hashTable.show();
		//
		// hashTable.show2();
		//
		// hashTable.delete("12345378942");
		//
		// hashTable.find("12345678778");

	}

}
