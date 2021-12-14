import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {
	
	public static void main(String[] args) throws InterruptedException {
		
		String chromeDriverLocation = "C:\\Users\\Admin\\Desktop\\chromedriver.exe";
		String chromeDriverKey = "webdriver.chrome.driver";
		System.setProperty(chromeDriverKey, chromeDriverLocation);
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		
		chromeDriver.get("https://www.flipkart.com/");
		chromeDriver.manage().timeouts();
		chromeDriver.findElement(By.cssSelector("._2KpZ6l._2doB4z")).click();
		WebElement searchBox = chromeDriver.findElement(By.cssSelector("input[type='text']"));
		searchBox.sendKeys("Refrigarator");
		chromeDriver.manage().timeouts();
		chromeDriver.findElement(By.cssSelector("svg[width='20']")).click();
		
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		chromeDriver.findElement(By.cssSelector("._4rR01T")).click();
		Set<String> ids = chromeDriver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentPage = it.next();
		String childPage = it.next();
		chromeDriver.switchTo().window(childPage);
		chromeDriver.findElement(By.cssSelector("._24_Dny")).click();
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		chromeDriver.findElement(By.cssSelector("._3hShhO")).click();
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		List<WebElement> choose = chromeDriver.findElements(By.cssSelector("._1EDlbo._17qiPn"));
		choose.get(0).click();
		List<WebElement> brands = chromeDriver.findElements(By.cssSelector(".vd8GqM"));
		brands.get(26).click();
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));	
		
		chromeDriver.findElement(By.xpath("//*[@id=\"fk-compare-page\"]/div/div/div/div[1]/div[2]/div/div[2]/div[1]/div/div[3]/div[1]")).click();
		brands = chromeDriver.findElements(By.cssSelector(".vd8GqM"));
		brands.get(33).click();
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Thread.sleep(2000);
		
		choose.get(2).click();
		brands = chromeDriver.findElements(By.cssSelector(".vd8GqM"));
		brands.get(26).click();
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		choose.get(3).click();
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		brands = chromeDriver.findElements(By.cssSelector(".vd8GqM"));
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		brands.get(35).click();
		Thread.sleep(2000);
		
		choose.get(4).click();
		brands = chromeDriver.findElements(By.cssSelector(".vd8GqM"));
		brands.get(26).click();
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		choose.get(5).click();
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		brands = chromeDriver.findElements(By.cssSelector(".vd8GqM"));
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		brands.get(36).click();
		
	
		List<WebElement> ele = chromeDriver.findElements(By.cssSelector(".row.CQXY4c._3T4CNT"));
        for(int j=0;j<ele.size();j++) {
            String listOfValues = ele.get(j).getText();
            if(listOfValues.contains("Weight")) {
            	System.out.println(listOfValues);
            }
        }
	}
}