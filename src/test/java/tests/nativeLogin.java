package tests;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

import java.sql.SQLOutput;

public class nativeLogin extends BaseTest{
    //private By emailAddressField = By.xpath("//input[contains(text(),'Enter your work email address')]");

    public String production_server = "app";
    public String beta_server = "beta";
    private String email="esha@getnada.com";
    private String password="Vcomply@123";
    private String emailBlank="        ";
    private String passwordBlank="      ";
    private By emailAddressField = By.xpath("//input[@formcontrolname='email']");
    //private By passwordField = By.xpath("//input[contains(text(),'Enter a password')]");
    private By passwordField = By.xpath("//input[@formcontrolname='password']");
    private By loginButton = By.xpath("//button[contains(text(),'SIGN IN')]");
    private By organization_module = By.xpath("//*[@id='organizationMenu']");


    @BeforeMethod
    public void setupTests() {
        //super.setup();
        //driver.navigate().to(baseURL+"/signin");
        //driver.navigate().to(organizationURL+"/manage-users");
    }

    @Test( priority=1 , description = "Test:Login Test With Blank Userid and passwords")
    public void loginWithBlankEmailidPassword() throws InterruptedException {
        super.setup();
        driver.navigate().to("https://" +dev_server+ ".v-comply.com"+"/signin");
        WebDriverWait wait=new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(emailAddressField));
        driver.findElement(emailAddressField).clear();
        driver.findElement(emailAddressField).sendKeys(emailBlank);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(passwordBlank);
        try
        {
            driver.findElement(loginButton).click();
            System.out.println("User can log in using userid and password");
            Assert.fail("User can log in using userid and password");

        }catch(Exception e)
        {
           System.out.println("Pass: Login button did not found with blank details");
        }

    }

    @Test( priority=2 , description = "Test:Login Test With Correct Details")
    public void loginWithCorrectDetails() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, 30);
        driver.navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(emailAddressField));
        driver.findElement(emailAddressField).clear();
        driver.findElement(emailAddressField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
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

    @Test( priority=3 , description = "Test:Login Test With Blank Userid and passwords")
    public void loginWithBlankEmailidPassword_inBETA() throws InterruptedException {
        driver.navigate().to("https://" +beta_server+ ".v-comply.com"+"/signin");
        WebDriverWait wait=new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(emailAddressField));
        driver.findElement(emailAddressField).clear();
        driver.findElement(emailAddressField).sendKeys(emailBlank);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(passwordBlank);
        try
        {
            driver.findElement(loginButton).click();
            System.out.println("User can log in using userid and password");
            Assert.fail("User can log in using userid and password");

        }catch(Exception e)
        {
            System.out.println("Pass: Login button did not found with blank details");
        }

    }

    @Test( priority=4 , description = "Test:Login Test With Correct Details")
    public void loginWithCorrectDetails_inBETA() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, 30);
        driver.navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(emailAddressField));
        driver.findElement(emailAddressField).clear();
        driver.findElement(emailAddressField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
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

    @Test( priority=5 , description = "Test:Login Test With Blank Userid and passwords")
    public void loginWithBlankEmailidPassword_inAPP() throws InterruptedException {
        driver.navigate().to("https://" +production_server+ ".v-comply.com"+"/signin");
        WebDriverWait wait=new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(emailAddressField));
        driver.findElement(emailAddressField).clear();
        driver.findElement(emailAddressField).sendKeys(emailBlank);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(passwordBlank);
        try
        {
            driver.findElement(loginButton).click();
            System.out.println("User can log in using userid and password");
            Assert.fail("User can log in using userid and password");

        }catch(Exception e)
        {
            System.out.println("Pass: Login button did not found with blank details");
        }

    }

    @Test( priority=6 , description = "Test:Login Test With Correct Details")
    public void loginWithCorrectDetails_inAPP() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, 30);
        driver.navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(emailAddressField));
        driver.findElement(emailAddressField).clear();
        driver.findElement(emailAddressField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
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



    @AfterMethod
    public void clearTests() {
        //driver.close();

    }
}
