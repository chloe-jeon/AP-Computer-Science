import java.util.ArrayList;

import kareltherobot.*;

public class SortableRobot extends Robot implements SortableBotInterface, Comparable<SortableRobot>{

    /**  
     * Constructs a Robot at the specified location witht he specified number of 
     * beepers facing North
     * @param s starting street
     * @param a starting avenue
     * @param b starting number of beepers
     */
    public SortableRobot(int s, int a, int b) {
        super(s, a, North, b);
    }
/**
 * Moves this Robot the specified number of steps
 * @param steps Number of steps to move.  If steps is <= 0, don't move.
 */
    public void move(int steps){

    }

    /**
     * Compares this Robot to bot.  If this Robot has more beepers, return positive int,
     * if this Robot has fewer beepers, return negative otherwise return 0
     */
    @Override
    public int compareTo(SortableRobot bot) {
      
        return 0;
    }

    @Override
    public void turnRight() {
        this.turnLeft();
        this.turnLeft();
        this.turnLeft();
    }

    @Override
    public void turnAround() {
       this.turnLeft();
       this.turnLeft();
    }

    @Override
    public void slideLeft(int steps) {
        
    }

    @Override
    public void slideRight(int steps) {
       

    }

    @Override
    public void showAllBeeps() {
        
    }

    // this method is required if we want other Objects to be able to 
    // ask how many beepers this Robot has
    @Override
    public int getNumBeeps() {
        return this.beepers();// beepers is protected
    }

    @Override
    public int[] getLocation() {
       
        return null;
    }

    @Override
    public void faceDirection(Direction dir) {
      

    }

    @Override
    public void moveToLocation(int[] loc) {
       

    }



    public static void main(String[] args){

        System.out.println("CODE TO TEST OUR SORTABLE ROBOT");
        SortableRobot sr1 = new SortableRobot(2, 3, 7),
                      sr2 = new SortableRobot(7, 3, 5),
                      sr3 = new SortableRobot(2, 8, 9),
                      sr4 = new SortableRobot(5, 1, 5);

        ArrayList<SortableRobot> list = new ArrayList<>();

        list.add(sr1);
        list.add(sr2);
        list.add(sr3);
        list.add(sr4);

        sr1.turnRight();
        sr2.turnAround();
        sr3.turnLeft();
        sr4.move();
        
        if(sr1.compareTo(sr2) < 0){
            System.out.println(sr1+" is smaller than "+sr2);
        }
        else{
            System.out.println(sr1+" is not smaller than "+sr2);
        }
        for(SortableRobot sr:list){
            if(sr1.compareTo(sr) < 0){
                System.out.println(sr1+" is smaller than "+sr);
            }
            else{
                System.out.println(sr1+" is not smaller than "+sr);
            }
        }
        sr1.moveToLocation(new int[]{9,9});

        for(SortableRobot sr: list){
            for(SortableRobot s: list){
                if(sr.compareTo(s) < 0){
                    System.out.println(sr+" is smaller than "+s);
                }
                else{
                    System.out.println(sr+" is not smaller than "+s);
                }
            }
        }
        for (SortableRobot sortableRobot : list) {
            sortableRobot.faceDirection(East);
            sortableRobot.showAllBeeps();
        }

    }

   
}