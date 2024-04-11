/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.sample.object.BarObject;
import java.awt.Color;
import java.util.List;

/**
 *
 * @author zedan.net
 */
public class HardStrategy implements IStrategy{

    @Override
    public int getSpeed() {
        return 6;
    }

    @Override
    public double getTimeout() {
        return  0.30;
    }    

    @Override
    public void numberOfBars(List<GameObject> constant, int width) {
        constant.add(new BarObject(0, 50, 250, true, Color.BLACK));
        constant.add(new BarObject(width - 250, 50, 250, true, Color.BLACK)); 
        constant.add(new BarObject(0, 100, 100, true, Color.BLACK));
          constant.add(new BarObject(width - 100, 100, 100, true, Color.BLACK)); 
    }

    @Override
    public int getNumberOfBars() {
      return  4; 
    }
}
