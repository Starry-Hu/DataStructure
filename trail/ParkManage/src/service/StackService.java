package service;

import dao.StackDao;
import domain.Car;

public class StackService {
	private StackDao stackDao = new StackDao();

	/**
	 * 获取停车场中的汽车数目
	 * 
	 * @return
	 */
	public int getCapacity() {
		return stackDao.getCapacity();
	}

	/**
	 * 返沪停车场总汽车信息
	 * 
	 * @return
	 */
	public Car[] getCars() {
		return stackDao.getCars();
	}
}
