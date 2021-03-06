import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testing.RorPapTestOnChrome;

public class Main {

	public static void main(String[] args) {
//		WebDriver driver = new FirefoxDriver();
//		driver.get("http://google.com");
//		driver.get("http://homestead.app");
//		driver.findElement(By.name("email")).sendKeys("test@test.com");
//		driver.findElement(By.name("password")).sendKeys("123456");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
		

	    WebDriver driver = new FirefoxDriver();
	    driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));
	    element.sendKeys("Kasetsart University\n"); // send also a "\n"
	    element.submit();

	    // wait until the google page shows the result
	    WebElement myDynamicElement = (new WebDriverWait(driver, 10))
	              .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

	    List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));

	    // this are all the links you like to visit
	    for (WebElement webElement : findElements)
	    {
	        System.out.println(webElement.getAttribute("href"));
	    }
	}

}
