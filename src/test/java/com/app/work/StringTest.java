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
	char removeCharacter;

	@BeforeMethod
	public void prepareTestData() {
		// positive and negative cases with Key as String to be replaced and value is expected string after character removal
		strMap = new Hashtable<String, String>();
		strMap.put("Apple", "pple");
		strMap.put("samsung", "smsung");
		strMap.put("scanaitem", "scnitem");
		strMap.put("Verizon", "Verizon");
		strMap.put("simulator", "simultor");
		strMap.put("scan and Buy", "scn nd Buy");
		strMap.put("deepak.ap64@gmail.com", "deepk.p64@gmil.com");
		strMap.put("", "");
		removeCharacter = 'a';
	}

	@Test(enabled = true)
	public void _testStringReplacemt() {
		Iterator itr = strMap.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, String> pair = (Entry<String, String>) itr.next();
			String repString = new JavaStringManipulation()
					.removeCharacter(pair.getKey(), removeCharacter);
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
					.removeCharacterJava(pair.getKey(), removeCharacter);
			Assert.assertEquals(repString.toLowerCase(), pair.getValue()
					.toLowerCase());
		}
	}

	@AfterMethod
	public void tearDownTestData() {
		strMap.clear();
		removeCharacter='\0';
	}

}
