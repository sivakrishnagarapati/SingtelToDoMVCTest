package com.singtel.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.singtel.pageobjectrepository.ToDoPageObjects;

public class ToDoActions {
	public WebDriver driver;
	ToDoPageObjects todoOR;
	Actions actions;

	public ToDoActions(WebDriver driver) {
		this.driver = driver;
		todoOR = new ToDoPageObjects(driver);
		actions = new Actions(driver);

	}

	public void enterAllTasksInTheTextBox(String listoftasks) {
		String[] listarray = listoftasks.split(",");
		try {
			for (int i = 0; i < listarray.length; i++) {
				driver.findElement(todoOR.textbox).sendKeys(listarray[i]);
				actions.sendKeys(Keys.ENTER).perform();
				if (i == listarray.length - 1) {
					Assert.assertTrue(true);
					System.out.println("All the tasks are entered successfully");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void validateAllTasksUnderAllFilter(String listoftasks) {
		try {
			List<String> listfromff = new ArrayList<String>(Arrays.asList(listoftasks.split(",")));
			if (driver.findElement(todoOR.allfilter).getAttribute("class").equalsIgnoreCase("selected")) {
				int numberoftasks = driver.findElements(todoOR.tasksafteradding).size();
				List<String> listfromui = new ArrayList<String>();
				for (int i = 0; i < numberoftasks; i++) {
					String task = driver.findElements(todoOR.tasksafteradding).get(i).getText();
					listfromui.add(task);
				}
				if (listfromff.equals(listfromui) == true) {
					System.out.println("Tasks list from Feature file is matching with tasks list from UI");
				} else {
					System.out.println("Tasks list from Feature file is not matching with tasks list from UI");
				}
			} else {
				System.out.println("All tab is not selected by default");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateNumberOfTasksAdded(String numberoftasks) {
		try {
			if (driver.findElement(todoOR.numbertasksfromui).getText().equalsIgnoreCase(numberoftasks)) {
				System.out.println(numberoftasks + " is displayed");
			} else {
				System.out.println("There is miss match in the number of tasks added");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void validateAllTasksUnderActiveFilter(String listoftasks) {
		try {
			driver.findElement(todoOR.activefilter).click();
			List<String> listfromff = new ArrayList<String>(Arrays.asList(listoftasks.split(",")));
			if (driver.findElement(todoOR.activefilter).getAttribute("class").equalsIgnoreCase("selected")) {
				int numberoftasks = driver.findElements(todoOR.tasksafteradding).size();
				List<String> listfromui = new ArrayList<String>();
				for (int i = 0; i < numberoftasks; i++) {
					String task = driver.findElements(todoOR.tasksafteradding).get(i).getText();
					listfromui.add(task);
				}
				if (listfromff.equals(listfromui) == true) {
					System.out.println("Tasks list from Feature file is matching with tasks list from UI");
				} else {
					System.out.println("Tasks list from Feature file is not matching with tasks list from UI");
				}
			} else {
				System.out.println("All tab is not selected by default");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateAllTasksUnderCompletedFilterWhenNoTasksArePresent() {
		try {
			driver.findElement(todoOR.completedfilter).click();
			if (driver.findElement(todoOR.completedfilter).getAttribute("class").equalsIgnoreCase("selected")) {
				try {
					int numberoftasks = driver.findElements(todoOR.tasksafteradding).size();
					if (numberoftasks == 0) {
						System.out.println("There are no tasks which are currently completed");
					}
				} catch (Exception NoSuchElementException) {
					System.out.println("There are no tasks which are currently completed");
				}

			} else {
				System.out.println("Completed tab is not selected by default");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void makeTaskAsComplete(String task) {
		try {
			driver.findElement(By.xpath("//label[text()='" + task + "']/preceding-sibling::input")).click();
			System.out.println(task + " task completed successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void makeTaskAsInComplete(String task) {
		try {
			driver.findElement(By.xpath("//label[text()='" + task + "']/preceding-sibling::input")).click();
			System.out.println(task + " task is incompleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void validateTaskCompletedAndNumberOfTasksLeft(String task, String numberoftasksleft) {

		try {
			WebElement completetask = driver.findElement(By.xpath("//label[text()='" + task + "']/ancestor::li"));
			if (completetask.getAttribute("class").equalsIgnoreCase("todo completed")) {
				validateNumberOfTasksAdded(numberoftasksleft);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void validateTasksUnderActiveTabWhenOneTaskIsCompleted(String lefttasks, String completedtask) {

		try {
			validateAllTasksUnderActiveFilter(lefttasks);
			System.out.println(completedtask + " is not present under Active tab");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void validateAllTasksUnderCompletedFilter(String completedtasks) {
		try {
			driver.findElement(todoOR.completedfilter).click();
			List<String> listfromff = new ArrayList<String>(Arrays.asList(completedtasks.split(",")));
			if (driver.findElement(todoOR.completedfilter).getAttribute("class").equalsIgnoreCase("selected")) {
				int numberoftasks = driver.findElements(todoOR.tasksafteradding).size();
				List<String> listfromui = new ArrayList<String>();
				for (int i = 0; i < numberoftasks; i++) {
					String task = driver.findElements(todoOR.tasksafteradding).get(i).getText();
					listfromui.add(task);
				}
				if (listfromff.equals(listfromui) == true) {
					System.out.println("Tasks list from Feature file is matching with tasks list from UI");
				} else {
					System.out.println("Tasks list from Feature file is not matching with tasks list from UI");
				}
			} else {
				System.out.println("Completed tab is not selected");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clearCompleted() {
		try {
			driver.findElement(todoOR.clearcompleted).click();
			System.out.println("Clear completed option is clicked successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void markAllAsComplereOrInComplete() {
		try {
			driver.findElement(todoOR.markallascomplete).click();
			System.out.println("Mark All as Completed or InComplete is clicked successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void validateAllTasksCompletedAndNumberOfTasksLeft(String numberoftasksleft) {

		try {
			List<WebElement> completetask = driver.findElements(todoOR.todolist);
			int numberoftasks = completetask.size();
			for (int i = 0; i < numberoftasks; i++) {
				if (completetask.get(i).getAttribute("class").equalsIgnoreCase("todo completed")) {
					if (i == numberoftasks - 1) {
						validateNumberOfTasksAdded(numberoftasksleft);
					}
				} else {
					System.out.println("Complete All option is not working as expected");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickOnAllTabAndMarkAllAsComplereOrInComplete() {
		try {
			driver.findElement(todoOR.allfilter).click();
			driver.findElement(todoOR.markallascomplete).click();
			System.out.println("Mark All as Completed or InComplete is clicked successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void removeAllTheTasks() {

		try {
			for (int i = 0; i < 5; i++) {
				actions.moveToElement(driver.findElement(By.xpath("(//ul[@class='todo-list']/li)[1]"))).build()
						.perform();
				driver.findElement(By.xpath("(//button[@class='destroy'])[1]")).click();
			}
			System.out.println("Removed all the tasks successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void validateWhenNoTasksArePresent() {
		try {
			try {
				int numberoftasks = driver.findElements(todoOR.tasksafteradding).size();
				if (numberoftasks == 0) {
					System.out.println("There are no tasks present under todo list");
				}
			} catch (Exception NoSuchElementException) {
				System.out.println("There are no tasks present under todo list");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closedriver() {
		driver.quit();
	}

}
