package com.stream.function;

import java.util.ArrayList;
/**
 * Student can study a single subject at a time.
 * @author RBR2
 *
 * @param <K>
 */
@FunctionalInterface
public interface IFunctionStudy <K extends String> {

	K study(ArrayList<K> subjects);
}
