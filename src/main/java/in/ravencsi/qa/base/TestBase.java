package in.ravencsi.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static  Properties prop;
	public static WebDriver driver;
	
	
	public TestBase() {
		try {
			 prop=new Properties();
			FileInputStream ip=new FileInputStream(System.getProperty("C:\\Users\\EMPULSE\\"
					+ "eclipse-workspace\\UIAutomation\\src\\main\\java\\in\\ravencsi\\qa\\config\\config.properties"));
			prop.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}	
		public static void initialization() {
			String browserName=prop.getProperty("browser");
			if(browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\"
						+ "EMPULSE\\Downloads\\chromedriver_win32.chromedriver.exe");
				driver=new ChromeDriver();
			}else if(browserName.equals("FF")) {
				System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
				driver=new FirefoxDriver();
			}
		
	}

	
		
		
	

}
