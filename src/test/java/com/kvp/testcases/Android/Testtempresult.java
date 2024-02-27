package com.kvp.testcases.Android;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class Testtempresult {

	@Test
	public void skipVerification() {
	 throw new SkipException("this execution skipped");
			
	}
}
