package trial9;

/**
 * 罪犯转移
 * 选取连续c个且值和不超过最大上限
 * 得到其方案总数
 * 
 * @author 葫芦胡
 *
 */
public class TransferPeople {
	// 依次输入罪犯个数n,罪行值和最大上限t,转移人数c名
	private int n;
	private int sumMax; // int t
	private int c;
	private int[] datas;

	/**
	 * 初始化
	 * 
	 * @param n
	 * @param sumMax
	 * @param c
	 */
	public void initial(int n, int sumMax, int c, int[] datas) {
		this.n = n;
		this.sumMax = sumMax;
		this.c = c;

		this.datas = datas;
	}

	public void achieve() {
		if (c > n) {
			System.out.println("------转移人数取值不合法------");
			return;
		}
		
		int sum = 0;
		int count = 0;

		for (int i = 0; i < n; i++) {

			// 在i<c-1时;表示前c-1项求和
			// 在i>= c-1 时;表示达到c个的和/大于c个的和
			sum += datas[i];

			// 进行sum处理
			if (i >= c-1) {
				// 此时已经超过第c个;则把原组合的第一个删掉;进行修正
				if (i >= c) {
					sum -= datas[i-c];
				}
				// 如果得到的和小于等于最大上限；则策略个数加1
				if (sum <= sumMax) {
					count ++ ;
				}
			}
		}
		System.out.println(count);

	}
}
