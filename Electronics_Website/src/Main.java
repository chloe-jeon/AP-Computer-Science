import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Main {
 
	private ElectronicsWebsite amazon = new ElectronicsWebsite();
	Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Main().start();
	}
	
	public void start(){
		fillWithRandomGamingLaptops(amazon);
		System.out.print(amazon);
		testFindMostExpensive();
		testReducePrice();
		testMeetsRamSSandPrice();
		testPurchaseTopBuy();
		
	}
	public  void fillWithRandomGamingLaptops(ElectronicsWebsite a){
		int numToMake = 25;
		while(numToMake>0){
			numToMake--;
			GamingLaptop gl =null;
			if(Math.random()>.25){
				gl = GamingLaptopFactory.getNewGamingLaptop();
			}
			a.add(gl);
		}
	}
	

	private void testFindMostExpensive() {
		System.out.println("Testing Find-Most-Expensive");
		
		int index = amazon.findMostExpensive();
		if(index == -1) {
			System.out.println(amazon +" was empty!");
		}
		else {
			System.out.println("The most expensive laptop was "+amazon.get(index));
		}
		
		
		
	}

	private void testReducePrice() {
		System.out.println("Testing Reduce-Price");
		
		int threshold = -1;
		do {
			System.out.print("Enter the threshold: ");
			try {
				threshold = in.nextInt();
				if(threshold < 0)
					throw new NoSuchElementException();
			}catch(InputMismatchException e) {
				System.out.println("Enter an integer!  "+e);
			}
			catch(NoSuchElementException e) {
				System.out.println("Enter an positive integer!  "+e);
				threshold = -1;
			}
			in.hasNext();
		}while(threshold < 0 );
		// should have valid threshold
		int numLaptops = amazon.reducePrice(threshold, .2);
		System.out.println(amazon);
		
	}

	private void testMeetsRamSSandPrice() {
		System.out.println("Testing Meets-Traits.  I assume you will pick some values that make sense");
		
		System.out.print("Enter ram min: ");
		int ramMin = in.nextInt();
		System.out.print("Enter screen size min: ");
		double ssMin = in.nextDouble();
		System.out.print("Enter price max: ");
		double priceMax = in.nextDouble();
		
		GamingLaptop[] arr = amazon.meetsRamSSandPrice(ramMin, ssMin, priceMax);
		
		System.out.println("Here are the laptops that meet your needs");
		if(arr != null)
			for(GamingLaptop gt:arr)
				System.out.println(arr);
		else {
			System.out.println("None... sorry :(");
		}
	}

	private void testPurchaseTopBuy() {
		System.out.println("Testing Purchase-Top-Buy");
		for(int i = 0; i<10; i++) {
			double amt = amazon.purchaseTopBuy();
			System.out.println("The top buy cost "+amt+" dollars.  Enjoy!");
		}
		
		
	}

	

}