import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Basic1 {
	@Parameters({"URL"})
	@Test
	public void Sample(String url) {
		System.out.println("Approved");
		System.out.println("URL is:" +url);
	}
	@Test(groups={"Name"})
	public void Sample1() {
		System.out.println("good");
	}

}
