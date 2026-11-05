package crickets;

import java.util.*;
import java.util.stream.*;



public class Stream_list{
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Ram", "John", "Arun");
		Stream<String> stream = names.stream();
		stream.forEach(System.out::println);
	}
}
