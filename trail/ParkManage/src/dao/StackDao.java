package dao;

import domain.Car;
import domain.DataBase;
import domain.Stack;

/**
 * 相当于停车场数据库 （用栈模拟）
 * 
 * @author 葫芦胡
 *
 */
public class StackDao {
	// 获取到停车场栈 数据库对象
	private Stack parkStack = DataBase.getInstance().getParkStack();

	/**
	 * 判断栈是否为空
	 * 
	 * @param stack
	 * @return
	 */
	public boolean isEmpty() {
		if (parkStack.getTop() == -1) {
			return true;
		}
		return false;
	}

	/**
	 * 判断栈是否已满
	 * 
	 * @param stack
	 * @return
	 */
	public boolean isFull() {
		System.out.println(parkStack);
		if (parkStack.getMaxSize() == parkStack.getTop() + 1) {
			return true;
		}
		return false;
	}

	/**
	 * 添加汽车入栈 (主要针对停车场栈)
	 * 
	 * @param car
	 * @return
	 */
	public int addCar(Car car) {
		int top = parkStack.getTop();
		Car[] data = parkStack.getCars();
		// 是不是抽出来考虑比较好呢
		// 提出来在service层考虑
		// if(isFull(stack)) {
		// return false;
		// }
		top++;
		data[top] = car;
		parkStack.setTop(top);
		return top;
	}

	/**
	 * 删除车辆（主要针对车辆出停车场栈）
	 * 这部分代码还可以优化
	 * @param pos
	 * @param parkStack
	 * @param tempStack
	 * @return
	 */
	public Car deleteCar(Car car) {
		int pos = findCarIndex(car.getCarId());
		Stack tempStack = new Stack();
		tempStack.setMaxSize(parkStack.getMaxSize());
		tempStack.setCars(new Car[parkStack.getMaxSize()]);

		int top1 = parkStack.getTop();
		int top2 = tempStack.getTop();
		Car[] realData = parkStack.getCars();
		Car[] tempData = tempStack.getCars();

		// 存储原top信息
		// int i = top1,j=top2;

		for (top2 = -1; top1 > pos; top1--, top2++) {
			tempData[(top2+1)] = realData[top1];
		}
		// 获取到要删除的车辆信息
		// 此时 top1=pos  top2指向存的临时元素的第一个
		Car deleteCar = realData[top1];

		//
		// 将临时栈的车辆放回来
		// 如果临时栈没有车辆 则是把将删除的位置置为null
		//
		for (; top2 >= 0; top2--, top1++) {
			realData[top1] = tempData[top2];
		}

		// 将top1比原来下降一个 相当于退了一个
		// 将删除的元素置空
		realData[top1] = null;
		top1 = top1 - 1;
		parkStack.setTop(top1);
		return deleteCar;
	}

	/**
	 * 获取栈的容量 （主要针对停车场）
	 * 
	 * @param parkStack
	 * @return
	 */
	public int getCapacity() {
		int top = parkStack.getTop();
		if (top == -1) {
			return 0;
		} else {
			return top + 1;
		}
	}

	/**
	 * 查找并返回车辆信息
	 * 
	 * @param carId
	 * @return
	 */
	public Car findCar(String carId) {
		int top = parkStack.getTop();
		Car[] data = parkStack.getCars();
		for (int i = top; i >= 0; i--) {
			if (data[i].getCarId().equals(carId)) {
				return data[i];
			}
		}
		return null;
	}

	/**
	 * 查找车辆所在停车场的index下标
	 * 
	 * @param carId
	 * @return
	 */
	public int findCarIndex(String carId) {
		int top = parkStack.getTop();
		Car[] data = parkStack.getCars();
		for (int i = top; i >= 0; i--) {
			if (data[i].getCarId().equals(carId)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 获取单价
	 * 
	 * @return
	 */
	public double getPrice() {
		return parkStack.getPrice();
	}

	/**
	 * 返回停车场所有的停车信息
	 * 
	 * @return
	 */
	public Car[] getCars() {
		return parkStack.getCars();
	}
}
