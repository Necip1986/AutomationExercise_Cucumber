package hooks;

import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.Login_SignupPage;
import pages.SignUpPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class Hooks {

    public static String path="C:\\Users\\admin\\IdeaProjects\\AutomationExercise_Cucumber\\src\\test\\resources\\testdata\\tester.jpg";


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
