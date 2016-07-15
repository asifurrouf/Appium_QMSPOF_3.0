package scenarios;

import org.openqa.selenium.WebDriver;

public class DriverInstance {
    public static WebDriver inidriver;
	
	public static void setDriver(WebDriver driver){
		inidriver=driver;
	}
	
	public static WebDriver getDriver(){
		return inidriver;
	}
}
