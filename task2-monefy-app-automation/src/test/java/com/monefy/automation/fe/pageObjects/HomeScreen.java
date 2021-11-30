package com.monefy.automation.fe.pageObjects;



import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class HomeScreen extends PageObject{

    @Managed(driver = "appium")
    WebDriver driver;

    @AndroidFindBy(id = "com.monefy.app.lite:id/income_button_title")
    private WebElement incomeButton;

    @AndroidFindBy(id = "com.monefy.app.lite:id/expense_button_title")
    private WebElement expenseButton;

    @AndroidFindBy(id = "com.monefy.app.lite:id/balance_amount")
    private WebElement balanceAmount;

    @AndroidFindBy(id = "com.monefy.app.lite:id/rightLinesImageView")
    private WebElement rightLines;

    @AndroidFindBy(id = "com.monefy.app.lite:id/leftLinesImageView")
    private WebElement leftLines;

    @AndroidFindBy(id = "com.monefy.app.lite:id/income_amount_text")
    private WebElement incomeAmountText;

    @AndroidFindBy(id = "com.monefy.app.lite:id/expense_amount_text")
    private WebElement expenseAmountText;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.monefy.app.lite:id/piegraph']/android.widget.ImageView")
    private List<WebElement> checking;


    public void checking(){
        checking.get(1).click();
    }


    public void clickIncomeButton(){
        withTimeoutOf(Duration.ofSeconds(30)).waitFor(incomeButton).click();
    }

    public void clickExpenseButton(){
        withTimeoutOf(Duration.ofSeconds(30)).waitFor(expenseButton).click();
    }

    public String incomeAmount(){
        return incomeAmountText.getText();
    }

    public String expenseAmount(){
        return expenseAmountText.getText();
    }

    public String balanceAmount(){
        return balanceAmount.getText();
    }

}
