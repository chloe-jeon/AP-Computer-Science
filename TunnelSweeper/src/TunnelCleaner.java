import kareltherobot.Robot;

public class TunnelCleaner extends Robot {
	private int[] tunnelStartLoc;
	
	public TunnelCleaner(int i, int j, Direction dir)
	{
		super(i, j, dir, 0);
	}
/**
 * This function takes the TunnelCleaner to the entrance of the
 * tunnel and leaves it facing into the tunnel one step outside
 * We do not know the starting location nor the starting direction 
 * of the Robot.
 */
	public void findTunnel() {
		//turnWest and move until wall
		while (!facingWest())
			turnLeft();
		while (frontIsClear())
		{
			move();
		}
		//move to bottom and count length
		int bottom = 0;
		turnLeft();
		while (frontIsClear())
			move();
		turnLeft();
		while (frontIsClear())
		{
			move();
			bottom++;
		}
		//turn around, move to bottom and count length
		turnLeft();
		turnLeft();
		int top = 0;
		while (frontIsClear())
			move();
		turnLeft();
		turnLeft();
		turnLeft();
		while (frontIsClear())
			move();
		turnLeft();
		turnLeft();
		turnLeft();
		while (frontIsClear())
		{
			move();
			top++;
		}
		if (top > bottom)
		{
			turnLeft();
			turnLeft();
			for (int i = 0; i < top - bottom; i++)
				move();
			turnLeft();
			turnLeft();
			return;
		}
		if (bottom > top)
		{
			turnLeft();
			turnLeft();
			turnLeft();
			while (frontIsClear())
				move();
			turnLeft();
			return;
		}
		turnLeft();
		turnLeft();
		turnLeft();
		move();
		while (!checkLeft())
		{
			move();
		}
		turnLeft();
		return;
	}
	
	private boolean checkRight()
	{
		turnLeft();
		turnLeft();
		turnLeft();
		boolean ans = frontIsClear();
		turnLeft();
		return ans;
	}
	private boolean checkLeft()
	{
		turnLeft();
		boolean ans = frontIsClear();
		turnLeft();
		turnLeft();
		turnLeft();
		return ans;
	}

	/**
	 * This function takes the TunnelCleaner to the end of the
	 * tunnel and leaves it facing the exit.
	 * We know the bot starts at the entrance of the tunnel, facing
	 * in.  @return returns the number of steps it took to get
	 * to the end
	 * @return 
	 */
	public int navigateTunnel() {
		int steps = 0;
		while (true)
		{
			while (frontIsClear())
			{
				move();
				steps++;
			}
			if (checkLeft())
				turnLeft();
			else if (checkRight())
			{
				turnLeft();
				turnLeft();
				turnLeft();
			}
			else
				return steps;
		}
	}
	/**
	 * This method takes the robot from the end of the tunnel to the 
	 * entrance.  It has this Robot pick up piles of beepers along the
	 * way.  For each pile of beepers, it places the pile size into the
	 * specified array of ints at a location that corresponds to the 
	 * depth that the robot currently is in the tunnel.  Finally, the 
	 * location of the biggest pile is returned by this function, thus
	 * requiring the robot to save its location 
	 * @param beeperPiles The array to be filled.  Assume the length of
	 * the array equals the number of steps this Robot is from the entrance
	 * @return This method returns an array of int that has length of 2 
	 * and contains the street and avenue, respectively.
	 */
	public int[] exitAndClean(int[] beeperPiles) {
		int highestPileSize = -1;
		int[] highestPilePos = new int[2];
		turnLeft();
		turnLeft();
		for (int i = 0; i < beeperPiles.length; i++)
		{
			int numBeepers = 0;
			while (true)
			{
				move();
				turnLeft();
				turnLeft();
				if (nextToABeeper())
				{
					move();
					pickBeeper();
					numBeepers++;
					turnLeft();
					turnLeft();
				}
				else
				{
					move();
					turnLeft();
					turnLeft();
					beeperPiles[i] = numBeepers;
					if (numBeepers > highestPileSize)
					{
						highestPileSize = numBeepers;
						highestPilePos[0] = street();
						highestPilePos[1] = avenue();
					}
					break;
				}
			}
			move();
		}
		return highestPilePos;
	}
	
}
