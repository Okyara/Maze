
import java.awt.event.*;

public abstract class MazeController implements ActionListener {

    private MazeGUI mazeGui_obj;

    public MazeController(MazeGUI gui) {
        this.mazeGui_obj = gui;
    }

    public Maze get_TheMaze() {
        return mazeGui_obj.getTheMaze();
    }

    public abstract void actionPerformed(ActionEvent e);
}
