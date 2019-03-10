package domain;

import java.util.Arrays;

/**
 * 采用循环队列模拟过道
 * head指向第一个元素的前一个
 * 
 * @author 葫芦胡
 *
 */
public class Queue {
	private int maxSize;
	private int tail = 0;
	private int head = 0;
	private Car[] cars;

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getTail() {
		return tail;
	}

	public void setTail(int tail) {
		this.tail = tail;
	}

	public int getHead() {
		return head;
	}

	public void setHead(int head) {
		this.head = head;
	}

	public Car[] getCars() {
		return cars;
	}

	public void setCars(Car[] cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "Queue [maxSize=" + maxSize + ", tail=" + tail + ", head=" + head + ", cars=" + Arrays.toString(cars)
				+ "]";
	}

}
