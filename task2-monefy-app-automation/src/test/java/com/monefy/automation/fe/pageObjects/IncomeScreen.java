package com.monefy.automation.fe.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class IncomeScreen extends PageObject {

    @Managed(driver = "appium")
    WebDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Deposits']")
    private WebElement depositsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Salary']")
    private WebElement salaryButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Savings']")
    private WebElement savingsButton;

    public void enterValues(String income) {
        switch (income) {
            //Case statements
            case "Deposits":
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(depositsButton).click();
                break;
            case "Salary":
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(salaryButton).click();
                break;
            case "Savings":
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(savingsButton).click();
                break;
        }
    }
}
