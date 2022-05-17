package org.example.HWLesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FirstPageLitRes extends AbstractPage{


        @FindBy(xpath = ".//a[@class='Login-module__loginLink']")
        private WebElement entry;

        @FindBy(xpath = ".//div[@class='childContainer-0-2-4 childContainer-d3-0-2-8']")
        private WebElement eMail;
    
        @FindBy(xpath = ".//input[@name='email']")
        private WebElement inputEmail;

        @FindBy(xpath = ".//div[@class='childContainer-0-2-4 childContainer-d11-0-2-16']")
        private WebElement resume;

        @FindBy(xpath = ".//input[@name='pwd']")
        private WebElement inputPwd;

        @FindBy(xpath = ".//div[@class='childContainer-0-2-4 childContainer-d31-0-2-36']")
        private WebElement enter;

        @FindBy(xpath = ".//input[@class='Search-module__input']")
        private WebElement inpytSearch;

        @FindBy(xpath = ".//button[@class='Search-module__button']")
        private WebElement search;

        @FindBy(xpath = ".//div[@class='Profile-module__name']")
        private WebElement name;

        public FirstPageLitRes(WebDriver driver) {
            super(driver);
        }

        public FirstPageLitRes clickEntry(){
            entry.click();
            return this;
        }

        public FirstPageLitRes clickEMail(){
            eMail.click();
            return this;
        }

        public FirstPageLitRes setEmail(String value){
            eMail.click();
            eMail.sendKeys(value);
            return this;

        }

        public FirstPageLitRes clickResume(){
            resume.click();
            return this;
        }

        public FirstPageLitRes setPwd(String pwd){
            inputPwd.click();
            inputPwd.sendKeys(pwd);
            return this;
        }

        public FirstPageLitRes clickEnter(){
            enter.click();
            return this;
        }

        public FirstPageLitRes clickInpytSearch(String name){
            inpytSearch.click();
            inpytSearch.sendKeys(name);
            return this;
        }
        public FirstPageLitRes clickSearch(){
            search.click();
            return this;
        }


}


