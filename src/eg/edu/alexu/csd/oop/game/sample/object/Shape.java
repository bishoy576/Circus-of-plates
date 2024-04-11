/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.sample.object;

import eg.edu.alexu.csd.oop.game.GameObject;

/**
 *
 * @author zedan.net
 */
public interface Shape {
    public ImageObject getC();
     public void setC(ImageObject c);
     public void setX(int mX);
      public void setY(int mY);
          public void setHorizontalOnly(boolean horizontalOnly);
            public int getWidth();
             public void setType(int type) ;
              public int getType();
              public int getY();
               public int getX() ;
               public void setPath(String path) ;
                public String getPath();
                public void setColor(int x);
                public int getColor();
}
