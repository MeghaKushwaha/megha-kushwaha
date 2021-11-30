package com.monefy.automation.fe.cucumberSteps;

import com.monefy.automation.fe.pageObjects.IncomeScreen;
import net.thucydides.core.annotations.Step;

public class IncomeScreenSteps {
    IncomeScreen incomeScreen;

    @Step
    public void clickingOnIncomeButton(String incomeSource) {
        incomeScreen.enterValues(incomeSource);
    }
}
