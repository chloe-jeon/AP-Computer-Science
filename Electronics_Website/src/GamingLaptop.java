public class GamingLaptop{

	private String brand;
	private String model;
	private Spec specifications;
	private double price;
	private int numInStock;
	// constructors takes in this info.  Assign to appropriate fields
	public GamingLaptop(String br, String mod, Spec spec, double pr, int num){
		brand = br;
		model = mod;
		specifications = spec;
		price = pr;
		numInStock = num;
	}
	// write getters for each fields
	public String getBrand()
	{
		return brand;
	}
	public String getModel()
	{
		return model;
	}
	public Spec getSpecifications()
	{
		return specifications;
	}
	public double getPrice()
	{
		return price;
	}
	public int getNumInStock()
	{
		return numInStock;
	}
	
	// write setters for the fields that make sense
	public void setPrice(double newPrice)
	{
		price = newPrice;
	}
	public void setNumInStock(int newNum)
	{
		numInStock = newNum;
	}

	// Write the toString method!!




}