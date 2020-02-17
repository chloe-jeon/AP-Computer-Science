public interface Spec{
	final int[][] RESOLUTIONS = {{1366,768},{1600,900},{1920,1080},{2304,1440},{2560,1440},
			{2560,1600},{2880,1800},{3000,2000},{3200,1800},{3840,2160}};
	final double[] SCREEN_SIZES = {12.1, 13.3, 14, 15, 15.4, 15.7, 16, 17};
	final int[] RAM = {8, 12, 16, 24, 32, 48, 64};
	final int DRIVE_MULT = 64;
	final double VID_MIN = 2;

	double getScreenSize();// standard laptop screensizes are: 12.1, 13.3, 14
	int[]  getRes();// in the form [ pixels wide   ,    pixels high  ]
	int getRAM();// returns amount of RAM
	int getDriveSize(); // returns value in GB (1 TB ~ 1000GB)
	double getVidSpeed();  // returns speed in GHz
	double getPerformance(); // returns   0 <= number <= 10
} 