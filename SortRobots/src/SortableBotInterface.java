import kareltherobot.Directions;

public interface SortableBotInterface extends Directions {
	void turnRight();
	void faceDirection(Direction dir);
	void turnAround();
	/**
	 * This method moves this Robot to the left
	 * @param steps - The number of places to the left to be moved steps > 0
	 */
	void slideLeft(int steps);
	/**
	 * This method moves this Robot to the right
	 * @param steps - The number of places to the right to be moved steps > 0
	 */
	void slideRight(int steps);

	/**
	 * This method repeatedly puts beeper down and moves until it runs out of beepers
	 */
	void showAllBeeps();

	/**
	 * @return the number of beepers this robot has
	 */
	int getNumBeeps();

	/**
	 * @return int array of length 2 that has this Robot's street at index 0 
	 * and this Robot's avenue at index 1
	 */
	int[] getLocation();

	/**
	 * This method moves this Robot to the specified location.  
	 * @param loc will be of length 2.  loc[0] has the street this Robot will be 
	 * move to and loc[1] has the avenue to be moved to.  Both elements will be positive
	 */
	void moveToLocation(int[] loc);
}
