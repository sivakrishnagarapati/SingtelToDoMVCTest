package com.singtel.commonactions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	public static WebDriver driver;
	public static Properties prop;

	public static WebDriver getDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\global.properties");
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
	}
}
