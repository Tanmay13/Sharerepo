package com.scopeByusing_keysChord;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QAscopekeysChordTest 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.get("http://www.qaclickacademy.com/practice.php");
        driver.manage().window().maximize();
        //no of hyperlinks
        List<WebElement> ls=driver.findElements(By.tagName("a"));
        int count1=ls.size();
        System.out.println("The number of hyperlinks on web page are:"+count1);
        //footer on page and no of hyperlinks on it 
        WebElement footerdriver= driver.findElement(By.id("gf-BIG"));
        int count2=footerdriver.findElements(By.tagName("a")).size();
        System.out.println("The number of hyperlinks in the footer of web page:"+count2);
        //no of hyperlink on column driver
        WebElement columndriver=driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td/ul[1]"));
        int count=columndriver.findElements(By.tagName("a")).size();
        System.out.println("The number of hyperlinks on columndrive :"+count);
        for(int i=1;i<count;i++)
        {
        	String clickonlink=Keys.chord(Keys.CONTROL,Keys.ENTER);
        	columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
        	Thread.sleep(5000);
        }
        Set<String> s=driver.getWindowHandles();
        Iterator<String> itr=s.iterator();        
        while(itr.hasNext())
        {
        	driver.switchTo().window(itr.next());
        	System.out.println(driver.getTitle());      
        	if(driver.getTitle().equalsIgnoreCase("REST API Tutorial"))
        	{
        		driver.findElement(By.linkText("What Is REST?")).click();
        	}   	
        }
        driver.close();
	}
}
