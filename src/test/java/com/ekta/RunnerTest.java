package com.ekta;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;




@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        monochrome = true,
        features = {"src/test/resources/com/ekta/"},
        glue= {"com.ekta"}


)
public class RunnerTest {

}