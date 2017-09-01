package recruiter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

public class Recr {
	static WebDriver d;

	protected static WebElement xp(String xpath) {

		return d.findElement(By.xpath(xpath));
	}

	protected static WebElement id(String id) {

		return d.findElement(By.id(id));
	}

	protected static WebElement css(String cssSelector) {

		return d.findElement(By.cssSelector(cssSelector));
	}

	public static void main(String[] args) throws InterruptedException,
			IOException {

		String workingDir;

		workingDir = System.getProperty("user.dir");

		File file = new File(workingDir + "\\Resources\\postjob.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);

		System.setProperty("webdriver.chrome.driver", workingDir
				+ "\\Resources\\chromedriver.exe");
		d = new ChromeDriver();

		d.get(prop.getProperty("url"));
		xp(prop.getProperty("recruitermenu")).click();

		xp(prop.getProperty("loginmenu")).click();

		d.switchTo().defaultContent();
		d.switchTo().frame("empcontentframe");

		xp(prop.getProperty("id")).sendKeys(prop.getProperty("recruiterid"));

		xp(prop.getProperty("pwd")).sendKeys(prop.getProperty("recruiterpwd"));

		xp(prop.getProperty("btnsubmit")).click();
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		/**
		 * @author surya Balapriya work name : postjobs
		 */

		id(prop.getProperty("postjobs")).click();
		d.switchTo().defaultContent();

		d.switchTo().frame("Iframe2");
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		id(prop.getProperty("Jobtitle")).clear();
		id(prop.getProperty("Jobtitle")).sendKeys(prop.getProperty("jobtitle"));
		id(prop.getProperty("Requiredskills")).clear();
		id(prop.getProperty("Requiredskills")).sendKeys(
				prop.getProperty("requiredskills"));
		id(prop.getProperty("Preferredskill")).clear();
		id(prop.getProperty("Preferredskill")).sendKeys(
				prop.getProperty("preferredskill"));
		id(prop.getProperty("explevel")).click();
		id(prop.getProperty("Jobdescription")).clear();
		id(prop.getProperty("Jobdescription")).sendKeys(
				prop.getProperty("jobdescription"));
		id(prop.getProperty("Clientname")).clear();
		id(prop.getProperty("Clientname")).sendKeys(
				prop.getProperty("clientname"));
		id(prop.getProperty("Buttonclick")).click();
		Thread.sleep(7000);

		id(prop.getProperty("City")).sendKeys(prop.getProperty("city"));

		Thread.sleep(7000);
		css(prop.getProperty("citylist")).click();

		Thread.sleep(7000);

		new Select(id(prop.getProperty("Jobexp")))
				.selectByVisibleText("1 Week");
		id(prop.getProperty("consulting")).click();

		id(prop.getProperty("workauthori")).click();
		id(prop.getProperty("preferemp")).click();
		id(prop.getProperty("Duration")).clear();
		id(prop.getProperty("Duration")).sendKeys(prop.getProperty("duration"));
		Select select = new Select(xp(prop.getProperty("splarea")));
		Select select1 = new Select(xp(prop.getProperty("splskills")));

		for (int i = 0; i <= 27; i++) {
			select.selectByIndex(i);

			d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		}

		select.selectByIndex(1);
		select1.selectByIndex(1);

		id(prop.getProperty("savebtn")).click();
		id(prop.getProperty("others")).click();
		id(prop.getProperty("domainexpo")).click();
		id(prop.getProperty("domainexpo1")).click();

		id(prop.getProperty("domainexpo2")).click();
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		id(prop.getProperty("postmyjob")).click();
		xp(prop.getProperty("closebtn")).click();
	}
}
