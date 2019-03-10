package trial8;

/**
 * 前17位为数字，根据权重值算出对应第18位的取值
 * 简易检验身份证号是否正确
 * 
 * @author 葫芦胡
 *
 */
public class CheckID {
	private String data;
	private char[] dataToChars;

	/**
	 * 初始化身份证号码(18位)
	 * 
	 * @param data
	 */
	public void initial(String data) {
		this.data = data;
		this.dataToChars = data.toCharArray();
	}

	/**
	 * 检测的具体程序
	 * 
	 * @return
	 */
	public boolean achieve() {
		// 长度小于18
		if (dataToChars.length < 18) {
			return false;
		}
		// 计算前17位的权重和
		int sum = 0;

		for (int i = 0; i < dataToChars.length; i++) {
			if (i < dataToChars.length - 1) {
				// 检测前17位的格式情况;是否全为数字
				if (dataToChars[i] < '0' || dataToChars[i] > '9') {
					return false;
				}
				sum = calculate(sum, dataToChars[i] - '0', i);
				
			} else {
				// 现最后一位不等于算出来的最后一位
				return checkLast(sum, dataToChars[i]);
			}
		}

		return true;
	}

	/**
	 * 计算前17位的加权和
	 * 
	 * @param sum
	 * @param value
	 * @param index
	 * @return
	 */
	public int calculate(int sum, int value, int index) {
		int[] weights = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };

		// 非最后一位，则进行权重求和
		sum += value *weights[index];
		return sum;
	}

	/**
	 * 检查最后一位是否符合
	 * 
	 * @param sum
	 * @param last
	 * @return
	 */
	public boolean checkLast(int sum, char last) {
		// 对应得各个取值上的校验码
		char[] M = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
		int check = sum % 11;
		return (M[check] == last );
		
	}
}
