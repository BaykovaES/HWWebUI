package org.example.HWLesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Authorization {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.litres.ru/");

        WebElement webElement1 = driver.findElement(By.cssSelector(".Login-module__loginLink"));
        webElement1.click();

        WebElement webElement2 = driver.findElement(By.xpath("//div[@class='childContainer-0-2-4 childContainer-d3-0-2-8']"));
        webElement2.click();
        WebElement webElement3 = driver.findElement(By.name("email"));
        webElement3.sendKeys("tathar@mail.ru");
        WebElement webElement4 = driver.findElement(By.xpath("//div[@class='childContainer-0-2-4 childContainer-d11-0-2-16']"));
        webElement4.click();
        WebElement webElement5 = driver.findElement(By.xpath("//div[@class='AuthorizationPopup-module__input']"));
        webElement5.click();
        webElement5.sendKeys("7169766");
        WebElement webElement6 = driver.findElement(By.xpath("button[@class='button-0-2-1 button-d28-0-2-33 AuthorizationPopup-module__button Button-module__primary_orange']"));
        webElement6.click();
        WebElement webElement7 = driver.findElement(By.xpath("//a[@class='Profile-module__profileLink']"));
        webElement7.click();
        WebElement webElement8 = driver.findElement(By.cssSelector(".user_menu__exit"));
        webElement8.click();
        //driver.quit();
    }

}
