package trial1;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入约瑟夫环数总人数大小");
		int maxSize = scanner.nextInt();
		System.out.println("请输入起始数");
		int startNum = scanner.nextInt();
		System.out.println("请输入循环数");
		int cycleNum = scanner.nextInt();
		
		
		System.out.println("---------链表实现约瑟夫环---------");
		YueLinkList yueLinkList = new YueLinkList();
		yueLinkList.initial(startNum, cycleNum);
		for (int i = 1; i <= maxSize; i++) {
			yueLinkList.push(i);
		}
		yueLinkList.achieve2();
		
		System.out.println();
		System.out.println("---------顺序表实现约瑟夫环---------");
		YueSeqList yueSeqList = new YueSeqList();
		yueSeqList.initial(startNum, cycleNum, maxSize);
		yueSeqList.achieve();
		
		scanner.close();
	}
}
