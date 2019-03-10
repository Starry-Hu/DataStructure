package chp8;

public class QuickSort {
	private int[] datas;
	// 用于第一次排序后输出位置
	static private boolean flag = false;
	
	public int[] getDatas() {
		return datas;
	}

	public void setDatas(int[] datas) {
		this.datas = datas;
	}

	public void quickSort(int start, int end) {
		int i = start;
		int j = end;
		// 将划分元素暂存
		int x = datas[i];
		while(i != j) {
			// 如果j的元素值小于比较值  且i,j不等
			// j-- 向后移动
			while(datas[j] > x && i!= j) {
				j--;
			}
			
			// 跳出循环 交换数据  进入前面段比较的阶段
			if (i < j) {
				datas[i] = datas[j];
				i++;
				
				while(datas[i] < x && i!=j) {
					i++;
				}
				
				// 遇到了跳出循环的条件;交换数据
				if (i < j) {
					datas[j] = datas[i];
				}
				
			}
			// 结束  循环进入后端比较
		}
		// i与j相遇，放置x;
		datas[i] = x;
		
		// 第一轮结束后输出x的位置
		if (!flag) {
			System.out.print((i+1) + " ");
			flag = true;
		}
		
		// 重置开始和起始;重复执行方法
		i--; j++;
		if (start < i) {
			quickSort(start, i);
		}
		if (j < end) {
			quickSort(j, end);
		}
	}
}
