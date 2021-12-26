package com.lambda;

import java.time.LocalDate;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class Lambda {
	
	private static Collection<String> names = new ArrayList<String>();
	private static HashMap<Integer, String> records = new HashMap<Integer, String>();
	
	// it will consume the object that is derived from Abstract collection of any type
	private BiFunction<? extends Collection<String>, String, Boolean>  findElement = (element, find) -> {
		
		for(String ele : element) {
			if(ele.equals(find)) {
				return true;
			}
		}
		
		return false;
	};
	
	static {
		//names = Arrays.asList(new String [] { Names.Romil.toString(),Names.Bhagu.toString(),Names.Harshita.toString(),Names.Saroj.toString()});
		String [] info =  new String [] { Names.Romil.toString(),Names.Bhagu.toString(),Names.Harshita.toString(),Names.Saroj.toString()};
		
		java.util.function.Function<String [], List<String>> asList = elements -> {
			return  Arrays.asList(elements);
		};
		names = asList.apply(info);
		
		
		
		records.put(1,Names.Romil.toString());
		records.put(2,Names.Bhagu.toString());
		records.put(3,Names.Harshita.toString());
		records.put(4,Names.Saroj.toString());
		
	}
	
	
	
	private static Consumer<String> display = (ele) -> {
		System.out.println("Hello function "+ele);
	};
	
	@FunctionalInterface
	// Locator Function interface, that will accept the collection of type T.
	interface FunctionLocator <T extends String, L extends Collection<T>> {
		T locate (L collection, T element);
	}
	
	private FunctionLocator locator = (collection, ele) -> {
		
		
		for (Object element : collection) {
			String eleStr = (String) element;
			if(eleStr.equals(ele)) return eleStr;
		}
		
		return null;
		
	};
	
	public static void main(String[] args) {
		
		Lambda obj = new Lambda();
		final String select = "Romil";
		
		// Below foreach only accept a Consumer Interface
		// Inline Lambda expression
		Lambda.names.forEach((ele) -> {
			System.out.println("Hello "+ele);
		});
		
		// Pre-Lambda declaration
		Lambda.names.forEach(display);
		
		
		String result = obj.locator.locate(names, "Romil");
		System.out.println("Locate "+result);
		
		
		
		Lambda.records.forEach((key, value) -> {
			
			System.out.println(" Key "+key+" value "+value);
			
		});
		
		Predicate<String> predicate = (filter) -> {
			if(filter.equals("RomilX")) return true;
			return false;
		};
		
		Lambda.names.forEach(element -> {
			boolean found = predicate.test(element);
			if(found) {
				System.out.println("Found");
			} else {
				
			}
		});
		
		
		
	}

	
	
	
	

}
