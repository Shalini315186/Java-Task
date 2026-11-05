package oops;

import java.time.LocalDate;
import java.util.Scanner;


class Pro{
		int productId;
		String productname;
		double price;
		
		Pro(int i,String n,double p){
			productId=i;
			productname=n;
			price=p;
		}
		public void display() {
			System.out.println("Enter your productid : " +productId);
			System.out.println("Enter your Product Name : " + productname);
			System.out.println("Enter the price of product : " + price);
		}
	}
	class Electronics extends Pro {
		int warranty;
		Electronics(int i,String n,double p,int w){
		super(i,n,p);
		warranty=w;
		}
		void displayele() {
			System.out.println("Enter the warranty time : " +warranty);
		}
		
	}
	class Clothing extends Pro{
		String size;
		Clothing(int i,String n,double p,String s){
			super(i,n,p);
			size=s;
		}
		void displaycloth() {
			System.out.println("Enter the size of clothing : " +size);
		}
	}
	class Food extends Pro{
		LocalDate date;
		Food(int i,String n,double p,LocalDate d){
			super(i,n,p);
			date=d;
		}
		void displayfood() {
			System.out.println("Enter the expiry time of food  : " +date);
		}
	}
	public class Product {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		while(true) {
		System.out.println("1.Electronics");
		System.out.println("2.Clothing");
		System.out.println("3.Food");
		System.out.println("4.Exit");
		
		System.out.println("Enter the choice of products : ");
		int choice=sc.nextInt();
		Pro pro=null;
		switch (choice) {
		case 1:
			System.out.println("Enter your Product ID:  ");
			int i=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter your Product name : ");
			String n=sc.nextLine();
			System.out.println("Enter the product price : ");
			double p=sc.nextDouble();
			System.out.println("Enter the Warranty in years : ");
			int w=sc.nextInt();
			Electronics ele=new Electronics(i,n,p,w);
			ele.display();
			ele.displayele();
			break;
		case 2:
			System.out.println("Enter your Product ID:  ");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter your Product name : ");
			String na=sc.nextLine();
			System.out.println("Enter the product price : ");
			double pr=sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter your size of your cloth : ");
			String s=sc.nextLine();
			Clothing clo=new Clothing(id,na,pr,s);
			clo.display();
			clo.displaycloth();
			break;
		case 3:
			System.out.println("Enter your Product ID:  ");
			int id1=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter your Product name : ");
			String na1=sc.nextLine();
			System.out.println("Enter the product price : ");
			double pr1=sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter the expiry date of food (yyyy-mm-dd): ");
			LocalDate d = LocalDate.parse(sc.next());
			Food fo=new Food(id1,na1,pr1,d);
			fo.display();
			fo.displayfood();
		case 4:
            System.out.println("Exiting the program...");
            sc.close();
            return;
        default:
            System.out.println("Invalid Product type!");
		}
		}

	}

}
