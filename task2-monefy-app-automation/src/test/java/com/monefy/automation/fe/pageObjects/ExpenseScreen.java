package com.monefy.automation.fe.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ExpenseScreen extends PageObject {
    @Managed(driver = "appium")
    WebDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bills']")
    private WebElement billsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Car']")
    private WebElement carButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Clothes']")
    private WebElement clothesButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Communications']")
    private WebElement communicationsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Eating out']")
    private WebElement eatingOutButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Entertainment']")
    private WebElement entertainmentButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Food']")
    private WebElement foodButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gifts']")
    private WebElement giftsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Health']")
    private WebElement healthButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='House']")
    private WebElement houseButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Pets']")
    private WebElement petsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sports']")
    private WebElement sportsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Taxi']")
    private WebElement taxiButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Toiletry']")
    private WebElement toiletryButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Transport']")
    private WebElement transportButton;

    public void enterValues(String expense) {
        switch (expense) {
            case "Bills":
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(billsButton).click();
                break;
            case "Car":
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(carButton).click();
                break;
            case "Clothes":
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(clothesButton).click();
                break;
            case "Communications":
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(communicationsButton).click();
                break;
            case "Eating out":
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(eatingOutButton).click();
                break;
            case "Entertainment":
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(entertainmentButton).click();
                break;
            case "Food":
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(foodButton).click();
                break;
            case "Gifts":
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(giftsButton).click();
                break;
            case "Health":
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(healthButton).click();
                break;
            case "House":
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(houseButton).click();
                break;
            case "Pets":
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(petsButton).click();
                break;
            case "Sports":
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(sportsButton).click();
                break;
            case "Taxi":
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(taxiButton).click();
                break;
            case "Toiletry":
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(toiletryButton).click();
                break;
            case "Transport":
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(transportButton).click();
                break;
        }
    }
}
