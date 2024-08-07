package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger; //log4j
	public Properties pr;
	
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"os","browser"}) //same names which we used in  master xml file
	public void setUp(String os,String br) throws 
IOException
	{
		//FileReader file=new FileReader("./src\\test\\resources\\config.proeprties"); //(./) means current directory
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		pr=new Properties();
		pr.load(file);
		
		logger=LogManager.getLogger(this.getClass());  //To run for every testcase we use this keyword(log4j2.xml)
		//os:
		if(pr.getProperty("execution_env").equalsIgnoreCase("remote"))  //remote
         {
			DesiredCapabilities capabilities=new DesiredCapabilities();
	           if(os.equalsIgnoreCase("windows"))
	           {
	        	   capabilities.setPlatform(Platform.WIN10);
	           }
	           else if(os.equalsIgnoreCase("mac"))
	           {
	        	   capabilities.setPlatform(Platform.MAC);
	           }
	           else
	           {
	        	   System.out.print("Not Platform Matched");
	           }
	         //browser:
	           switch(br.toLowerCase())
	           {
	           case "chrome":capabilities.setBrowserName("chrome");break;
	           case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
	           default:System.out.println("No Browser Matched");return;
	           }
	           driver=new RemoteWebDriver(new URL("http://192.168.0.106:4444/wd/hub"),capabilities);
         }
		if(pr.getProperty("execution_env").equalsIgnoreCase("local")) //local
		{
			switch(br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver();break;
			case "firefox": driver=new FirefoxDriver();break; 
			case "edge": driver=new EdgeDriver();break;
			default: System.out.println("Invalid Browser");return; //To exit from test case without executing next steps
		}
	}
		driver.get(pr.getProperty("appUrL"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
	}
	@AfterClass(groups= {"sanity","regression","master"})
	   public void tearDown()
	   {
		   driver.quit();
	   }
		public String randomeString()
		{
			String generatedString=RandomStringUtils.randomAlphabetic(5);
			return generatedString;
		}
		
		public String randomeNumber()
		{
			String generatedString=RandomStringUtils.randomNumeric(10);
			return generatedString;
		}
		
		public String randomAlphaNumeric()
		{
			String str=RandomStringUtils.randomAlphabetic(3);
			String num=RandomStringUtils.randomNumeric(3);
			
			return (str+"@"+num);
		}
		public String captureScreen(String tname) throws IOException {

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
					
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
				
			return targetFilePath;

		}
}
