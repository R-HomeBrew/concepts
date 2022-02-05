package com.streams.handson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import com.stream.model.Person;





public class HandsOn {
	
	private static Collection<String> names = new ArrayList<String>();
	private static HashMap<Integer, String> records = new HashMap<Integer, String>();
	private static String [] namesArr = null;

	static {
		//names = Arrays.asList(new String [] { Names.Romil.toString(),Names.Bhagu.toString(),Names.Harshita.toString(),Names.Saroj.toString()});
		String [] info =  new String [] { Names.Romil.toString(),Names.Bhagu.toString(),Names.Harshita.toString(),Names.Saroj.toString()};
		namesArr = info;
		names = Arrays.asList(info);
		records.put(1,Names.Romil.toString());
		records.put(2,Names.Bhagu.toString());
		records.put(3,Names.Harshita.toString());
		records.put(4,Names.Saroj.toString());
		
	}
	
	
	public static void main(String[] args) {
		
		HandsOn obj = new HandsOn();
		// Empty Stream
		obj.emptyStreamHandsOn();
		
		// Stream from collection
		obj.streamFromCollection(names);
		
		//stream from arrays 
		
		
		// from map 
		Map<Integer, Person> map = new HashMap<Integer, Person>();
		map.put(1, new Person("Romil"));
		map.put(2, new Person("Bhagu"));
		obj.streamFromMap2(map);
	}
	/*
	 * Find a person bound by a key xxx
	 */
	public void streamFromMap(Map<Integer, Person> map) {
		for(Integer key : map.keySet()) {
			if(key == 1) {
				System.out.println("Hello "+map.get(key));
			}
		}
	}
	
	public void streamFromMap2(Map<Integer, Person> map) {
		System.out.println("From streamFromMap2 "+map.get(map.keySet().stream().filter(key -> key == 3).findFirst().get()));
	}
	
	public void emptyStreamHandsOn() {
		// 1. Empty stream : Stream.empty();
		Stream<String> stream = Stream.empty();
		Optional<Stream<String>> strOption = Optional.ofNullable(stream);
		if(strOption.isPresent()) {
			strOption.ifPresent(strm -> {
				// strm -> stream 
				if(strm.count() == 0) { // stream consumption : results into closing
					// any further operation: IllegalStateException: stream has already been operated upon or closed.
					System.out.println("Empty Stream");
				} else {
					System.out.println("Non Emmpty Stream");
				}
			});
		}
	}
	
	
	public void streamFromCollection(Collection<String> list) {
		// 2. Create  Stream from Collection
		Stream<String> stream = list.stream();
		Optional<Stream> strmOption = Optional.ofNullable(stream);
		strmOption.ifPresent(strm -> {
			System.out.println("Non Empty Stream"+Thread.currentThread().getName());
			Stream onlyRomils = strm.filter( str -> str.equals("Romil"));
			displayStream(onlyRomils);
			
		});
	}
	
	public void streamFromArray(String [] names) {
		 Stream<String> strmNames = Arrays.stream(names);
		 Optional<Stream> optionalStrm = Optional.ofNullable(strmNames);
		 optionalStrm.ifPresent(strm -> {
			
		 });
	}
	
	private void displayStream(Stream<String> strm) {
		// Iterate over stream.
		strm.forEach(ele -> {
			System.out.println("From Display "+ele);
		});
	}
	
}
