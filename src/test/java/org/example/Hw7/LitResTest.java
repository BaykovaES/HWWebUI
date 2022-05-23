package org.example.Hw7;

import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.example.HWLesson6.BookPage;
import org.example.HWLesson6.FirstPageLitRes;
import org.example.HWLesson6.MyBookPage;
import org.example.HWLesson6.SearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LitResTest extends AbstractTest {

    @Test
    @DisplayName("Авторизация")
    @Link("https://www.litres.ru/")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Вход на сайт по имени пользователя и паролю")
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
    @DisplayName("Проверка поля Поиск")
    @Link("https://www.litres.ru/")
    @Severity(SeverityLevel.NORMAL)
    @Story("Работа поисковой строки по существующему запросу")
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
    @DisplayName("Добавление книг в корзину")
    @Link("https://www.litres.ru/")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Проверка работы кнопки добавить в корзину")
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
    @DisplayName("Тест очистить корзину")
    @Link("https://www.litres.ru/")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка очищаемости корзины")
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
                    .clickClearBasket();



        Assertions.assertNull(getDriver()
                .findElement(By.xpath("//*[@id='my-books-list__basket']/div/span[2]"))
                .getText());
    }

    @Test
    @DisplayName("Тест кнопки Отложено")
    @Link("https://www.litres.ru/")
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка работы кнопки отложить")
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
    @DisplayName("Негативный тест авторизации")
    @Link("https://www.litres.ru/")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Проверка вывода информационного сообщения при авторизации пользователя не верными данными")
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
