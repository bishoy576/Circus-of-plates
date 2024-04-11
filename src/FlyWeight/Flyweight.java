/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FlyWeight;

import Observer.Observer;
import Observer.SubjectList;
import Sound.Sound;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.sample.object.Shape;
import eg.edu.alexu.csd.oop.game.sample.world.CircusWorld;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author zedan.net
 */
public class Flyweight implements Observer {
    public SubjectList left = new SubjectList() ;
    private SubjectList right = new SubjectList() ;
     private  LinkedList<GameObject> recycle = new LinkedList<GameObject>() ;
    private List<GameObject> moving = new LinkedList<GameObject>();
    private  List<GameObject> control = new LinkedList<GameObject>();
    private int screenHeight ;
    private Sound sound = new Sound();
    CircusWorld w  ;
    int level ;
    public Flyweight( List<GameObject> control , List<GameObject> moving  , int screenHeight , CircusWorld s){
    this.control = control ;
    this.moving = moving ;
    this.screenHeight = screenHeight ;
    w = s;
  
    
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
            
    

    public SubjectList getLeft() {
        return left;
    }

    public void setLeft(SubjectList left) {
        this.left = left;
    }

    public SubjectList getRight() {
        return right;
    }

    public void setRight(SubjectList right) {
        this.right = right;
    }
    
    
    public boolean isRecyclable ( GameObject o ){
        return recycle.contains(o) ;
    }
    public  void recycle(  int posX , int posY ){
      
        
        if(this.level == 1)
            posY = 43 ;
        else 
        {Random r = new Random();
        int w = r.nextInt(2);
        if(w==0)
            posY = 43 ;
        else
            posY = 93 ;
        }
            
       
        
        
        
        
 while(! recycle.isEmpty())
            {  
               
               int p = posX ;
Random r = new Random() ; 
int x = r.nextInt(2);
if(x == 0)
  p =  0 - 50 * (3 * posX);
else
    p = 800 + 50 * (3 * posX);
    

recycle.get(0).setX(p);
    recycle.get(0).setY(posY);
 recycle.remove(recycle.get(0));
 
    posX++ ;

              
            }
  
    
   
//        System.out.println("Iam here ");
        
        
    }
    
    
    public boolean checkIfEmpty()
    {
        if(! recycle.isEmpty())
            return true ;
        return false ;
    }
    public void addShape (GameObject s)
    {
      this.recycle.add(s);
  
        
    }
    public void checkIfOut(GameObject e , int height)
    {
        if(e.getY() > height)
     recycle.add(e);
        
        
    }
 
    @Override
    public void updateLeft() {
        if (left.list.size() >= 3) {
           Shape p1 = (Shape) left.list.get(left.list.size() - 1);
            Shape p2 = (Shape) left.list.get(left.list.size() - 2);
            Shape p3 = (Shape) left.list.get(left.list.size() - 3);
            if (p1.getColor() == p2.getColor() && p2.getColor() == p3.getColor()) {
                  sound.setFile(3);
                  sound.play();
                  
               recycle.add(left.list.get(left.list.size() - 1));
              
                   recycle.add(left.list.get(left.list.size() - 2));
                
                  recycle.add(left.list.get(left.list.size() - 3));
   
                left.list.remove(left.list.size() - 1);
                left.list.remove(left.list.size() - 1);
                left.list.remove(left.list.size() - 1);
                control.remove(p1);
                control.remove(p2);
                control.remove(p3);
                p1.setC(null);
                p1.setHorizontalOnly(false);
                p1.setType(0);
                moving.add((GameObject) p1);
                 p2.setC(null);
                p2.setHorizontalOnly(false);
                p2.setType(0);
                moving.add((GameObject) p2);
                 p3.setC(null);
                p3.setHorizontalOnly(false);
                p3.setType(0);
                moving.add((GameObject) p3);
             
 
                left.notifyObservers();
                
            }
        }
    }

    
    @Override
  public void updateRight() {
        if (right.list.size() >= 3) {
            Shape p1 = (Shape) right.list.get(right.list.size() - 1);
            Shape p2 = (Shape) right.list.get(right.list.size() - 2);
           Shape p3 = (Shape) right.list.get(right.list.size() - 3);
            if (p1.getColor() == p2.getColor() && p2.getColor() == p3.getColor()) {
                sound.setFile(3);
                  sound.play();
                  recycle.add((GameObject)p1);
                 recycle.add((GameObject)p2);
                 recycle.add((GameObject)p3);
                right.list.remove(right.list.size() - 1);
                right.list.remove(right.list.size() - 1);
                right.list.remove(right.list.size() - 1);
                control.remove(p1);
                control.remove(p2);
                control.remove(p3);

              
                    p1.setC(null);
                p1.setHorizontalOnly(false);
                p1.setType(0);
                moving.add((GameObject) p1);
                 p2.setC(null);
                p2.setHorizontalOnly(false);
                p2.setType(0);
                moving.add((GameObject) p2);
                 p3.setC(null);
                p3.setHorizontalOnly(false);
                p3.setType(0);
                moving.add((GameObject) p3);
             
                right.notifyObservers();
            }
        }
    }
    
}
