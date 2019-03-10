package trial6;

import java.util.Arrays;

public class CardPlay {
	private String inCards;
	// 字符串转int数组
	private int[] inCardsToInt;

	public String getInCards() {
		return inCards;
	}

	public void setInCards(String inCards) {
		this.inCards = inCards;
	}

	public int[] getInCardsToInt() {
		return inCardsToInt;
	}

	public void setInCardsToInt(int[] inCardsToInt) {
		this.inCardsToInt = inCardsToInt;
	}

	/**
	 * 初始化手中的牌
	 * 
	 * @param inCards
	 */
	public void initial(String inCards) {
		char[] toChars = inCards.toCharArray();
		int[] toInts = new int[toChars.length];

		// 转成int数组并排序
		for (int i = 0; i < toInts.length; i++) {
			toInts[i] = toChars[i] - '0';
		}

		Arrays.sort(toInts);
		this.inCardsToInt = toInts;

		// int数组转字符串
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < toInts.length; i++) {
			sBuilder.append(toInts[i]);
		}

		this.inCards = sBuilder.toString();
	}

	/**
	 * 
	 * 检查对手的牌是否合法
	 * 
	 * @param outCards
	 * @return
	 */
	private boolean checkOutCards(String outCards) {
		int length = outCards.length();
		if (length > 5) {
			return false;
		}
		if (length < 5) {
			char first = outCards.charAt(0);

			// 从第二个数开始;比较是否是重复的数
			for (int i = 1; i < outCards.length(); i++) {
				if (first != outCards.charAt(i)) {
					return false;
				}
			}
		} else {
			if (!(outCards.equals("12345") || outCards.equals("23456") || outCards.equals("34567")
					|| outCards.equals("45678") || outCards.equals("56789"))) {
				return false;
			}
		}
		return true;

	}

	/**
	 * 打牌的主方法
	 * 
	 * @param outCards
	 */
	public void play(String outCards) {
		boolean format = checkOutCards(outCards);
		int length = outCards.length();

		// 输入格式不合法
		if (!format) {
			System.out.println("------输入格式不合法------");
			return;
		}

		boolean result = false;

		if (length == 5) {
			result = compareInFive(outCards);
		} else {
			result = compareUnderFive(outCards);
		}

		// 结果的比较
		if (result) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	/**
	 * 输入5个以下的牌的比较;成功为true
	 * 
	 * @param outCards
	 * @return
	 */
	private boolean compareUnderFive(String outCards) {

		// 输入字符串的第一个
		int first = outCards.charAt(0) - '0';
		// 输入字符串的长度
		int length = outCards.length();
		// 表示是否进入到匹配状态
		boolean flag = false;
		// 已经匹配成功的个数
		int num = 0;
		// 正在进行匹配的数
		int compare = 0;

		for (int i = 0; i < inCardsToInt.length; i++) {
			// 找到了第一个比出的牌大的数
			if (inCardsToInt[i] > first && !flag) {
				// 确定以当前值为标准
				compare = inCardsToInt[i];
				num++;
				flag = true;
			}
			// 进入匹配状态
			// 在第一个数的基础上比较是否一样
			else if (inCardsToInt[i] == compare && flag) {
				num++;

			} else if (inCardsToInt[i] != compare && flag) {
				// 若是在比较的过程中遇到了不相等 则还原清零 退出匹配状态
				num = 0;
				flag = false;
				// 回退到这个位置 使下次继续跟他比较
				i--;
			}

			if (num == length) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 输入5个时的比较;成功为true
	 * 
	 * @param outCards
	 * @return
	 */
	private boolean compareInFive(String outCards) {
		// 输入字符串的第一个
		int first = outCards.charAt(0) - '0';
		// 输入字符串的长度
		int length = outCards.length();
		// 表示是否进入到匹配状态
		boolean flag = false;
		// 已经匹配成功的个数
		int num = 0;
		// 正在进行匹配的数
		int compare = 0;

		for (int i = 0; i < inCardsToInt.length; i++) {
			// 第一次找到比输入字符的第一个大的数
			if (inCardsToInt[i] > first && !flag) {
				// 以当前值+1 作为下一次比较的值
				compare = inCardsToInt[i] + 1;
				num++;
				flag = true;
				continue;
			}

			// 进入匹配阶段
			if (inCardsToInt[i] == compare && flag) {
				compare = inCardsToInt[i] + 1;
				num++;

			} else if (inCardsToInt[i] != compare && flag) {
				// 与比较的不相等 退出比较状态 清空
				num = 0;
				flag = false;
			}

			if (num == length) {
				return true;
			}
		}

		return false;
	}
}
