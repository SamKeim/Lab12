package co.grandcircus02052020;

public class UsedVehicle extends Vehicle {

	private double mileage;
	
	public UsedVehicle(String chooseMake, String chooseModel, int chooseYear, double choosePrice, double chooseMileage) {
		super(chooseMake, chooseModel, chooseYear, choosePrice);
		mileage = chooseMileage;	
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %s, $%,.2f (Used) %,.1f miles", getYear(), getMake(), getModel(), getPrice(), mileage);
	}
}
