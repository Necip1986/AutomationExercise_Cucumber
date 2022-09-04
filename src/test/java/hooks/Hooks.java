package hooks;

import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.Login_SignupPage;
import pages.SignUpPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class Hooks {

    public static String path="C:\\Users\\admin\\IdeaProjects\\AutomationExercise_Cucumber\\src\\test\\resources\\testdata\\tester.jpg";


    public static RequestSpecification spec;
    @Before(value = "@usersApi")
    public void setUpApi(){
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("api_url")).build();
    }

    @After (value = "@focus")
    public void tearDown(Scenario scenario) throws IOException {


        if (scenario.isFailed()) {


            ReusableMethods.getScreenshot(scenario.getName());
            final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png","screenshots");
        }



        /*
        if(scenario.isFailed()){

            //scenario.attach(ReusableMethods.getScreenshot(scenario.getName()), "image/png", scenario.getName());
        }



         */
          Driver.closeDriver();

    }
}
