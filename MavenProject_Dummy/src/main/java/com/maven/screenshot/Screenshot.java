package com.maven.screenshot;

import java.io.File;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Screenshot{
	public static WebDriver driver;
	
	public static void driver() {
		  System.out.println("inside driver");
		  System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://www.google.co.in/");
		  driver.manage().window().maximize();
	  }
	
	public static void takeScreenshoot(String Name) throws Exception {
		ru.yandex.qatools.ashot.Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	    ImageIO.write(fpScreenshot.getImage(),"PNG",new File("src\\test\\resources\\Evidence\\"+Name+".png"));
	}

}
