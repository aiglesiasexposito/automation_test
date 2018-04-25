package com.selenium.framework.base;

import com.support.framework.base.AbstractBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.support.framework.support.Property.BASE_URL;

abstract class AbstractSeleniumBase extends AbstractBase<WebElement> {

    private static final Logger LOG = Logger.getLogger(AbstractSeleniumBase.class);
    private WebDriver driver;

    AbstractSeleniumBase(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void getURL(String subURL) {
        driver.get(BASE_URL + subURL);
    }


    public void waitForPageLoaded(int waitDuration) {
        ExpectedCondition<Boolean> expectation = driver -> {
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
        };
        try {
            Thread.sleep(500);
            new WebDriverWait(driver, waitDuration).until(expectation);
        } catch (Throwable error) {
            LOG.warn("Timeout while waiting for Page Load");
        }
    }
}
