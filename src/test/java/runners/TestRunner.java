package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import utilities.ExcelUt;

import java.io.IOException;


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
        tags = "@JobApplication",
        features = "./src/test/resources/features",//MUST
        glue = {"stepdefinitions","hooks"}, //MUST
        dryRun=false
)


public class TestRunner {

        public static void main(String[] args) throws IOException {
                String path="src\\test\\resources\\testdata\\DATA.xls";
                ExcelUt excelUt = new ExcelUt(path);
                System.out.println(excelUt.getColumnNames("Sheet8"));
                System.out.println(excelUt.getExcelDataList("Sheet8","dd/MM/yyyy"));
        }



        




}