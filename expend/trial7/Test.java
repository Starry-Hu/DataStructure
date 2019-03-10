package trial7;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		HelloU helloU = new HelloU();
//		System.out.println("-----请输入字符串-----");
		Scanner scanner = new Scanner(System.in);
		String data = scanner.nextLine();
		
		helloU.initial(data);
		helloU.achieve();
		
		scanner.close();
	}

}
