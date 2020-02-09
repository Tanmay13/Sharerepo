package com.calender.bycss;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolsqaDate 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("datepicker")).click();
		while(!driver.findElement(By.cssSelector("div>span")).getText().contains("February"))
		{
			driver.findElement(By.cssSelector("div[class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all'] [class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		List<WebElement>ls=driver.findElements(By.cssSelector("td[data-handler='selectDay']"));
		int count=ls.size();
		System.out.println(" no of dates"+count);
		for(int i=0;i<count;i++)
		{
			String day=driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).getText();
			if(day.equalsIgnoreCase("13"))
			{
				driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).click();
			}
		}
	}
}
