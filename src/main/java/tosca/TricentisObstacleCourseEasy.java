package tosca;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;
import org.openqa.selenium.By;


public class TricentisObstacleCourseEasy extends TestBase {

	@Test
	public void idsAreNotEverything22505() {
		open("22505");
		waitForVisibility(By.cssSelector(".btn.theme-btn-color.btn-lg.animated.fadeInDown.delay-3.btn-big")).click();
		assertTrue(successMessage().isDisplayed());
	}

	@Test
	public void twins12952() {
		open("12952");
		waitForVisibility(By.xpath("//*[@id='thisoneistheright']")).findElement(By.id("id")).click();
		assertTrue(successMessage().isDisplayed());
	}

	@Test
	public void waitAMoment33678() {
		open("33678");
		waitForVisibility(By.id("one")).click();
		waitUntilClickable(By.id("two")).click();
		assertTrue(successMessage().isDisplayed());
	}

	@Test
	public void extractingText81012() {
		open("81012");
		String alertText = waitForVisibility(By.id("alerttext")).getAttribute("innerText");
		String regEx = "(\\d+)(\\.*)(\\d*)";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(alertText);
		
		while (m.find()) {
			waitForVisibility(By.id("totalamountText")).sendKeys(m.group());
		}
		assertTrue(successMessage().isDisplayed());
	}

	@Test
	public void popupWindows51130() {
		open("51130");
		String winHandleBefore = driver.getWindowHandle();
		waitForVisibility(By.id("button")).click();
		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(winHandleBefore);
		assertTrue(successMessage().isDisplayed());
	}

	@Test
	public void tomorrow19875() {
		open("19875");
		Date tomorrowDate = new Date();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

		calendar.setTime(tomorrowDate);
		calendar.add(Calendar.DATE, 1);
		tomorrowDate = calendar.getTime();

		waitForVisibility(By.id("datefield")).sendKeys(dateFormat.format(tomorrowDate));
		assertTrue(successMessage().isDisplayed());
	}

	@Test
	public void meetingScheduler41037() {
		open("41037");
		String availability = waitForVisibility(By.xpath("//*[@id='timeTable']/tbody/tr[3]/td[5]")).getText();
		waitForVisibility(By.id("resulttext")).sendKeys(availability);
		assertTrue(successMessage().isDisplayed());
	}

	@Test
	public void escape41041() {
		open("41041");
		waitForVisibility(By.id("resulttext")).sendKeys("{Click}");
		assertTrue(successMessage().isDisplayed());
	}

	@Test
	public void hiddenElement66666() {
		open("66666");
		waitForVisibility(By.id("clickthis")).click();
		assertTrue(successMessage().isDisplayed());
	}
	
	@Test
	public void triStateCheckbox12631() {
		open("12631");
		String topBoxColor;
		String bottomBoxColor;
		int i = 0;
		int j = 2;
		do {
			topBoxColor = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/table/tbody/tr[1]/td["+j+"]/span[@id='date"+(i+1)+"']")).getCssValue("background-color");
			bottomBoxColor = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/table/tbody/tr[2]/td["+j+"]/span[@id='mydate"+(i+1)+"']")).getCssValue("background-color");

			if(!topBoxColor.equals(bottomBoxColor)) {
				driver.findElement(By.xpath("//*[@id='mydate"+(i+1)+"']")).click();
				bottomBoxColor = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/table/tbody/tr[2]/td["+j+"]/span[@id='mydate"+(i+1)+"']")).getCssValue("background-color");
				if(!topBoxColor.equals(bottomBoxColor)) {
					driver.findElement(By.xpath("//*[@id='mydate"+(i+1)+"']")).click();
					}  
			} i++; j++;
		} while ( i < driver.findElements(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/table/tbody/tr[2]/td/span")).size());
		waitForVisibility(By.id("check")).click();
		assertTrue(successMessage().isDisplayed());
	}
}
