package crickets;

import java.util.*;

public class Reduce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(10,20,30);
		int sum = numbers.stream() .reduce(0, (a,b) -> a + b); 
		System.out.println(sum);
	}

}
