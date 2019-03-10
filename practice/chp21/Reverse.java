package chp21;

import java.util.Scanner;

/**
 * 实现对数组的循环左移
 * 
 * @author 葫芦胡
 *
 */
public class Reverse {

	/**
	 * 实现从start到end下标的反转
	 * 
	 * @param arr
	 * @param strat
	 * @param end
	 */
	public void reverseFun(int[] arr, int strat, int end) {
		for (int i = strat, j = end; i < j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

	/**
	 * 初始化一个n大小的数组 并输入相应数字
	 * 
	 * @param n
	 * @param scanner
	 */
	public void init(int[] arr, Scanner scanner) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
	}
	
	/**
	 * 输出数组元素
	 * @param arr
	 */
	public void show(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				System.out.print(arr[i]);
			} else {
				System.out.print(arr[i] + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		Reverse reverse = new Reverse();
		Scanner scanner = new Scanner(System.in);
		
		int p = scanner.nextInt();
		int n =scanner.nextInt();
		p = p % n; //防止出现循环个数超出数组个数
		int[] arr = new int[n];
		reverse.init(arr, scanner);
		
		reverse.reverseFun(arr, 0, p-1);
		reverse.reverseFun(arr, p, n-1);
		reverse.reverseFun(arr, 0, n-1);
		
		reverse.show(arr);
	}
}
