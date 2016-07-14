package it.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	static String string = "name=amtonio materia=informatica aaa=bbb";
	
	public static Map<String, String> regExp2 (String s){
		Map<String , String> m = new HashMap<>();
		String pref="", suff="";
		
		ArrayList<String> l = new ArrayList<>(Arrays.asList(s.split(" ")));

		
		for(String str : l){
			Pattern p1 = Pattern.compile("^[a-zA-Z]+=");
			Pattern p2 = Pattern.compile("=[a-zA-Z]+");
			Matcher m1 = p1.matcher(str);
			Matcher m2 = p2.matcher(str);
			
			if(m1.find()){
				pref = str.substring(m1.start(),m1.end()-1);
			}
			if(m2.find()){
			    suff = str.substring(m2.start()+1,m2.end());
			}
			
			m.put(pref, suff);
		}
		return m;
	}
	
	public static void main(String[] args) {
		
		for( String s : regExp(string).keySet()){
			System.out.println("key : "+s+" - value : "+regExp(string).get(s));
		}
		
		System.out.println(regExp2(string));
		
	}
		
}
