package org.example.HWLesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyBookPage extends AbstractPage{

    @FindBy(xpath = ".//*[@id='my-books-list__basket']/a/span[1]")
    private WebElement myBasket;

    @FindBy(xpath = ".//button[@class='btn_link']")
    private WebElement clearBasket;

    public MyBookPage(WebDriver driver) {
        super(driver);
    }

    public MyBookPage clickMyBasket(){
        myBasket.click();
        return this;
    }

    public MyBookPage clickClearBasket(){
        clearBasket.click();
        return this;
    }
}
