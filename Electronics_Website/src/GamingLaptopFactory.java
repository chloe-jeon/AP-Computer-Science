public class GamingLaptopFactory{
	public static  final String[] BRANDS = {"Sony", "Dell", "Samsung", "Apple", "Asus","Razer","HP", "MSI"};
	public static final String[] MODELS = {"Vaio", "Stealth", "Blade", "Dominate", "Crusher","Flamethrower","Ballistic", "FanSoLoud", "FPS"};
	final static double BASE_PRICE = 1200; 
	final static double VARIABILITY = 2000;

	public static GamingLaptop getNewGamingLaptop(){
		String br = getRandomBrand();
		String model = getRandomModel();
		Spec spec = new GLaptopSpec();
		double price = BASE_PRICE+Math.random()*VARIABILITY;
		int numInStock =(int)( Math.random()*20);

		return new GamingLaptop(br,model,spec,price,numInStock);
	}

	private static String getRandomBrand(){
		int ind = (int)(Math.random()*BRANDS.length);
		return BRANDS[ind];
	}
	private static  String getRandomModel(){
		int ind = (int)(Math.random()*MODELS.length);
		String model = MODELS[ind];

		model += (int)(Math.random()*1000);

		model += randomLet();

		return model;
	}
	private static  String randomLet(){
		int above = (int)(Math.random()*26);
		char let = (char) (above +( Math.random()>.5?'A':'a'));
		return  ""+ let;
	}


}

