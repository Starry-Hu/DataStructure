package chp43;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();

		PrintCircle pCircle = new PrintCircle();
		int[][] data = pCircle.calMatrix(n);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((j + 1) % n == 0) {
					System.out.println(data[i][j]);
				} else {
					System.out.print(data[i][j] + " ");
				}
			}
		}
	}

}
