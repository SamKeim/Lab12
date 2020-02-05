package co.grandcircus02052020;

import java.util.ArrayList;
import java.util.Scanner;

public class SalesFloorMain {
	
	// Creates inventory list
	public static ArrayList<Vehicle> stockInventory(){
		ArrayList<Vehicle> inventory = new ArrayList<>();
		inventory.add(new Vehicle("Nikolai", "Model S", 2017, 54999.9));
		inventory.add(new Vehicle("Fourd", "Escapade", 2017, 31999.9));
		inventory.add(new Vehicle("Chewie", "Vette", 2017, 44989.95));
		inventory.add(new UsedVehicle("Hyonda", "Prior", 2015, 14795.5, 35987.6));
		inventory.add(new UsedVehicle("GC", "Chirpus", 2013, 8500.0, 12345.0));
		inventory.add(new UsedVehicle("GC", "Witherell", 2016, 14450.0, 3500.3));
		// Returns list
		return inventory;
	}
	
	public static int printInventory(ArrayList<Vehicle> inventory) {
		int i = 1;
		for (Vehicle vehicle : inventory) {
			System.out.println(i + ". " + vehicle);
			i++;
		}
		System.out.println(i + ". Quit");
		// Returns number of items currently in inventory
		return i;
	}
	
	public static void main(String[] args) {
		// Declare variables
		Scanner scnr = new Scanner(System.in);
		int inventoryCount = 0;
		ArrayList<Vehicle> inventory = SalesFloorMain.stockInventory();
		ArrayList<Vehicle> userVehicles = new ArrayList<>();
		boolean cont = true;
		int userSelection = 0;
		boolean userPurchase = true;
		double userTotal = 0;
		
		// Welcoming statements
		System.out.println("Welcome to the Grand Circus Dealership.\n");
		do {
			// Gets number of items in inventory and assigns it to variable
			inventoryCount = printInventory(inventory);
			
			// Gets selection from user, number between 1 and inventoryCount
			userSelection = Validator.getInt(scnr, "Which vehicle would you like?\n", 1, inventoryCount);

			// Checks if user has selected "Exit" option
			if (userSelection == inventoryCount) {
				cont = false;
				break;
			}
			
			// Prints user selection
			System.out.println(inventory.get(userSelection - 1));
			
			// Asks to purchase vehicle, if so, remove it from inventory and adds it to userVehicle list
			userPurchase = Validator.yesOrNo(scnr, "Would you like to purchase this vehicle? (Y/N)");
			if (userPurchase) {
				userVehicles.add(inventory.get(userSelection - 1)); // Adds to userVehicles
				userTotal += inventory.get(userSelection - 1).getPrice(); // Adds Price to userTotal
				inventory.remove(userSelection - 1); // Removes from inventory
				System.out.println("Excellent! Our finance department will be with your shortly.");
			} else {
				// If not purchased
				System.out.println("Thank you for taking a test drive!");
			}
			
		} while (cont);
		
		// Checkout protocol, presents total charges and list of vehicles purchased
		System.out.printf("Thank you for visiting our lot, your total is $%,.2f. Here are your selected vehicles : \n", userTotal);
		for (Vehicle vehicle : userVehicles) {
			System.out.println(vehicle);
		}
	}
}
