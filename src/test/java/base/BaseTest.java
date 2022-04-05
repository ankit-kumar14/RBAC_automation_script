package base;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.File;
import java.io.FileInputStream;


public class BaseTest {
    public WebDriver driver;
    public String baseURL;
    private By emailAddressField = By.xpath("//input[@formcontrolname='email']");
    private By passwordField = By.xpath("//input[@formcontrolname='password']");
    private By loginButton = By.xpath("//button[contains(text(),'SIGN IN')]");
    private By organization_module = By.xpath("//*[@id='organizationMenu']");

    public void setup() throws Exception{

        File src = new File("C:\\Users\\VComply\\IdeaProjects\\RBAC_automation_script\\TestData.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fis);
        XSSFSheet BaseSetup_Sheet = xsf.getSheetAt(0);

        //Data Fetched from BASE SETUP Excel Sheet
        String Runningserver = BaseSetup_Sheet.getRow(3).getCell(1).getStringCellValue();
        String Admin_Email_Address = BaseSetup_Sheet.getRow(8).getCell(1).getStringCellValue();
        String Admin_Password = BaseSetup_Sheet.getRow(9).getCell(1).getStringCellValue();
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

        // Login with Admin Email id and password

        WebDriverWait wait=new WebDriverWait(driver, 30);
        driver.navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(emailAddressField));
        driver.findElement(emailAddressField).clear();
        driver.findElement(emailAddressField).sendKeys(Admin_Email_Address);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(Admin_Password);
        try
        {
            driver.findElement(loginButton).click();
            System.out.println("User can log in using userid and password");

        }catch(Exception e)
        {
            Assert.fail("Log in button is not working");
        }
        wait.until(ExpectedConditions.elementToBeClickable(organization_module));
        String CurrentUrl=driver.getCurrentUrl();
        if(!CurrentUrl.contains("compliance_dashboard")){
            Assert.fail("Did not landed on correct page");
        }
        else{
            System.out.println("Landed on correct page");
        }
    }

}

