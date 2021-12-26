package com.demo.generics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.stream.model.Person;

/**
 * Like paramterized type we can not used wild card in Class, interface.
 * - Allowed in method
 * - Instant creation
 * @author RBR2
 * 
 * WildCards:
 * 	- upper bound: relax the restriction.
 *  - lower bound,
 *  - unbound
 *  - 
 *
 * @param <T>
 * 
 * 
 * Below service
 * 	- meant to send a message to a Person 
 *  - can take Message type 
 * 
 */
interface MessageService <T extends Person> {
	
	// example : upper bound wild card 
	// desired messages must be a list of Type that extends/implements String {specified class or interface}
	T getReciever(List<? extends Message> messages);
	
	// upper bound wildcard
	// objective: return list of objects of Type that extends Person.
	List<? extends PersonalMessage> sendPersonalMessage(List<? extends Message> messages, T person);
}


interface Message {}

class MarathiMessage implements Message{
	public MarathiMessage() {
		System.out.println("Marathi Message !");
	}
}

class HindiMessage implements Message{
	public HindiMessage() {
		System.out.println("Hindi Message !");
	}
}

class PersonalMessage implements Message {
	public PersonalMessage() {
		System.out.println("Personal Message !");
	}
}


public class WildCard {
	
	//Wildcard:  Instance creation
		private MessageService service = new MessageService() {

				@Override
				public Person getReciever(List messages) {
					messages.stream().forEach(msg -> {
						// msg: is a raw type
						if(msg instanceof MarathiMessage) {
							System.out.println("Marathi Message Reciever");
						} else if(msg instanceof HindiMessage) {
							System.out.println("Hindi Message Reciever");
						} else if (msg instanceof PersonalMessage) {
							System.out.println("Personal Message Reciever");
						}
					});
					return new Person("Hello Person");
				}

				@Override
				public List sendPersonalMessage(List messages, Person person) {
					messages.stream().forEach(msg -> {
						// msg: is a raw type
						if(msg instanceof MarathiMessage) {
							System.out.println("Marathi Message Reciever");
						} else if(msg instanceof HindiMessage) {
							System.out.println("Hindi Message Reciever");
						} else if (msg instanceof PersonalMessage) {
							System.out.println("Personal Message Reciever, hello Person "+person.toString());
						}
					});
					return null;
				}
			
			}; 
			
	
			
	private Supplier<List<MarathiMessage>> marathiDataSource = () -> {
		return Stream.of(new MarathiMessage(), new MarathiMessage()).collect(Collectors.toList());
	};
	
	private Supplier<List<HindiMessage>> hindiDataSource = () -> {
		return Stream.of(new HindiMessage(), new HindiMessage()).collect(Collectors.toList());
	};
	
	private Supplier<List<PersonalMessage>> personalDataSource = () -> {
		return Stream.of(new PersonalMessage(), new PersonalMessage()).collect(Collectors.toList());
	};

	
	public static void main(String[] args) {
		WildCard demo = new WildCard();
		
		// messages of unknow type
		List<? extends Message> messages = null;//List<?> messages = null; : this is a unbound wild card not same as "? extends Message" upper bound wildcard.
		 
		// datasource : marathi message
		messages = demo.marathiDataSource.get();
		demo.service.getReciever(messages);
		// datasource : hindi message
		messages = demo.hindiDataSource.get();
		demo.service.getReciever(messages);
		
		// datasource : personal message
		messages = demo.personalDataSource.get();
		demo.service.sendPersonalMessage(messages, (new Person("Romil")));
		
		
		
	}
	
}
