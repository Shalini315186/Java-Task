package crickets;

import java.util.*;

public class Square_numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		numbers.stream() .map(n -> n * n) .forEach(System.out::println);
	}

}
