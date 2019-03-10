package service;

import dao.QueueDao;
import domain.Car;

public class QueueService {

	private QueueDao queueDao = new QueueDao();

	/**
	 * 获取候车场车辆数
	 * 
	 * @return
	 */
	public int getCapacity() {
		return queueDao.getCapacity();
	}

	/**
	 * 返回过道的所有车辆信息
	 * 
	 * @return
	 */
	public Car[] getCars() {
		return queueDao.getCars();
	}
}
