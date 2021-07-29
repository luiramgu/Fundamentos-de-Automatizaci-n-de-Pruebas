import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Main {
    public static void main(String[] args){
        String pathToDriver = Main.class.getResource("/chromedriver").getPath(); //MacOS, Linux
        //String pathToDriver = Main.class.getResource("/chromedriver.exe").getPath(); //Windows
        System.setProperty("webdriver.chrome.driver", pathToDriver);

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/index.php?route=account/login");

        WebElement emailElement = driver.findElement(By.name("email"));
        emailElement.sendKeys("Hola@test.com");

        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("asdfg");

        //WebElement loginButton = driver.findElement(By.xpath("//input[@type = 'submit']"));
        //loginButton.click();

        driver.findElement(By.xpath("//input[@type = 'submit']")).click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertTrue(alertMessage.isDisplayed());

        driver.close();
        driver.quit();
    }
}
