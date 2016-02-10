package org.spring.testapp;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SmokeTest extends SeleniumTest {

	private static WebDriver driver;
	private int imageCounter = 0;

	@BeforeClass
	public static void setUpClass() throws IOException, AWTException {
		driver = new FirefoxDriver();
	}

	@AfterClass
	public static void cleanUp() throws InterruptedException {
		Thread.sleep(10000L);
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}

	@Test
	public void smokeTest() throws InterruptedException, IOException {
		driver.get(getBaseUrl());
		makeScreenShot();
		assertEquals("PetClinic :: a Spring Framework demonstration", driver.getTitle());
	}

	private void makeScreenShot() throws IOException {
		makeScreenshot(driver, getClass(), imageCounter);
		imageCounter++;
	}
}
