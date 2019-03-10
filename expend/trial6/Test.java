package trial6;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		CardPlay cardPlay = new CardPlay();
		Scanner scanner = new Scanner(System.in);
		System.out.println("------请输入手中的牌(1-9以内的数字)------");
		String inCards = scanner.nextLine();
		System.out.println("------请输入对方出的牌------");
		String outCards = scanner.nextLine();
		scanner.close();
		
		cardPlay.initial(inCards);
		cardPlay.play(outCards);
	}

}
