package com.monefy.automation.fe.serenityDefinitions;

import com.monefy.automation.fe.cucumberSteps.SelectMoneyScreenSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class SelectMoneyDefinitions {

    @Steps
    SelectMoneyScreenSteps selectMoneyScreenSteps;

    @Then("user enters {string} as amount")
    public void userEntersAndAsIncome(String amountEntered) {
        for(int i=0;i<amountEntered.length();i++){
            selectMoneyScreenSteps.enteringValues(Integer.parseInt(String.valueOf(amountEntered.charAt(i))));
        }
    }

    @And("clicks on choose category")
    public void clicksOnChooseCategory() {
        selectMoneyScreenSteps.choosingCategory();
    }
}
