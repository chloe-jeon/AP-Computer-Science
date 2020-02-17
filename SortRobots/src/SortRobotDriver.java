import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SortRobotDriver {
	// like a new data type!
	private enum SORTS  {Bubble,Selection,Insertion,Quick, Merge};

	private final ArrayList<SortableRobot> botList = new ArrayList<>();

	public static void main(final String[] args) {
		new SortRobotDriver().start();
	}

	private void start() {
		final int numBots = 0, maxBeeps=0;
		//1. input number of robots, and max number of robots
		
		//2. create that number of robots (from part 1) with max number
		// of beeps, and place into an array and return that array to here.
		
		makeBots(numBots, maxBeeps);
		//3. Find robot with min # of beeps. Have that bot show all beeps
		showRobotWithMinBeeps();
		//4. Repeat looking for max # of beeps.
		showRobotWithMaxBeeps();
		
		// When you are sure the two methods above work, comment out that code
		//Now sort 
		final ArrayList sortList = new ArrayList();
		for (final Object sort : SORTS.values()) {
			sortList.add(sort);
		}
		String[] sorts = new String[sortList.size()];
		
		for(int ind = 0;ind < sortList.size(); ind++) {
			sorts[ind]= sortList.get(ind).toString();
		}
			
		final int sortType = promptForSortType(sorts);
		sortAndMove(SORTS.values()[sortType]);
		
		final int sel =JOptionPane.showConfirmDialog(null, "OK to try again, cancel to exit");
		//if()
	}

	private void sortAndMove(final SORTS sorts) {
		switch(sorts){

			case Selection:
				selectionSort();
				break;
			case Bubble:
				bubbleSort();
				break;
			case Insertion:
				insertionSort();
				break;
			case Quick:
				quickSort();
				break;
			case Merge:
				mergeSort();
				break;
			default:
				break;
				
		}
	}

	
	private void selectionSort() {
	}

	private void bubbleSort() {
	}
	private void mergeSort() {
	}

	private void quickSort() {
	}

	private void insertionSort() {
	}

	

	private int promptForSortType(final String[] sorts) {

		final JComboBox<String> sortList = new JComboBox<String>(sorts);
		
        // Add to panel with accompanying label
        final JPanel panel = new JPanel();

        panel.add(new JLabel("Choose Sort Type:"));
        panel.add(sortList);
        
        // Display the dialog
        JOptionPane.showMessageDialog(null, panel);

		return sortList.getSelectedIndex();

	}

    /**
	 * Find the SortableRobot with the fewest number of beepers and have it invoke
	 * its showAllBeeps method.  
	 */
	private void showRobotWithMinBeeps() {
		int minIndex = -1;
		int minVal = Integer.MAX_VALUE;
		for (int i = 0; i < botList.length; i++)
		{
			if (botList[i] < minVal)
			{
				minIndex = i;
				minVal = botList[i];
			}
		}
	}

	/**
	 * Find the SortableRobot with the most number of beepers and have it invoke its
	 * showAllBeeps method.
	 */
	private void showRobotWithMaxBeeps() {
	}

	/**
	 * Adds numBots SortableRobots to the ArrayList botList. Each Robot is on its
	 * own location and facing North with a random number of beepers, where 0 <
	 * beepers < maxBeeps
	 * 
	 * @param numBots  Number of SortableRobots to make
	 * @param maxBeeps The maximum number of beepers to give Robot when constructed
	 */
	private void makeBots(final int numBots, final int maxBeeps) {
		for (int i = 1; i <= numBots; i++)
		{
			Random rand = new Random();
			int numBeeps = rand.nextInt(maxBeeps + 1);
			botList.add(new SortableRobot(1, i, numBeeps));
		}
	}

}
