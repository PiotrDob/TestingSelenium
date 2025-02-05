package com.mike.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestScenarioStructured {
    //Variables
    private String url;
    private static WebDriver driver;

    @BeforeSuite
    public void startWebdriver() {
        url = "http://automationpractice.com/index.php?";
        System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

    @Test(priority = 1)
    public void CheckTittle(){
        driver.get(url);
        Assert.assertTrue(driver.getTitle().contains("My Store"));
    }

    @Test(priority = 2)
    public void FindWebElements(){
        List<WebElement> elements = driver.findElements(new By.ByXPath(".//*[@id=\"block_top_menu\"]"));
        for (WebElement allLinks:elements){
            allLinks.getText();
            System.out.println(allLinks.getText());
        }
    }
    @Test(priority = 3)
    public void CountingWebElements(){
        int CountElements = driver.findElements(new By.ByXPath(".//*[@id=\"block_top_menu\"]")).size();
        System.out.println(CountElements);
    }

    @Test(priority = 4)
    public void GoingToWomen(){
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();
        Assert.assertTrue(driver.getTitle().contains("Women - My Store"));
    }

    @Test(priority = 5)
    public void ChoosingSizeM(){
        driver.findElement(By.xpath("//*[@id=\"layered_id_attribute_group_2\"]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"layered_id_attribute_group_2\"]")).isSelected());
    }

}
