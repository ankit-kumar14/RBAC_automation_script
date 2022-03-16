package tests;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

import java.sql.SQLOutput;

public class CreateRisk extends BaseTest{
    //private By emailAddressField = By.xpath("//input[contains(text(),'Enter your work email address')]");
    private String email="jamescop@knol-power.nl";
    private String password="Vcomply@1234";
    private String RiskName = "Automated risk";
    private String Rcname = "Cloud";
    private String DescriptionDetails = "Here is the description of the risk create field";
    private By emailAddressField = By.xpath("//input[@formcontrolname='email']");
    //private By passwordField = By.xpath("//input[contains(text(),'Enter a password')]");
    private By passwordField = By.xpath("//input[@formcontrolname='password']");
    private By loginButton = By.xpath("//button[contains(text(),'SIGN IN')]");
    // Script for organization module 'Adding user name , email address , assigning role and group'
    private By RiskModule = By.xpath("//*[@id='riskMenu']");
    private By RiskWorkflowEngine = By.xpath("//button[contains(text(),'+') and @class='top']");
    private By RiskNameField = By.xpath("//input[@placeholder = 'Add a risk name']");
    private By DescriptionData = By.xpath("//div[@id ='mGzoBcdvcaMNgr4mS1Gs4']");
    private By RcList = By.xpath("//input[@placeholder = 'Select Responsibility Center(s)']"); //RESPONSIBILITY CENTER
    private By SearchRc = By.xpath("//input[@placeholder = 'Search Responsibility Center']");
    private By SelectRcFromList = By.xpath("(//li[contains(text(),'Cloud')])[1]");
    private By NextButton = By.xpath("//button[contains(text(),'Next')]");
    private By EditRiskOwner = By.xpath("(//button[contains(text(),' Edit')])[4]");
    private By SelectRiskOwner1 = By.xpath("//span[contains(text(),'Larson') and @class='name']");
    private By SelectRiskOwner2 = By.xpath("//span[contains(text(),'Sophia') and @class='name']");
    private By SelectRiskOwner3 = By.xpath("//span[contains(text(),'Isabella') and @class='name']");
    private By SelectRiskOwner4 = By.xpath("//span[contains(text(),'Olivia') and @class='name']");
    private By OpeningRiskCategory = By.xpath("//input[@placeholder='Select Risk Category']");
    private By SelectingOtherRiskCategory = By.xpath("//span[@class='counter' and contains(text(),'4')]");
    private By SelectingRiskCategory = By.xpath("//span[contains(text(),' Residual details')]");
    private By AddingRiskOverseerField = By.xpath("//span[contains(text(),'Risk Overseer')]");
    private By OpeningOverseerList = By.xpath("//input[@placeholder = 'Select Risk Overseer(s)']");
    private By SelectOverseer1 = By.xpath("//span[contains(text(),'Jason') and @class='name']");
    private By SelectOverseer2 = By.xpath("//span[contains(text(),'Ava') and @class='name']");
    private By SelectOverseer3 = By.xpath("//span[contains(text(),'Michael') and @class='name']");
    private By AddingRiskMitigationPriorityField = By.xpath("//span[contains(text(),'Risk Mitigation Priority')]");
    private By MitigationPriorityList = By.xpath("//input[@placeholder = 'Select a mitigation priority']");
    private By SelectingRiskMitigationPriority = By.xpath("//div[@class='list'] //span[@class='value' and contains(text(),'HIGH')]");
    private By AddButton = By.xpath("//button[contains(text(),'Add') and @class='submit']");





    @BeforeMethod
    public void setupTests() {
        super.setup();
        driver.navigate().to(baseURL+"/signin");
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
        wait.until(ExpectedConditions.elementToBeClickable(RiskModule));
        driver.findElement(RiskModule).click();
        wait.until(ExpectedConditions.elementToBeClickable(RiskWorkflowEngine));
        driver.findElement(RiskWorkflowEngine).click();
        wait.until(ExpectedConditions.elementToBeClickable(RiskNameField));
        Thread.sleep(10000);
        driver.findElement(RiskNameField).sendKeys(RiskName);
        Thread.sleep(3000);
        //driver.findElement(DescriptionData).sendKeys(DescriptionDetails);
        driver.findElement(RcList).click();
        Thread.sleep(2000);
        driver.findElement(SearchRc).click();
        Thread.sleep(2000);
        driver.findElement(SearchRc).sendKeys(Rcname);
        driver.findElement(SearchRc).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(SelectRcFromList).click();
        driver.findElement(NextButton).click();
        Thread.sleep(2000);
        driver.findElement(EditRiskOwner).click();
        Thread.sleep(2000);
        driver.findElement(SelectRiskOwner1).click();
        Thread.sleep(500);
        driver.findElement(SelectRiskOwner2).click();
        Thread.sleep(500);
        driver.findElement(SelectRiskOwner3).click();
        Thread.sleep(500);
        driver.findElement(SelectRiskOwner4).click();
        Thread.sleep(500);
        driver.findElement(NextButton).click();
        Thread.sleep(6000);
        driver.findElement(OpeningRiskCategory).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(SelectingOtherRiskCategory));
        driver.findElement(SelectingOtherRiskCategory).click();
        Thread.sleep(2000);
        driver.findElement(SelectingRiskCategory).click();
        Thread.sleep(2000);
        driver.findElement(NextButton).click();
        Thread.sleep(2000);
        driver.findElement(AddingRiskOverseerField).click();
        Thread.sleep(500);
        driver.findElement(OpeningOverseerList).click();
        Thread.sleep(500);
        driver.findElement(SelectOverseer1).click();
        Thread.sleep(500);
        driver.findElement(SelectOverseer2).click();
        Thread.sleep(500);
        driver.findElement(SelectOverseer3).click();
        Thread.sleep(500);
        driver.findElement(NextButton).click();
        Thread.sleep(1000);
        driver.findElement(AddingRiskMitigationPriorityField).click();
        Thread.sleep(1000);
        //driver.findElement(MitigationPriorityList).click();
        //Thread.sleep(1000);
        //driver.findElement(SelectingRiskMitigationPriority).click();
        driver.findElement(AddButton).click();
        Thread.sleep(5000);
        String CurrentUrl=driver.getCurrentUrl();
        if(!CurrentUrl.contains("risk_dashboard?module=risk")){
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
