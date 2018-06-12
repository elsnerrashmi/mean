package com.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class test1 {

	@Test
	public void test() {
		WebDriver driver = null;
		System.out.println("Hello");
		driver.get("https://www.google.co.in/");
	}

}
