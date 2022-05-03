package org.example.Hw5;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.TimeUnit;




public class LitResTest {
    static WebDriver driver;

    @BeforeAll
    public static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void getPage(){
        driver.get("https://www.litres.ru/");
    }

    @Test
    public void authorizationTest() throws InterruptedException {

        WebElement webElement = driver.findElement(By.cssSelector(".Login-module__loginLink"));
        webElement.click();
        WebElement webElement2 = driver.findElement(By.xpath("//div[@class='childContainer-0-2-4 childContainer-d3-0-2-8']"));
        webElement2.click();
        WebElement webElement3 = driver.findElement(By.name("email"));
        webElement3.sendKeys("tathar@mail.ru");
        WebElement webElement4 = driver.findElement(By.xpath("//div[@class='childContainer-0-2-4 childContainer-d11-0-2-16']"));
        webElement4.click();
        WebElement webElement5 = driver.findElement(By.xpath("//input[@name='pwd']"));
        webElement5.click();
        webElement5.sendKeys("7169766");
        WebElement webElement6 = driver.findElement(By.xpath("button[@class='button-0-2-1 button-d28-0-2-33 AuthorizationPopup-module__button Button-module__primary_orange']"));
        webElement6.click();
        String s = driver.findElement(By.xpath("//div[@class='Profile-module__name']")).getText();
        Assertions.assertTrue(s.equals("tathar"));

    }

    @Test
    public void SearchAutorTest(){
        WebElement webElement1 = driver.findElement(By.xpath("//input[@class='Search-module__input']"));
        webElement1.sendKeys("Пулман");
        WebElement webElement2 = driver.findElement(By.cssSelector(".Search-module__button"));
        webElement2.click();
        String webElement3 = driver.findElement(By.cssSelector("#result-tabs > ul > li.tab-active > a > span")).getText();
        Assertions.assertNotNull(webElement3);
    }

    @Test
    public void AddBookTest(){
        WebElement webElement1 = driver.findElement(By.xpath("//input[@class='Search-module__input']"));
        webElement1.sendKeys("Пулман");
        WebElement webElement2 = driver.findElement(By.xpath("//button[@class='Search-module__button']"));
        webElement2.click();
        WebElement webElement3 = driver.findElement(By.xpath("//*[@id='art_item_30789861']/div[2]/a"));
        webElement3.click();
        WebElement webElement4 = driver.findElement(By.cssSelector(".art-buttons__basket"));
        webElement4.click();
        WebElement webElement5 = driver.findElement(By.xpath("//button[@class='art-button art-buttons__basket']"));
        webElement5.click();
        String webElement6 = driver.findElement(By.xpath("//*[@id='my-books-list__basket']/a/span[2]")).getText();
        Assertions.assertNotNull(webElement6);


    }

    @Test
    public void EmptyBascketTest(){
        WebElement webElement1 = driver.findElement(By.xpath("//input[@class='Search-module__input']"));
        webElement1.sendKeys("Пулман");
        WebElement webElement2 = driver.findElement(By.xpath("//button[@class='Search-module__button']"));
        webElement2.click();
        WebElement webElement3 = driver.findElement(By.xpath("//*[@id='art_item_30789861']/div[2]/a"));
        webElement3.click();
        WebElement webElement4 = driver.findElement(By.xpath("//button[@class='art-button art-buttons__basket']"));
        webElement4.click();
        WebElement webElement5 = driver.findElement(By.xpath("//*[@id='promo-books-popup']/a]"));
        webElement5.click();
        WebElement webElement6 = driver.findElement(By.xpath("//*[@id='my-books-list__basket']/a/span[1]"));
        webElement6.click();
        WebElement webElement7 = driver.findElement(By.xpath("//button[@class='btn_link']"));
        webElement7.click();
        String webElement8 = driver.findElement(By.xpath("//*[@id='my-books-list__basket']/a/span[2]")).getText();
        Assertions.assertNull(webElement8);
    }

    @Test
    public void putBookDownTest() {

        WebElement webElement1 = driver.findElement(By.xpath("//input[@class='Search-module__input']"));
        webElement1.sendKeys("Пулман");
        WebElement webElement2 = driver.findElement(By.xpath("//button[@class='Search-module__button']"));
        webElement2.click();
        WebElement webElement3 = driver.findElement(By.xpath("//a[@title='Северное сияние']"));
        webElement3.click();
        WebElement webElement4 = driver.findElement(By.xpath("//button[@data-action='addfavorite']"));
        webElement4.click();
        String webElement5  = driver.findElement(By.xpath("//button[@class='art-button art-buttons__favorite']")).getText();
        Assertions.assertTrue(webElement5.equals("Отложено"));
    }

    @Test
    public void authorizationNoTest(){
        WebElement webElement = driver.findElement(By.cssSelector(".Login-module__loginLink"));
        webElement.click();
        WebElement webElement2 = driver.findElement(By.xpath("//div[@class='childContainer-0-2-4 childContainer-d3-0-2-8']"));
        webElement2.click();
        WebElement webElement3 = driver.findElement(By.name("email"));
        webElement3.sendKeys("tathar@mail.ru");
        WebElement webElement4 = driver.findElement(By.xpath("//div[@class='childContainer-0-2-4 childContainer-d11-0-2-16']"));
        webElement4.click();
        WebElement webElement5 = driver.findElement(By.xpath("//input[@name='pwd']"));
        webElement5.click();
        webElement5.sendKeys("3598745");
        WebElement webElement6 = driver.findElement(By.xpath("button[@class='button-0-2-1 button-d28-0-2-33 AuthorizationPopup-module__button Button-module__primary_orange']"));
        webElement6.click();
        String s = driver.findElement(By.xpath("//div[@class='AuthorizationPopup-module__error']")).getText();
        Assertions.assertTrue(s.equals("Неверное сочетание логина и пароля"));

    }



    @AfterAll
    public static void close(){
        driver.quit();
    }


}
