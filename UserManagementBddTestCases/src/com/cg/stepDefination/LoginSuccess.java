package com.cg.stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSuccess {
	WebDriver driver;
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","G:\\BDDSoftware\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver(); 
        driver.get("http://localhost:4200");
	     driver.manage().window().maximize();
	}

	@When("^User clicks the Login button$")
	public void user_clicks_the_Login_button() throws Throwable {
		driver.findElement(By.id("homeloginbutton")).click();
	}

	@When("^User enters email and password$")
	public void user_enters_email_and_password() throws Throwable {
		 driver.findElement(By.name("txtname")).sendKeys("sais11604@gmail.com");
	     driver.findElement(By.name("txtpwd")).sendKeys("saishiva123");
	   }
	@Then("^User Clicks on login button , eventually gets logged in$")
	public void user_Clicks_on_login_button_eventually_gets_logged_in() throws Throwable {
		   driver.findElement(By.xpath("//button[@value='login']")).click();
		   driver.navigate().to("http://localhost:4200");
		 driver.findElement(By.xpath("//a[@id='logoutbuttonclick']")).click();
		   Thread.sleep(5000);
		   driver.close();
		     
	}

	 
	}   

