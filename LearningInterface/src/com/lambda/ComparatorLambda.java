package com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;


public class ComparatorLambda {
	
	private static List<String> names = new ArrayList<String>();
	
	static {
		
		String [] info =  new String [] { Names.Romil.toString(),Names.Bhagu.toString(),Names.Harshita.toString(),Names.Saroj.toString()};
		
		
		//--> Function functional interface takes a array input and provides a List of String 
		
		Function<String [], List<String>> asList = (arrs) -> {
			List<String> list = Arrays.asList(arrs);
			return list;
		};
		// Invocation of Function Interface apply, actual conversion
		names = asList.apply(info);
	}
	
	public static void main(String[] args) {
		
		
		Comparator<String> comp = (t1, t2) -> {
			if(t1 == t2) return 0;
			return t1.compareTo(t2);
		};
		
		
		names.forEach(ele -> System.out.println("Before sort "+ele));
		
		// --> passing of use defined Comparator to sort method.
		Collections.sort(names, comp);
		
		names.forEach(ele -> System.out.println("After sort "+ele));
	}

}
