package com.app.work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.service.JavaStringManipulation;


public class StringTest {

	public Map<String, String> strMap;

	@BeforeMethod
	public void prepareTestData() {
		// positive and negative cases
		strMap = new Hashtable<String, String>();
		strMap.put("Apple", "pple");
		strMap.put("samsung", "smsung");
		strMap.put("scanaitem", "scnitem");
		strMap.put("Verizon", "Verizon");
		strMap.put("simulator", "simultor");
		strMap.put("", "");
	}

	@Test(enabled = true)
	public void _testStringReplacemt() {
		Iterator itr = strMap.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, String> pair = (Entry<String, String>) itr.next();
			String repString = new JavaStringManipulation()
					.replaceStringWithCharacter(pair.getKey(), 'a');
			Assert.assertEquals(repString.toLowerCase(), pair.getValue()
					.toLowerCase());
		}
	}

	@Test(enabled = true)
	public void testStringReplacemtWithJava() {
		Iterator itr = strMap.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, String> pair = (Entry<String, String>) itr.next();
			String repString = new JavaStringManipulation()
					.replaceStringWithJava(pair.getKey(), 'a');
			Assert.assertEquals(repString.toLowerCase(), pair.getValue()
					.toLowerCase());
		}
	}

	@AfterMethod
	public void tearDownTestData() {
		strMap.clear();
	}

}
