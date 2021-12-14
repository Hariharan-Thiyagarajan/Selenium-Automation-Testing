import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {
	
public static void main(String[] args) throws InterruptedException {
		
		String chromeDriverLocation = "C:\\Users\\Admin\\Desktop\\chromedriver.exe";
		String chromeDriverKey = "webdriver.chrome.driver";
		System.setProperty(chromeDriverKey, chromeDriverLocation);
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.get("http://amazon.in/");
		
		WebElement searchBox = chromeDriver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		searchBox.sendKeys("Refrigarator");
		Thread.sleep(300);
		chromeDriver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		Thread.sleep(100);
		String refrigaratorString, searchPagePrice = "", productPageUrl = "";
		//
		for(int i=5; i<19; i++) { 
			
			String xPath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[" + i + "]/div/span/div/div/div[2]/div[2]/div/div/div[1]/h2/a/span";
			if( chromeDriver.findElements(By.xpath(xPath)).size() > 0 ) {
					WebElement searchResult = chromeDriver.findElement(By.xpath(xPath));
					refrigaratorString = searchResult.getText();
					if(refrigaratorString.contains("Samsung 192 L 2")) {
						String priceXpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[" + i + "]/div/span/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div/div[1]/div[1]/a/span[1]/span[2]/span[2]";
						WebElement searchPriceResult = chromeDriver.findElement(By.xpath(priceXpath));
						searchPagePrice = searchPriceResult.getText();
						String searchPageAnchorXpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[" + i + "]/div/span/div/div/div[2]/div[2]/div/div/div[1]/h2/a";
						productPageUrl = chromeDriver.findElement(By.xpath(searchPageAnchorXpath)).getAttribute("href");
						 searchResult.click();
						break;
					}
					Thread.sleep(100);
			}
		}
		
		ChromeOptions opt = new ChromeOptions();
	    opt.addArguments("headless");
	    WebDriver chromeDriver1 = new ChromeDriver(opt);
	    chromeDriver1.manage().timeouts();
		chromeDriver1.get(productPageUrl);
		String productXpath = "//span[@id=\"priceblock_ourprice\"]";
		String productPagePrice = chromeDriver1.findElement(By.xpath(productXpath)).getText().substring(1,7);
		System.out.println();
		
		System.out.println( "Search Page Price = " + searchPagePrice);
		System.out.println();
		System.out.println( "Product Page Price = " + productPagePrice);
		System.out.println();
		
		if( searchPagePrice.equals(productPagePrice)) {
			System.out.println("Successfully Pass");
		}else {
			System.out.println("Error");
		}
		
		System.out.println();
		
		String comparisionString = "";
		for(int i=2; i<25; i++) { 
			String xPath = "//*[@id=\"HLCXComparisonTable\"]/tbody/tr[" + i + "]/th/span";
			if( chromeDriver1.findElements(By.xpath(xPath)).size() > 0 ) {
					WebElement weightResult = chromeDriver1.findElement(By.xpath(xPath));
					comparisionString = weightResult.getText();
					if(comparisionString.equals("Capacity")) {
						System.out.print("Capacity =  ");
						String capacityXpath = "//*[@id=\"HLCXComparisonTable\"]/tbody/tr[" + i + "]/td[1]/span";
						System.out.println(chromeDriver1.findElement(By.xpath(capacityXpath)).getText());
						System.out.println();
					}
					if(comparisionString.equals("Item Weight")) {
						String weights = "";
						System.out.print("weights of all the Items from Comparision Table  -  ");
						for(int j=1; j<=4; j++) {
							String weightXpath = "//*[@id=\"HLCXComparisonTable\"]/tbody/tr[" + i + "]/td[" + j + "]/span";
							if(chromeDriver1.findElements(By.xpath(weightXpath)).size() > 0) {
								weights = chromeDriver1.findElement(By.xpath(weightXpath)).getText();
								System.out.print( weights + ",  ");
							}
						}
						break;
					}
					Thread.sleep(200);
			}
		}
		System.out.println();
	}
	

}
