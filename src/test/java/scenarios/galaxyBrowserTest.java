package scenarios;

import org.testng.annotations.Test;
public class galaxyBrowserTest extends AndroidSetupChrome {
    
	@Test
	public void openUrl(){
		driver.get("http://www.google.com");
		System.out.println("Android Title is: " + driver.getTitle());
	}
}
