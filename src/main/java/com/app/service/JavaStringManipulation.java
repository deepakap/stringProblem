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
	
	public String removeCharacter(String str, char c){
		String result="";
		List<Character> charList = new ArrayList<Character>();
		for(char cr:str.toCharArray()){
			charList.add(cr);
		}
		Iterator<Character> itr = charList.iterator();
		while(itr.hasNext()){
			char value = itr.next();
			if(c == (Character.toLowerCase(value) | value)){
				itr.remove();
			}else{
				result+=value+"";
			}
		}
		return result;
	}
	
	public String removeCharacterJava(String str, char c){
		return str.toLowerCase().replaceAll(c+"","").trim();
	}
	
}
