/**
 * 
 */
package com.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author deepakkumar
 *
 */
public class JavaStringManipulation {
	
	public String replaceStringWithCharacter(String str, char c){
		String result;
		int stLength = str.length();
		List<Character> charList = new ArrayList<Character>();
		for(int i=0;i< stLength;i++){
			charList.add(str.toLowerCase().charAt(i));
		}
		Iterator<Character> itr = charList.iterator();
		while(itr.hasNext()){
			if(itr.next()==c){
				itr.remove();
			}
		}
		return charList.toString().replaceAll("[,\\s\\[\\]]", "");
	}
	
	
	public String replaceStringWithJava(String str, char c){
		return str.toLowerCase().replaceAll(c+"","").trim();
	}
	
	
}
