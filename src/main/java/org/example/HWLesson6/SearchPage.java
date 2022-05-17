package org.example.HWLesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractPage{

    @FindBy(xpath = ".//*[@id='art_item_30789861']/div[2]/a")
    private WebElement searchItems;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage clickSearchItem(){
        searchItems.click();
        return this;
    }
}
