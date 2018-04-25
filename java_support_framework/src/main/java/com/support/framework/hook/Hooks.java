package com.support.framework.hook;

import com.support.framework.support.ThreadLocalMap;
import cucumber.api.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import static com.support.framework.support.Util.getCurrentScenario;
import static com.support.framework.support.Util.setCurrentScenario;
import static com.support.framework.support.Util.takeScreenShotAsByte;

public class Hooks {

    private static final Logger LOG = Logger.getLogger(Hooks.class);

    public static void hookAfter(WebDriver driver) {
        Scenario scenario = getCurrentScenario();
        LOG.info("### " + scenario.getStatus() + " ###");
        LOG.info("### End scenario: " + scenario.getName() + " ###");
        if (scenario.isFailed()) {
            scenario.embed(takeScreenShotAsByte(driver), "image/png");
        }
        ThreadLocalMap.cleanup();
    }

    public static void hookBefore(Scenario scenario) {
        LOG.info("### Start scenario: " + scenario.getName() + " ###");
        setCurrentScenario(scenario);
    }
}
