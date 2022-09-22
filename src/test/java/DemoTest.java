import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
// Import DevTools
import ai.devtools.selenium.SmartDriver;

public class DemoTest
{
    @Test
    public void showIngest() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver chromeDriver = new ChromeDriver();
        try
        {
            SmartDriver driver = new SmartDriver(chromeDriver, "<<get your api key at dev-tools.ai>>");
            driver.get("https://github.com/login");

            Thread.sleep(1000);

            WebElement loginField = driver.findElement(By.xpath("//input[@id=\"login_field\"]"));
            loginField.sendKeys("my_username");

            Thread.sleep(1000);
        }
        finally
        {
            chromeDriver.quit();
        }
    }

    @Test
    public void showFindByAI() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver chromeDriver = new ChromeDriver();
        try
        {
            SmartDriver driver = new SmartDriver(chromeDriver, "<<get your api key at dev-tools.ai>>");
            driver.get("https://duckduckgo.com");

            Thread.sleep(1000);

            WebElement loginField = driver.findByAI("java_searchbox");
            loginField.sendKeys("Hello World!");

            Thread.sleep(1000);
        }
        finally
        {
            chromeDriver.quit();
        }
    }
}