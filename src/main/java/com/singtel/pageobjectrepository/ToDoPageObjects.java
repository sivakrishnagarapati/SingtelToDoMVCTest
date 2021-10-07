package com.singtel.pageobjectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToDoPageObjects {
	public WebDriver driver;

	public ToDoPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public By textbox = By.xpath("//input[@autofocus='autofocus']");
	public By allfilter = By.xpath("//a[text()='All']");
	public By tasksafteradding = By.xpath("//li/div/label");
	public By numbertasksfromui = By.xpath("//span[@class='todo-count']");
	public By activefilter = By.xpath("//a[text()='Active']");
	public By completedfilter = By.xpath("//a[text()='Completed']");
	public By clearcompleted = By.xpath("//button[@class='clear-completed']");
	public By markallascomplete = By.xpath("//label[text()='Mark all as complete']");
	public By todolist = By.xpath("//ul[@class='todo-list']/li");
	public By removetasks = By.xpath("//button[@class='destroy']");

}
