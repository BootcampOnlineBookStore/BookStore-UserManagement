package com.cg.stepDefination;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginNotSuccess {
	WebDriver  driver; 
	@Given("^User is on BookStoreUserManagement page$")
	public void user_is_on_BookStoreUserManagement_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","G:\\BDDSoftware\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:4200/adminlogin");
	     driver.manage().window().maximize();
        
	}

	@When("^user clicks the Login  button$")
	public void user_clicks_the_Login_button() throws Throwable {
		driver.findElement(By.id("homeloginbutton")).click();
	}

	@When("^User enter email and and invalid password$")
	public void user_enter_email_and_and_invalid_password() throws Throwable {
		 driver.findElement(By.name("txtname")).sendKeys("john@gmail.com");
	     driver.findElement(By.name("txtpwd")).sendKeys("saishiva");

	}

	@When("^User clicks on login$")
	public void user_clicks_on_login() throws Throwable {
		driver.findElement(By.xpath("//button[@value='login']")).click();
	}

	@Then("^User Should get a message \"([^\"]*)\"$")
	public void user_Should_get_a_message(String arg1) throws Throwable {
		
		boolean view =driver.findElement(By.xpath(" //div[@id='loginerrormessage']")).isDisplayed();
		 assertTrue(view);
		 Thread.sleep(10000);
		 driver.close();
	}


}
