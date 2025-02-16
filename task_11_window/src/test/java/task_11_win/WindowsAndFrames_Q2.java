package task_11_win;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsAndFrames_Q2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement top = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(top);

		List<WebElement> count = driver.findElements(By.xpath("//frame"));
		System.out.println(count.size());

		WebElement frameleft = driver.findElement(By.xpath("//frame[@name='frame-left']"));
		driver.switchTo().frame(frameleft);
		String str = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
		String left = "LEFT";
		if (left.equals(str)) {
			System.out.println("'LEFT' text is present on left frame");
		}

		driver.switchTo().parentFrame();

		WebElement frameMiddle = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(frameMiddle);
		String str1 = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]")).getText();
		String middle = "MIDDLE";
		if (middle.equals(str1)) {
			System.out.println("'MIDDLE' text is present on middle frame");
		}

		driver.switchTo().parentFrame();

		WebElement frameright = driver.findElement(By.xpath("//frame[@name='frame-right']"));
		driver.switchTo().frame(frameright);
		String str2 = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText();
		String right = "RIGHT";
		if (right.equals(str2)) {
			System.out.println("'RIGHT' text is present on right frame");
		}

		driver.switchTo().defaultContent();

		WebElement framebottom = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
		driver.switchTo().frame(framebottom);
		String str3 = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText();
		String bottom = "BOTTOM";
		if (bottom.equals(str3)) {
			System.out.println("'BOTTOM' text is present on bottom frame");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(top);

		String st = "Frames";

		if (driver.getTitle().equals(st)) {
			System.out.println("Frame title is- " + "Frames");
		} else {
			System.out.println("Frame title is blank--");
		}

	}

}
