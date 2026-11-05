package crickets;

import java.util.*;

public class Sorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(40, 10, 30, 20);
		numbers.stream() .sorted() .forEach(System.out::println);
	}

}
