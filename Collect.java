package crickets;

import java.util.*;
import java.util.stream.Collectors;

public class Collect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Arrays.asList("Ram", "John", "Arun");
		List<String> result = names.stream() .filter(name -> name.startsWith("R")) .collect(Collectors.toList());
		System.out.println(result);
	}

}
