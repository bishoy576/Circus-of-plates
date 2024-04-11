import MVC.*;
import Strategy.EasyStrategy;
import eg.edu.alexu.csd.oop.game.sample.world.CircusWorld;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.World;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JComboBox ;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
public class Main {

    public static void main(String[] args) {

       
       Model m = new Model() ;
       View v = new View() ;
       Control c = new Control(v, m);
       c.ShowGUI();
        
        
        
        JMenuBar menuBar = new JMenuBar();;
        JMenu menu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        JMenuItem resumeMenuItem = new JMenuItem("Resume");
        menu.add(newMenuItem);
        menu.addSeparator();
        
        menu.add(pauseMenuItem);
        menu.add(resumeMenuItem);
        menuBar.add(menu);
        //World gameWorld = new CircusWorld( 800, 500,c.selectedItem(),menuBar,Color.BLACK);
        World gameWorld = new CircusWorld( 800, 500,c.selectedItem()) ;
        final GameEngine.GameController gameController = GameEngine.start
        ("Hello", gameWorld, menuBar, Color.CYAN );
        newMenuItem.addActionListener((ActionEvent e) -> {
            
            gameController.changeWorld(gameWorld);
            
        });
        pauseMenuItem.addActionListener((ActionEvent e) -> {
            gameController.pause();
        });
        resumeMenuItem.addActionListener((ActionEvent e) -> {
            gameController.resume();
        });
    }
}
