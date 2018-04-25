package com.support.framework.support;

import org.junit.Assert;

import java.util.Optional;

import static com.support.framework.support.Util.stringIsEmpty;

public enum Property {

    PLATFORM_NAME(System.getProperty("platform.name")),
    PLATFORM_VERSION(System.getProperty("platform.version")),

    //Selenium
    DEVICE_NAME(Optional.ofNullable(System.getProperty("device.name")).orElse("NO DEVICE")),
    BROWSER_NAME(Optional.ofNullable(System.getProperty("browser.name")).orElse("Chrome")),
    BASE_URL(System.getProperty("base.url")),
    GRID_URL(System.getProperty("grid.url")),
    GRID_USE(System.getProperty("grid.use")),
    SELENIUM_LOG(Optional.ofNullable(System.getProperty("selenium.log")).orElse("WARNING")),
    BROWSER_HEIGHT(Optional.ofNullable(System.getProperty("browser.height")).orElse("900")),
    BROWSER_WIDTH(Optional.ofNullable(System.getProperty("browser.width")).orElse("1400"));

    private String value;

    Property(String value) {
        this.value = value;
    }

    public boolean toBoolean() {
        if (stringIsEmpty(value)) {
            Assert.fail("Property " + this.name() + " is missing. Check your pom.xml");
        }
        return Boolean.parseBoolean(value);
    }

    public int toInt() {
        if (stringIsEmpty(value)) {
            Assert.fail("Property " + this.name() + " is missing. Check your pom.xml");
        }
        return Integer.parseInt(value);
    }

    public String toString() {
        if (stringIsEmpty(value)) {
            Assert.fail("Property " + this.name() + " is missing. Check your pom.xml");
        }
        return value;
    }
}



