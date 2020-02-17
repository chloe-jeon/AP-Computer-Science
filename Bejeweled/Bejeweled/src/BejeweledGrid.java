import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BejeweledGrid {
	/**
	 * The 2D array of jewels
	 */
	private Jewel[][] jewels;
	/** Offsets for drawing the grid of Jewels*/
	public static final int OFFSET_X = 20, OFFSET_Y = 10; 
	
	public BejeweledGrid() {
		jewels = new Jewel[9][12];
		this.refill();
	}
	
	/** directs each Jewel to draw itself.  The Jewel knows its row
	 * and column and can ask the grid for the offset info
	 * @param g Graphics context onto which the Jewels will draw themselves
	 */
	public void draw(Graphics g) {
		for (int i = 0; i < jewels.length; i++)
		{
			for (int j = 0; j < jewels[i].length; j++)
				if (jewels[i][j] != null)
					jewels[i][j].draw(g);
		}
	}
	
	/** swaps the Jewels at the specified locations.  Also must
	 * tell the Jewels to set their rows and cols appropriately.
	 * @param r1 row of Jewel 1
	 * @param c1 col of Jewel 1
	 * @param r2 row of Jewel 2
	 * @param c2 col of Jewel 2
	 */
	public void swap(int r1, int c1, int r2, int c2) {
		jewels[r1][c1].row = r2;
		jewels[r1][c1].col = c2;
		jewels[r2][c2].row = r1;
		jewels[r2][c2].col = c1;
		
		Jewel temp = jewels[r1][c1];
		jewels[r1][c1] = jewels[r2][c2];
		jewels[r2][c2] = temp;
	}
	
	/**
	 * Creates an ArrayList<Jewel> of all Jewels that are part of a
	 * three-in-a-row.  The same Jewel may appear in the List more than
	 * once.
	 * @return
	 */
	public void _3InARow() {
		ArrayList<Jewel> list = _3InARowHor();
		list.addAll(_3InARowVert());
		while (list.size() != 0)
		{
			int tbdRow = list.get(0).row;
			int tbdCol = list.get(0).col;
			jewels[tbdRow][tbdCol] = null;
			list.remove(0);
		}
	}

	private ArrayList<Jewel> _3InARowHor() {
		
		ArrayList<Jewel> list = new ArrayList<Jewel>();
		for (int col = 0; col < jewels[0].length - 2; col++)
		{
			for (int row = 0; row < jewels.length; row++)
			{
				if (jewels[row][col] == null)
					continue;
				if (jewels[row][col].equalTo(jewels[row][col + 1]))
				{
					if (jewels[row][col].equalTo(jewels[row][col + 2]))
					{
						list.add(jewels[row][col]);
						list.add(jewels[row][col + 1]);
						list.add(jewels[row][col + 2]);
					}
				}
			}
		}
		return list;
	}
	
	private ArrayList<? extends Jewel> _3InARowVert() {
		ArrayList<Jewel> list = new ArrayList<Jewel>();
		for (int row = 0; row < jewels.length - 2; row++)
		{
			for (int col = 0; col < jewels[0].length; col++)
			{
				if (jewels[row][col] == null)
					continue;
				if (jewels[row][col].equalTo(jewels[row + 1][col]))
				{
					if (jewels[row][col].equalTo(jewels[row + 2][col]))
					{
						list.add(jewels[row][col]);
						list.add(jewels[row + 1][col]);
						list.add(jewels[row + 2][col]);
					}
				}
			}
		}
		return list;
	}
	/**
	 * This method drops all Jewels that should drop...
	 * Basically, any Jewel that has no Jewel below it needs to 
	 * be in a higher row.  Lots of ways to approach this.
	 */
	public void drop() {
		for (int col = 0; col < jewels[0].length; col++)
		{
			for (int i = 0; i < jewels.length - 1; i++)
			{
				for (int j = i; j < jewels.length - 1; j++)
				{
					if (jewels[j][col] == null)
						continue;
					if (jewels[j + 1][col] == null)
					{
						jewels[j][col].row++;
						jewels[j + 1][col] = jewels[j][col];
						jewels[j][col] = null;
					}
				}
			}
		}
		System.out.println("dropped");
	}
	
	/**
	 * Fill in any empty positions in the grid with randomly selected Jewel
	 */
	public void refill() {
		for (int i = 0; i < jewels.length; i++)
		{
			for (int j = 0; j < jewels[i].length; j++)
			{
				if (jewels[i][j] == null)
				{
					jewels[i][j] = randomJewel(i, j);
					System.out.println(jewels[i][j]);
				}
			}
		}
	}

	/**
	 * Generates a random Jewel that will have its starting location
	 * at the specified row and col.
	 * @param r row where the Jewel will be placed
	 * @param c col where the Jewel will be placed
	 * @return random type of Jewel constructed at r,c
	 */
	private Jewel randomJewel(int r, int c) {
		int type = (int) (Math.random() * 7);
		if (type == 0)
			return new Emerald(r, c);
		if (type == 1)
			return new Ruby(r, c);
		if (type == 2)
			return new Diamond(r, c);
		if (type == 3)
			return new Topaz(r, c);
		if (type == 4)
			return new Pearl(r, c);
		if (type == 5)
			return new Rhombus(r, c);
		if (type == 6)
			return new Amethyst(r, c);
		return null;
	}
	/**
	 * This method is called by the game when a click has been made 
	 * on the panel.  Must determine if the click makes sense (is it 
	 * a valid location, is there a Jewel at the location, can that 
	 * Jewel be clicked).  If it is the first click, then note it and
	 * the next click will attempt a move (maybe).
	 * @param me
	 */
	
	private int[] prevClick = {-1, -1};
	
	public void justClicked(MouseEvent me) {
		int row = (me.getY() - OFFSET_Y) / 64;
		int col = (me.getX() - OFFSET_X) / 64;
		if (row < 0 || row >= jewels.length)
			return;
		if (col < 0 || col >= jewels[0].length)
			return;

		if (prevClick[0] == -1 || prevClick[1] == -1)
		{
			System.out.println("first click");
			jewels[row][col].selected = true;
			prevClick[0] = row; prevClick[1] = col;
		}
		else
		{
			if (!nextTo(prevClick[0], prevClick[1], row, col))
			{
				System.out.println("second click, not next to");
				jewels[prevClick[0]][prevClick[1]].selected = false;
				jewels[row][col].selected = true;
				prevClick[0] = row; prevClick[1] = col;
				return;
			}
			System.out.println("second click, next to");
			jewels[prevClick[0]][prevClick[1]].selected = false;
			jewels[row][col].selected = false;
			
			swap(prevClick[0], prevClick[1], row, col);
			
			_3InARow();
			drop();
			refill();
			
			prevClick[0] = -1;
			prevClick[1] = -1;
		}
		System.out.println("End of mouse event.");
	}
	
	private boolean nextTo(int row1, int col1, int row2, int col2)
	{
		if (row1 == row2)
		{
			if (col1 == col2 + 1 || col1 == col2 - 1)
				return true;
		}
		if (col1 == col2)
		{
			if (row1 == row2 + 1 || row1 == row2 - 1)
				return true;
		}
		return false;
	}
	
}
