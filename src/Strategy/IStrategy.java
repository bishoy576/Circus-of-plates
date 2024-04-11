package Strategy;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.List;


public interface IStrategy {

    public int getSpeed();

    public double  getTimeout();
    
    public void numberOfBars (List<GameObject> constant , int width);
    public int getNumberOfBars();
}
