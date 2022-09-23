package runners;

import hooks.StaticWork;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
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
        tags = " @Demo",
        dryRun = false,
        monochrome = true

)
public class TestRunner {


        




}