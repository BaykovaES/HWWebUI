package org.example.HW6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.HWLesson6.BookPage;
import org.example.HWLesson6.FirstPageLitRes;
import org.example.HWLesson6.MyBookPage;
import org.example.HWLesson6.SearchPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LitResTest extends AbstractTest{

    @Test
    public void authorizationTest()  {
        FirstPageLitRes firstPageLitRes = new FirstPageLitRes(getDriver());
        firstPageLitRes
                .clickEntry()
                .clickEMail()
                .setEmail("tathar@mail.ru")
                .clickResume()
                .setPwd("7169766")
                .clickEnter();

        Assertions.assertTrue(
                getDriver()
                    .findElement(By.xpath(".//div[@class='Profile-module__name']"))
                    .getText()
                    .equals("tathar"));



    }

    @Test
    public void SearchAutorTest(){
        FirstPageLitRes firstPageLitRes = new FirstPageLitRes(getDriver());
        firstPageLitRes
                .clickInpytSearch("Пулман")
                .clickSearch();


        Assertions.assertNotNull(getDriver()
                .findElement(By.cssSelector("#result-tabs > ul > li.tab-active > a > span"))
                .getText());
    }

    @Test
    public void AddBookTest(){
        FirstPageLitRes firstPageLitRes = new FirstPageLitRes(getDriver());
        firstPageLitRes
                .clickInpytSearch("Пулман")
                .clickSearch();

        SearchPage searchPage = new SearchPage(getDriver());
        searchPage
                .clickSearchItem();

        BookPage bookPage = new BookPage(getDriver());
        bookPage
                .clickBascket()
                .clickMyBooks();


        Assertions.assertNotNull(getDriver()
                .findElement(By.xpath("//*[@id='my-books-list__basket']/div/span[2]"))
                .getText());


    }

    @Test
    public void EmptyBascketTest(){
            FirstPageLitRes firstPageLitRes = new FirstPageLitRes(getDriver());
            firstPageLitRes
                    .clickInpytSearch("Пулман")
                    .clickSearch();

            SearchPage searchPage = new SearchPage(getDriver());
            searchPage
                    .clickSearchItem();

            BookPage bookPage = new BookPage(getDriver());
            bookPage
                    .clickBascket()
                    .clickMyBooks();

            MyBookPage myBookPage = new MyBookPage(getDriver());
            myBookPage
                    .clickMyBasket()
                    .clickClearBasket()


        String webElement8 = driver.findElement(By.xpath("//*[@id='my-books-list__basket']/a/span[2]")).getText();
        Assertions.assertNull(getDriver()
                .findElement(By.xpath("//*[@id='my-books-list__basket']/div/span[2]"))
                .getText());
    }

    @Test
    public void putBookDownTest() {
        FirstPageLitRes firstPageLitRes = new FirstPageLitRes(getDriver());
        firstPageLitRes
                .clickInpytSearch("Пулман")
                .clickSearch();

        SearchPage searchPage = new SearchPage(getDriver());
        searchPage
                .clickSearchItem();

        BookPage bookPage = new BookPage(getDriver());
        bookPage
                .clickAddFavorite();


        Assertions.assertTrue(getDriver()
                .findElement(By.xpath("//button[@class='art-button art-buttons__favorite']"))
                .getText()
                .equals("Отложено"));
    }

    @Test
    public void authorizationNoTest(){
        FirstPageLitRes firstPageLitRes = new FirstPageLitRes(getDriver());
        firstPageLitRes
                .clickEntry()
                .clickEMail()
                .setEmail("tathar@mail.ru")
                .clickResume()
                .setPwd("3598745")
                .clickEnter();


        Assertions.assertTrue(
                getDriver()
                        .findElement(By.xpath(".//div[@class='AuthorizationPopup-module__error']"))
                        .getText()
                        .equals("Неверное сочетание логина и пароля"));
    }



}
