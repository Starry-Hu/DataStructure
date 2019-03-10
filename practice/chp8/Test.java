package chp8;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		int[] datas = new int[count];
		
		for (int i = 0; i < count; i++) {
			datas[i] = scanner.nextInt();
		}
		
		QuickSort quickSort = new QuickSort();
		quickSort.setDatas(datas);
		quickSort.quickSort(0, count-1);
		
		
		for (int i = 0; i < datas.length; i++) {
			if (i == datas.length -1) {
				System.out.print(datas[i]);
			}else {
				System.out.print(datas[i] + " ");
			}
		}
		scanner.close();
	}

}
