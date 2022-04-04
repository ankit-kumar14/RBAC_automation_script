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
    public void setupTests() throws Exception{
        super.setup();
        driver.navigate().to(baseURL+"/signin");
        //driver.navigate().to(organizationURL+"/manage-users");
    }
    @Test(description="Test:Testing import users functionality")
    public void ImportUser() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(emailAddressField));
        driver.findElement(emailAddressField).clear();
        driver.findElement(emailAddressField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(organization_module));
        driver.findElement(organization_module).click();
        wait.until(ExpectedConditions.elementToBeClickable(ImportUser));
        driver.findElement(ImportUser).click();
        Thread.sleep(2000);
        driver.findElement(DownloadTemplate).click();
        Thread.sleep(3000);
        WebElement upload_file = driver.findElement(BrowseTemplate);
        upload_file.sendKeys("C:\\Users\\VComply\\Downloads\\VComply - Add Multiple Users - 2022-03-28.xls");
    }


    @AfterMethod
    public void clearTests() {
        driver.quit();

    }
}
