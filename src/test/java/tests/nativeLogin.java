package tests;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseTest;

public class nativeLogin extends BaseTest{

    //private By emailAddressField = By.xpath("//input[contains(text(),'Enter your work email address')]");
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
    public void setupTests() throws Exception{
        super.setup();
    }


    @Test( priority=2 , description = "Test:Login Test With Correct Details")
    public void loginWithCorrectDetails_inDEV() throws InterruptedException {

    }

    @AfterMethod
    public void clearTests() {
        driver.close();

    }
}
