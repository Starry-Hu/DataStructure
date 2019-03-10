package chp31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws IOException {
		LinkList linkList = new LinkList();
		linkList.initial();

		// 创建输入流对象
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// 读取一行信息
		String input = reader.readLine();
		// 以空格为分隔符，转换成数组
		String[] numbers = input.split(" ");
		int k = Integer.parseInt(numbers[0]); // 第一个输入倒数第k个节点的k值

		for (int j = 1; j < numbers.length; j++) {
			linkList.push(Integer.parseInt(numbers[j]));  //将之后输入的值存入链表中
		}

//		 Scanner scanner = new Scanner(System.in);
//		 while(scanner.hasNext()) {
//			 int x =scanner.nextInt();
//			 linkList.push(x);
//			 System.out.println("12");
//			 System.out.println(linkList.getLength());
//		 }
//		 
//		 scanner.close();

		linkList.findReverseK(k);
	}
}
