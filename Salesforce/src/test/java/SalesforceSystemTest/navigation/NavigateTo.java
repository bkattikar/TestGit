
package SalesforceSystemTest.navigation;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class NavigateTo {





    @Step("Open the Salesforce home page")
    public void LogintoSalesforce(WebDriver driver) {
        String salesforceURL = getConfigurationDetails("webdriver.base.url");
        String userName = getConfigurationDetails("Salesforce.username");
        String passWord = getConfigurationDetails("Salesforce.password");
        driver.get(salesforceURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(passWord);
        driver.findElement(By.xpath("//input[@id='Login']")).click();
    }

    public void clickNewContact(WebDriver driver) {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       driver.findElement(By.xpath("(//lightning-icon[@class='slds-icon-utility-chevrondown slds-icon_container'])[2]")).click();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Actions act1=new Actions(driver);
        act1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void insertRecords(WebDriver driver,String firstName,String lastName,String Salutation) {

      //  Actions act1=new Actions(driver);
       // act1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div[contains(@class,'uiInputSelect')]//span[contains(text(),'Salutation')]/../..//div[contains(@class,'salutation')]//a")).click();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div[contains(@class,'select-options')]//a[contains(@title,'Mr')]")).click();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(firstName);
        driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys(lastName);


    }

    public void selectFromDropDown(WebDriver driver,String supporterLevel) {

        driver.findElement(By.xpath("//div[contains(@class,'uiInputSelect')]//span[contains(@class,'inputLabel')]//..//a")).click();
        driver.findElement(By.xpath("//div[contains(@class,'select-options')]//a[contains(@title,'"+supporterLevel+"')]")).click();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        Actions act11=new Actions(driver);
        act11.sendKeys(Keys.PAGE_DOWN).build().perform();

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }


       // WebElement ele22 = driver.findElement(By.xpath("//a[.='Accounts']"));
        // Actions act11=new Actions(driver);
        // act11.click(ele22);
        //act11.click(ele22).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();




    }

    public void clickOnButton(WebDriver driver,String buttonClick) {
         driver.findElement(By.xpath("//span[text()= '"+buttonClick+"']")).click();

    }

    public void clickontab(WebDriver driver,String tabClick) {
        driver.findElement(By.xpath("//span[text()='"+tabClick+"']")).click();

    }

    @Screenshots(forEachAction=true)
    public void chooseLevelsOfService(WebDriver driver,String levelofService,String chooseServiceLevel) {

        driver.findElement(By.xpath("//div[contains(@class,'forcePageBlockItem')]//span[contains(text(),'"+levelofService+"')]/../..//a")).click();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        WebElement element1 = driver.findElement(By.xpath("//ul/li/a[text()='"+chooseServiceLevel+"']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element1);


    }

    public String getConfigurationDetails(String nameURL) {
        EnvironmentVariables props = Injectors.getInjector().getInstance(EnvironmentVariables.class);
        String configDetails = EnvironmentSpecificConfiguration.from(props).getProperty(nameURL);
        return configDetails;
    }


    public String verifyDetails(WebDriver driver,String fieldName) {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.xpath("//div[contains(@class,'test-id__section-content')]//div[contains(@class,'label-container')]//span[contains(text(),'"+fieldName+"')]/../..//div[contains(@class,'slds-form-element__control')]//span//span"));
        return element.getText();

    }

    public String verifyDetails1(WebDriver driver) {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.xpath("//div[contains(@class,'test-id__section-content')]//div[contains(@class,'label-container')]//span[contains(text(),'Supporter Level')]/../..//div[contains(@class,'slds-form-element__control')]//span//span"));
        return element.getText();

    }

    public void clickonopportunity(WebDriver driver) {
        driver.findElement(By.xpath("//div[contains(@class,'slds-context-bar')]//a//span[contains(text(),'Contacts')]")).click();
       // driver.findElement(By.xpath("//div[contains(@class,'slds-context-bar')]//a[contains(@title,'Opportunities')]")).click();
        //div[contains(@class,'slds-context-bar')]//a//span[contains(text(),'Home')]
    }


    }

