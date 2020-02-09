package com.calender.Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentDate 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
		//date textbox click find frame
		List<WebElement>ls=driver.findElements(By.tagName("iframe"));
		int count=ls.size();
		System.out.println("The no of frame is:"+ count);
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();
		//month select
		while(!driver.findElement(By.cssSelector("[class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all'] [class='ui-datepicker-month']")).getText().contains("February"))
		{
			driver.findElement(By.cssSelector("[class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all'] [class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		List<WebElement>ls1=driver.findElements(By.cssSelector("td[data-handler='selectDay']"));
		int count1=ls1.size();
		System.out.println("The days in month:"+ count1);
		for(int i=0;i<count1;i++)
		{
			String day=driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).getText();
			if(day.equals("14"))
			{
				driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).click();
			}
			
		}
		
	
	}

}
