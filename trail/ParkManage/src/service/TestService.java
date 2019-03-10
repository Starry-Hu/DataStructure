package service;

import dao.QueueDao;
import dao.StackDao;
import domain.Car;
import domain.DataBase;

public class TestService {

	public static void main(String[] args) {
		// 初始化一个停车场系统
		DataBase.getInstance(2, 3, 5);

		StackDao stackDao = new StackDao();
		QueueDao queueDao = new QueueDao();

		// 循环进入两辆车 已达到停车场满的效果
		for (int i = 0; i < 2; i++) {
			Car car = new Car();
			car.setCarId(i + "");
			car.setInTime("10");
			int index = stackDao.addCar(car);
			System.out.println(i + "停车成功" + "  位于停车场" + index);
		}

		// 再添加进入时 停车场已满 进入队列
		for (int i = 0; i < 2; i++) {
			Car car = new Car();
			car.setCarId(i+2 + "");
			int index = queueDao.addCar(car);
			System.out.println(car.getCarId() + "停入过道等候" + "  位于过道" + index);
		}

		// 输出此时的停车场系统情况
		System.out.println(DataBase.getInstance());

		System.out.println("============删除一号车辆示例===============");

		/*
		 * 汽车出停车场 从停车场删除该汽车 同时获取到队列的第一个汽车元素 并将其添加进停车场 本例中 即删除1号元素 将队头元素2放入
		 */
		stackDao.deleteCar(stackDao.findCar("1"));

		Car newcar = queueDao.deleteCar();
		stackDao.addCar(newcar);

		System.out.println(DataBase.getInstance());
	}

}
