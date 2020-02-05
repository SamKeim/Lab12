package co.grandcircus02052020;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleMain {
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int userInt = 0;
		ArrayList<Vehicle> inventory = new ArrayList<Vehicle>();
		
		System.out.println("Welcome to the Grand Circus Motors - Controllers Console");
		System.out.println("How many vehicles are you entering:");
		userInt = scnr.nextInt();
		scnr.nextLine();
		
		for (int i = 1; i <= userInt; i++) {
			System.out.println("Enter Vehicle #" + i + " Make:");
			String chooseMake = scnr.nextLine();
			System.out.println("Enter Vehicle #" + i + " Model:");
			String chooseModel = scnr.nextLine();
			int chooseYear = Validator.getInt(scnr, "Enter Vehicle #" + i + " Year:", 1885, 2020);
			System.out.println("Enter Vehicle #" + i + " Price:");
			double choosePrice = Validator.getDouble(scnr, "Enter Vehicle #" + i + " Price:", 0, 1000000);
			inventory.add(new Vehicle(chooseMake, chooseModel, chooseYear, choosePrice));
		}
		
		for (Vehicle vehicle : inventory) {
			System.out.println(vehicle);
		}
	}

}
