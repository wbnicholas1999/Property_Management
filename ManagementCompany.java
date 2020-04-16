/**
 * 
 * @author William Nicholas
 *
 */

public class ManagementCompany extends java.lang.Object {
	
	private int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private java.lang.String name;
	private java.lang.String taxID;
	private Property[] properties;
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;
	private Plot plot;

	//** The No-arg Constructor with the default objects with empty strings, 0 for mgmFeePer, the Plot values set to (0, 0, 10, 10), and the property array length set to 5 */
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.mgmFeePer = 0;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}

	//** The Constructor that creates a ManagementCompany object with the default objects */
	public ManagementCompany(java.lang.String name, java.lang.String taxID, double mgmFeePer) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}

	//** The Constructor that creates a ManagementCompany object with the default objects */
	public ManagementCompany(java.lang.String name, java.lang.String taxID, double mgmFeePer, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.plot = new Plot(x, y, width, depth);
		this.properties = new Property[MAX_PROPERTY];
	}

	//** The Copied Constructor to be used in the ManagementCompany object */
	public ManagementCompany(ManagementCompany otherCompany) {
		name = otherCompany.name;
		taxID = otherCompany.taxID;
		mgmFeePer = otherCompany.mgmFeePer;
		plot = new Plot(otherCompany.plot);
		properties = new Property[otherCompany.MAX_PROPERTY];;
	}

	/*
	 * Creates a property object by copying from another property and adds it to the "properties" array
	 * 
	 * return -1 if the array is full
	 * return -2 if the property object is null
	 * return -3 if the management company does not encompass the property plot
	 * return -4 if the property plot overlaps any of the properties in the array
	 * 
	 * otherwise  return the index of the property where the property was added
	 */
	public int addProperty(Property property) {
		if (property == null) {
			return -2;
		}
		else if (!plot.encompasses(property.getPlot())) {
			return -3;
		}
		
		for (int a = 0; a < properties.length; a++) {
			if (properties[a] != null) {
				if (properties[a].getPlot().overlaps(property.getPlot())) {
					return -4;
				}
			}
			else {
				properties[a] = property;
				return a;
			}
		}
		
		return -1;
	}

	//** Creates a property object with default property objects and add them all to the "properties" array */
	public int addProperty(String name, String city, double rent, String owner) {
		return addProperty(new Property(name, city, rent, owner));
	}

	//** Creates a property object with default property objects, plot objects and add them all to the "properties" array */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	}

	//** Displays the information of the property at index i */
	public java.lang.String displayPropertyAtIndex(int i) {
		return (properties[i].toString());
	}

	//** Returns the MAX_PROPERTY constant that represents the size of the "properties" array */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	//** This method finds the property within the properties array that has the maximum rent amount and returns the rent amount */
	public double maxRentProp() {
		double maxAmount = 0;
		
		for (Property prop: properties) {
			if (prop == null) {
				break;
			}

			if (maxAmount < prop.getRentAmount()) {
				maxAmount = prop.getRentAmount();
			}
		}
		
		return maxAmount;
	}

	//** This method finds the index of the property with the maximum rent amount */
	public int maxRentPropertyIndex() {
		int maxIndex = -1;
		double maxAmount = 0;
		
		for (int b = 0; b  < properties.length; b++) {
			if (properties[b] == null) {
				break;
			}

			if (maxAmount < properties[b].getRentAmount()) {
				maxAmount = properties[b].getRentAmount();
				maxIndex = b;
			}
		}
		
		return maxIndex;
	}

	//** Displays the information of all the properties in the "properties" array */
	public java.lang.String toString() {
		String returnString = "";
		returnString += "List of properties for " + name + ", taxID: " + taxID;
		returnString += "\n____________________________________________________________________\n";
		
		for (Property prop: properties) {
			if (prop == null) {
				break;
			}
			returnString += prop.toString();
		}
		
		returnString += "\n____________________________________________________________________\n";
		returnString += "\nTotal Management Fee: $" + (totalRent() + mgmFeePer / 100) + "\n";
		
		return returnString;
	}

	//** This method accesses each "Property" object within the array "properties" and sums up the property rent and returns the total amount */
	public double totalRent() {
		double total = 0;
		
		for (Property prop: properties) {
			if (prop == null) {
				break;
			}
			total += prop.getRentAmount();
		}
		
		return total;
	}

	//** Returns the plot */
	public Plot getPlot() {
		return plot;
	}

	//** Returns the name */
	public java.lang.String getName() {
		return name;
	}
}
