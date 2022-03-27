package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExecutiveUserRoleVerify extends BaseTest {
        private String Executive_user_emailid = "minicooper1@knol-power.nl";  // light users with view (role and group permission)
        private String Executive_user_password = "seknhn1";
        //private String Executive_user_emailid = "jamescop@knol-power.nl";   // Key admin's account
        //private String Executive_user_password = "Vcomply@1234";
        //private String Executive_user_emailid = "alberto@knol-power.nl";    // Executive user account
        //private String Executive_user_password = "Vcomply@1234";
        private By emailAddressField = By.xpath("//input[@formcontrolname='email']");
        private By passwordField = By.xpath("//input[@formcontrolname='password']");
        private By loginButton = By.xpath("//button[contains(text(),'SIGN IN')]");
        private By organization_module = By.xpath("//*[@id='organizationMenu']");
        private By ClickRole = By.xpath("//a[contains(text(), ' Roles ')]");
        private By CreateRoleButton = By.xpath("//button[contains(text(),'+ CREATE A ROLE')]");
        private By ClickGroup = By.xpath("//a[contains(text(),'Groups')]");
        private By CreateGroupButton = By.xpath("//button[contains(text(),'+ ADD A GROUP')]");
        private By ResponsibilityCenterButton = By.xpath("//a[contains(text(), ' Responsibility Centers ')]");
        private By CreateRcButton = By.xpath("//button[contains(text(),'+ ADD A RESPONSIBILITY CENTER')]");

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
                boolean GroupButtonFound = false;
                boolean CreateGroupButtonFound = false;
                boolean RCButtonFound = false;
                boolean CreateRCButtonFound = false;

                try
                {
                        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(ClickRole));
                        RolebuttonFound=true;

                }catch(Exception e)
                {
                        System.out.println("The Role Button is not present for executive users.");
                        driver.findElement(organization_module).click();
                }

                if(RolebuttonFound)
                {
                        driver.findElement(ClickRole).click();
                        try
                        {
                                new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(CreateRoleButton));
                                CreateRoleButtonFound=true;

                        }catch(Exception e)
                        {
                                System.out.println("The \" + Create Role\" button is not present for executive users.");
                                driver.findElement(organization_module).click();
                        }
                        if(CreateRoleButtonFound)
                        {
                                Assert.fail("Executive user have create role permission");
                        }

                }
                try
                {
                        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(ClickGroup));
                        GroupButtonFound=true;
                }
                catch(Exception e)
                {
                        System.out.println("The Group Button is not present for executive users.");
                        driver.findElement(organization_module).click();
                }
                if(GroupButtonFound)
                {
                        driver.findElement(ClickGroup).click();
                        try
                        {
                                new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(CreateGroupButton));
                                CreateGroupButtonFound=true;
                        }
                        catch(Exception e)
                        {
                                System.out.println("The \"+ ADD A GROUP\" button is not present for executive users.");
                                driver.findElement(organization_module).click();
                        }
                        if(CreateGroupButtonFound)
                        {
                                Assert.fail("\"+ ADD A GROUP\" button is visible to executive users");
                        }
                }

                try
                {
                        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(ResponsibilityCenterButton));
                        RCButtonFound=true;

                }catch(Exception e)
                {
                        System.out.println("The Responsibility Center Button is not present for executive users.");
                        driver.findElement(organization_module).click();
                }

                if(RCButtonFound)
                {
                        driver.findElement(ResponsibilityCenterButton).click();
                        try
                        {
                                new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(CreateRcButton));
                                CreateRCButtonFound=true;

                        }catch(Exception e)
                        {
                                System.out.println("The \" + Create Responsibility center\" button is not present for executive users.");
                                driver.findElement(organization_module).click();
                        }
                        if(CreateRCButtonFound)
                        {
                                Assert.fail("Executive user have create \" Create Responsibility center \" permission");
                        }

                }

        }

        @AfterMethod
        public void clearTests() {
               driver.quit();

        }
}
