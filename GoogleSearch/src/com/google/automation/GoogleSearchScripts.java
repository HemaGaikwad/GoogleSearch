package com.google.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class GoogleSearchScripts extends BaseTest
{
	@Test
	public void TC_01_googleSearch()
	{
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Johnny Johnny yes papa");
		searchBox.submit();
		wait.until(ExpectedConditions.titleContains("Johnny Johnny"));
		String title = driver.getTitle();
		Reporter.log("Navigated to the search results page : "+title);
		
	}
	
	@Test
	public void TC_02_invalid_value_search()
	{
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("@#$%");
		searchBox.submit();
		wait.until(ExpectedConditions.titleContains("Google Search"));
		String title = driver.getTitle();
		Reporter.log("Navigated to the search results page : "+title);
		String validationText=driver.findElement(By.xpath("//li[text()='Make sure that all words are spelled correctly.']")).getText();
		Reporter.log("Validation Text : "+validationText);
	}

	@Test
	public void tc_03_signIn()
	{
		WebElement signIn= driver.findElement(By.xpath("//a[text()='Sign in']"));
		signIn.click();
		String title = driver.getTitle();
		Assert.assertEquals("Sign in - Google Accounts", title);
		Reporter.log("Successfully naviagted to sign in page");
	}
	
	
	@Test
	public void tc_04_selectAllLinks()
	{
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		Reporter.log("Number of links on the webpage" + allLinks.size());
		for(WebElement link : allLinks)
		{
			String linkText=link.getText();
			Reporter.log(linkText);
		}
		
		
		
	}
	
	@Test
	public void tc_05_ClickOnInputBox()
	{
		WebElement inputBox = driver.findElement(By.xpath("//input[@value=\"I'm Feeling Lucky\"]"));
		inputBox.click();
		String url = driver.getCurrentUrl();
		Reporter.log("Navigated to "+ url +"Page");
	}
	
}
