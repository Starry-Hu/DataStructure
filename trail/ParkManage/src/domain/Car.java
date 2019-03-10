package domain;

public class Car {
	private String carId;
	private String inTime;
	private String outTime;
	private double money;

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", inTime=" + inTime + ", outTime=" + outTime + ", money=" + money + "]";
	}

}
