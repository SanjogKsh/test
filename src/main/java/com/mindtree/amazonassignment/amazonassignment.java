package com.mindtree.amazonassignment;


import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class amazonassignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("refrigerator");
		//driver.findElement(By.id("nav-search-submit-button")).sendKeys(Keys.CONTROL,Keys.ENTER);
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("(//a[contains(@href,'/Samsung-Direct-Refrigerator-RR19A24')])[1]")).click();
		WebElement price1= driver.findElement(By.xpath("(//a[contains(@href,'/Samsung-Direct-Refrigerator-RR19A24')])[4]/span//span[@class='a-price-whole']"));
		WebElement sym=driver.findElement(By.xpath("(//span[@class='a-price-symbol'])[3]"));
		String pr=price1.getText();
		System.out.println(pr);
		/*String pr1=sym.getText();
		String pri1=pr1.concat(pr);
		String pri2=".00";
		String pri=pri1.concat(pri2);
		//System.out.println(pri);*/
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> newpage=ids.iterator();
		String parenttab=newpage.next();
		String childtab=newpage.next();
		driver.switchTo().window(childtab);
		//System.out.println(driver.getTitle());
		WebElement price2= driver.findElement(By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']//span[@class='a-price-whole']"));
		String prinext=price2.getText();
		System.out.println(prinext);
		if(prinext.equals(pr)) {
			System.out.println("Same price");
		}
		else {
			System.out.println("Not same");
		}
		//WebElement weight=driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base'])[79]"));
		//System.out.println(weight.getText());
		//List<WebElement> abc=driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));
		int count=driver.findElements(By.xpath("//tr[@class='comparison_other_attribute_row']")).size();
		//System.out.println(count);
		for(int i=0; i<count;i++) {
			String weight=driver.findElements(By.xpath("//tr[@class='comparison_other_attribute_row']//th")).get(i).getText();
			if(weight.equalsIgnoreCase("Item Weight")) {
				System.out.println(driver.findElements(By.xpath("//td[2]//span[@class='a-size-base a-color-base']")).get(i).getText());
				break;
			}
		}
	}

}
