
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.*;

public class MazeGUI extends JPanel implements Observer {

    private static final long serialVersionUID = 1L;
    private String title = "Maze Challenge";
    private CommandMenuController cmc;
    private NavigationController nc;
    private Maze theMaze;
    private JButton north;
    private JButton east;
    private JButton south;
    private JButton west;
    private JButton reset;
    private JTextField movesLeft;
    private JTextField colField;
    private JTextField rowField;
    private JMenuBar menuBar;
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();

    public MazeGUI() {

        //Construct the window

        theMaze = new Maze();
        theMaze.initializeMaze();

        theMaze.addObserver(this);

        nc = new NavigationController(this);
        cmc = new CommandMenuController(this);

        p1.setLayout(new FlowLayout());
        p1.add(new JLabel("Row"));
        rowField = new JTextField("" + theMaze.getPlayerRow(), 10);
        p1.add(rowField);
        rowField.addActionListener(nc);


        p1.add(new JLabel("Column"));
        colField = new JTextField("" + theMaze.getPlayerCol(), 10);
        p1.add(colField);
        colField.addActionListener(nc);


        p1.add(new JLabel("Moves Left"));
        movesLeft = new JTextField("" + theMaze.getNumMover(), 10);
        p1.add(movesLeft);
        movesLeft.addActionListener(nc);


        p2.setLayout(new FlowLayout());
        north = new JButton("North");
        p2.add(north);
        north.addActionListener(nc);

        south = new JButton("South");
        p2.add(south);
        south.addActionListener(nc);

        west = new JButton("West");
        p2.add(west);
        west.addActionListener(nc);

        east = new JButton("East");
        p2.add(east);
        east.addActionListener(nc);

        reset = new JButton("Reset");
        p2.add(reset);
        reset.addActionListener(nc);

        menuBar = new JMenuBar();

        JMenu command = GUIutils.makeMenu("&Command Menuue", new String[]{"&North", "Eas&t", "&West", "So&uth", "&Reset"}, cmc);

        menuBar.add(command);


    }//end of constructor.

    public Maze getTheMaze() {
        return theMaze;
    }

    /**
     * @return the movesLeft
     */
    public JTextField getMovesLeft() {
        return movesLeft;
    }

    /**
     * @return the colField
     */
    public JTextField getColField() {
        return colField;
    }

    /**
     * @return the rowField
     */
    public JTextField getRowField() {
        return rowField;
    }

    /**
     *  Creates and displays a frame for this panel
     */
    public void display() {
        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.getContentPane().add(p1);
        frame.getContentPane().add(p2);
        frame.getContentPane().add(p2, BorderLayout.SOUTH);
        frame.getContentPane().add(p1, BorderLayout.NORTH);
        frame.setJMenuBar(menuBar);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void update(Observable o, Object obj) {

        getRowField().setText("" + theMaze.getPlayerRow());
        getColField().setText("" + theMaze.getPlayerCol());
        getMovesLeft().setText("" + theMaze.getNumMover());

        return;

    }//update

    //Initializes gui to a new maze.
    public void initGUI() {

        theMaze.setChanged();
        theMaze.setChanged(false);
    }

    /**
     * Called when there is a new model
     * @param theModel: the new model
     */
    public void setTheModel(Maze m) {
        this.theMaze = m;
        theMaze.addObserver(this);
        initGUI();
    }

    public static void main(String[] args) {
        MazeGUI gui = new MazeGUI();
        gui.display();
    }
}//class

