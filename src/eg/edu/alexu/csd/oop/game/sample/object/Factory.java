/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.sample.object;

import java.awt.Color;

/**
 *
 * @author 20100
 */
public class Factory {
     private static  Factory factoryInstance ;
    PlateObject plate;
    BarObject bar;
    RectangleObject rect;
    BombObject bomb ;
    private Factory() {
    }
    public static Factory getFactoryInstance(){
        if( factoryInstance == null){
            factoryInstance = new Factory() ;
        }
        return factoryInstance ;
    }
    
    public BombObject createBomb(int x, int y, String path) {
//        if (plate == null) {
          return  new BombObject(x, y, path);
        //}
        //return plate;
    }



    public PlateObject createPlate(int x, int y, String path) {
//        if (plate == null) {
          return  new PlateObject(x, y, path);
        //}
        //return plate;
    }

    public RectangleObject createRect(int x, int y, String path) {
//        if (rect == null) {
            return new RectangleObject(x, y, path);
//        }
//        return rect;
    }

    public BarObject createBar(int posX, int posY, int width, boolean horizontalOnly, Color color) {
        //if (bar == null) {
           return  new BarObject(posX, posY, width, horizontalOnly, color);
//        }
//        return bar;
    }

}
