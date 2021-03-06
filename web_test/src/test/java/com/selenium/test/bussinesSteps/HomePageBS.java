package com.selenium.test.bussinesSteps;

import com.selenium.framework.base.SeleniumBase;
import com.selenium.test.pages.homePage.HomePage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.google.gson.*;

import java.io.*;


@Component
@Scope("cucumber-glue")
public class HomePageBS extends SeleniumBase {

    @Autowired
    public HomePage hp;

    public void doLogin() {

        hp.sign_in_button.click();
        hp.user_identifier_field.sendKeys("alextest23021983@gmail.com");
        hp.user_password_field.sendKeys("I23A5678!");
        hp.submit_button.click();


        }

    public HomePageBS(WebDriver driver) {
        super(driver);
    }

}