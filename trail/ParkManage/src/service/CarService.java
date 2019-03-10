package service;

import dao.CarDao;
import dao.QueueDao;
import dao.StackDao;
import domain.Car;
import domain.DataBase;

/**
 * 对车辆的业务逻辑操作 (service层可以操作多个dao)
 * 
 * @author 葫芦胡
 *
 */
public class CarService {
	private CarDao carDao = new CarDao();
	private StackDao stackDao = new StackDao();
	private QueueDao queueDao = new QueueDao();

	/**
	 * 车辆入停车场 并返回在其中的位置
	 * 
	 * @param carId
	 * @param parkStack
	 * @param inTime
	 * @return
	 * @throws StackException
	 */
	public int addCarToPark(String carId, String inTime) throws StackException {
		if (stackDao.isFull()) {
			throw new StackException("停车场已满！");
		}
		Car car = carDao.createCar(carId, inTime);
		return stackDao.addCar(car);
	}

	/**
	 * 车辆出停车场 同时返回相应的车辆信息
	 * 
	 * @param carId
	 * @param parkStack
	 * @param outTime
	 * @return
	 * @throws CarException
	 */
	public Car deleteCarFromPark(String carId, String outTime) throws CarException {
		// 在停车场查找汽车信息
		Car car = carDao.findCar(carId, 0);
		if (car == null) {
			throw new CarException("没有找到相应的车辆信息");
		}
		// 设置出的时间、并计算费用
		carDao.SetOutTime(carId, outTime);
		carDao.calculateMoney(carId);

		return stackDao.deleteCar(car);
	}

	/**
	 * 车辆进过道等候 并返回在其中的位置
	 * 
	 * @param carId
	 * @return
	 * @throws QueueException
	 */
	public int addCarToSide(String carId) throws QueueException {
		System.out.println(queueDao.isFull());
		if (queueDao.isFull()) {
			throw new QueueException("过道已满！");
		}
		Car car = carDao.createCar(carId);
		car.setCarId(carId);
		return queueDao.addCar(car);
	}

	/**
	 * 队头车辆退出过道 准备进入停车场 (这个方法只是从过道删除)
	 * 
	 * @param carId
	 * @return
	 * @throws QueueException
	 */
	private Car deleteCarFromSide(String carId) throws QueueException {
		// 只允许队头车辆元素进入
		Car car = queueDao.getHead();
		System.out.println(DataBase.getInstance().getSideQueue());
		if (car == null) {
			throw new QueueException("没有找到相应的车辆信息");
		}
		if (!carId.equals(queueDao.getHead().getCarId())) {
			throw new QueueException("不是队头车辆，不允许插队进入");
		}

		return queueDao.deleteCar();
	}

	/**
	 * 车从过道进入停车场 (这个是添加到停车场里面)
	 * 
	 * @param carId
	 * @param inTime
	 * @return
	 * @throws StackException
	 * @throws QueueException
	 */
	public int addCarToParkFromSide(String carId, String inTime) throws StackException, QueueException {

		if (stackDao.isFull()) {
			throw new StackException("停车场已满！");
		}
		// 判断是否为对头元素 防止插空插队进入
		Car car = deleteCarFromSide(carId);

		// Car car = carDao.findCar(carId, 1);
		car.setInTime(inTime);
		return stackDao.addCar(car);

	}

}
