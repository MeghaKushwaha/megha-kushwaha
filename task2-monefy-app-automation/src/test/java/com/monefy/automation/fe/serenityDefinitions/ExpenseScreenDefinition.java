package com.monefy.automation.fe.serenityDefinitions;

import com.monefy.automation.fe.cucumberSteps.ExpenseScreenSteps;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

public class ExpenseScreenDefinition {

    @Steps
    ExpenseScreenSteps expenseScreenSteps;

    @And("user chooses expense category as {string}")
    public void userChoosesCategoryAsDeposits(String source) {
        expenseScreenSteps.clickingOnExpenseButton(source);
    }
}
