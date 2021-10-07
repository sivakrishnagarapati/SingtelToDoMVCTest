package stepDefinations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.singtel.actions.ToDoActions;
import com.singtel.commonactions.Base;
import com.singtel.commonactions.Screenshot;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefination {
	public WebDriver driver = null;
	Screenshot screenshot;
	ToDoActions todoactions;

	@Given("^Browser is launched and todos web URL is entered$")
	public void browser_is_launched_and_todos_web_url_is_entered() throws Throwable {
		driver = Base.getDriver();

	}

	@After
	public void hook3() throws IOException

	{
		todoactions = new ToDoActions(driver);
		todoactions.closedriver();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {

		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "image");

	}

	@When("^user enters all the tasks \"([^\"]*)\" in the text box and hit enter one after the other$")
	public void user_enters_all_the_tasks_in_the_text_box_and_hit_enter_one_after_the_other(String listoftasks)
			throws Throwable {
		todoactions = new ToDoActions(driver);
		todoactions.enterAllTasksInTheTextBox(listoftasks);
	}

	@Then("^All the tasks \"([^\"]*)\" should be added as list under All tab$")
	public void all_the_tasks_should_be_added_as_list_under_all_tab(String listoftasks) throws Throwable {
		todoactions = new ToDoActions(driver);
		todoactions.validateAllTasksUnderAllFilter(listoftasks);
	}

	@And("^user validates numbers tasks \"([^\"]*)\" added to the list$")
	public void user_validates_numbers_tasks_added_to_the_list(String numberoftasks) throws Throwable {
		todoactions = new ToDoActions(driver);
		todoactions.validateAllTasksUnderAllFilter(numberoftasks);
	}

	@And("^user clicks on Active tab and ensure all the tasks \"([^\"]*)\" are showing$")
	public void user_clicks_on_active_tab_and_ensure_all_the_tasks_are_showing(String listoftasks) throws Throwable {
		todoactions = new ToDoActions(driver);
		todoactions.validateAllTasksUnderActiveFilter(listoftasks);
	}

	@And("^user clicks on Completed tab and ensure no tasks are showing$")
	public void user_clicks_on_completed_tab_and_ensure_no_tasks_are_showing() throws Throwable {
		todoactions = new ToDoActions(driver);
		todoactions.validateAllTasksUnderCompletedFilterWhenNoTasksArePresent();
	}

	@Then("^user validates \"([^\"]*)\" task turned to completed and number of tasks left should become \"([^\"]*)\" under All tab$")
	public void user_validates_task_turned_to_completed_and_number_of_tasks_left_should_become_under_all_tab(
			String todoitemtocomplete, String numberoftasksleft) throws Throwable {
		todoactions = new ToDoActions(driver);
		todoactions.validateTaskCompletedAndNumberOfTasksLeft(todoitemtocomplete, numberoftasksleft);

	}

	@And("^user clicks on check box for \"([^\"]*)\" task in order to complete it$")
	public void user_clicks_on_check_box_for_task_in_order_to_complete_it(String todoitemtocomplete) throws Throwable {
		todoactions = new ToDoActions(driver);
		todoactions.makeTaskAsComplete(todoitemtocomplete);
	}

	@And("^user clicks on Active tab and ensure all the tasks \"([^\"]*)\" should be displaying except \"([^\"]*)\" task$")
	public void user_clicks_on_active_tab_and_ensure_all_the_tasks_should_be_displaying_except_task(String itemsleft,
			String todoitemtocomplete) throws Throwable {
		todoactions = new ToDoActions(driver);
		todoactions.validateTasksUnderActiveTabWhenOneTaskIsCompleted(itemsleft, todoitemtocomplete);
	}

	@And("^user clicks on Completed tab and ensure \"([^\"]*)\" task is displaying$")
	public void user_clicks_on_completed_tab_and_ensure_task_is_displaying(String todoitemtocomplete) throws Throwable {
		todoactions = new ToDoActions(driver);
		todoactions.validateAllTasksUnderCompletedFilter(todoitemtocomplete);

	}

	@And("^user clicks on check box for \"([^\"]*)\" task in order to incomplete it$")
	public void user_clicks_on_check_box_for_task_in_order_to_incomplete_it(String todoitemtocomplete)
			throws Throwable {
		todoactions = new ToDoActions(driver);
		todoactions.makeTaskAsInComplete(todoitemtocomplete);
	}

	@And("^user clicks on Clear completed option$")
	public void user_clicks_on_clear_completed_option() throws Throwable {
		todoactions = new ToDoActions(driver);
		todoactions.clearCompleted();
	}

	@And("^user clicks on select all check box in order to complete all the tasks$")
	public void user_clicks_on_select_all_check_box_in_order_to_complete_all_the_tasks() throws Throwable {
		todoactions = new ToDoActions(driver);
		todoactions.markAllAsComplereOrInComplete();
	}

	@Then("^user validates \"([^\"]*)\" tasks turned to completed and number of tasks left should become \"([^\"]*)\" under All tab$")
	public void user_validates_tasks_turned_to_completed_and_number_of_tasks_left_should_become_under_all_tab(
			String listoftasks, String numberoftasksleft) throws Throwable {
		todoactions = new ToDoActions(driver);
		todoactions.validateAllTasksCompletedAndNumberOfTasksLeft(numberoftasksleft);
	}

	@And("^user clicks on Completed tab and ensure \"([^\"]*)\" tasks are displaying$")
	public void user_clicks_on_completed_tab_and_ensure_tasks_are_displaying(String listoftasks) throws Throwable {
		todoactions = new ToDoActions(driver);
		todoactions.validateAllTasksUnderCompletedFilter(listoftasks);
	}

	@And("^user clicks on All tab and select all check box in order to incomplete all the tasks$")
	public void user_clicks_on_all_tab_and_select_all_check_box_in_order_to_incomplete_all_the_tasks()
			throws Throwable {
		todoactions = new ToDoActions(driver);
		todoactions.clickOnAllTabAndMarkAllAsComplereOrInComplete();
	}

	@And("^user clicks on cross mark beside each task$")
	public void user_clicks_on_cross_mark_beside_each_task() throws Throwable {
		todoactions = new ToDoActions(driver);
		todoactions.removeAllTheTasks();
	}

	@Then("^All the tasks should be removed under All tab$")
	public void all_the_tasks_should_be_removed_under_all_tab() throws Throwable {
		todoactions = new ToDoActions(driver);
		todoactions.validateWhenNoTasksArePresent();
	}

	@And("^user validates numbers tasks \"([^\"]*)\" should be displayed under All tab$")
	public void user_validates_numbers_tasks_should_be_displayed_under_all_tab(String numberoftasksleft)
			throws Throwable {
		todoactions = new ToDoActions(driver);
		todoactions.validateNumberOfTasksAdded(numberoftasksleft);
	}

}
