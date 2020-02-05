package co.grandcircus02052020;

public class Vehicle {
	private String make;
	private String model;
	private int year;
	private double price;
	
	public Vehicle(String chooseMake, String chooseModel, int chooseYear, double choosePrice) {
		make = chooseMake;
		model = chooseModel;
		year = chooseYear;
		price = choosePrice;
	}
	
	public Vehicle() {
		make = "No Make";
		model = "No Model";
		year = 1885;
		price = 0.01;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year > 1884 && year < 2021) {
		this.year = year;
		} else {
			System.out.println("Invalid year, year was not set.");
		}
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		} else {
			System.out.println("Invalid price, price was not set.");
		}
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %s, $%,.2f", year, make, model, price);
	}
}
