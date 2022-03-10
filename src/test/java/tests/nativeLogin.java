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
    private String email="jamescop@knol-power.nl";
    private String password="Vcomply@1234";
    private By emailAddressField = By.xpath("//input[@formcontrolname='email']");
    //private By passwordField = By.xpath("//input[contains(text(),'Enter a password')]");
    private By passwordField = By.xpath("//input[@formcontrolname='password']");
    private By loginButton = By.xpath("//button[contains(text(),'SIGN IN')]");
    // Script for organization module 'Adding user name , email address , assigning role and group'
    private By organization_module = By.xpath("//*[@id='organizationMenu']");
    private By add_a_user_button = By.xpath("//button[contains(text(),'+ ADD A USER')]");
    private String NewUserName = "Lucas Zin";
    private String NewUserEmailaddress = "lucas1@knol-power.nl";
    private By UserNameField = By.xpath("//input[@formcontrolname='userName']");
    private By EmailaddressField = By.xpath("//input[@formcontrolname='userEmail']");


    @BeforeMethod
    public void setupTests() {
        super.setup();
        driver.navigate().to(baseURL+"/signin");
        //driver.navigate().to(organizationURL+"/manage-users");
    }
    @Test(description="Test:Login Test With Correct Details")
    public void loginWithCorrectDetails() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(emailAddressField).clear();
        driver.findElement(emailAddressField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        Thread.sleep(15000);
        driver.findElement(organization_module).click();
        Thread.sleep(7000);
        driver.findElement(add_a_user_button).click();
        Thread.sleep(3000);
        driver.findElement(UserNameField).sendKeys(NewUserName);
        driver.findElement(EmailaddressField).sendKeys(NewUserEmailaddress);
        driver.findElement(By.xpath("//span[contains(text(), 'Assign a role for this user')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(text(), 'Admin')]")).click();
        driver.findElement(By.xpath("//div[contains(text(), 'Manager')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'NEXT')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(), 'Select groups')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(text(), 'Automation role ')]")).click();
        driver.findElement(By.xpath("//div[contains(text(), 'Admin system roles ')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'NEXT')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(), 'Add')]")).click();
    }


    @AfterMethod
    public void clearTests() {
       // driver.quit();

    }
}
