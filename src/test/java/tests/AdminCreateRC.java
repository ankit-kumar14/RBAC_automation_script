package tests;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import base.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLOutput;

public class AdminCreateRC extends BaseTest{

    private By emailAddressField = By.xpath("//input[@formcontrolname='email']");
    private By passwordField = By.xpath("//input[@formcontrolname='password']");
    private By loginButton = By.xpath("//button[contains(text(),'SIGN IN')]");

    // Script for organization module 'Creating new Responsibility Center' from 'Admin's account'

    private By organization_module = By.xpath("//*[@id='organizationMenu']");
    private By ResponsibilityCenter = By.xpath("//a[contains(text(), ' Responsibility Centers ')]");
    private By CreateRcButton = By.xpath("//button[contains(text(),'+ ADD A RESPONSIBILITY CENTER')]");
    private By RcNameFeild = By.xpath("//input[@formcontrolname='rcName']"); //RESPONSIBILITY CENTER NAME
    private By RcparentList = By.xpath("//span[contains(text(),'Select parent Responsibility Center')]"); //SELECT A PARENT RESPONSIBILITY CENTER (LEAVE BLANK IF NOT APPLICABLE)
    private By SelectingRcParent = By.xpath("(//div[contains(text(),'Root')])[2]"); // Selecting parent from list of responsibility
    private By NextButton = By.xpath("//button[contains(text(),'NEXT')]"); // Next button for saving the parent RC
    private By LocationOfRcInputField = By.xpath("//input[@formcontrolname= 'rcLocation']"); //LOCATION OF THIS RESPONSIBILITY CENTER
    private By SelectOwnersEditButton = By.xpath("(//button[contains(text(),'EDIT')])[2]"); //SPECIFY WHO CAN VIEW REPORTS AND DASHBOARDS FOR THIS RESPONSIBILITY CENTER
    private By Owner1 = By.xpath("//span[@class='value']//div[contains(text(),'Ubner')]");
    private By Owner2 = By.xpath("//div[contains(text(),'Isabella')]");
    private By Owner3 = By.xpath("//div[contains(text(),'Emma')]");
    private By Owner4 = By.xpath("//div[contains(text(),'William')]");
    private By RcType = By.xpath("//input[@readonly and @placeholder='Select']"); //SPECIFY WHO CAN TAG RESPONSIBILITIES TO THIS RESPONSIBILITY CENTER
    private By SelectingAllPowerUers = By.xpath("(//input[@class=\"pointer-none\"])[1]"); //Selecting all power users type
    // private String Description ="A group, in mathematics,with Évariste Galois in the 1830s.";
    // private By AddDescriptionField = By.xpath("//div[@placeholder='Add description' and @id='mPcY8BIzOVIGNI7CJ83bS']"); //DESCRIPTION FOR THIS RESPONSIBILITY CENTER
    private By SaveButton = By.xpath("//button[contains(text(),'SAVE')]");

    private By ViewRcDetails = By.xpath("(//button[@class='view-details-btn vx-fs-11 vx-fw-500 vx-tt-uppercase vx-p-0 vx-pl-2 vx-pr-2 vx-m-0 vx-d-flex vx-align-center vx-lh-5'])[1]");
    private By ClickingThreeDots = By.xpath("//button[@class='action-btn vx-fs-16 vx-d-inline-flex vx-align-center']");
    private By DeleteRC = By.xpath("//button[contains(text(),' delete')]");
    private By DeleteYes = By.xpath("//button[contains(text(),'Yes')]");
    private By SearchBar = By.xpath("//input[@placeholder = 'Type here & press enter to search']");




    @BeforeMethod
    public void setupTests() throws Exception{
        super.setup();
    }
    @Test(description="Test:Testing create responsibility center using admins account")
    public void AdminCreateRC() throws Exception {

        File src = new File("C:\\Users\\VComply\\IdeaProjects\\RBAC_automation_script\\TestData.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fis);
        XSSFSheet BaseSetup_Sheet = xsf.getSheetAt(0);
        XSSFSheet Admin_Create_Rc_Sheet = xsf.getSheetAt(1);

        //Data Fetched from Admin_Create_RC Excel Sheet
        String Responsibility_Center_Name = Admin_Create_Rc_Sheet.getRow(2).getCell(1).getStringCellValue();
        String Location_Of_RC = Admin_Create_Rc_Sheet.getRow(3).getCell(1).getStringCellValue();

        xsf.close();

        //Test condition script starts from here

        WebDriverWait wait=new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(organization_module));
        driver.findElement(organization_module).click();
        wait.until(ExpectedConditions.elementToBeClickable(ResponsibilityCenter));
        driver.findElement(ResponsibilityCenter).click();
        wait.until(ExpectedConditions.elementToBeClickable(CreateRcButton));
        driver.findElement(CreateRcButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(RcparentList));
        driver.findElement(RcNameFeild).sendKeys(Responsibility_Center_Name);
        driver.findElement(RcparentList).click();
        wait.until(ExpectedConditions.elementToBeClickable(SelectingRcParent));
        driver.findElement(SelectingRcParent).click();
        Thread.sleep(1000);
        driver.findElement(NextButton).click();
        driver.findElement(LocationOfRcInputField).sendKeys(Location_Of_RC);
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
        driver.findElement(SelectingAllPowerUers).click();
        wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
        //driver.findElement(AddDescriptionField).click();
        //Thread.sleep(1000);
        //driver.findElement(AddDescriptionField).sendKeys(Description);
        driver.findElement(SaveButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(SearchBar));
        String CurrentUrl=driver.getCurrentUrl();
        if(!CurrentUrl.contains("manage-responsibility-centers")){
            Assert.fail("Did not landed on correct page");
        }
        else{
            System.out.println("Landed on correct page");
        }

        //Delete Rc functionality

        wait.until(ExpectedConditions.elementToBeClickable(organization_module));
        driver.findElement(SearchBar).click();
        driver.findElement(SearchBar).sendKeys(Responsibility_Center_Name);
        Thread.sleep(1000);
        driver.findElement(SearchBar).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(ViewRcDetails));
        driver.findElement(ViewRcDetails).click();
        wait.until(ExpectedConditions.elementToBeClickable(ClickingThreeDots));
        driver.findElement(ClickingThreeDots).click();
        wait.until(ExpectedConditions.elementToBeClickable(DeleteRC));
        driver.findElement(DeleteRC).click();
        wait.until(ExpectedConditions.elementToBeClickable(DeleteYes));
        driver.findElement(DeleteYes).click();
        wait.until(ExpectedConditions.elementToBeClickable(organization_module));
        String AfterDeleteUrl=driver.getCurrentUrl();
        Thread.sleep(3000);
        if(!AfterDeleteUrl.contains("manage-responsibility-centers")){
            Assert.fail("Did not landed on correct page");
        }
        else{
            System.out.println("Landed on correct page");
        }
    }

    @AfterMethod
    public void clearTests() {
        WebDriverWait wait=new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(organization_module));
        driver.quit();
    }
}
