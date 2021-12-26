package com.streams.handson;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.stream.model.Student;


public class ForEachUsage {
	
	// lambda to generate students
	private Supplier<List<Student>> studentsGenerator = () -> {
		 return Arrays.asList(new Student[] {
				 new Student("A", 1),
				 new Student("B", 2),
				 new Student("C", 3),
				 new Student("D", 4),
				 null
		});
	};
	
	// lambda to map List<Student> --> List<Optional<Students>>/
	private Function<List<Student>, List<Optional<Student>>> optionalStudentsGenerator = (list) -> {
		return list.stream().map(ele -> Optional.ofNullable(ele)).collect(Collectors.toList());
	};
	
	@SuppressWarnings("deprecation")
	private Supplier<Map<Integer, Student>> studentMapGenerator = () -> {
		Map<Integer, Student> map = new HashMap<Integer, Student>();
		
		Stream<java.util.Map.Entry<Integer, Student>>  entries = studentsGenerator.get().stream().map(std -> {
			int key = (new Random()).nextInt();
			java.util.Map.Entry<Integer, Student> entry =  new AbstractMap.SimpleEntry<Integer, Student>(key , std);
			return entry;
		});
		map = entries.collect(Collectors.toMap(java.util.Map.Entry::getKey, java.util.Map.Entry::getValue));
		return map;
	};
	
	@SuppressWarnings("deprecation")
	private Supplier<Map<Integer, Optional<Student>>> optionalStudentMapGenerator = () -> {
		Map<Integer, Optional<Student>> map = new HashMap<Integer, Optional<Student>>();
		
		Stream<java.util.Map.Entry<Integer, Optional<Student>>>  entries = optionalStudentsGenerator.apply(studentsGenerator.get()).stream().map(std -> {
			int key = (new Random()).nextInt();
			java.util.Map.Entry<Integer, Optional<Student>> entry =  new AbstractMap.SimpleEntry<Integer, Optional<Student>>(key , std);
			return entry;
		});
		map = entries.collect(Collectors.toMap(java.util.Map.Entry::getKey, java.util.Map.Entry::getValue));
		return map;
	};
	
	public static void main(String[] args) {
		ForEachUsage object = new ForEachUsage();
		object.studentsGenerator.get().forEach(ele -> System.out.println("From List : "+ele));
		
		object.optionalStudentsGenerator.apply(object.studentsGenerator.get()).forEach(opt -> {
			opt.ifPresent(value -> System.out.println("From Opt : "+value));
		});
		
		// this will 
		object.optionalStudentMapGenerator.get().forEach((key, value)->{
			System.out.println("From Optional Map : key "+key+" value "+value);
		});
		
		// This is a fail case, as it will brake once Null occurs in collect API
		object.studentMapGenerator.get().forEach((key, value)->{
			System.out.println("From Map : key "+key+" value "+value);
		});
	}
	

}
