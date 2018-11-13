package tosca;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.junit.Before;
import org.junit.After;
import java.util.concurrent.TimeUnit;

public class TestBase {
	
    protected WebDriver driver;
    protected WebDriverWait wait;
    String obstacleUrl = "https://obstaclecourse.tricentis.com/Obstacles/";

    @Before
	public void initializeBrowser() {
		System.setProperty("webdriver.chrome.driver","resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,  TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
    }

    public WebElement successMessage() {
        return driver.findElement(By.xpath("/html/body/div[5]/h2"));
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void open(String obstacleNumber) {
        driver.get(obstacleUrl + obstacleNumber);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}