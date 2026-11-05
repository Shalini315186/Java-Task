package java_projects;

public class task1 {
	public static void main(String[] args) {
		double a=10.3456;
		int b=20;
		int e=20;
		
		System.out.println("...Math FUnctions..");
		
//		Math functions
		
//		1.floor
		System.out.println(Math.floor(a));
		
//		2.ceil
		System.out.println(Math.ceil(a));
//		3.random
		
		double randomno=(int)Math.floor(Math.random()*100)+1;
		System.out.println(randomno);
		
//		4.abs
		int c=-10;
		System.out.println(Math.abs(c));
		
//     5.min
		System.out.println(Math.min(c , b));
		
//		6.Max
		System.out.println(Math.max(c ,b));
//		7.sqrt
		System.out.println(Math.sqrt(randomno));
		
//		8.chrt
		System.out.println(Math.cbrt(randomno));
		
//		9.pow
		System.out.println(Math.pow(a, b));
		
//		10.round
		System.out.println(Math.round(a));
		
//		11.pi
		System.out.println(Math.PI);
//		12.Euler number
		System.out.println(Math.E);
		
//		13.equal
		
		System.out.println(b==e);
		System.out.println(b==a);
		
		System.out.println("...........................................");
		
		System.out.println("...String Functions......");
		
		String name="java";
		String sub="java";
		String name1="  hii";
		
//		1.uppercase
		
		System.out.println("Uppercase : "+name.toUpperCase());
		
//		2.Lowercase
		
		System.out.println("Lowercase : "+name.toLowerCase());
		
//		3.length
		
		System.out.println("Length of the string : " +name.length());
		
//		4.charAt
		
		System.out.println(name.charAt(2));
		
//		5.contains
		
		System.out.println(name.contains("ja"));
		
//		6.trim()
		
		System.out.println(name1.trim());
//		7.equals()
		System.out.println(name.equals(sub));
		
//		8.equalsIgnorecaase
		System.out.println("equalsIgnorecaase : "+"hello".equalsIgnoreCase("HELLO"));
		
//		9.isEmpty
		System.out.println("".isEmpty());
		
//		10.isBlank
		System.out.println("  ".isBlank());
		
//		11.substring
		System.out.println(name.substring(0,2));
		
//		12.indexOf
		System.out.println(name.indexOf('a'));
		
//		13.lastindexOf
		System.out.println(name.lastIndexOf('a'));
		
//		14.concat
		System.out.println(name.concat(" programming"));
		
//		15.startswith
		System.out.println(name.startsWith("j"));
		
//		16.endswith
		System.out.println(name.endsWith("e"));
		
		
		
		
		
		
	}

}
