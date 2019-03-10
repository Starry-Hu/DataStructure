package chp33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

		for (int j = 0; j < numbers.length; j++) {
			linkList.push(Integer.parseInt(numbers[j]), Integer.parseInt(numbers[++j])); // 将之后输入的值存入链表中
			j++; //防止一组数据分隔后的两个空格
		}
		linkList.traversal();
	}

}
