package com.demo.nestedClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.model.Student;

/*
 * Natural ordering : As per order of different element.
 * Naturally comparable: Same class 
 * 
 * 
 * - Comparable interface provides Comparable method.
 * - Use: Compare two objects of same class (to avoid classCast exception] as per natural ordering [detemine by developer]
 * - int this.compareTo(that) : implements interface
 * 		- Ascending: 
 * 			- Positive : (represent higher precedence): this is greater than that
 * 			- Negative : : that is greater than this
 * 			- 0 : both are same.
 */
public class Sorter {

	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<Student>();
		list.addAll(Arrays.asList(new Student[] {
						new Student("Romil", 10),
						new Student("Bhagu", 13),
						new Student("Harshita", 15),
						new Student("Bhagu", 14)
						}));
		
		Collections.sort(list);
		
		
		list.forEach(student -> {
			System.out.println(student);
		});
		
		// Anonymous implementation of Comparator.
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student student1, Student student2) {
				if(student1.getName() == null) return -1; // student 2 is bigger
				if(student2.getName() == null) return 1; // student 1 is bigger
				if(student1.getName() == student2.getName()) return 0; // same
				
				if(student1.getName().compareTo(student2.getName()) == 0) return 0;
				if(student1.getName().compareTo(student2.getName()) > 0) return 1;
				if(student1.getName().compareTo(student2.getName()) < 0) return -1;
				
				return 0;
			}
			
		});
		
		list.forEach(student -> {
			System.out.println(student);
		});
		
		
	}
}
