package org.example.Hw7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AbstractTest {
    static EventFiringWebDriver eventDriver;;

    @BeforeAll
    public static void setDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(10));

        eventDriver = new EventFiringWebDriver(new ChromeDriver(options));

        eventDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeEach
    public void getPage(){
        Assertions.assertDoesNotThrow( ()-> getDriver().navigate().to("https://www.litres.ru/"),
                "Страница не доступна");
        Assertions.assertTrue(true);

    }

    @AfterAll
    public static void close(){

        if(eventDriver !=null) eventDriver.quit();
    }

    @AfterEach
    public void checkBrowser(){
        List<LogEntry> allLogRows = getDriver().manage().logs().get(LogType.BROWSER).getAll();
        if(!allLogRows.isEmpty()){

            if (allLogRows.size() > 0 ) {
                allLogRows.forEach(logEntry -> {
                    System.out.println(logEntry.getMessage());
                });

            }

        }

    }

    public WebDriver getDriver(){
        return this.eventDriver;
    }
}
