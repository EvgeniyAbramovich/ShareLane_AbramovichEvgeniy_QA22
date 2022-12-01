import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ShareLaneTests {

    WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void firstTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();
        zipCodeInput = driver.findElement(By.name("zip_code"));
        Assert.assertFalse(zipCodeInput.isDisplayed());

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        Assert.assertTrue(firstNameInput.isDisplayed());

    }

    @Test
    public void secondTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("fffffff");
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[class=error_message]"));
        Assert.assertTrue(errorMessage.isDisplayed());

    }

    @Test
    public void thirdTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();
        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Evgeniy");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Abramovich");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("tinkerbox@yandex.by");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("1111");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("1111");
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        registerButton.click();

        WebElement confirmationMessage = driver.findElement(By.cssSelector("[class=confirmation_message]"));
        Assert.assertTrue(confirmationMessage.isDisplayed());

    }

    @Test
    public void fourthTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();
        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Evgeniy");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Abramovich");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("tinkerbox@yandex.by");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("1111");
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        registerButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[class=error_message]"));
        Assert.assertTrue(errorMessage.isDisplayed());

    }
}

