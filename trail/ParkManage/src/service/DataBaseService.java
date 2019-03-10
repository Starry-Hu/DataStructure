package service;

import dao.DatabaseDao;

public class DataBaseService {
	private DatabaseDao databaseDao = new DatabaseDao();

	/**
	 * 初始化数据库
	 * 
	 * @param params
	 */
	public void init(int... params) {
		databaseDao.init(params);
	}

	/**
	 * 修改数据库信息
	 * 
	 * @param params
	 * @throws DatabaseException
	 */
	public void change(int... params) throws DatabaseException {
		/*
		 * 传参数过去查找数据库  
		 * 如果没有则根据这个参数初始化一个
		 * 有了则直接修改那个数据库
		 * */
		databaseDao.init(params);
		
		databaseDao.change(params);
	}
}
