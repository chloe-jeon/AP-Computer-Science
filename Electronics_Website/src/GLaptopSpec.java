public class GLaptopSpec implements Spec{

	private double screenSize, vidSpeed, performance;
	private int driveSize, ram;
	private int[] res;

	public GLaptopSpec(){
		screenSize = randScreenSize();
		vidSpeed = randVidSpeed();
		performance = randPerformance();
		driveSize = randDriveSize();
		ram = randRAM();
		res = randRes();
	}
	public double getScreenSize(){// standard laptop screensizes are: 12.1, 13.3, 14
		return screenSize;
	}
	public int[]  getRes(){// in the form [ pixels wide   ,    pixels high  ]
		return res;
	}
	public int getRAM(){// returns amount of RAM
		return ram;
	}
	public int getDriveSize(){ // returns value in GB (1 TB ~ 1000GB)
		return driveSize;
	}
	public double getVidSpeed(){ // returns speed in GHz
		return vidSpeed;
	}
	public double getPerformance(){ // returns   0 <= number <= 10
		return performance;
	}

	private double randScreenSize(){
		int ind = randInd(Spec.SCREEN_SIZES.length);
		return SCREEN_SIZES[ind];
	}
	private int[]  randRes(){
		int ind = randInd(Spec.RESOLUTIONS.length);
		return RESOLUTIONS[ind];
	}
	private int randRAM(){
		int ind = randInd(Spec.RAM.length);
		return RAM[ind];
	}
	private int randDriveSize(){ 
		return (int)(Math.pow(2, (int)(Math.random()*6))*Spec.DRIVE_MULT);
	}
	private double randVidSpeed(){ 
		return Spec.VID_MIN + Spec.VID_MIN*Math.random();
	}
	private double randPerformance(){
		return 4 + Math.random()*6;
	}
	private int randInd(int max){
		return (int)(Math.random()*max);
	}
}