package Eclipse_Tips;

import org.openqa.selenium.WebDriver;

public class Topic_03_Getter_Setter {
	WebDriver driver;
	private String carName;
	private String carType;
	private String carColor;
	private String carMachine;
	
	/**
	 * @return the carType
	 */
	public String getCarType() {
		return carType;
	}

	/**
	 * @param carType the carType to set
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}

	/**
	 * @return the carColor
	 */
	public String getCarColor() {
		return carColor;
	}

	/**
	 * @param carColor the carColor to set
	 */
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	/**
	 * @return the carMachine
	 */
	public String getCarMachine() {
		return carMachine;
	}

	/**
	 * @param carMachine the carMachine to set
	 */
	public void setCarMachine(String carMachine) {
		this.carMachine = carMachine;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}
	
}
