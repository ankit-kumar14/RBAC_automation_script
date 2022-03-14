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

public class Importusersscript extends BaseTest{
    private String email="jamescop@knol-power.nl";
    private String password="Vcomply@1234";
    private By emailAddressField = By.xpath("//input[@formcontrolname='email']");
    private By passwordField = By.xpath("//input[@formcontrolname='password']");
    private By loginButton = By.xpath("//button[contains(text(),'SIGN IN')]");

    // Script for organization module 'Adding user name , email address , assigning role and group'
    private By organization_module = By.xpath("//*[@id='organizationMenu']");
    private By ImportUser = By.xpath("//button[contains(text(),'+ IMPORT USERS')]");
    private By DownloadTemplate = By.xpath("//button[contains(text(),'DOWNLOAD TEMPLATE')]");
    private By BrowseTemplate = By.xpath("//button[contains(text(),'BROWSE')]");



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
        Thread.sleep(10000);
        driver.findElement(organization_module).click();
        Thread.sleep(5000);
        driver.findElement(ImportUser).click();
        Thread.sleep(2000);
        driver.findElement(DownloadTemplate).click();
        driver.findElement(BrowseTemplate).click();


    }


    @AfterMethod
    public void clearTests() {
        // driver.quit();

    }
}
