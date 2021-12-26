package com.demo.functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// user defined function interface
// use of predefined function interface



interface Calculator <I extends Data, R extends Income> {
	R calculate(I in);
}


public class FunctionalDemo {
	

	public static void main(String[] args) {
		
		
		//###############UnaryOperator<T> & BinaryOperator<T>: starts
		
		//---> 1. use of UnaryOperator Interface
		// Represents operation on single operand
		UnaryOperator<Integer> unaryAdd = (input -> {
			return input + 10;
		});
		
		//unaryAdd.apply(FunctionalDemo.intValue); ---> // this return a Integer
		Optional<Integer> optional = Optional.ofNullable(unaryAdd.apply(FunctionalDemo.intValue));
		optional.ifPresent(result -> System.out.println("UnaryOperator --> "+result)); // --> UnaryOperator --> 20
		
		//--> 2. use of BinaryOperator interface
		// Represents Operation of two operands of same type
		BinaryOperator<Integer> binaryAdd = (in_1, in_2) -> {
			return in_1 + in_2 + 20;
		};
		
		Optional<Integer> optionBinary = Optional.ofNullable(binaryAdd.apply(FunctionalDemo.intValue, FunctionalDemo.intValue));
		optionBinary.ifPresent(result -> System.out.println("BinaryOperator --> "+result)); // --> BinaryOperator --> 40
		
		
		//###############UnaryOperator<T> & BinaryOperator<T>: Ends
		
		
		//###############Consumer<T> and BiConsumer<T,U>: starts
		//---> 3. Consumer<T>
		// Consumes provided input and produce output [no return]
		Consumer<List<Integer>> consumerAdd = (list) -> {
			
			List<Optional<Integer>> opts = list.stream().map(ele -> Optional.ofNullable(ele)).collect(Collectors.toList());
			int sum =0;
			
			for(Optional<Integer> intvalue : opts) {
				sum += intvalue.isEmpty() ? 0 : intvalue.get();
				
			}
			System.out.println("Consumer sum --> "+sum);
		};
		
		consumerAdd.accept(intValues); // should produce sum of all elements
		
		//---> 4. BiConsumer<T, U>
		// Consumes two arguments of different type and produce output. [no return]
		BiConsumer<Integer, String> rollNoMapper = (rol, name) -> {
			System.out.println("BiConsumer --> "+rol.toString()+" Name "+name);
		};
		
		rollNoMapper.accept(Integer.valueOf(10), "Romil"); // should print roll and Name
		
		//###############Consumer<T> and BiConsumer<T,U>: ends
		
		
		//############### T Supplier: starts
		//---> 5. R Supplier<>
		// Consumes not arguments but return a value
		Supplier<Data> dataSource = () -> {
			return (new Data(10000, 1000.0));
		};
		
		Optional<Data> dataOpt = Optional.ofNullable(dataSource.get());
		dataOpt.filter(value -> value.getSalary() == 10000).ifPresent(value -> {
			System.out.println("Supplier --> "+value.toString());
		});
		//############### T Supplier: ends
		
		//############### Predicate<T> and BiPredicate<T,U>: starts
		//---> 6. boolean Predicate<T>
		// return boolean if predication based on T is true otherwise false, consumes single argument
		Predicate<List<Optional<Integer>>> predicateZero = (list) -> { // list is List of Optional
			Optional<Integer> optReturn = list.stream().filter(opt ->  opt.get() == 0 ).findFirst().orElse(Optional.empty());
			if(optReturn.isPresent() && !optReturn.isEmpty()) return true;
			return false;
		};
		
		System.out.println("Predicate -->  Predication does 0 exists "+predicateZero.test(optIntValues));
		
		//---> 7. boolean BiPredicate<T,U>
		// return true if predication based on arguments  T and U returns true, otherwise false
		BiPredicate<Integer, Integer> biPredicateSame = (value1, value2) -> {
			if(value1 == value2) return true;
			return false;
		};
		
		System.out.println("BiPredicate -->  Predication does 0 exists "+biPredicateSame.test(Integer.valueOf(102), Integer.valueOf(10)));
		//############### Predicate<T> and BiPredicate<T,U>: ends
		
		
	}
	
	
	private static Integer intValue = Integer.valueOf(10);// deprecated new Integer(10);
	
	private static Integer [] intArr =  new Integer[] {1,3,4,6,0};
	
	private static List<Integer> intValues = Arrays.asList(intArr);
	
	private static List<Optional<Integer>> optIntValues;
	
	static {
		
		 optIntValues = intValues.stream().map(value -> Optional.ofNullable(value)).collect(Collectors.toList());
	}
	
}



