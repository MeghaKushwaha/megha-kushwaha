package com.monefy.automation.fe.serenityDefinitions;

import com.monefy.automation.fe.cucumberSteps.IncomeScreenSteps;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

public class IncomeScreenDefinition {

    @Steps
    IncomeScreenSteps incomeScreenSteps;

    @And("user chooses category as {string}")
    public void userChoosesCategoryAsDeposits(String source) {
        incomeScreenSteps.clickingOnIncomeButton(source);
    }

    @And("wait")
    public void waiting() throws InterruptedException {
        Thread.sleep(10000);
    }
}
