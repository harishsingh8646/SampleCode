package mystore.testcases;

import com.mystore.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();

	public String emailAddress = readConfig.getEmail() ;
	String password = readConfig.getPassword();
	
	
	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	public void setup()
	{

		switch(browser.toLowerCase())
		{

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			driver = null;
			break;

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger = LogManager.getLogger("MyStoreV1");
		driver.get(url);
		logger.info("url opened");

	}


	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}


	public void captureScreenShot(WebDriver driver,String testName) throws IOException
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
		FileUtils.copyFile(src, dest);
	}
	

}
