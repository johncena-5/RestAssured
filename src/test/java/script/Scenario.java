package script;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibrary.BaseAPIClass;
import genericLibrary.EndPointLibrary;
import genericLibrary.IconstantPath;
import io.github.bonigarcia.wdm.WebDriverManager;


import static io.restassured.RestAssured.*;

public class Scenario extends BaseAPIClass{
	
	@Test
	public void general() {
		
		
		
		login.loginToApp(pLib.fetchDataFromPropertyFile("username"), pLib.fetchDataFromPropertyFile("password"));
		
		home.clickProjectModuel();
		
		project.clickCreateButton();
		
		createp.createProject(web, pLib.fetchDataFromPropertyFile("projectName")+jLib.getRandom(), pLib.fetchDataFromPropertyFile("createdBy"), 1);
		
		
		String query = "select * from project";
		
		String expData = project.getProjectId(driver);
		
		String actData = dLib.readDataFromDatabaseAndValidate(query, 1, expData);
		
		Assert.assertEquals(expData, actData);
		
		given()
		.pathParam("id", actData);
		
		
		
		
		
		
		
		
	}
}
		
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.get(IconstantPath.baseUri);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		driver.findElement(By.id("usernmae")).sendKeys(IconstantPath.rmg_id);
//		driver.findElement(By.id("inputPassword")).sendKeys(IconstantPath.rmg_password);
//		driver.findElement(By.xpath("//button[.='Sign in']")).click();
//
//		driver.findElement(By.xpath("//a[.='Projects']")).click();
//		
//		driver.findElement(By.xpath("//button[@class=\"btn btn-success\"]")).click();
//		String projectName = "Agni"+jLib.getRandom();
//		driver.findElement(By.name("projectName")).sendKeys(projectName);
//		driver.findElement(By.name("createdBy")).sendKeys("rohit");
//		WebElement drop = driver.findElement(By.name("status"));
//		
//		Select s = new Select(drop);
//		s.selectByValue("On Going");
//		
//		driver.findElement(By.xpath("//input[@class=\"btn btn-success\"]")).click();
//		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		
//		String projectId = driver.findElement(By.xpath("//td[.='"+projectName+"']/preceding-sibling::td")).getText();
//		String query = "select * from project";
//		
//		String status = dLib.readDataFromDatabaseAndValidate(query, 1, projectId);
//		
//		System.out.println(status);
//		
//		
//		given()
//		.pathParam("id", projectId)
//		.when().get("/projects/{id}")
//		
//		.then()
//		.assertThat()
//		.log().all();
		
		
		
	

