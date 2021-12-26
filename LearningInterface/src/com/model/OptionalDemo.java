package com.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.lambda.Names;

/**
 * Optional :
 * 	- container that may or may contain provided value
 * 	- Provides auxillary method to operation/decision making around the value
 * @author RBR2
 *
 */
public class OptionalDemo {

	public static void main(String[] args) {
		List<String> list = Arrays.asList(
				new String [] { Names.Romil.toString(),Names.Bhagu.toString(),Names.Harshita.toString(),Names.Saroj.toString()});
		
		Optional<List> listOptional = Optional.ofNullable(list);
		
		
	}
}
