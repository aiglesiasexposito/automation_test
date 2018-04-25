package com.selenium.framework.base;

import com.support.framework.base.DriverInterface;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class SeleniumBase extends AbstractSeleniumBase implements DriverInterface<WebElement> {

    private static final Logger LOG = Logger.getLogger(SeleniumBase.class);

    public SeleniumBase(WebDriver driver) {
        super(driver);
        initPageFactoryElements(this);
    }

    @Override
    public void initPageFactoryElements(Object object) {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(),10), object);
    }
}
