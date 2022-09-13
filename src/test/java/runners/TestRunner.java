package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import stepdefinitions.uiSteps.Carts_Steps;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
               // "de.monochromata.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "./src/test/resources/features",//MUST
        glue = {"stepdefinitions","hooks"}, //MUST
        tags = " @login",
        dryRun = false,
        monochrome = true

)
public class TestRunner {

        public static void main(String[] args) {
                System.out.println("merhaba");
                Carts_Steps a=new Carts_Steps();

        }




}