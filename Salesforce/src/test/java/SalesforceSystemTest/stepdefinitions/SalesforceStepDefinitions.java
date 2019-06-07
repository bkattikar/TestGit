
package SalesforceSystemTest.stepdefinitions;

import SalesforceSystemTest.navigation.NavigateTo;
import SalesforceSystemTest.navigation.SalesforceHomePage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Map;


//import static org.assertj.core.api.Assertions.assertThat;

public class SalesforceStepDefinitions {

    @Steps
    NavigateTo navigateTo;
    SalesforceHomePage homePage;
    String firstName,lastName,Salutation;
    String expectedString;
    String enteredSupporterLevel,expectedSupporterLevel,expectedLevelOfService,expectedSelectService,expectedchoosedSupporter,enteredSelectService;

    public WebDriver initialize() {
        String saleforceNotifications = getConfigurationDetails("webdriver.base.disable_notifications");
        String driverName = getConfigurationDetails("webdriver.name.chrome");
        String driverPath = getConfigurationDetails("webdriver.chrome.driver");
        ChromeOptions option = new ChromeOptions();
        option.addArguments(saleforceNotifications);
        System.setProperty(driverName, driverPath);
        WebDriver driver = new ChromeDriver(option);
        return driver;
    }

    public String getConfigurationDetails(String nameURL) {
        EnvironmentVariables props = Injectors.getInjector().getInstance(EnvironmentVariables.class);
        String configDetails = EnvironmentSpecificConfiguration.from(props).getProperty(nameURL);
        return configDetails;
    }

    WebDriver driver = initialize();

    @Given("^I login to Salesforce URL$")
    public void i_login_to_Salesforce_URL() throws Throwable {


        navigateTo.LogintoSalesforce(driver);


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }




    @When("^I click on Contacts Page")
    public void i_click_on_contacts_page() throws Throwable {
        navigateTo.clickNewContact(driver);
     //   restapi.testRestApi();

    }

    @When("^I enter following details under New Contact Page:$")
    public void i_enter_details(DataTable dataTable) throws Throwable {
        List<Map<String, String>> data =  dataTable.asMaps(String.class, String.class);
        firstName = data.get(0).get("First Name");
        lastName = data.get(0).get("Last Name");
        Salutation = data.get(0).get("Salutation");
        navigateTo.insertRecords(driver,firstName,lastName,Salutation);
    }

     @When("^I select (.*) under Supporter level$")
     public void i_select(String supporterLevel) throws Throwable {
         navigateTo.selectFromDropDown(driver,supporterLevel);
         enteredSupporterLevel = supporterLevel;

     }

     @When("^I select (.*) as (.*)$")
     public void i_select_levels_of_service(String levelsOfService, String selectService) throws Throwable {
       navigateTo.chooseLevelsOfService(driver,levelsOfService,selectService);
       expectedLevelOfService = levelsOfService;
       enteredSelectService = selectService;

     }
     @When("^I click on (.*) Button$")
     public void i_click_on_button(String buttonClick) throws Throwable {
        navigateTo.clickOnButton(driver,buttonClick);
     }
     @When("^I click on (.*) Tab$")
     public void i_click_on_tab(String tabClick) throws Throwable {
        navigateTo.clickontab(driver,tabClick);
     }


     @When("^I retrieve (.*), (.*) and (.*) fields under Details Page$")
     public void i_retrieve_details(String fieldName,String supporterField,String choosedSupporter) throws Throwable {
         expectedString = navigateTo.verifyDetails(driver,fieldName);
         expectedSupporterLevel = navigateTo.verifyDetails(driver,supporterField);
         expectedchoosedSupporter = navigateTo.verifyDetails(driver,choosedSupporter);

    }


    @When("^I retrieve (.*) and (.*) fields under Details Page$")
    public void i_retrieve_details_High_NotApplicablr(String fieldName,String supporterField) throws Throwable {
        expectedString = navigateTo.verifyDetails(driver, fieldName);
        expectedSupporterLevel = navigateTo.verifyDetails(driver, supporterField);
        //expectedchoosedSupporter = navigateTo.verifyDetails(driver,choosedSupporter);
    }

     @Then("^I Verify Name and Supporter Level fields under Details page$")
     public void i_verify_details() throws Throwable {
         String enteredString = Salutation+" "+firstName+" "+lastName;
         Assert.assertEquals(expectedString,enteredString);
         Assert.assertEquals(expectedSupporterLevel,enteredSupporterLevel);
         Assert.assertEquals(expectedchoosedSupporter,enteredSelectService);


     }

    }

