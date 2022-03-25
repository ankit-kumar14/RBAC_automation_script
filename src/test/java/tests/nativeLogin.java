package tests;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

import java.sql.SQLOutput;

public class nativeLogin extends BaseTest{
    //private By emailAddressField = By.xpath("//input[contains(text(),'Enter your work email address')]");
    private String email="esha@getnada.com";
    private String password="Vcomply@123";
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

    @Test( priority=1 , description = "Test:Login Test With Correct Details")
    public void loginWithBlankEmailidPassword() throws InterruptedException {
        super.setup();
        driver.navigate().to(baseURL+"/signin");
        WebDriverWait wait=new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(emailAddressField));
        driver.findElement(emailAddressField).clear();
        driver.findElement(emailAddressField).sendKeys(email);

        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(organization_module));
        String CurrentUrl=driver.getCurrentUrl();
        if(!CurrentUrl.contains("compliance_dashboard")){
            Assert.fail("Did not landed on correct page");
        }
        else{
            System.out.println("Landed on correct page");
        }
    }

    @Test( priority=1 , description = "Test:Login Test With Correct Details")
    public void loginWithCorrectDetails() throws InterruptedException {
        super.setup();
        driver.navigate().to(baseURL+"/signin");
        WebDriverWait wait=new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(emailAddressField));
        driver.findElement(emailAddressField).clear();
        driver.findElement(emailAddressField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(organization_module));
        String CurrentUrl=driver.getCurrentUrl();
        if(!CurrentUrl.contains("compliance_dashboard")){
            Assert.fail("Did not landed on correct page");
        }
        else{
            System.out.println("Landed on correct page");
        }
    }

    @Test(priority = 2)
    public void logthrough() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(organization_module));
        driver.findElement(organization_module).click();

    }



    @AfterMethod
    public void clearTests() {
        //driver.close();

    }
}
