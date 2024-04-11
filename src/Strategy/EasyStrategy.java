package Strategy;


import Strategy.IStrategy;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.sample.object.BarObject;
import java.awt.Color;
import java.util.List;

public class EasyStrategy implements IStrategy {

    
    
    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public double getTimeout() {
        return 1;
    
    }
     public void numberOfBars(List<GameObject> constant, int width)
       {
       
        constant.add(new BarObject(0, 50, 250, true, Color.BLACK));
        constant.add(new BarObject(width - 250, 50, 250, true, Color.BLACK)); 
       }

    @Override
    public int getNumberOfBars() {
       return 2 ;
    }

     
     
     
}
