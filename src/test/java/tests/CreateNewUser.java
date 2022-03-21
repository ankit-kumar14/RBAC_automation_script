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

public class CreateNewUser extends BaseTest{
    //private By emailAddressField = By.xpath("//input[contains(text(),'Enter your work email address')]");
    private String email="jamescop@knol-power.nl";
    private String password="Vcomply@1234";
    private String NewUserName = "Akash patil";
    private String NewUserEmailaddress = "patil_akash@knol-power.nl";
    private By emailAddressField = By.xpath("//input[@formcontrolname='email']");
    //private By passwordField = By.xpath("//input[contains(text(),'Enter a password')]");
    private By passwordField = By.xpath("//input[@formcontrolname='password']");
    private By loginButton = By.xpath("//button[contains(text(),'SIGN IN')]");

    // Script for organization module 'Adding user_name , email address , assigning role and group'

    private By organization_module = By.xpath("//*[@id='organizationMenu']");
    private By add_a_user_button = By.xpath("//button[contains(text(),'+ ADD A USER')]");
    private By UserNameField = By.xpath("//input[@formcontrolname='userName']");
    private By EmailaddressField = By.xpath("//input[@formcontrolname='userEmail']");
    private By AssignARole = By.xpath("//span[contains(text(), 'Assign a role for this user')]");
    private By AssignAdminRole = By.xpath("//div[contains(text(), 'Admin')]");
    private By AssignManagerRole = By.xpath("//div[contains(text(), 'Manager')]");
    private By ClickNextButton = By.xpath("//button[contains(text(), 'NEXT')]");
    private By SelectGroupName = By.xpath("//span[contains(text(), 'Select groups')]");
    private By SelectingGroup1 = By.xpath("//div[contains(text(), 'Automation role ')]");
    private By SelectingGroup2 = By.xpath("//div[contains(text(), 'Admin system roles ')]");
    private By AddAUserButton = By.xpath("//button[contains(text(), 'Add')]");



    @BeforeMethod
    public void setupTests() {
        super.setup();
        driver.navigate().to(baseURL+"/signin");
        //driver.navigate().to(organizationURL+"/manage-users");
    }
    @Test(description="Test: Testing create a new user functionality")
    public void loginWithCorrectDetails() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(emailAddressField));
        driver.findElement(emailAddressField).clear();
        driver.findElement(emailAddressField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(organization_module));
        driver.findElement(organization_module).click();
        wait.until(ExpectedConditions.elementToBeClickable(add_a_user_button));
        driver.findElement(add_a_user_button).click();
        Thread.sleep(3000);
        driver.findElement(UserNameField).sendKeys(NewUserName);
        driver.findElement(EmailaddressField).sendKeys(NewUserEmailaddress);
        driver.findElement(AssignARole).click();
        wait.until(ExpectedConditions.elementToBeClickable(AssignAdminRole));
        driver.findElement(AssignAdminRole).click();
        driver.findElement(AssignManagerRole).click();
        driver.findElement(ClickNextButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(SelectGroupName));
        driver.findElement(SelectGroupName).click();
        wait.until(ExpectedConditions.elementToBeClickable(SelectingGroup1));
        driver.findElement(SelectingGroup1).click();
        driver.findElement(SelectingGroup2).click();
        driver.findElement(ClickNextButton).click();
        Thread.sleep(2000);
        driver.findElement(AddAUserButton).click();
    }


    @AfterMethod
    public void clearTests() {
        // driver.quit();

    }
}
