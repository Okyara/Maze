
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class CommandMenuController extends MazeController {

    private Maze maze;

    public CommandMenuController(MazeGUI gui) {
        super(gui);
    }

    public void actionPerformed(ActionEvent e) {

        //Get the new maze (updated maze) every time you perform
        //an action.
        maze = get_TheMaze();


        String cmmd = e.getActionCommand();

        if (cmmd.equals("North")) {

            maze.move("North");
            return;
        }

        if (cmmd.equals("South")) {

            maze.move("South");
            return;
        }

        if (cmmd.equalsIgnoreCase("West")) {

            maze.move("West");
            return;
        }


        if (cmmd.equalsIgnoreCase("East")) {

            maze.move("East");
            return;
        }


        if (cmmd.equalsIgnoreCase("Reset")) {

            if (0 == JOptionPane.showConfirmDialog(null, "Do you want to reset the game?")) {

                maze.move("Reset");
                return;
            }
        }

    }//ActionPerformed

}//class

