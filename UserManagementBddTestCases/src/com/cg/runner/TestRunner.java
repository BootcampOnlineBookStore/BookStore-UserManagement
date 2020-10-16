package com.cg.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="Feature/listuser.feature",glue= {"com.cg.stepDefination"},plugin= {"pretty","html:cucumber-report/valid-report","json:cucumberjson-report/validjson-report.json","junit:junit_cucumber/valid_test.xml"},monochrome=true)
public class TestRunner {

}
//when we specify tags, this tags run the test only for the scenario annotated by a name
/*plugin shows the time taken and report for execution of test-case,
 *  one is usage report,which give time for execution, 
 *  another pretty, 
 *  for printing small report with all the sentences we gave in scenario and feature
 */
//monochrome prints the report in a more understandable manner by removing question mark and some symbols
/*"html:cucumber-report/valid-report" creates html version of the report and saves it to the cucumber-report folder when 
 * we refresh the project and we need to expand and choose index.html and right click on it and copy the path from properties and 
 * in json version, when .json is specified, the notepad version will be saved in the specified path
 * in you this pc give the path and you can see the report
 */
