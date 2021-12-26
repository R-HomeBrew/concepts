package com.streams.handson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.stream.model.Person;
import com.stream.model.Student;

// Convert above list of student to Optional<Student>
// case1: from Database -- Hibernate -- list of Pojo -- List of Optional Pojo -- Processing
// case2: from client -- list of Optional Pojo -- list of Pojo -- serialize.

public class OptionalDemo {
	
	private static List<Optional<Student>> students;
	
	private Optional<Student> student;
	
	public OptionalDemo(Optional<Student> student) {
		super();
		this.student = student;
	}

	public Optional<Student> getStudent() {
		return student;
	}

	public void setStudent(Optional<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		
		return "OptionalDemo [student=" + student + "]";
	}
	
	public static void main(String[] args) {
		
		Supplier<List<Student>> generator = () -> {
			return Arrays.asList(new Student[] {
					new Student("Romil",1),
					new Student("Bhagu",2),
					new Student("Harsh",3)
			});
		};
		// map takes a Function<T,R> as input
		// Supplier lamba will return List<String>
		// list is streamed 
		// each element is converted to Optional 
		// Stream is terminated with Collection of All Optional Object into List
		List<Optional<Student>> list = generator.get().stream().map((elem) -> Optional.ofNullable(elem) ).collect(Collectors.toList());
		
		
		// map takes a Function<T,R> as input
		// Supplier lamba will return List<String>
		// list is streamed 
		// each element is converted to Optional : stream of optional 
		// Process stream of Optional: filter optional to check the RollNumber if roll ==2 then collect the lsit
		// Stream is terminated with Collection of All Optional Object into List
		List<Optional<Student>> listRollOne =  generator.get().stream().map(ele -> Optional.ofNullable(ele)).filter(opt -> opt.get().getRollNumber() == 1).collect(Collectors.toList());
		
		
		list.forEach(elem -> System.out.println("All "+elem.get().toString()));
		listRollOne.forEach(elem -> System.out.println("One "+elem.get().toString()));
		
	
		
		Optional<Student> optStudent = Optional.ofNullable(new Student("Sameer", 0));
		// filter option to check name of student "Sameer" if present then only display
		optStudent.filter(value -> value.getName().equals("Sameer")).ifPresent(value -> System.out.println(value));
		// if filter does not match then Provide empty Optional
		optStudent.filter(value -> value.getName().equals("Romil")).or(() -> Optional.empty());
		// if filter does not 
		optStudent.filter(value -> value.getName().equals("Romil")).orElseThrow(IllegalStateException::new);
	
	
	
	}

}
