package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {
    public WebDriver driver;
    public String baseURL;
    public String organizationURL;




    public void setup() {
        baseURL="https://app.v-comply.com";
        //organizationURL = "https://app.v-comply.com/organization/#";
        System.setProperty("webdriver.chrome.driver","resources/chromedriver99.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        options.addArguments("--start-maximized");
        options.addArguments("--lang=en_US");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

}

