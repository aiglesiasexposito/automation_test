package com.support.framework.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

import static org.junit.Assert.assertTrue;

public abstract class AbstractBase<T extends WebElement> {

    private static final Logger LOG = Logger.getLogger(AbstractBase.class);
    private WebDriver driver;

    public AbstractBase(WebDriver driver) {
        this.driver = driver;
    }


    public void assertElementPresent(T element) {
        assertTrue(elementPresent(element));
    }

    public boolean assertContainText(T element, String text) {
        assertTrue(element.getText().contains(text));
        return true;
    }

    public boolean elementPresent(T element, int duration) {
        try {
            new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException ignore) {
            return false;
        }
    }

    public boolean elementPresent(T element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException | TimeoutException ignore) {
            return false;
        }
    }
}


