package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int totalAthletes, quantityMen, quantityWomen;
		String name, tallestAthlete = null;
		char sex;
		double height, greatestHeight, weight, averageWeight, percentageMen, averageHeightWomen;
		
		System.out.print("How many athletes? ");
		totalAthletes = sc.nextInt();
		
		quantityMen = 0;
		quantityWomen = 0;
		averageWeight = 0;
		greatestHeight = 0;
		percentageMen = 0;
		averageHeightWomen = 0;
		
		for(int i = 0; i < totalAthletes; i++) {
			System.out.println("Enter the data of athlete number "+(i+1)+":");
			System.out.print("Name: ");
			sc.nextLine();
			name = sc.nextLine();
			
			System.out.print("Sex: ");
			sex = sc.next().charAt(0);
			while(sex != 'F' && sex != 'M') {
				System.out.print("Invalid value! Please type F or M: ");
				sex = sc.next().charAt(0);
			}
			
			System.out.print("Height: ");
			height = sc.nextDouble();
			while(height <= 0) {
				System.out.print("Invalid value! Please enter a positive value: ");
				height = sc.nextDouble();
			}
			if(height > greatestHeight) {
				greatestHeight = height;
				tallestAthlete = name;
			}
			
			System.out.print("Weight: ");
			weight = sc.nextDouble();
			while(weight <= 0) {
				System.out.print("Invalid value! Please enter a positive value: ");
				weight = sc.nextDouble();
			}
			
			averageWeight += weight;
			
			if(sex == 'M') {
				quantityMen++;
			} else {
				quantityWomen++;
				averageHeightWomen += height;
				
			}
			
		}
		
		averageWeight = averageWeight / totalAthletes;
		percentageMen = quantityMen * 100.0 / totalAthletes;
		averageHeightWomen = averageHeightWomen / quantityWomen;
		
		System.out.println("\nREPORT: ");
		System.out.printf("Average weight of athletes: %.2f%n", averageWeight);
		System.out.printf("Tallest athlete: %s%n", tallestAthlete);
		System.out.printf("Percentage of men: %.1f %%%n", percentageMen);
		if(quantityWomen == 0) {
			System.out.println("There are no registered women!");
		} else {
			System.out.printf("Average height of women: %.2f%n", averageHeightWomen);
		}

		sc.close();
	}

}
