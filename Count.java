package crickets;

import java.util.*;

public class Count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(10, 20, 30, 40);
		long count = numbers.stream() .count();
		System.out.println(count);

	}

}
