package com.demo.nestedClass;

/**
 * 
 * Date: 22/12/2021
 * This demo explains 
 * 
 * 	1. Can write an interface and a class inside a class
 * 	2. Default method 
 * 	3. Inline / anonymous implementation of Interface and Abstract class.
 * 
 * Check Sorter.java: for anonymous implementation of Comparator interface 
 * 
 * @author RBR2
 *
 */


// abstract class extending the Interface MessgaeService
abstract class HindiMessageService implements Anonymous.MessageService{
	
	public void sayMessage(String hindiMessage) {
		System.out.println("Hindi Message "+hindiMessage);
	}
	
}

public class Anonymous {

	// Can write interface inside a class
	public interface MessageService {
		
		default void sayHello () {
			System.out.println("Default Hello");
		}
		void sayMessage(String message);
	}
	
	private String message = "Hello Outer";
	
	
	public Anonymous() { System.out.println(this.message); }

	public static void main(String[] args) {
		
		// Anonymous class with interface implementation
		// Inline Interface implementation.
		MessageService service = new Anonymous.MessageService() {
			@Override
			public void sayMessage(String message) {
				System.out.println("Marathi Message "+message);
			}
		};
		service.sayHello(); // default method from Interface
		service.sayMessage("Romil"); // marathi message service
		
		
		// Anonymous class with abstract class extends
		HindiMessageService hindiService = new HindiMessageService() {
			
			public void sayMessage(String hindiMessage) { // overriding the method from abstract class
				sayMessage(hindiMessage, "HINDI");
			}
			public void sayMessage(String hindiMessage, String font) { // additional implementation
				System.out.println("Hindi Message "+hindiMessage+" Font "+font);
			}
			
		};
		hindiService.sayHello();
		hindiService.sayMessage("Jim");
		
	}
}
