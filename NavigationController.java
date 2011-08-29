import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class NavigationController extends MazeController implements ActionListener  {

     private Maze maze;
     

     public NavigationController(MazeGUI gui) {
			super(gui);
			
		}
     
 
     public void actionPerformed(ActionEvent e) {
    	 
    	 maze = get_TheMaze();
	
	 
       String button_push = e.getActionCommand();
       
        if(button_push=="North") {
          
        	maze.move("North");
        	return;
        } 
        
        if(button_push=="South") {
        	
        	maze.move("South");
        	return;
        } 
           
        if(button_push=="West"){
        	
        	maze.move("West");
            return;
        } 


        if(button_push=="East"){
        	
        	maze.move("East");
            return;
        } 


        if(button_push=="Reset"){
        	
            if(0 == JOptionPane.showConfirmDialog(null, "Do you want to reset the game?")) {

            	maze.move("Reset");
            	return;
            } 
        }            	
 
     }//end of ActionPerformed method
   
   
 
}//end of class

