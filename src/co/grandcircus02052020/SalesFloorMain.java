package co.grandcircus02052020;

import java.util.ArrayList;
import java.util.Scanner;

public class SalesFloorMain {
	
	public static ArrayList<Vehicle> stockInventory(){
		ArrayList<Vehicle> inventory = new ArrayList<>();
		inventory.add(new Vehicle("Nikolai", "Model S", 2017, 54999.9));
		inventory.add(new Vehicle("Fourd", "Escapade", 2017, 31999.9));
		inventory.add(new Vehicle("Chewie", "Vette", 2017, 44989.95));
		inventory.add(new UsedVehicle("Hyonda", "Prior", 2015, 14795.5, 35987.6));
		inventory.add(new UsedVehicle("GC", "Chirpus", 2013, 8500.0, 12345.0));
		inventory.add(new UsedVehicle("GC", "Witherell", 2016, 14450.0, 3500.3));
		return inventory;
	}
	
	public static int printInventory(ArrayList<Vehicle> inventory) {
		int i = 1;
		for (Vehicle vehicle : inventory) {
			System.out.println(i + ". " + vehicle);
			i++;
		}
		System.out.println(i + ". Quit");
		return i;
	}
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int inventoryCount = 0;
		System.out.println("Welcome to the Grand Circus Dealership.\n");
		ArrayList<Vehicle> inventory = SalesFloorMain.stockInventory();
		ArrayList<Vehicle> userVehicles = new ArrayList<>();
		boolean cont = true;
		int userSelection = 0;
		boolean userPurchase = true;
		double userTotal = 0;
		do {
			inventoryCount = printInventory(inventory);
			userSelection = Validator.getInt(scnr, "Which vehicle would you like?\n", 1, inventoryCount);
			if (userSelection != inventoryCount) {
				System.out.println(inventory.get(userSelection - 1));
				userPurchase = Validator.yesOrNo(scnr, "Would you like to purchase this vehicle? (Y/N)");
				if (userPurchase) {
					userVehicles.add(inventory.get(userSelection - 1));
					userTotal += inventory.get(userSelection - 1).getPrice();
					inventory.remove(userSelection - 1);
					System.out.println("Excellent! Our finance department will be with your shortly.");
				} else {
					System.out.println("Thank you for taking a test drive!");
				}
			} else {
				cont = false;
			}
		} while (cont);
		System.out.printf("Thank you for visiting our lot, your total is $%,.2f. Here are your selected vehicles : \n", userTotal);
		for (Vehicle vehicle : userVehicles) {
			System.out.println(vehicle);
		}
	}
	
}
