
import java.io.File;
import java.io.Serializable;
import java.util.Observable;
import java.util.Random;

import javax.swing.JOptionPane;

public class Maze extends Observable implements Serializable {

    private final int maxRow_size = 20;
    private final int maxCol_size = 20;
    private int playerRow;
    private int playerCol;
    private int exitRow;
    private int exitCol;
    private int numMover;
    private static final long serialVersionUID = 1L;


    /**
     * True if changes have been made to this model that need to be saved
     * before exiting or opening a new model
     */
    private boolean changed = false;

    public Maze() {
    }

    public Maze(int playerCol, int playerRow, int exitCol, int exitRow, int numMover) {
        super();
        this.playerRow = playerRow;
        this.playerCol = playerCol;
        this.exitRow = exitRow;
        this.exitCol = exitCol;
        this.numMover = numMover;

    }

    public void initializeMaze() {

        //Randomly generate initial place of the player when the game is started

        Random r = new Random();
        int random_col = r.nextInt(maxCol_size);
        int random_row = r.nextInt(maxRow_size);
        int random_exit_col = r.nextInt(maxCol_size);
        int random_exit_row = r.nextInt(maxRow_size);

        setPlayerCol(random_col);
        setPlayerRow(random_row);
        setExitCol(random_exit_col);
        setExitRow(random_exit_row);

        setNumMover(40);

        setChanged();

    }

    /**
     * @return the maze_moves
     */
    public int getMaze_moves() {
        return numMover;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    /**
     * notifies observers of changes and sets changed flag to true
     */
    @Override
    public void setChanged() {
        super.setChanged();
        this.notifyObservers();
        this.changed = true;
    }

    /**
     * @param playerRow the playerRow to set
     */
    public void setPlayerRow(int playerRow) {
        this.playerRow = playerRow;
    }

    /**
     * @param playerCol the playerCol to set
     */
    public void setPlayerCol(int playerCol) {
        this.playerCol = playerCol;
    }

    /**
     * @param numMover the numMover to set
     */
    public void setNumMover(int numMover) {
        this.numMover = numMover;
    }

    /**
     * @return the playerRow
     */
    public int getPlayerRow() {
        return playerRow;
    }

    /**
     * @return the playerCol
     */
    public int getPlayerCol() {
        return playerCol;
    }

    /**
     * @return the numMover
     */
    public int getNumMover() {
        return numMover;
    }

    /**
     * @return the exitRow
     */
    public int getExitRow() {
        return exitRow;
    }

    /**
     * @param exitRow the exitRow to set
     */
    public void setExitRow(int exitRow) {
        this.exitRow = exitRow;
    }

    /**
     * @return the exitCol
     */
    public int getExitCol() {
        return exitCol;
    }

    /**
     * @param exitCol the exitCol to set
     */
    public void setExitCol(int exitCol) {
        this.exitCol = exitCol;
    }

    private void chkeck_if_youCan_Move() {

        if (numMover > 0) {
            numMover--;
        } else {
            JOptionPane.showMessageDialog(null, "             Game is Over!\n"
                    + "You had reached maximum number of steps!");
            return;
        }

    }

    public void move(String heading) {

        if (heading == null ? "Reset" == null : heading.equals("Reset")) {
            initializeMaze();
            setChanged();

            return;
        }


        if (heading == null ? "North" == null : heading.equals("North")) {

            if ((getPlayerRow() - 1) < 0) {

                chkeck_if_youCan_Move();
                setPlayerRow(maxRow_size - 1);
                setChanged();


                check_if_Exit();
            } else {

                chkeck_if_youCan_Move();
                setPlayerRow(getPlayerRow() - 1);
                setChanged();
                notify();

                check_if_Exit();
            }

            return;
        }

        if (heading == null ? "South" == null : heading.equals("South")) {

            if ((getPlayerRow() + 1) >= maxRow_size) {

                chkeck_if_youCan_Move();
                setPlayerRow(0);
                setChanged();


                check_if_Exit();
            } else {

                chkeck_if_youCan_Move();
                setPlayerRow(getPlayerRow() + 1);
                setChanged();

                check_if_Exit();
            }

            return;
        }

        if (heading == null ? "West" == null : heading.equals("West")) {

            if ((getPlayerCol() - 1) < 0) {

                chkeck_if_youCan_Move();
                setPlayerCol(maxCol_size - 1);
                setChanged();


                check_if_Exit();
            } else {

                chkeck_if_youCan_Move();
                setPlayerCol(getPlayerCol() - 1);
                setChanged();

                check_if_Exit();
            }

            return;
        }

        if (heading == null ? "East" == null : heading.equals("East")) {

            if ((getPlayerCol() + 1) >= maxCol_size) {

                chkeck_if_youCan_Move();
                setPlayerCol(0);
                setChanged();

                check_if_Exit();
            } else {

                chkeck_if_youCan_Move();
                setPlayerCol(getPlayerCol() + 1);
                setChanged();

                check_if_Exit();
            }

            return;
        }

        JOptionPane.showMessageDialog(null, "Unexpected move!");


    }//move

    private void check_if_Exit() {

        if (getExitCol() == getPlayerCol() && getExitRow() == getPlayerRow()) {
            JOptionPane.showMessageDialog(null, "You won!");
            initializeMaze();
        }

        return;
    }
}//class 

