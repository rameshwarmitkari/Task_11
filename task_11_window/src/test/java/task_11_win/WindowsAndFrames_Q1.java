package task_11_win;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsAndFrames_Q1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		Set<String> windows = driver.getWindowHandles();
		List<String> list = new ArrayList(windows);

		String child = list.get(1);
		driver.switchTo().window(child);

		String str = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();

		String str1 = "New Window";

		if (str1.equals(str)) {
			System.out.println("new windo text is present");
			driver.close();
		}

		String parent = list.get(0);

		driver.switchTo().window(parent);

		String str2 = "Opening a new window";
		String str3 = driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();

		if (str3.equals(str2)) {
			System.out.println("original window is active");

		}
		driver.quit();

	}

}
