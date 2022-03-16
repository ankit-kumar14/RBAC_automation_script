package tests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import base.BaseTest;

import java.sql.SQLOutput;

public class AdminCreateRC extends BaseTest{
    private String email="charles@knol-power.nl";
    private String password="Vcomply@1234";
    private By emailAddressField = By.xpath("//input[@formcontrolname='email']");
    private By passwordField = By.xpath("//input[@formcontrolname='password']");
    private By loginButton = By.xpath("//button[contains(text(),'SIGN IN')]");

    // Script for organization module 'Creating new Responsibility Center' from 'Admin's account'

    private By organization_module = By.xpath("//*[@id='organizationMenu']");
    private By ResponsibilityCenter = By.xpath("//a[contains(text(), ' Responsibility Centers ')]");
    private By CreateRcButton = By.xpath("//button[contains(text(),'+ ADD A RESPONSIBILITY CENTER')]");
    private String Rcname = "SeleniumNg"; //RC name
    private By RcNameFeild = By.xpath("//input[@formcontrolname='rcName']"); //RESPONSIBILITY CENTER NAME
    private By RcparentList = By.xpath("//span[contains(text(),'Select parent Responsibility Center')]"); //SELECT A PARENT RESPONSIBILITY CENTER (LEAVE BLANK IF NOT APPLICABLE)
    private By SelectingRcParent = By.xpath("(//div[contains(text(),'Root')])[2]"); // Selecting parent from list of responsibility
    private By NextButton = By.xpath("//button[contains(text(),'NEXT')]"); // Next button for saving the parent RC
    private String LocationOfRc ="Power users location";
    private By LocationOfRcInputField = By.xpath("//input[@formcontrolname= 'rcLocation']"); //LOCATION OF THIS RESPONSIBILITY CENTER
    private By SelectOwnersEditButton = By.xpath("(//button[contains(text(),'EDIT')])[2]"); //SPECIFY WHO CAN VIEW REPORTS AND DASHBOARDS FOR THIS RESPONSIBILITY CENTER
    private By Owner1 = By.xpath("//span[@class='value']//div[contains(text(),'Ubner')]");
    private By Owner2 = By.xpath("//div[contains(text(),'Isabella')]");
    private By Owner3 = By.xpath("//div[contains(text(),'Emma')]");
    private By Owner4 = By.xpath("//div[contains(text(),'William')]");
    private By RcType = By.xpath("//input[@readonly and @placeholder='Select']"); //SPECIFY WHO CAN TAG RESPONSIBILITIES TO THIS RESPONSIBILITY CENTER
    private By SelectingAllPowerUers = By.xpath("(//input[@class=\"pointer-none\"])[1]"); //Selecting all power users type
    //private String Description ="A group, in mathematics,with Évariste Galois in the 1830s.";
    //private By AddDescriptionField = By.xpath("//div[@placeholder='Add description' and @id='mPcY8BIzOVIGNI7CJ83bS']"); //DESCRIPTION FOR THIS RESPONSIBILITY CENTER
    private By SaveButton = By.xpath("//button[contains(text(),'SAVE')]");

    private By ViewRcDetails = By.xpath("(//button[@class='view-details-btn vx-fs-11 vx-fw-500 vx-tt-uppercase vx-p-0 vx-pl-2 vx-pr-2 vx-m-0 vx-d-flex vx-align-center vx-lh-5'])[1]");
    private By ClickingThreedots = By.xpath("//button[@class='action-btn vx-fs-16 vx-d-inline-flex vx-align-center']");
    private By DeleteRC = By.xpath("//button[contains(text(),' delete')]");
    private By DeleteYes = By.xpath("//button[contains(text(),'Yes')]");
    private By SearchBar = By.xpath("//input[@placeholder = 'Type here & press enter to search']");
    private String search = "SeleniumNg";



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
        Thread.sleep(1500);
        driver.findElement(ResponsibilityCenter).click();
        Thread.sleep(1500);
        driver.findElement(CreateRcButton).click();
        Thread.sleep(1000);
        driver.findElement(RcNameFeild).sendKeys(Rcname);
        driver.findElement(RcparentList).click();
        Thread.sleep(3000);
        driver.findElement(SelectingRcParent).click();
        Thread.sleep(1000);
        driver.findElement(NextButton).click();
        driver.findElement(LocationOfRcInputField).sendKeys(LocationOfRc);
        driver.findElement(SelectOwnersEditButton).click();
        Thread.sleep(4000);
        driver.findElement(Owner1).click();
        Thread.sleep(500);
        driver.findElement(Owner2).click();
        Thread.sleep(500);
        driver.findElement(Owner3).click();
        Thread.sleep(500);
        driver.findElement(Owner4).click();
        Thread.sleep(500);
        driver.findElement(NextButton).click();
        driver.findElement(RcType).click();
        Thread.sleep(500);
        driver.findElement(SelectingAllPowerUers).click();
        Thread.sleep(1500);
        //driver.findElement(AddDescriptionField).click();
        //Thread.sleep(1000);
        //driver.findElement(AddDescriptionField).sendKeys(Description);
        driver.findElement(SaveButton).click();
        Thread.sleep(5000);
        String CurrentUrl=driver.getCurrentUrl();
        if(!CurrentUrl.contains("manage-responsibility-centers")){
            Assert.fail("Did not landed on correct page");
        }
        else{
            System.out.println("Landed on correct page");
        }

        //Delete Rc functionality

        driver.findElement(SearchBar).click();
        driver.findElement(SearchBar).sendKeys(search);
        Thread.sleep(1000);
        driver.findElement(SearchBar).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(ViewRcDetails).click();
        Thread.sleep(5000);
        driver.findElement(ClickingThreedots).click();
        Thread.sleep(2000);
        driver.findElement(DeleteRC).click();
        Thread.sleep(1000);
        driver.findElement(DeleteYes).click();
        Thread.sleep(5000);
        String AfterDeleteUrl=driver.getCurrentUrl();
        if(!AfterDeleteUrl.contains("manage-responsibility-centers")){
            Assert.fail("Did not landed on correct page");
        }
        else{
            System.out.println("Landed on correct page");
        }
    }

    @AfterMethod
    public void clearTests() {
        // driver.quit();
    }
}
