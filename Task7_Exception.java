package java_projects;

class InvalidAgeException extends Exception{
	InvalidAgeException(String message){
		super(message);
	}
}

public class Task7_Exception {
	static void checkAge(int age) throws InvalidAgeException{
		if(age<18) {
			throw new InvalidAgeException("you are not eligible to login");
		}
		System.out.println("Login Successful");
	}
	


public static void main(String[] args) {

    try {
        checkAge(18);
    }
    catch (InvalidAgeException e) {
        System.out.println("Exception: " + e.getMessage());
    }

    System.out.println("Program completed");
}
}
