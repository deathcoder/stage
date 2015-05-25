package it.objectway.corsi.mocktest;

import it.objectway.corsi.mocktest.interfaces.MyClassInterface;
import it.objectway.corsi.mocktest.interfaces.SuperCalculatorInterface;

import java.util.Date;



public class MyClass implements MyClassInterface {
	private SuperCalculatorInterface sc;
	
	public String doSomething(String a, String b, boolean c){
		
		String s="OK";
		
		if (a!=null && b!=null){
			if (c){
				return a+b;
			}else{
				return b+a;
			}
		}
		
		return s;
		
	}
	
	
	public int calculate(String action, int a, int b){
		int calc=0;
		if ("sum".equals(action)){
			calc= a+b;
		}else{
			calc= sc.calc(action, a,b);
		}
		
		if (calc>(a+b)){
			return a*b;
		}

		return calc;
		
		
	
	}
	
	
	public Date retrieveDate(Date d) throws Exception {
		Thread.sleep(100l);
		Date now = getNow();
		
		if (d.before(now)) {
			return now;
		}else{
			return d;
		}
	}
	
	
	
	public void setSuperCalculator(SuperCalculatorInterface sci){
		sc=sci;
	}

	public Date getNow(){
		return new Date();
	}
}
