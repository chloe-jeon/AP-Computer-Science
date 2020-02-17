import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import info.gridworld.grid.*;
import info.gridworld.world.*;

public final class LifeRunner {

	private JFrame frame = new JFrame("Life, as we know it!");
	private JPanel panel;
	private int currentGen;
	private int numClicks;
	private int[][] grid;// to be constructed in the makeGrid method
	private final boolean SHOW_GUI = true;

//	JOptionPane promter = new JOptionPane("Pick a color scheme:");
	
	
	public static void main(String[] args) {
		new LifeRunner().start();
	}

	private void start() {
		makeGrid(45,60, 116);// row, col, lives
		if(this.SHOW_GUI)
			makeFrame();

		printGrid();
		if(this.SHOW_GUI)
			this.frame.repaint();
		printGrid();
		if(this.SHOW_GUI)
			frame.repaint();


	}



	private void makeFrame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel  = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				// code to draw on graphics
				
//				g.setColor(new Color(100,100,100));
//				g.fillRect(200, 100+15*currentGen, 75, 20);
//				g.setColor(Color.RED);
//				g.drawLine(10+10*currentGen, 50, 600, 100);
				showLife(g);
			}
		};
		frame.add(panel);
		panel.setLayout(null);
		JButton button = new JButton("Next");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Code to be performed when button is clicked
				nextGen();
				panel.repaint();
			}
		});
		panel.add(button);
		button.setBounds(350, 250, 100,100);
		panel.setPreferredSize(new Dimension(800,600));
		frame.pack();
		frame.setVisible(true);
	}

	final int WIDTH = 13;
	
	protected void showLife(Graphics g) {
		for (int i = 1; i < (grid.length - 1); i++)
		{
			for (int j = 1; j < (grid[i].length - 1); j++)
			{
				g.setColor(Color.gray);
				if (grid[i][j] == 1)
					g.setColor(Color.yellow);
				g.fillRect(j * WIDTH, i * WIDTH, WIDTH, WIDTH);
				g.setColor(Color.white);
				g.drawRect(j * WIDTH, i * WIDTH, WIDTH, WIDTH);
			}
		}
	}

	/**
	 * create a grid with dimension of rows X cols with lives objects
	 * randomly placed into the grid.  One tricky part is to make sure you are 
	 * placing the correct number of objects in the grid.  If you randomly 
	 * come up with the same location, your code needs to account for that!
	 * 
	 * After making the grid, it is added to the List of grids
	 * 
	 * @param rows number of rows in the grid
	 * @param cols number of cols in the grid
	 * @param lives number of lives to be added to the grid
	 */
	private void makeGrid(int rows, int cols, int lives) {
		grid = new int[rows + 2][cols + 2]; //buffer zone of 0's
		while (lives > 0)
		{
			int r = (int)(rows * Math.random()) + 1;
			int c = (int)(cols * Math.random()) + 1;
			if (grid[r][c] == 0)
			{
				grid[r][c] = 1;
				lives--;
			}
		}
	}
	/**
	 * Prints the specified 2D array of int to the console.
	 * @param grid2 
	 */
	private void printGrid() {
		for (int i = 1; i < (grid.length - 1); i++)
		{
			for (int j = 1; j < (grid[i].length - 1); j++)
			{
				if (grid[i][j] == 1)
					System.out.print("*");
				else
					System.out.print("-");
			}
			System.out.println();
		}
	}
	/**
	 * This method advances grid from the previous generation to the next generation
	 * based on these two simple rules:
	 * 1.  If there are 3 or more neighboring objects around a cell, that cell will  contain a 
	 *     life in the subsequent generation.
	 * 2.  If there are 1 or less neighboring objects around a cell, that cell won't contain a
	 *     life in the subsequent generation.
	 *     
	 * Be sure to make all the changes to a different grid.
	 * Finally, the newest grid is added to the list of generations
	 */
	private void nextGen() {
		this.currentGen++;
		System.out.println("creating next gen "+currentGen);
		
		int[][] grid2 = new int[grid.length][grid[0].length];
		for (int i = 1; i < (grid.length - 1); i++)
		{
			for (int j = 1; j < (grid[i].length - 1); j++)
			{
				int numNeighbors = 0;
				numNeighbors += grid[i - 1][j - 1];
				numNeighbors += grid[i - 1][j - 0];
				numNeighbors += grid[i - 1][j + 1];
				numNeighbors += grid[i - 0][j - 1];
				numNeighbors += grid[i - 0][j + 1];
				numNeighbors += grid[i + 1][j - 1];
				numNeighbors += grid[i + 1][j - 0];
				numNeighbors += grid[i + 1][j + 1];
				if (numNeighbors > 2)
					grid2[i][j] = 1;
				else if (numNeighbors < 2)
					grid2[i][j] = 0;
				else
					grid2[i][j] = grid[i][j];
			}
		}
		
		for (int i = 1; i < (grid.length - 1); i++)
		{
			for (int j = 1; j < (grid[i].length - 1); j++)
			{
				grid[i][j] = grid2[i][j];
			}
		}
		
		printGrid();
		makeFrame();
	}


}
