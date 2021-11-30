package com.monefy.automation.fe.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class SelectMoneyScreen extends PageObject {

    @Managed(driver = "appium")
    WebDriver driver;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard0")
    private WebElement keyBoardButton0;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard1")
    private WebElement keyBoardButton1;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard2")
    private WebElement keyBoardButton2;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard3")
    private WebElement keyBoardButton3;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard4")
    private WebElement keyBoardButton4;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard5")
    private WebElement keyBoardButton5;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard6")
    private WebElement keyBoardButton6;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard7")
    private WebElement keyBoardButton7;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard8")
    private WebElement keyBoardButton8;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard9")
    private WebElement keyBoardButton9;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboardPlus")
    private WebElement keyBoardButtonPlus;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboardMinus")
    private WebElement keyBoardButtonMinus;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboardDivide")
    private WebElement keyBoardButtonDivide;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboardMultiply")
    private WebElement keyBoardButtonMultiply;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboardEquals")
    private WebElement keyBoardButtonEquals;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboardDot")
    private WebElement keyBoardButtonDot;

    @AndroidFindBy(id = "com.monefy.app.lite:id/keyboard_action_button")
    private WebElement chooseCategoryButton;

    @AndroidFindBy(id = "com.monefy.app.lite:id/amount_text")
    private WebElement textField;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboardClear")
    private WebElement clearButton;

    @AndroidFindBy(id = "com.monefy.app.lite:id/textViewNote")
    private WebElement notesField;

    public void enterValues(int number) {
        switch (number) {
            //Case statements
            case 1:
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(keyBoardButton1).click();
                break;
            case 2:
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(keyBoardButton2).click();
                break;
            case 3:
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(keyBoardButton3).click();
                break;
            case 4:
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(keyBoardButton4).click();
                break;
            case 5:
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(keyBoardButton5).click();
                break;
            case 6:
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(keyBoardButton6).click();
                break;
            case 7:
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(keyBoardButton7).click();
                break;
            case 8:
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(keyBoardButton8).click();
                break;
            case 9:
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(keyBoardButton9).click();
                break;
            case 0:
                withTimeoutOf(Duration.ofSeconds(30)).waitFor(keyBoardButton0).click();
                break;
        }
    }

    public void chooseCategory(){
        chooseCategoryButton.click();
    }

}
