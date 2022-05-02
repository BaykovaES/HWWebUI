package org.example.HWLesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SearchAutor {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.litres.ru/");

        WebElement webElement1 = driver.findElement(By.xpath("//input[@class='Search-module__input']"));
        webElement1.sendKeys("Пулман");
        WebElement webElement2 = driver.findElement(By.cssSelector(".Search-module__button"));
        webElement2.click();
        //driver.quit();
    }
}
