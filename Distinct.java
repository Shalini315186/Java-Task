package crickets;

import java.util.*;

public class Distinct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(1,2,2,3,3,4);
		numbers.stream() .distinct() .forEach(System.out::println);
	}

}
