package com.singtel.step_definitions;

import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.singtel.pages.*;
import com.singtel.utilities.BrowserActions;
import com.singtel.utilities.ReadProperties;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStep {
	BrowserActions actions = new BrowserActions();
	WebDriver driver = actions.getInstance();
	public static Properties envProperties = ReadProperties.getPropInstance().testProperties;
	String url = envProperties.getProperty("app.url");
	HomePage homepage = new HomePage(driver);
	
	@Given("^I navigate to singtel application$")
	public void navigate_url() throws InterruptedException{
		actions.open_url(url);
	}     
	
	 @And("I closed the browser$")
	 public void i_closed_browser() {
		 driver.close();
		 //driver.quit();
	 }
	 
	 @Then("^I create the todays todo list (.+)$")
	 public void createTodoList(String todo) throws Throwable {
	    homepage.enterTodoList(driver, todo); 
	 }

	 @Then("^I verify the created todo list (.+) successfully$")
	 public void VerifyCreatedTodoList(String createdTodoListName) throws Throwable {
	     homepage.verifyTodoList(driver, createdTodoListName);
	 }
	 
	 @Then("^I verify the todo list count (.+) item left$")
	 public void verifyCreatedTodoListCount(String count) throws Throwable {
	     homepage.verifyTodoCount(driver, count);
	 }
	 
	 @Then("^I verify the required buttons on the screen$")
	 public void i_verify_the_required_buttons_on_the_screen(DataTable buttons) throws Throwable {
		 List<String> textMessages;
	        textMessages = buttons.asList(String.class);
	        for (String key : textMessages) {
	           homepage.verifyFilterButtons(driver, key);
	        }
	       
	 }
	 
	 @When("^I remove the (.+) from the todo list$")
	 public void removeTodoList(String removeTodo) throws Throwable {
		 homepage.removeTodoList(driver, removeTodo);
	     
	 }
	 
	 @When("^I mark todo list (.+) to completed status$")
	 public void completedTodoListStatus(String markCompleteStatus) throws Throwable {
	     homepage.selectCompleteTodoItemRadioButton(driver, markCompleteStatus);
	 }
	 
	 @When("^I select all todo list into completed status$")
	 public void allTodoListCompletedStatus() throws Throwable {
		 homepage.selectAllTodoItemRadioButton(driver);
	    
	 }
	 
	 @Then("^I verify the selected item removed successfully$")
	 public void verifyRemovedItems() throws Throwable {
	     homepage.verifyRemovedTodoListItem(driver);
	 }
	 
	 @When("^I click the (.+) filter$")
	 public void clickFilter(String filterName) throws Throwable {
	    homepage.clickFilterButtons(driver, filterName); 
	 }
	 
	 @Then("^I verify the completed todo list (.+) successfully$")
	 public void verifyCompletedTodoList(String completedTodoList) throws Throwable {
	     homepage.verifyTodoList(driver, completedTodoList);
	 }
	 
	 @Then("^I verify the active filter todo list (.+) successfully$")
	 public void verifyActiveFilterTodoLit(String activeTodoList) throws Throwable {
		 homepage.verifyTodoList(driver, activeTodoList);
	 }
	 
	 @Then("^I verify strike through todo list (.+) successfully$")
	 public void verifyStrikeThrough(String strikeThroughTodoList) throws Throwable {
	     homepage.verifyStrikeThroughTodoList(driver, strikeThroughTodoList);
	 }
	 
	 @When("^I click the clear completed button$")
	 public void clickClearCompletedButton() throws Throwable {
	     homepage.clickClearCompletedButton(driver);
	 }
	 
	 @When("^I edit the action item (.+) in todo list (.+)$")
	 public void editTodoItem(String actualTodoItem, String editedTodoItem) throws Throwable {
	     homepage.editTodoListItem(driver, actualTodoItem, editedTodoItem);
	 }
	 
	 @Then("^I verify the edited todo list (.+) successfully$")
	 public void verifyEditedTodoList(String editedTodoList) throws Throwable {
	     homepage.verifyTodoList(driver, editedTodoList);
	 }
	 
	 @Then("^I verify the active todo list (.+) successfully$")
	 public void verifyActiveTodoItem(String activeTodoList) throws Throwable {
		 homepage.verifyTodoList(driver, activeTodoList);
	 }
	 
	 @When("^I mark todo list (.+) back to active status$")
	 public void changeTodoListStatus(String changeStatusTodoItem) throws Throwable {
	     homepage.selectCompleteTodoItemRadioButton(driver, changeStatusTodoItem);
	 }

	 
	
}
