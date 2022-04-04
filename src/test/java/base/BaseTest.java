package base;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

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




    public void setup() throws Exception{

        File src = new File("C:\\Users\\VComply\\IdeaProjects\\RBAC_automation_script\\TestData.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fis);
        XSSFSheet BaseSetup_Sheet = xsf.getSheetAt(0);

        //Data Fetched from BASE SETUP Excel Sheet
        String Runningserver = BaseSetup_Sheet.getRow(3).getCell(1).getStringCellValue();
        xsf.close();

        baseURL="https://" +Runningserver+ ".v-comply.com";
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

