package scenarios;

import org.openqa.selenium.WebDriver;

public class DriverInstance {
    public static WebDriver initdriver;
	
	public static void setDriver(WebDriver driver){
		initdriver=driver;
	}
	
	public static WebDriver getDriver(){
		return initdriver;
	}
}
