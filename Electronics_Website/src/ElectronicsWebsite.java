public class ElectronicsWebsite{
	private GamingLaptop[]  gamingLaptops ;// there may be nulls in the array


	public void add(GamingLaptop gt){
		increaseSizeAndCopyOver();
		gamingLaptops[gamingLaptops.length-1]=gt;
	}

	private void increaseSizeAndCopyOver(){
		int size = 0;
		if(gamingLaptops != null){
			size = gamingLaptops.length;
		}
		GamingLaptop[] temp = gamingLaptops;
		gamingLaptops = new GamingLaptop[size+1];
		for(int i = 0; i<size; i++){
			gamingLaptops[i] = temp[i];
		}
	}


	// returns the index of the GamingLaptop with the largest price
	// if no GamingLaptop Objects are in this Website, then -1 is returned
	public int findMostExpensive(){
		double max = -1;
		int maxIndex = -1;
		for (int i = 0; i < gamingLaptops.length; i++)
		{
			if (gamingLaptops[i] == null)
				continue;
			if (max < gamingLaptops[i].getPrice())
			{
				max = gamingLaptops[i].getPrice();
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	// This method reduces the price of the GamingLaptop that has greater than the specified threshold in stock
	// by discount percent.  precondition:  threshold > 0 and   0 < discount < 1 (example if discount = .4, then the 
	// price will be adjusted to 60% of the original price
	// the number of affected laptops is returned
	public int reducePrice(int threshold, double discount){
		int counter = 0;
		for (int i = 0; i < gamingLaptops.length; i++)
		{
			if (gamingLaptops[i] == null)
				continue;
			if (gamingLaptops[i].getNumInStock() > threshold)
			{
				double newPrice = gamingLaptops[i].getPrice();
				newPrice *= 1 - discount;
				gamingLaptops[i].setPrice(newPrice);
				counter += gamingLaptops[i].getNumInStock();
			}
		}
		return counter;
	}
	// returns an array of Laptops which have at least minRam RAM, at least minSS screensize, and at most maxPrice 
	// cost.  The returned array has length equal to the number of Laptop Object stored in it (no nulls)
	public GamingLaptop[] meetsRamSSandPrice(int minRam, double minSS, double maxPrice){


		return null;
	}

	// This method makes a purchase of the "top buy" Laptop according to the following algorithm:
	//  the "top buy" laptop is the laptop with the (highest performance score / price) ratio.  The number of 
	// laptops in stock should be reduced by one and the price of the laptop should be returned. 
	// If no GamingLaptops are in this ElectronicsWebsite, then 0 is returned.
	public double purchaseTopBuy(){

		return 0;
	}
	@Override
	public String toString(){
		String s = ""+getClass()+" "+hashCode()+"\nContains: \n";
		for(GamingLaptop gt:gamingLaptops){
			s+=gt+"\n";
		}
		return s;
	}

	public GamingLaptop get(int index) {
		
		return this.gamingLaptops[index];
	}

}

