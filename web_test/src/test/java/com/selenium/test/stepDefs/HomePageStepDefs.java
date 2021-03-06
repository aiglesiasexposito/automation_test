package com.selenium.test.stepDefs;

import com.selenium.test.bussinesSteps.HomePageBS;
import com.selenium.test.pages.homePage.HomePage;
import com.selenium.test.pages.newsPage.NewsPage;
import com.selenium.test.pages.menuPage.PrincipalMenu;
import com.selenium.test.pages.menuPage.SubMenuTypeEnum;
import com.selenium.test.bussinesSteps.SubMenuSectionBS;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;


public class HomePageStepDefs {

    @Autowired
    public HomePage hp;
    @Autowired
    public HomePageBS hpbs;
    @Autowired
    public PrincipalMenu pm;
    @Autowired
    public SubMenuSectionBS smbs;
    @Autowired
    public NewsPage np;


    @Given("^I am a invited user in the platform$")
    public void iAmAInvitedUserInThePlatform(){
        hp.getURL("bbc.com");
        hp.assertContainText(hp.sign_in_button,"Sign in");
    }

    @When("^I go to any sport news$")
    public void iGoToAnySportNews(Map<String, String> tableData) {
        pm.sport_menu.click();
        smbs.accessToSection(SubMenuTypeEnum.getSubMenuTypeEnum(tableData.get("section")));

    }

    @Then("^I can to read the first news story$")
    public void iCanToReadTheFirstNewsStory(){
        String newsHead = np.news_links.get(0).getText();
        np.news_links.get(0).click();
        np.assertContainText(np.title_news,newsHead);
    }

    @Given("^I am a registered user in the platform$")
    public void iAmARegisteredUserInThePlatform(){
        hp.getURL("bbc.com");
        hpbs.doLogin();
        hp.assertContainText(hp.sign_in_button,"Your account");
    }
}
