package com.cg.stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ListUser {
	WebDriver driver;
	@Given("^User is on the Home Page$")
	public void user_is_on_the_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","G:\\BDDSoftware\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver(); 
        driver.get("http://localhost:4200");
	     driver.manage().window().maximize();
	}

	@When("^User clicks Login button$")
	public void user_clicks_Login_button() throws Throwable {
		driver.findElement(By.id("homeloginbutton")).click();

	}

	@When("^User enters his email and password$")
	public void user_enters_his_email_and_password() throws Throwable {
		 driver.findElement(By.name("txtname")).sendKeys("sais11604@gmail.com");
	     driver.findElement(By.name("txtpwd")).sendKeys("saishiva123");	
	}

	@When("^User Clicks on the login button , eventually gets logged in$")
	public void user_Clicks_on_the_login_button_eventually_gets_logged_in() throws Throwable {
		   driver.findElement(By.xpath("//button[@value='login']")).click();
		   driver.navigate().to("http://localhost:4200");   
	}

	@When("^the homepage is displayed, the user clicks on listuser button$")
	public void the_homepage_is_displayed_the_user_clicks_on_listuser_button() throws Throwable {
	    
		driver.findElement(By.xpath("//button[@id='listbtn']")).click();
	    driver.navigate().to("http://localhost:4200/listuser");
	}

	@Then("^the user gets navigated to listuser page where all users are displayed$")
	public void the_user_gets_navigated_to_listuser_page_where_all_users_are_displayed() throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='logoutbuttonclick']")).click();
		   Thread.sleep(1000);
		   driver.close();
		 
         
	}

	


}
