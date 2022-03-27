package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class BaseTest {
    public WebDriver driver;
    public String baseURL;
    public String organizationURL;
    public String production_server = "app";
    public String beta_server = "beta";
    public String dev_server = "dev";




    public void setup() {
        baseURL="https://" +production_server+ ".v-comply.com";
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

