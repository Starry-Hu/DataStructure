package domain;

import java.util.Arrays;

public class Stack {
	private int maxSize;
	// 栈顶汽车数组下标编号
	private int top = -1;
	private Car[] cars;
	private double price;

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public Car[] getCars() {
		return cars;
	}

	public void setCars(Car[] cars) {
		this.cars = cars;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Stack [maxSize=" + maxSize + ", top=" + top + ", cars=" + Arrays.toString(cars) + ", price=" + price
				+ "]";
	}
}
