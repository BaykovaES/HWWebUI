package org.example.HWLesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookPage extends AbstractPage{

    @FindBy(xpath = ".//button[@class='art-button art-buttons__basket']")
    private WebElement bascket;

    @FindBy(xpath = ".//button[@data-action='addfavorite']")
    private WebElement addFavorite;

    @FindBy(xpath = ".//a[@class ='MyBooks-modules__myBooksLink']")
    private WebElement myBooks;

    public BookPage(WebDriver driver) {
        super(driver);
    }

    public BookPage clickBascket(){
        bascket.click();
        return this;
    }

    public BookPage clickAddFavorite(){
        addFavorite.click();
        return this;
    }
    public BookPage clickMyBooks(){
        myBooks.click();
        return this;
    }
}
