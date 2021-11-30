package com.monefy.automation.fe.cucumberSteps;

import com.monefy.automation.fe.pageObjects.HomeScreen;
import net.thucydides.core.annotations.Step;

public class HomeScreenSteps {

    HomeScreen homeScreen;

    @Step
    public void clickingOnIncomeButton() {
        homeScreen.clickIncomeButton();
    }

    @Step
    public void clickingOnExpenseButton() {
        homeScreen.clickExpenseButton();
    }

    @Step
    public String gettingIncomeAmount() {
        return homeScreen.incomeAmount();
    }

    @Step
    public String gettingExpenseAmount() {
        return homeScreen.expenseAmount();
    }

    @Step
    public void clickingChecking(){
        homeScreen.checking();
    }

    @Step
    public String checkingBalance(){return homeScreen.balanceAmount();}



}
