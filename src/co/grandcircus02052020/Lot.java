package co.grandcircus02052020;

import java.util.ArrayList;

public class Lot {
	
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
	
	public static void displayMake(ArrayList<Vehicle> inventory, String make) {
		for (Vehicle vehicle : inventory) {
			if (vehicle.getMake().equalsIgnoreCase(make)) {
				System.out.println(vehicle);
			}
		}
	}
	public static void displayYear(ArrayList<Vehicle> inventory, int year) {
		for (Vehicle vehicle : inventory) {
			if (vehicle.getYear() == year) {
				System.out.println(vehicle);
			}
		}
	}
	public static void displayPrice(ArrayList<Vehicle> inventory, double price) {
		for (Vehicle vehicle : inventory) {
			if (vehicle.getPrice() < price) {
				System.out.println(vehicle);
			}
		}
	}
	public static void displayUsed(ArrayList<Vehicle> inventory, String choice) {
		boolean used = choice.equalsIgnoreCase("Used");
		if(used) {
			for (Vehicle vehicle : inventory) {
				if (vehicle.getClass().equals(UsedVehicle.class)) {
					System.out.println(vehicle);
				} 
			}
		} else {
			for (Vehicle vehicle : inventory) {
				if (!(vehicle.getClass().equals(UsedVehicle.class))) {
					System.out.println(vehicle);
				} 
			}
		}
	}
	
}
