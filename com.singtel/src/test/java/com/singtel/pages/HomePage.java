package com.singtel.pages;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.canvas.WebGLActiveInfo;
import com.singtel.utilities.BrowserActions;
import com.singtel.utilities.Utils;




public class HomePage extends BrowserActions{
	
	@FindBy (xpath="//input[@autofocus='autofocus']")
	WebElement todoTxt;
	
	@FindBy (xpath="//span[@class='todo-count']")
	WebElement todoListCountTxt;
	
	@FindBy(xpath="//button[@class='destroy']")
	WebElement removeBtn;
	
	@FindBy(css="//label[text()='Need to send email for card approval']")
	WebElement removedItem;
	
	String filterButtons = "//a[text()='";
	
	@FindBy(xpath ="//button[@class='clear-completed']")       
	WebElement clearCompletedBtn; 
	
	@FindBy(xpath ="//label[text()='Mark all as complete']")       
	WebElement selectAllTodoListBtn; 
	
	@FindBy(xpath ="//div[@class='header-navigation']//nav[@class='header__nav header__nav--categories']")       
	WebElement categoriesTxt;
	
	String todoListTxt = "//label[text()='";
	String filtersBtn = "//ul[@class='filters']/li/a[text()='";
	
	String completeCheckBox= "/preceding::input[@type='checkbox'][1]";
	
	@FindBy(xpath="//div[@class='header__user-menu-item']/following-sibling::div/a[text()='Log out']")
	WebElement logoutTxt;
	      
	String todoListCount = "//span[@class='todo-count']/strong[text()='";

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public  void enterTodoList(WebDriver driver, String todo) throws Exception{
		BrowserActions.typeOnTextField(todoTxt, todo, driver, "Entered todo action item");
		BrowserActions.pressEnter(driver,todoTxt,"Press Enter Key");
	}
	
	public void verifyTodoList(WebDriver driver,String todoList) throws Exception {
		WebElement createdTodoList = driver.findElement(By.xpath(todoListTxt+todoList +"']"));
		Assert.assertTrue(BrowserActions.elementDisplayed(driver, createdTodoList));
	}
	
	public void verifyTodoCount(WebDriver driver,String listCount) throws Exception {
		WebElement createdTodoListCount = driver.findElement(By.xpath(todoListCount+listCount +"']"));
		Assert.assertTrue(BrowserActions.elementDisplayed(driver, createdTodoListCount));
	}
	
	public void verifyFilterButtons(WebDriver driver,String filterName) throws Exception {
		WebElement filterButtons = driver.findElement(By.xpath(filtersBtn+filterName +"']"));
		Assert.assertTrue(BrowserActions.elementDisplayed(driver, filterButtons));
	}
	
	public void removeTodoList(WebDriver driver,String todoList) throws Exception {
		WebElement createdTodoList = driver.findElement(By.xpath(todoListTxt+todoList +"']"));
		BrowserActions.mouseHover(driver,createdTodoList);
		BrowserActions.clickOnButton(removeBtn, driver, "Clicked remove button");
	}
	
	public void selectCompleteTodoItemRadioButton(WebDriver driver,String todoList) throws Exception {
		WebElement createdTodoList = driver.findElement(By.xpath(todoListTxt+todoList +"']"+completeCheckBox));
		System.out.println("This is the Completed X-Path :"+ createdTodoList);
		Thread.sleep(5000);
		BrowserActions.clickOnButton(createdTodoList, driver, "Clicked completed checkbox button");
	}
	
	public void selectAllTodoItemRadioButton(WebDriver driver) throws Exception {
		Thread.sleep(3000);
		BrowserActions.clickOnButton(selectAllTodoListBtn, driver, "Clicked all todo list completed checkbox button");
	}
	
	public void verifyRemovedTodoListItem(WebDriver driver) throws Exception {
		Assert.assertFalse(BrowserActions.elementDisplayed(driver, removedItem));
	}
	
	public void clickFilterButtons(WebDriver driver,String filterName) throws Exception {
		Thread.sleep(3000);
		WebElement filterBtns = driver.findElement(By.xpath(filterButtons+filterName +"']"));
		BrowserActions.clickOnButton(filterBtns, driver, "Clicked on "+filterName+"button");
	}
	
	public void verifyStrikeThroughTodoList(WebDriver driver,String todoList) throws Exception {
		WebElement createdTodoList = driver.findElement(By.xpath(todoListTxt+todoList +"']"));
		System.out.println("This is Attribute :"+createdTodoList.getCssValue("text-decoration"));
		if(createdTodoList.getCssValue("text-decoration").contains("line-through solid")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);	
		}
	}
	
	public void clickClearCompletedButton(WebDriver driver) throws Exception {
		BrowserActions.clickOnButton(clearCompletedBtn, driver, "Clicked on the clear completed button");
	}
	
	public void editTodoListItem(WebDriver driver,String todoList,String editedTodoItem) throws Exception {
		WebElement editedTodoList = driver.findElement(By.xpath(todoListTxt+todoList +"']"));
		BrowserActions.doubleClick(driver, editedTodoList);
		BrowserActions.editExistingTodoItem(driver, editedTodoList, editedTodoItem, "Edited existing completed todo list");
		BrowserActions.pressEnter(driver,todoTxt,"Press Enter Key");
	}
	
	}
