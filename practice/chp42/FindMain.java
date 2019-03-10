package chp42;

public class FindMain {
	private int[] data;

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public int find() {
		int max = data[0];
		int count = 1;
		for (int i = 1; i < data.length; i++) {
			if (max == data[i]) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				max = data[i];
				count = 1;
			}
		}
		
		if (calculate(max) > data.length / 2) {
			return max;
		} else {
			return -1;
		}
	}

	public int calculate(int x) {
		int count = 0;
		for(int i = 0; i < data.length;i++) {
			if(data[i] == x) {
				count++;
			}
		}
		return count;
	}
}
