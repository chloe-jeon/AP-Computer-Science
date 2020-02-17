import kareltherobot.Directions;
import kareltherobot.World;
import javax.swing.JOptionPane;

public class TunnelSweeperTester implements Directions{

	public static void main(String[] args) {
		new TunnelSweeperTester().start();
	}
	
	private int steps;				// depth of tunnel
	private int[] beeperPiles;		// array containing all pile heights
	private int[] bigPileLoc;		// array with two ints [street, ave]
	private int[] tunnelEntrance;	// array with two ints [street, ave]

	private void start()
	{
		String worldName = promptForWorld();
		String[] robotInfo = promptForRobotInfo();
		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(5);
		// create TunnelCleaner with info from line 12
		TunnelCleaner tc = makeBot(robotInfo);
		
		sweepTunnel(tc);
//		displayResults();
	}
	private String promptForWorld()
	{
		String name = JOptionPane.showInputDialog("World Name:");
		//String name = "tunnel1.wld";
		return name;
	}
	private String[] promptForRobotInfo()
	{
		String[] robotInfo = new String[3];
		robotInfo[0] = JOptionPane.showInputDialog("Street (integer)");
		robotInfo[1] = JOptionPane.showInputDialog("Avenue (integer)");
		robotInfo[2] = JOptionPane.showInputDialog("Direction (e.g. North)");
		return robotInfo;
	}
	/**
	 * This method parses the Strings in robotInfo and return
	 * a robot with that info
	 * @param robotInfo array of Strings with 3 elements
	 *        robotInfo[0] will represent street, 
	 *        robotInfo[1] avenue
	 *        robotInfo[2] direction
	 * @return TunnelCleaner initialized with specified info
	 */
	private TunnelCleaner makeBot(String[] robotInfo)
	{
		int i = Integer.parseInt(robotInfo[0]);
		int j = Integer.parseInt(robotInfo[1]);
		Direction dir = North;
		if (robotInfo[2].equals("South"))
			dir = South;
		else if (robotInfo[2].equals("East"))
			dir = East;
		else if (robotInfo[2].equals("West"))
			dir = West;
		return new TunnelCleaner(i, j, dir);
	}
	private void sweepTunnel(TunnelCleaner tc) {
		tc.findTunnel();
		steps = tc.navigateTunnel();
//		System.out.println(steps);
		beeperPiles = new int[steps];
		bigPileLoc = tc.exitAndClean(beeperPiles);
		System.out.println(bigPileLoc);
	}
	/**
	 * Display the following info:
	 * 
	 * Location of the tunnel entrance
	 * Depth of the tunnel
	 * Highest pile size and location of the highest pile
	 * Total # of beepers, beeper piles and average pile size
	 */
	private void displayResults() {
		
		
	}
}
