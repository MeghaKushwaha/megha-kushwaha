package com.monefy.automation.fe.cucumberSteps;

import com.monefy.automation.fe.pageObjects.SelectMoneyScreen;
import net.thucydides.core.annotations.Step;

public class SelectMoneyScreenSteps {

    SelectMoneyScreen selectMoneyScreen;

    @Step
    public void enteringValues(int number){
        selectMoneyScreen.enterValues(number);
    }

    @Step
    public void choosingCategory(){
        selectMoneyScreen.chooseCategory();
    }
}
