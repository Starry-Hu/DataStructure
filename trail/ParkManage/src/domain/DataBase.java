package domain;


/**
 * 模拟数据库
 * 
 * @author 葫芦胡
 *
 */
public class DataBase {

	// 单例对象 模拟数据库
	private static DataBase dataBase = null;

	// 栈模拟停车场
	private Stack parkStack;

	// 队列模拟过道
	private Queue sideQueue;

	// private构造方法 防止别人创建
	private DataBase() {
	}

	public Stack getParkStack() {
		return parkStack;
	}

	public Queue getSideQueue() {
		return sideQueue;
	}

	@Override
	public String toString() {
		return "DataBase [parkStack=" + parkStack + ", sideQueue=" + sideQueue + "]";
	}

	public static DataBase getInstance(int... params) {
		if (dataBase == null || dataBase.parkStack == null || dataBase.sideQueue == null) {
			dataBase = new DataBase();
			dataBase.init(params[0], params[1], params[2]);
		}
		return dataBase;
	}
	
	public static void changeInstance(int... params) {
		
		if (dataBase == null) {
			return ;
		}
		dataBase.change(params[0], params[1], params[2]);
	}

	// 初始化方法，对数据库的初始化操作
	private void init(int parkSize, int waitSize, int price) {
		this.parkStack = new Stack();
		this.sideQueue = new Queue();

		this.parkStack.setMaxSize(parkSize);
		this.parkStack.setCars(new Car[parkSize]);
		this.parkStack.setPrice(price);
		this.sideQueue.setMaxSize(waitSize);
		// 会损失一个来判断队满情况   所以要多创建一个空间
		this.sideQueue.setCars(new Car[waitSize+1]);
		
		System.out.println(this.parkStack);
		System.out.println(this.sideQueue);
	}
	
	/**
	 * 修改停车场系统
	 * 之前的停车信息会丢失
	 * 
	 * @param parkSize
	 * @param waitSize
	 * @param price
	 */
	private void change(int parkSize, int waitSize, int price) {
		if (dataBase == null) {
			return;
		}
		this.parkStack.setMaxSize(parkSize);
		this.parkStack.setCars(new Car[parkSize]);
		this.parkStack.setPrice(price);
		this.sideQueue.setMaxSize(waitSize);
		this.sideQueue.setCars(new Car[waitSize]);
		
		
		System.out.println(this.parkStack);
		
	}
}
