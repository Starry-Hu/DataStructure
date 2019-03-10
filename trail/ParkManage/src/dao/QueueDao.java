package dao;

import domain.Car;
import domain.DataBase;
import domain.Queue;

public class QueueDao {
	// 获取过道对象
	private Queue queue = DataBase.getInstance().getSideQueue();

	/**
	 * 循环队列会损失一个数组的位置来判断队满 实际的数组大小即运算的m是车辆数组长度 （maxsize+1）
	 */
	private int realSize = queue.getMaxSize() + 1; // queue.getCars().length

	/**
	 * 获取循环队列的容量
	 * 
	 * @return
	 */
	public int getCapacity() {
		return (queue.getTail() - queue.getHead() + realSize) % realSize;
	}

	/**
	 * 判断过道是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (queue.getHead() == queue.getTail()) {
			return true;
		}
		return false;
	}

	/**
	 * 判断过道是否已满
	 * 
	 * @return
	 */
	public boolean isFull() {
		// 损失一个空间(0 下标)来判断队列是否已满
		if ((queue.getTail() + 1) % realSize == queue.getHead()) {
			return true;
		}
		return false;
	}

	/**
	 * 查找指定车辆 若存在则返回车辆信息
	 * 
	 * @param carId
	 * @return
	 */
	public Car findCar(String carId) {
		Car[] data = queue.getCars();
		int head = queue.getHead();
		// 下标从front+1 开始
		for (int i = 1, p = (head + i) % realSize; i <= getCapacity();) {
			if (data[p].getCarId().equals(carId)) {
				return data[p];
			}
			i++;
			p = (head + i) % realSize;
		}
		return null;
	}

	/**
	 * 查找指定车辆 存在则返回下标 否则返回-1
	 * 
	 * @param x
	 * @return
	 */
	public int findCarIndex(String carId) {
		Car[] data = queue.getCars();
		int head = queue.getHead();

		// 下标从front+1 开始
		for (int i = 1, p = (head + 1) % realSize; i <= getCapacity(); i++) {
			if (data[p].getCarId().equals(carId)) {
				return p;
			}
			i++;
			p = (head + i) % realSize;
		}
		return -1;
	}

	/**
	 * 添加汽车入队 并返回其位置 应该判断队列是否已满，已满返回提示信息
	 * 
	 * @param car
	 * @return
	 */
	public int addCar(Car car) {
		int tail = queue.getTail();
		tail = (tail + 1) % realSize;
		Car[] data = queue.getCars();
		data[tail] = car;
		queue.setTail(tail);
		return tail;
	}

	/**
	 * 汽车出队 并返回该汽车的信息
	 * 
	 * @return
	 */
	public Car deleteCar() {
		Car[] data = queue.getCars();
		int head = queue.getHead();
		head = (head + 1) % realSize; // 移到下一个 （即原本的第一个，现在的队头的前一个元素
		// 获取到删除的元素 (即现在head的位置 队头元素的前一个)
		Car deleteCar = data[head];
		// 将删除的元素置空
		data[head] = null;

		queue.setHead(head);
		return deleteCar;
	}

	/**
	 * 返回队头车辆元素
	 * 
	 * @return
	 */
	public Car getHead() {
		Car[] data = queue.getCars();
		int head = queue.getHead();
		System.out.println(data[(head + 1) % realSize]);
		return data[(head + 1) % realSize];
	}

	/**
	 * 返回过道停的总车辆信息
	 * 
	 * @return
	 */
	public Car[] getCars() {
		return queue.getCars();
	}

}
