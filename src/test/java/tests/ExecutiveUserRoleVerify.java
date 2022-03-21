package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExecutiveUserRoleVerify extends BaseTest {
        private String Executive_user_emailid = "minicooper1@knol-power.nl";
        private String Executive_user_password = "seknhn1";
        private By emailAddressField = By.xpath("//input[@formcontrolname='email']");
        private By passwordField = By.xpath("//input[@formcontrolname='password']");
        private By loginButton = By.xpath("//button[contains(text(),'SIGN IN')]");
        private By organization_module = By.xpath("//*[@id='organizationMenu']");
        private By ClickRole = By.xpath("//a[contains(text(), ' Roles ')]");
        private By CreateRoleButton = By.xpath("//button[contains(text(),'+ CREATE A ROLE')]");


        @BeforeMethod
        public void setupTests() {
        super.setup();
        driver.navigate().to(baseURL +"/signin");
        }

        @Test (description = "Test: Login with executive user and verify whether he has access to create any role and group")
        public void ExecutiveRoleVerification() throws IOException {
                WebDriverWait wait = new WebDriverWait(driver,30);
                wait.until(ExpectedConditions.elementToBeClickable(emailAddressField));
                driver.findElement(emailAddressField).clear();
                driver.findElement(emailAddressField).sendKeys(Executive_user_emailid);
                driver.findElement(passwordField).clear();
                driver.findElement(passwordField).sendKeys(Executive_user_password);
                driver.findElement(loginButton).click();
                wait.until(ExpectedConditions.elementToBeClickable(organization_module));
                driver.findElement(organization_module).click();

                boolean RolebuttonFound=false;
                boolean CreateRoleButtonFound = false;
                try
                {
                        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(ClickRole));
                        RolebuttonFound=true;

                }catch(Exception e)
                {
                        System.out.println("The Role Button isn't present.");
                        driver.findElement(organization_module).click();
                }

                if(RolebuttonFound)
                {
                        try
                        {
                                new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(CreateRoleButton));
                                CreateRoleButtonFound=true;

                        }catch(Exception e)
                        {
                                System.out.println("The \"Create Role\" Button isn't present.");
                                driver.findElement(organization_module).click();
                        }

                }

        }

        @AfterMethod
        public void clearTests() {
                //driver.quit();

        }
}
