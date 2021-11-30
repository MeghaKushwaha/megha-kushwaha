package com.monefy.automation.fe.serenityDefinitions;

import com.monefy.automation.fe.cucumberSteps.HomeScreenSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class HomeScreenDefinition {
    @Steps
    HomeScreenSteps homeScreenSteps;

    String availableBalanceOfIncome;
    String availableBalanceOfExpense;

    double incomeBalance, expenseBalance;

    @And("user clicks on income button")
    public void userClicksOnIncomeButton() {
        homeScreenSteps.clickingOnIncomeButton();
    }


    @Given("income balance as {string}")
    public void balanceAs(String availableBalance) {
        availableBalanceOfIncome = homeScreenSteps.gettingIncomeAmount();
        Assert.assertEquals(availableBalance, availableBalanceOfIncome);
    }


    @Then("income balance should be {string}")
    public void balanceShouldBe(String newBalance) {
        availableBalanceOfIncome = homeScreenSteps.gettingIncomeAmount();
        Assert.assertEquals(newBalance, availableBalanceOfIncome);
    }

    @And("user clicks on expense button")
    public void userClicksOnExpenseButton() {
        homeScreenSteps.clickingOnExpenseButton();
    }

    @Then("expense balance should be {string}")
    public void expenseBalanceShouldBe(String expenseBalance) {
        availableBalanceOfExpense = homeScreenSteps.gettingExpenseAmount();
        Assert.assertEquals(expenseBalance, availableBalanceOfExpense);
    }

    @Given("expense balance as {string}")
    public void expenseBalanceAs(String expenseBalance) {
        availableBalanceOfExpense = homeScreenSteps.gettingExpenseAmount();
        Assert.assertEquals(expenseBalance, availableBalanceOfExpense);
    }

    @And("Checking")
    public void checking() {
        homeScreenSteps.clickingChecking();
    }

    @Given("income and expense")
    public void incomeAndExpense() {

        availableBalanceOfIncome = homeScreenSteps.gettingIncomeAmount();
        availableBalanceOfExpense = homeScreenSteps.gettingExpenseAmount();

        incomeBalance = Double.parseDouble(availableBalanceOfIncome.substring(1));
        expenseBalance = Double.parseDouble(availableBalanceOfExpense.substring(1));

    }

    @Then("Balance is equal to Income minus Expense")
    public void balanceIsIncomeMinusExpense() {
        String balance = homeScreenSteps.checkingBalance();
        String[] arr = balance.split("\\$");
        double balanceAmount= Double.parseDouble(arr[1]);
        double amountAfterSubstraction = Math.abs(incomeBalance-expenseBalance);

        Assert.assertEquals(balanceAmount, amountAfterSubstraction, 0.001);
    }
}
