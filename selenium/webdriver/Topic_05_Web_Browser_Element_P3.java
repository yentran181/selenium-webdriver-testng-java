package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser_Element_P3 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}

	@Test
	public void TC_01_Is_Displayed() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//Email Textbox
		WebElement emailTextbox = driver. findElement(By.xpath("//input[@id='mail']"));
		if (emailTextbox.isDisplayed()) {
			emailTextbox.sendKeys("Automation Testing");
			System.out.println("Email textbox is displayed");
		} else {
			System.out.println("Email textbox is undisplayed");		
		}
		
		//Age Under 18 Radio button
		WebElement under18Radiobutton = driver.findElement(By.xpath("//input[@id='under_18']"));
		if (under18Radiobutton.isDisplayed()) {
			under18Radiobutton.click();
			System.out.println("Age Under18 Radio button is displayed");
		} else {
			System.out.println("Age Under18 Radio button is undisplayed");
		}
		
		//Education Textarea
		WebElement educationTextarea = driver.findElement(By.xpath("//textarea[@id='edu']"));
		if (educationTextarea.isDisplayed()) {
			educationTextarea.sendKeys("Automation Testing");
			System.out.println("Education Textare is displayed");
		} else {
			System.out.println("Education Textare is undisplayed");
		}
		
		//Image5 (Undisplayed)
		WebElement image5 = driver.findElement(By.xpath("//h5[text()=\"Name: User5\"]"));
		if (image5.isDisplayed()) {
			System.out.println("Image5 is displayed");
		} else {
			System.out.println("Image5 is not displayed");

		}
			
	}
	@Test
	public void TC_02_isEnable() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Email
		WebElement emailTextbox = driver.findElement(By.cssSelector("input#email"));
		if (emailTextbox.isEnabled()) {
			System.out.println("emailTextbox is enabled");
		} else {
			System.out.println("emailTextbox is disabled");
		}
		
		// Age Under 18 Radio button
		WebElement under18RadioButton = driver.findElement(By.cssSelector("input#under_18"));
		if (under18RadioButton.isEnabled()) {
			System.out.println("Under 18 radio button is enabled");
		} else {
			System.out.println("Under 18 radio button is disabled");
		}
		
		// Education Textarea
		WebElement educationTextArea = driver.findElement(By.cssSelector("textarea#edu"));
		if (educationTextArea.isEnabled()) {
			System.out.println(" Education Text Area is enabled");
		} else {
			System.out.println(" Education Text Area is disabled");
		}
		
		// Job Role 01 Single Dropdown
		WebElement JobRole01SingleDropdown = driver.findElement(By.cssSelector("select#job1"));
		if (JobRole01SingleDropdown.isEnabled()) {
			System.out.println("Job Role 01 is enabled");
		} else {
			System.out.println("Job Role 01 is disabled");
		}
		
		//Job Role 02 Multiple Dropdown
		WebElement JobRole02MultipleDropdown = driver.findElement(By.cssSelector("select#job2"));
		if (JobRole02MultipleDropdown.isEnabled()) {
			System.out.println("Job Role 02 is enabled");
		} else {
			System.out.println("Job Role 02 is disabled");
		}
		
		//Interest Development Checkbox
		WebElement developmentCheckbox = driver.findElement(By.cssSelector("input#development"));
		if (developmentCheckbox.isEnabled()) {
			System.out.println("Interest Development Checkbox is enabled");
		} else {
			System.out.println("Interest Development Checkbox is disabled");
		}
		
		//Slider 01
		WebElement n01Slider = driver.findElement(By.cssSelector("input#slider-1"));
		if (n01Slider.isEnabled()) {
			System.out.println("Slider 01 is enabled");
		} else {
			System.out.println("Slider 02 is enabled");
		}
		
		//Password Textbox
		WebElement passwordTextbox = driver.findElement(By.cssSelector("input#disable_password"));
		if (passwordTextbox.isEnabled()) {
			System.out.println("Password Textbox is enabled");
		} else {
			System.out.println("Password Textbox is disabled");
		}
		
		// Age radio button
		WebElement AgeRadioButton = driver.findElement(By.cssSelector("input#radio-disabled"));
		if (AgeRadioButton.isEnabled()) {
			System.out.println("Age radio button is enabled");
		} else {
			System.out.println("Age radio button is disabled");
		}
		
		//Biology Text Area
		WebElement biologyTextArea = driver.findElement(By.cssSelector("#bio"));
		if (biologyTextArea.isEnabled()) {
			System.out.println("Biology Text Area is enabled");
		} else {
			System.out.println("Biology Text Area is disabled");
		}
		
		// Job Role 03 Dropdown
		WebElement jobRole03Dropdown = driver.findElement(By.cssSelector("#job3"));
		if (jobRole03Dropdown.isEnabled()) {
			System.out.println("Job Role 03 Dropdown is enabled");
		} else {
			System.out.println("Job Role 03 Dropdown is disabled");
		}
		
		// Interest Checkbox
		WebElement interestCheckbox = driver.findElement(By.cssSelector("#check-disbaled"));
		if (interestCheckbox.isEnabled()) {
			System.out.println("Interest Checkbox is enabled");
		} else {
			System.out.println("Interest Checkbox is disabled");
		}
		
		// Slider 02
		WebElement n02Slider = driver.findElement(By.cssSelector("#slider-2"));
		if (n02Slider.isEnabled()) {
			System.out.println("Slider 02 is enabled");
		} else {
			System.out.println("Slider 02 is disabled");
		}
	}

	@Test
	public void TC_03_isSelected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		WebElement ageUnder18Radiobutton = driver.findElement(By.cssSelector("#under_18"));
		ageUnder18Radiobutton.click();
		
		if (ageUnder18Radiobutton.isSelected()) {
			System.out.println("Age Under 18 is selected");
		} else {
			System.out.println("Age Under 18 is de-selected");
		}
		
		WebElement languageJavaCheckbox = driver.findElement(By.cssSelector("input#java"));
		
		languageJavaCheckbox.click();
		if (languageJavaCheckbox.isSelected()) {
			System.out.println("Language Java Checkbox is selected");
		} else {
			System.out.println("Language Java Checkbox is de-selected");
		}
		languageJavaCheckbox.click();
		if (languageJavaCheckbox.isSelected()) {
			System.out.println("Language Java Checkbox is selected");
		} else {
			System.out.println("Language Java Checkbox is de-selected");
		}
	}
	
	@Test
	public void TC_04_Register_Function() {
		driver.get("https://login.mailchimp.com/signup/");
		
		//Nhập Email/Username textbox
		driver.findElement(By.cssSelector("input#email")).sendKeys("yentranabc@gmail.com");
		sleepInSecond(3); //sleep để tự quan sát tự động điền email vào field Username
		
		WebElement passwordTextbox = driver.findElement(By.cssSelector("input#new_password"));
		
		//Check lowcase
		passwordTextbox.sendKeys("abc");
		sleepInSecond(2); //sleep để quan sát effect trên màn hình
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		//Check uppercase
		passwordTextbox.clear(); //Xóa dữ liệu cũ
		passwordTextbox.sendKeys("ABC");
		sleepInSecond(2); //sleep để quan sát effect trên màn hình
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		//Check number-char
		passwordTextbox.clear(); //Xóa dữ liệu cũ
		passwordTextbox.sendKeys("123");
		sleepInSecond(2); //sleep để quan sát effect trên màn hình
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		//Check special-char
		passwordTextbox.clear(); //Xóa dữ liệu cũ
		passwordTextbox.sendKeys("!@#$");
		sleepInSecond(2); //sleep để quan sát effect trên màn hình
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		//Check 8 lowcase-char
		passwordTextbox.clear(); //Xóa dữ liệu cũ
		passwordTextbox.sendKeys("abcdabcd");
		sleepInSecond(2); //sleep để quan sát effect trên màn hình
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		//Check 8 uppercase-char
		passwordTextbox.clear(); //Xóa dữ liệu cũ
		passwordTextbox.sendKeys("ABCDABCD");
		sleepInSecond(2); //sleep để quan sát effect trên màn hình
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		//Check 8 number-char
		passwordTextbox.clear(); //Xóa dữ liệu cũ
		passwordTextbox.sendKeys("12345678");
		sleepInSecond(2); //sleep để quan sát effect trên màn hình
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		//Check 8 special-char
		passwordTextbox.clear(); //Xóa dữ liệu cũ
		passwordTextbox.sendKeys("!@#$%^&*");
		sleepInSecond(2); //sleep để quan sát effect trên màn hình
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		//Check 8 lowcase and uppercase-char
		passwordTextbox.clear(); //Xóa dữ liệu cũ
		passwordTextbox.sendKeys("abcdABCD");
		sleepInSecond(2); //sleep để quan sát effect trên màn hình
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		//Check 8 lowcase and number-char
		passwordTextbox.clear(); //Xóa dữ liệu cũ
		passwordTextbox.sendKeys("abcd1234");
		sleepInSecond(2); //sleep để quan sát effect trên màn hình
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		//Check 8 lowcase and special-char
		passwordTextbox.clear(); //Xóa dữ liệu cũ
		passwordTextbox.sendKeys("abcdabc@");
		sleepInSecond(2); //sleep để quan sát effect trên màn hình
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		//Check 8 lowcase - uppercase - number -char
		passwordTextbox.clear(); //Xóa dữ liệu cũ
		passwordTextbox.sendKeys("Abcd1234");
		sleepInSecond(2); //sleep để quan sát effect trên màn hình
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		//Check 8 lowcase - uppercase - special -char
		passwordTextbox.clear(); //Xóa dữ liệu cũ
		passwordTextbox.sendKeys("Abcd!@#$");
		sleepInSecond(2); //sleep để quan sát effect trên màn hình
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		//Check 8 lowcase - uppercase - number - special -char
		passwordTextbox.clear(); //Xóa dữ liệu cũ
		passwordTextbox.sendKeys("Abcd1234@");
		sleepInSecond(2); //sleep để quan sát effect trên màn hình
		
		Assert.assertFalse(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());



	} 
		//Sleep cứng (Static wait)
				public void sleepInSecond(long timeInSecond) {
					try {
					Thread.sleep(timeInSecond*1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
						}
					}
		
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}