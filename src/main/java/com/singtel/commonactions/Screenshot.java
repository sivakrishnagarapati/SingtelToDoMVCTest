package com.singtel.commonactions;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public WebDriver driver;

	public Screenshot(WebDriver driver) {
		this.driver = driver;
	}

	public void takess() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String xyz = timestamp.toString().replace(":", "_");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now);

		FileUtils.copyFile(source, new File("./Screenshots/" + date + "/Screen" + xyz + ".png"));
	}
}
