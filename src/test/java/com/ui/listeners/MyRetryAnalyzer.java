package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	private static final int MAX_NUMBER_OF_ATTEMPS = 2;
	private static int currentAttempts = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (currentAttempts <= MAX_NUMBER_OF_ATTEMPS) {
			currentAttempts++;
			return true;
		}

		return false;
	}

}
