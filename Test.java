package it.test;

import java.util.HashMap;
import java.util.Map;

public class Test {

	static String string = "name=amtonio\nmateria=informatica\naaa=bbb";
	
	public static Map<String,String> regExp(String s){
			
			Map<String , String> m = new HashMap<>();
			String pref = "";
			String suff = "";
			
			boolean sep = false;
			
			for(int i=0; i<s.length() ; i++){
				boolean end = false;
				String c = s.charAt(i)+"";
			//	System.out.println(pref +","+suff);
				if(c.equals("=")) sep = true; 
				else if( c.equals("\n") || s.length() -1 == i) { 
					if(s.length() -1 == i){ suff+=c;}
					m.put(pref, suff); pref=""; suff=""; sep=false; end = true;}
				else if( sep && !c.equals("=") && !end) suff+=c;
				else if( !sep && !c.equals("=") && !end) pref+=c;
				
			}
			return m;
		}
	
	public static void main(String[] args) {
		
		for( String s : regExp(string).keySet()){
			System.out.println("key : "+s+" - value : "+regExp(string).get(s));
		}
		
		
	}
		
}
