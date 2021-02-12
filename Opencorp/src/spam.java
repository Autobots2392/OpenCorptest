import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.Reader;
//import java.nio.charset.Charset;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;
//import java.util.Properties.LineReader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import net.bytebuddy.asm.Advice.Exit;

public class spam {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
//		System.setProperty("webdriver.chrome.driver","F:\\drivers\\chrome driver\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		

		String path = System.getenv("PATH_GEEKO"); 
		System.setProperty("webdriver.gecko.driver", path);
		FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        //pass the options parameter in the Firefox driver declaration
        WebDriver driver = new FirefoxDriver(options);
        //FirefoxDriver driver = new FirefoxDriver();
		
		final StringBuilder stringBuilder = new StringBuilder();
		InputStream fis = new FileInputStream("E:\\Companyname.properties");
		final InputStreamReader streamReader = new InputStreamReader(fis, "UTF-8");
		final BufferedReader bufferedReader = new BufferedReader(streamReader);
		String line = "";
		// Store found count to Output properties file
		FileOutputStream fis1 = new FileOutputStream("E:\\output.properties");
		
		  while ((line = bufferedReader.readLine()) != null) 
		{
		      System.out.println("======#######>>"+line);
		      stringBuilder.append(line);
		      String[] linestr = line.split("=");
		  	  String linestr2 = linestr[1];
		  	  System.out.println("======>"+linestr2);
		  	
		  	driver.get("https://opencorporates.com/");
			driver.manage().window().maximize();
			
			WebElement searchBOX = driver.findElement(By.name("q"));
			//	String i = "" + j + "";
			// get the property of using getProperty()
			//System.out.println(prop.getProperty(i));
			// Enter the company name.
			searchBOX.sendKeys(linestr2);
			// find searchButton.
			WebElement searchButton = driver.findElement(By.className("oc-home-search_button"));
			// Click on SearchButton
			searchButton.click();
			// Wait for 5 seconds.
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Found')]")));
			// find the count.
			WebElement Count = driver.findElement(By.xpath("//h2[contains(text(),'Found')]"));
		    // Get text of found count.
			String count = Count.getText();
			// Print the found count
			System.out.println(count);
			// create Properties class object to access properties file
			Properties nprop = new Properties();
			//System.setProperty("file.encoding", "UTF-8");
			//String linestr3 = streamWriter.toString();
//			final OutputStreamWriter streamWriter = new OutputStreamWriter(fis1, "UTF-8");
//			final BufferedWriter bufferedWriter = new BufferedWriter(streamWriter);
//			String line2= bufferedWriter.write(linestr2);
			// load the properties file and set the properties file
			nprop.setProperty("->", count);
			// store the file into local system
			nprop.store(fis1, null);
			Thread.sleep(2000);
//			Properties prop = new Properties();
//			// load the properties file
//			prop.load(fis);
//			int companycount = prop.size();
//			System.out.println("Found company names = " + companycount);
	  }
		    // create Properties class object to access properties file

		driver.close();
		System.out.print("End of the test");
	}
}


