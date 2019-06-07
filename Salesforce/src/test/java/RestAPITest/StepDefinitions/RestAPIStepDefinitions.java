
package RestAPITest.StepDefinitions;

import RestAPITest.restAPITest;
import SalesforceSystemTest.navigation.NavigateTo;
import SalesforceSystemTest.navigation.SalesforceHomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


//import static org.assertj.core.api.Assertions.assertThat;

public class RestAPIStepDefinitions {

    @Steps
    NavigateTo navigateTo;
    restAPITest restapi;
    SalesforceHomePage homePage;
    String userName, passWord;
    Response response = null;

    String expectedString;
    String enteredSupporterLevel, expectedSupporterLevel, expectedLevelOfService, expectedSelectService, expectedchoosedSupporter, enteredSelectService;
    int STATUS_CODE_OK = 200;


    public String getConfigurationDetails(String nameURL) {
        EnvironmentVariables props = Injectors.getInjector().getInstance(EnvironmentVariables.class);
        String configDetails = EnvironmentSpecificConfiguration.from(props).getProperty(nameURL);
        return configDetails;
    }

    public Response postRequestResponse(String payload,String supporterAPIEndpoint) {
        try {
            response = RestAssured.given()
                    .auth().basic(userName,passWord)
                    .contentType(ContentType.JSON)
                    .body(payload)
                    .post(supporterAPIEndpoint);

        } catch(Exception e) {
            e.printStackTrace();

        }

        return response;
    }


    @Given("^I post Supporters Request Online channel$")
    public void i_post_supporters_request_online() throws Throwable {
        String jsonpathName = getConfigurationDetails("JSON.file.path.name.online.channel");
        userName = getConfigurationDetails("Supporter.API.Username");
        passWord = getConfigurationDetails("Supporter.API.Password");
        String supporterAPIEndpoint = getConfigurationDetails("Supporter.API.endpoint.online.channel");
        String payload = null;
        try {
            payload = new String(Files.readAllBytes(Paths.get(jsonpathName)));

        } catch (IOException e) {
            e.printStackTrace();
        }

        response = postRequestResponse(payload,supporterAPIEndpoint);
        int expectedstatusCode = response.statusCode();
        Assert.assertEquals(expectedstatusCode,STATUS_CODE_OK);
        System.out.println("Response:" + response.asString());


    }
    @When("^I post Supporters Request Waysact - CC failed transaction$")
    public void i_post_supporters_request_waysact() throws Throwable {
        String jsonpathName = getConfigurationDetails("JSON.file.path.name");
        userName = getConfigurationDetails("Supporter.API.Username");
        passWord = getConfigurationDetails("Supporter.API.Password");
        String supporterAPIEndpoint = getConfigurationDetails("Supporter.API.endpoint");
        String payload = null;
        try {
            payload = new String(Files.readAllBytes(Paths.get(jsonpathName)));

        } catch (IOException e) {
            e.printStackTrace();
        }

        response = postRequestResponse(payload,supporterAPIEndpoint);
        int expectedstatusCode = response.statusCode();
        Assert.assertEquals(expectedstatusCode,STATUS_CODE_OK);
        System.out.println("Response:" + response.asString());


        }

    }

