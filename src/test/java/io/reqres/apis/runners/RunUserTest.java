package io.reqres.apis.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
//import utilities.reports.AllureReportConfigurationSetup;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features"},
        plugin = {"pretty", "html:target/cucumber/test-report", "json:target/cucumber-report.json"},
        glue = {"io.reqres.apis.stepdefs"})

public class RunUserTest {

}
