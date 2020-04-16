/**
 * 
 * @author William Nicholas
 *
 */

public class Property extends Plot {
	
	private java.lang.String city;
	private java.lang.String owner;
	private java.lang.String propertyName;
	private double rentAmount;
	private Plot plot;

	//** The No-arg Constructor with the default objects with null strings, 0 for rentAmount, and null plot */
	public Property() {
		city = null;
		owner = null;
		propertyName = null;
		rentAmount = 0;
		plot = null;
	}

	//** The Copied Constructor to be used in the Property object */
	public Property(Property p) {
		this.city = p.city;
		this.owner = p.owner;
		this.propertyName = p.propertyName;
		this.rentAmount = p.rentAmount;
		this.plot = new Plot(p.plot);
	}

	//** The Parameterized Constructor with no plot objects */
	public Property(java.lang.String propertyName, java.lang.String city, double rentAmount, java.lang.String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}

	//** The Parameterized Constructor */
	public Property(java.lang.String propertyName, java.lang.String city, double rentAmount, java.lang.String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}

	//** Returns the Plot instance */
	public Plot getPlot() {
		return plot;
	}

	//** Returns the city */
	public java.lang.String getCity() {
		return city;
	}

	//** Returns the owner name */
	public java.lang.String getOwner() {
		return owner;
	}

	//** Returns the property name */
	public java.lang.String getPropertyName() {
		return propertyName;
	}

	//** Returns the rent amount */
	public double getRentAmount() {
		return rentAmount;
	}

	//** Sets the Plot values and return the Plot instance */
	public Plot setPlot(int x, int y, int width, int depth) {
		return new Plot(x, y, width, depth);
	}

	//** Sets the city */
	public void setCity(java.lang.String city) {
		this.city = city;
	}

	//** Sets the owner name */
	public void setOwner(java.lang.String owner) {
		this.owner = owner;
	}

	//** Sets the property name */
	public void setPropertyName(java.lang.String propertyName) {
		this.propertyName = propertyName;
	}

	//** Sets the rent amount */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	//** Prints out the city, owner name, and rent amount for the property */
	public java.lang.String toString() {
		return ("\nProperty Name: " + propertyName +
				"\nCity: " + city +
				"\nOwner of " + propertyName + ": " + owner +
				"\nRent Amount: $" + rentAmount);
	}
}
