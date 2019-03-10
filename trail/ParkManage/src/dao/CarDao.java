package dao;

import domain.Car;

/**
 * 对车辆的操作 （以park 和 queue为数据库操作）
 * 
 * @author 葫芦胡
 *
 */
public class CarDao {

	// 操作停车场数据库对象 以及过道数据库对象
	private StackDao stackDao = new StackDao();
	private QueueDao queueDao = new QueueDao();

	/**
	 * 创建一个只有车牌号有效字段的车辆对象
	 * 
	 * @param carId
	 * @return
	 */
	public Car createCar(String carId) {
		Car car = new Car();
		car.setCarId(carId);
		return car;
	}

	/**
	 * 创建一个车辆对象
	 * 
	 * @param carId
	 * @param inTime
	 * @return
	 */
	public Car createCar(String carId, String inTime) {
		Car car = new Car();
		car.setCarId(carId);
		car.setInTime(inTime);
		return car;
	}

	/**
	 * 当x为0时 在停车场内查找 当x=1时 在过道查找
	 * 
	 * @param carId
	 * @param x
	 * @return
	 */
	public Car findCar(String carId, int x) {
		if (x == 0) {
			return stackDao.findCar(carId);
		} else {
			return queueDao.findCar(carId);
		}

	}

	/**
	 * 计算车辆的费用
	 * 
	 * @param carId
	 * @return
	 */
	public double calculateMoney(String carId) {
		Car car = findCar(carId, 0);
		if (car == null) {
			return 0;
		}

		String inTime = car.getInTime();
		String outTime = car.getOutTime();
		double money = (Integer.parseInt(outTime) - Integer.parseInt(inTime)) * stackDao.getPrice();
		car.setMoney(money);
		return money;

	}

	/**
	 * 设置车辆的到达时间 离开时间
	 * 
	 * @param carId
	 */
	public void SetOutTime(String carId, String outTime) {
		Car car = findCar(carId, 0);
		if (car == null) {
			return;
		}
		car.setOutTime(outTime);
	}

}
