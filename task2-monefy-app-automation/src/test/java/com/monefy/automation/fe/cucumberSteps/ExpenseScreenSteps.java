package com.monefy.automation.fe.cucumberSteps;

import com.monefy.automation.fe.pageObjects.ExpenseScreen;
import net.thucydides.core.annotations.Step;

public class ExpenseScreenSteps {
    ExpenseScreen expenseScreen;

    @Step
    public void clickingOnExpenseButton(String expenseSource) {
        expenseScreen.enterValues(expenseSource);
    }
}
