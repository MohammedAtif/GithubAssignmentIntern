package com.zemoso.githubtask.assignment.services;

import com.zemoso.githubtask.assignment.services.impl.PostfixCalculationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CalculationServiceTest {

	private CalculationService calculationService;

	@Before
	public void setup() {
		calculationService = new PostfixCalculationService();
	}

	@Test
	public void testResultInt() {
		
	}

	@Test
	public void testResultFloat() {

		
	}

	@Test
	public void testResultLong() {
		
	}

	@Test
	public void testResultDouble() {

	}

}
