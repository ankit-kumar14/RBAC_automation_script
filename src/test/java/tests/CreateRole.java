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

public class CreateRole extends BaseTest{
    private String email="jamescop@knol-power.nl";
    private String password="Vcomply@1234";
    private String roleName = "Admin_RBAC_role2";
    private By emailAddressField = By.xpath("//input[@formcontrolname='email']");
    private By passwordField = By.xpath("//input[@formcontrolname='password']");
    private By loginButton = By.xpath("//button[contains(text(),'SIGN IN')]");

    // Script for organization module 'Creating a new power user role and assigning a role and group'
    private By organization_module = By.xpath("//*[@id='organizationMenu']");
    private By ClickRole = By.xpath("//a[contains(text(), ' Roles ')]");
    private By CreateRoleButton = By.xpath("//button[contains(text(),'+ CREATE A ROLE')]");
    private By roleNameField = By.xpath("//input[@formcontrolname='roleName']");
    private By LicenseType = By.xpath("//div[contains(text(), ' POWER USERS')]");
    private By SelectRoleGroupName = By.xpath("//span[contains(text(), 'Select users and groups for this role')]");
    private By SelectGroupFromList = By.xpath("//div[contains(text(), 'Automation role ')]");
    private By SelectRoleFromList = By.xpath("//div[contains(text(), 'Isabella')]");
    private By NextButton = By.xpath("//button[contains(text(), 'NEXT')]");
    private By CreateButton = By.xpath("//button[contains(text(), 'create')]");


    @BeforeMethod
    public void setupTests() {
        super.setup();
        driver.navigate().to(baseURL+"/signin");
        //driver.navigate().to(organizationURL+"/manage-users");
    }
    @Test(description="Test:Login Test With Correct Details")
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
        wait.until(ExpectedConditions.elementToBeClickable(ClickRole));
        driver.findElement(ClickRole).click();
        wait.until(ExpectedConditions.elementToBeClickable(CreateRoleButton));
        driver.findElement(CreateRoleButton).click();
        driver.findElement(roleNameField).sendKeys(roleName);
        Thread.sleep(2000);
        driver.findElement(LicenseType).click();
        Thread.sleep(2000);
        driver.findElement(SelectRoleGroupName).click();
        Thread.sleep(2000);
        driver.findElement(SelectGroupFromList).click();
        driver.findElement(SelectRoleFromList).click();
        driver.findElement(NextButton).click();
        driver.findElement(CreateButton).click();
    }


    @AfterMethod
    public void clearTests() {
        // driver.quit();

    }
}
