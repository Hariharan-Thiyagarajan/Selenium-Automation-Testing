import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Basic {
	@Test(dataProvider="getDemo")
	public void Practice(String username,String password) {
		System.out.println(username);
		System.out.println(password);
		}
	
	@DataProvider
	public Object[][] getDemo() {
		Object[][] data = new Object[1][2];
		data[0][0] = "Name1";
		data[0][1] = "Name2";
		return data;
	}
	@BeforeTest
	public void Second() {
		System.out.println("Bye");
	}

}
