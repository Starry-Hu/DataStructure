package trial7;

/**
 * 实现字符串U型化
 * 
 * @author 葫芦胡
 *
 */
public class HelloU {
	private String data;
	private char[] dataToChars;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public char[] getDataToChars() {
		return dataToChars;
	}

	public void setDataToChars(char[] dataToChars) {
		this.dataToChars = dataToChars;
	}

	/**
	 * 初始化数据
	 * 
	 * @param data
	 */
	public void initial(String data) {
		this.data = data;
		dataToChars = data.toCharArray();
	}

	public void achieve() {
		// 检测输入是否包含空格
		if (data.contains(" ")) {
			System.out.println("------字符串包含空格，输入形式不合法------");
			return;
		}
		
		
		int n1, n3, mid = 0;
		int N = data.length();
		/*
		 * n1和n3是不大于n2,且满足 n1+n2+n3=N+2 的最大值 则n1=n3=(N+2)/3,n2=N + 2-(n1+n3)
		 * side为两边的字符数,则side=n1=n3=(N + 2)/3
		 * 
		 * mid为最后一行除去两端的两个字符后剩下的字符数 mid=N-side*2（总长度减去两边的字符数） 同时也是除最后一行外每一行所需要输出的空格数
		 */
		// 根据题目公式可得
		
		// 检测字符串长度是否合法
		if (N < 5 || N > 80) {
			System.out.println("------字符串长度不合法------");
			return;
		}
		n1 = n3 = (N + 2) / 3;
		// 最后一行中间的长度
		mid = N - n1 - n3;

		// i为行数;此时不包括最后一行
		for (int i = 0; i < n1 - 1; i++) {
			for (int j = 1; j <= mid+2; j++) {
				// 第i行的第一个;需要输出元素
				if (j == 1) {
					System.out.print(dataToChars[i]);
				}else if (j == mid+2) {
					// 第i行的最后一个；需要输出元素;
					// 与这一行的第一个成对称性下标
					System.out.println(dataToChars[N - i - 1]);
				}else {
					// 中间的 输出空格即可
					System.out.print(" ");
				}
			}
		}
		
		// 处理最后一行 总共输出 mid+2 个数据 
		for (int i = n1 - 1; i <= mid + n1; i++) {
			System.out.print(dataToChars[i]);
		}
		System.out.println();

	}

}
