package com.support.framework.support;

import cucumber.api.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class Util {

    private static final Logger LOG = Logger.getLogger(Util.class);

    public static Scenario getCurrentScenario() {
        return ThreadLocalMap.getItem("CURRENT_SCENARIO", Scenario.class);
    }

    public static void setCurrentScenario(Scenario scenario) {
        ThreadLocalMap.getMap().put("CURRENT_SCENARIO", scenario);
    }


    public static boolean stringIsEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static byte[] takeScreenShotAsByte(WebDriver driver) {
        LOG.info("Capturing a screenshot");
        threadWait(0.25);
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void threadWait(double duration){
        try {
            if (duration > 3) {
                LOG.info("Waiting '" + duration + "' duration");
            }
            Thread.sleep((long) (duration * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
