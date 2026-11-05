package java_projects;


import java.util.Arrays;
import java.util.Scanner;

public class Task5_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		1.sum of array elements
		
		int[] arr1= {10,20,30,40,50};
		
		
		int sum=0;
		for(int i=0;i<arr1.length;i++) {
			sum+=arr1[i];
		}
		System.out.println(sum);
		
		
//		2.largest element in the array
		
		int[] arr2= {2,5,9,4,7,93,5,8};
		int large=arr2[0];
		for(int i=1;i<arr2.length;i++) {
			
			if (arr2[i]>large) {
				large=arr2[i];
			}
			
			
		}
		System.out.println("the largest number is : " + large);
		
//		3.Duplicates elements in the array
		
		int[] arr3= {10,20,30,40,30,50,60};
		
		System.out.println("The original array is : " + Arrays.toString(arr3));
		for(int i=0;i<arr3.length-1;i++) {
			for(int j=i+1;j<arr3.length;j++) {
				if(arr3[i]==arr3[j]) {
					System.out.println("the duplicate value is : " + arr3[i]);
				}
			}
		}
		
//		4.search the number and return its index position
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter your number that you want to search : ");
		int num=sc.nextInt();
		
		int[] arr4= {2,5,7,8,4,9,3,10,78,56,90};
		System.out.println("Search the index position from these array : " +Arrays.toString(arr4));
		for(int i=0;i<arr4.length;i++) {
			if(num==arr4[i]) {
				System.out.println("Your number index position is: " + i);
			}
		}
		
//		5.find the odd numbes and even numbers in the array
		
		int[] arr5={1,2,3,4,5,6,7,8,9};
		
		int[] odd=new int[arr5.length];
		int[] even=new int[arr5.length];
		
		int j=0;
		int k=0;
		
		for(int i=0;i<arr5.length;i++) {
			if(arr5[i]%2==0) {
				even[j]=arr5[i];
				j++;
			}else {
				odd[k]=arr5[i];
				k++;
			}
		}
		System.out.print("Even numbers : ");
		for(int i=0;i<j;i++) {
			System.out.print(even[i]+ " ");
		}
		
		System.out.println();
		
		System.out.print("Odd numbers: ");
		for (int i = 0; i < k; i++) {
		    System.out.print(odd[i] + " ");
		}
		System.out.println();
		
//		6.Matrix addition and subtraction
		
		int[][]a=new int[3][3];
		int[][]b=new int[3][3];
		int[][]add=new int[3][3];
		int[][]sub=new int[3][3];
		
        System.out.println("Enter the elements of the first matrix:");
        
        for(int i=0;i<3;i++) {
        	for(int p=0;p<3;p++) {
        		a[i][p]=sc.nextInt();
        	}
        }
        
        System.out.println("Enter the elements of the second matrix:");
        for(int i=0;i<3;i++) {
        	for(int p=0;p<3;p++) {
        		b[i][p]=sc.nextInt();
        	}
        }
        
        for (int i = 0; i < 3; i++) {
            for (int p = 0; p < 3; p++) {
                add[i][p] = a[i][p] + b[i][p];
            }
        }
        
        System.out.println("Addition of two matrices : ");
        
        for(int i=0;i<3;i++) {
        	for(int p=0;p<3;p++) {
        		System.out.print(add[i][p]+ "  ");
        	}
        	System.out.println();
        }
        
        for (int i = 0; i < 3; i++) {
            for (int p = 0; p < 3; p++) {
                sub[i][p] = a[i][p] - b[i][p];
            }
        }
        System.out.println("Substraction of two matrices : ");
        
        for(int i=0;i<3;i++) {
        	for(int p=0;p<3;p++) {
        		System.out.print(sub[i][p]+ "  ");
        	}
        	System.out.println();
        }
		
		
		
		
		
		
		
		

	}

}
