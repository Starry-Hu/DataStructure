package chp42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	public static void main(String[] args) throws IOException {
		// 创建输入流对象
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// 读取一行信息
		String input = reader.readLine();
		// 以空格为分隔符，转换成数组
		String[] numbers = input.split(" ");
		int length = numbers.length;

		FindMain findmain = new FindMain();

		int[] data = new int[length];
		for (int j = 0; j < length; j++) {
			data[j] = Integer.parseInt(numbers[j]); //将数据传入数组
		}
		findmain.setData(data);
		
		int max = findmain.find();
		System.out.print(max);
	}
}
