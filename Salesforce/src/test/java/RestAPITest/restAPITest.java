package RestAPITest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class restAPITest {
    int STATUS_CODE_OK = 200;

    public String getConfigurationDetails(String nameURL) {
        EnvironmentVariables props = Injectors.getInjector().getInstance(EnvironmentVariables.class);
        String configDetails = EnvironmentSpecificConfiguration.from(props).getProperty(nameURL);
        return configDetails;
    }

    public void testRestApi()  {

        String jsonpathName = getConfigurationDetails("JSON.file.path.name");
        String userName = getConfigurationDetails("Supporter.API.Username");
        String passWord = getConfigurationDetails("Supporter.API.Password");
        String supporterAPIEndpoint = getConfigurationDetails("Supporter.API.endpoint");
        String payload = null;
        try {
            payload = new String(Files.readAllBytes(Paths.get(jsonpathName)));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Response response = null;
        try {
            response = RestAssured.given()
                    .auth().basic(userName,passWord)
                    .contentType(ContentType.JSON)
                    .body(payload)
                    .post(supporterAPIEndpoint);

        } catch(Exception e) {
            e.printStackTrace();

        }
        int expectedstatusCode = response.statusCode();
        Assert.assertEquals(expectedstatusCode,STATUS_CODE_OK);

        System.out.println("Response:" + response.asString());


    }


}


//}
