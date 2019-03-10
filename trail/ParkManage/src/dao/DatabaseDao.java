package dao;

import domain.DataBase;

/**
 * 对模拟数据库的操作
 * 
 * @author 葫芦胡
 *
 */
public class DatabaseDao {

	/**
	 * 初始化数据库
	 * 
	 * @param params
	 *            传入参数分别为 停车场大小 过道大小 收费价格
	 */
	public void init(int... params) {
		DataBase.getInstance(params);
	}

	/**
	 * 修改数据库（停车场系统规模）
	 * 
	 * @param params
	 */
	public void change(int... params) {
		DataBase.changeInstance(params);
	}
}
