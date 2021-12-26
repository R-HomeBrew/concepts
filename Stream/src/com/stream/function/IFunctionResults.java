package com.stream.function;

import java.util.ArrayList;

/**
 * Functional Interface that consumes a type of ArrayList of Integer and results Integer
 * @author RBR2
 *
 * @param <E>
 */
@FunctionalInterface
public interface IFunctionResults <E extends ArrayList<Integer>>{

	E getResults(E marks);
}
