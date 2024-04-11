package eg.edu.alexu.csd.oop.game.sample.world;


import FlyWeight.Flyweight;
import Observer.Score;
import Observer.SubjectList;
import Sound.Sound;
import eg.edu.alexu.csd.oop.game.sample.object.PlateObject;
import eg.edu.alexu.csd.oop.game.sample.object.ImageObject;
import eg.edu.alexu.csd.oop.game.sample.object.BarObject;
import java.util.LinkedList;
import java.util.List;
import eg.edu.alexu.csd.oop.game.* ;
import Strategy.* ;
import eg.edu.alexu.csd.oop.game.sample.object.RectangleObject;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.awt.Color;
import java.util.Random;
import eg.edu.alexu.csd.oop.game.sample.object.Shape;
import eg.edu.alexu.csd.oop.game.sample.object.Factory;
import eg.edu.alexu.csd.oop.game.sample.object.BombObject ;
import iterator.Iterator;
import iterator.IteratorClass;
public class CircusWorld implements World {
  private Factory shapeFactory = Factory.getFactoryInstance();
 // 1 minute
   private final Sound sound = new Sound();
    private final long startTime = System.currentTimeMillis();
    private final int width;
    private final int height;
    private final List<GameObject> constant = new LinkedList<GameObject>();
    private final List<GameObject> moving = new LinkedList<GameObject>();
    private  List<GameObject> control = new LinkedList<GameObject>();
    private IStrategy current;
      SubjectList left = new SubjectList() ;
        SubjectList right = new SubjectList() ;
        Score s = new Score();
        Flyweight flyweight  ;
        private IteratorClass iterator ;
private static double MAX_TIME ;
    public CircusWorld( int screenWidth, int screenHeight , String level) {
       flyweight = new Flyweight(control, moving,screenHeight,this) ;
      left.register(s);
      right.register(s);
      left.register(flyweight);
      right.register(flyweight);
      s.setLeft(left);
      s.setRight(right);
            
      constant.add(new ImageObject(0,0, "/Background.png"));
        width = screenWidth;
        height = screenHeight;
        
        if(level.equals("Easy")){
            flyweight.setLevel(1);
            current = new EasyStrategy() ;
            MAX_TIME = 1 * 60 * 1000;	}
        
        else if(level.equals("Medium")){
             flyweight.setLevel(2);
            current = new MediumStrategy();
            MAX_TIME = 0.75 * 60 * 1000;	
        }
        else{ flyweight.setLevel(3);
            current = new HardStrategy() ;
        MAX_TIME = 0.50 * 60 * 1000;	
        }
        
       
        sound.setFile(0);
        control.add(new ImageObject(screenWidth / 3, (int) (screenHeight * 0.6), "/clown1.png"));
       sound.play();
       sound.loop();
        moveShapes();
         

     }
      
    public void moveShapes ()
            {
                Random r = new Random();
 current.numberOfBars(constant, width);
        for (int i = 0; i <15; i++) {
            int y = r.nextInt(5);
            int z =((int) (Math.random() * 1000) % 2 + 1);
            if(current.getNumberOfBars() ==2){
                 int it1 = r.nextInt(6);
            
            switch(it1)
            {   
              

                case 0 :
                   
                
                    moving.add(shapeFactory.createRect(0 - 50 * (3 * i), 43, "/Rectangle" +z+ ".png"));
                    break ;
                    
                case 1:
                 
                    moving.add(shapeFactory.createRect(800 + 50 * (3 * i), 43, "/Rectangle" +z+ ".png"));
                     break ;
                case 2 :
          
                    moving.add(shapeFactory.createPlate(0 - 50 * (3 * i), 43, "/plate" +z+ ".png"));
                    break ;
                    
                case 3:
           
                    moving.add(shapeFactory.createPlate(800 + 50 * (3 * i), 43, "/plate" +z+ ".png"));
                     break ;
                case 4 :
                    moving.add(shapeFactory.createBomb(800 + 50 * (3 * i), 43, "/Bomb.png"));
                    break ;
                case 5 :
                   moving.add(shapeFactory.createBomb(0 - 50 * (3 * i), 43, "/Bomb.png"));
                    break ; 
                    
            }
 
         }
        
        else if (current.getNumberOfBars() ==3 )
                { int it2 = r.nextInt(9);
                   switch(it2)
            {   
              
               
                case 0 :
                   // RectangleObject rect1= new RectangleObject(0 - 50 * (3 * i), 43, "/Rectangle" +z+ ".png");
                    moving.add(shapeFactory.createRect(0 - 50 * (3 * i), 43, "/Rectangle" +z+ ".png"));
                    break ;
                    
                case 1:
                     //RectangleObject rect2 = new RectangleObject(800 + 50 * (3 * i), 43, "/Rectangle" + z+ ".png");
                    moving.add(shapeFactory.createRect(800 + 50 * (3 * i), 43, "/Rectangle" +z+ ".png"));
                     break ;
                case 2 :
                   // PlateObject p1 = new PlateObject(0 - 50 * (3 * i), 43, "/plate" +z+ ".png");
                    moving.add(shapeFactory.createPlate(0 - 50 * (3 * i), 43, "/plate" +z+ ".png"));
                    break ;
                    
                case 3:
                 
                    moving.add(shapeFactory.createPlate(800 + 50 * (3 * i), 43, "/plate" +z+ ".png"));
                     break ;
                    
                case 4: 
             
                    moving.add(shapeFactory.createRect(0 - 50 * (3 * i), 93, "/Rectangle" +z+ ".png"));
                    break ;
                case 5:
                       
                    moving.add(shapeFactory.createPlate(0 - 50 * (3 * i), 93, "/plate" +z+ ".png"));
                    break ;
                     
                  case 6 :
                    moving.add(shapeFactory.createBomb(800 + 50 * (3 * i), 43, "/Bomb.png"));
                    break ;
                case 7 :
                   moving.add(shapeFactory.createBomb(0 - 50 * (3 * i), 43, "/Bomb.png"));
                    break ;     
                case 8 :
                   moving.add(shapeFactory.createBomb(0 - 50 * (3 * i), 93, "/Bomb.png")); 
                   break ;
                    
            } }
            
        else {
            
           int it3 = r.nextInt(12);
                   switch(it3)
            {   
              
                 case 0 :
                   // RectangleObject rect1= new RectangleObject(0 - 50 * (3 * i), 43, "/Rectangle" +z+ ".png");
                    moving.add(shapeFactory.createRect(0 - 50 * (3 * i), 43, "/Rectangle" +z+ ".png"));
                    break ;
                    
                case 1:
                     //RectangleObject rect2 = new RectangleObject(800 + 50 * (3 * i), 43, "/Rectangle" + z+ ".png");
                    moving.add(shapeFactory.createRect(800 + 50 * (3 * i), 43, "/Rectangle" +z+ ".png"));
                     break ;
                case 2 :
                   // PlateObject p1 = new PlateObject(0 - 50 * (3 * i), 43, "/plate" +z+ ".png");
                    moving.add(shapeFactory.createPlate(0 - 50 * (3 * i), 43, "/plate" +z+ ".png"));
                    break ;
                    
                case 3:
                    // PlateObject p2 = new PlateObject(800 + 50 * (3 * i), 43, "/plate" +z+ ".png");
                    moving.add(shapeFactory.createPlate(800 + 50 * (3 * i), 43, "/plate" +z+ ".png"));
                     break ;
                    
                case 4: 
                     // RectangleObject rect3= new RectangleObject(0 - 50 * (3 * i), 93, "/Rectangle" +z+ ".png");
                    moving.add(shapeFactory.createRect(0 - 50 * (3 * i), 93, "/Rectangle" +z+ ".png"));
                    break ;
                case 5:
                       
                    moving.add(shapeFactory.createPlate(0 - 50 * (3 * i), 93, "/plate" +z+ ".png"));
                    break ;
                     
                     
                     
                case 6 :
                     RectangleObject rect4 = new RectangleObject(800 + 50 * (3 * i), 93, "/Rectangle" + z+ ".png");
                     moving.add(shapeFactory.createRect(800 + 50 * (3 * i), 93, "/Rectangle" + z+ ".png"));
                     break ;
                     
                case 7:
                    
                     moving.add(shapeFactory.createPlate(800 + 50 * (3 * i), 93, "/plate" +z+ ".png"));
                     break ; 
                    
              case 8 :
                    moving.add(shapeFactory.createBomb(800 + 50 * (3 * i), 43, "/Bomb.png"));
                    break ;
                case 9 :
                   moving.add(shapeFactory.createBomb(0 - 50 * (3 * i), 43, "/Bomb.png"));
                    break ;     
                case 10 :
                   moving.add(shapeFactory.createBomb(0 - 50 * (3 * i), 93, "/Bomb.png")); 
                   break ;       
                case 11 :
                     moving.add(shapeFactory.createBomb(800 + 50 * (3 * i), 93, "/Bomb.png"));  
                     
                    
            } 
            
        }  }
    
            }    
    
     public boolean intersect(GameObject o1 , GameObject o2) {
        return  (Math.abs((o1.getX() + o1.getWidth() / 2) - (o2.getX() + o2.getWidth() / 2)) <= o1.getWidth())&&
                (Math.abs(o1.getY() + o1.getHeight() ) == o2.getY());
    }
   
   
     
     
     

    @Override
    public  boolean refresh() {
 int pos = 13-current.getSpeed(); 
        boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME; // time end and game over
        GameObject clown = control.get(0);
 flyweight.setLeft(left);
 flyweight.setRight(right);
        
        iterator  = new IteratorClass(moving);

        while(iterator.hasNext()){
            GameObject m = iterator.next();
      
            
            flyweight.updateLeft(); flyweight.updateRight();
                flyweight.checkIfOut(m, height);
              if(left.list.size() == 7  || right.list.size() == 7)
                  return false ;
             if(flyweight.checkIfEmpty()) 
           flyweight.recycle(pos++,43);
        

                  moveMovingObject(m);
             if (left.list.isEmpty()   ) {
                
                if (clownIntersectleft(m)) {
                    System.out.println(" First  Left");
                    moving.remove(m);
                    Shape p = (Shape)m ;
                    if(p instanceof BombObject){
                        sound.setFile(1);
                        sound.play();
                        return false ;
                    }
                    p.setC((ImageObject) clown);
                    p.setHorizontalOnly(true);
                    p.setType(1);
                    control.add(m);
                    left.list.add(m);
                    left.notifyObservers();
                    
                    continue;
                }
            }   
          
          
            else {
                    if (intersect(m, left.list.get(left.list.size() - 1))) {
                        m.setY(left.list.get(left.list.size()-1).getY()-m.getHeight());
                        System.out.println("Not first left");
                    moving.remove(m);
                    
                     Shape p = (Shape)m ;
                  if(p instanceof BombObject){
                        sound.setFile(1);
                        sound.play();
                        return false ;
                    }
                    p.setC((ImageObject) clown);
                    p.setHorizontalOnly(true);
                    p.setY(left.list.get(left.list.size() - 1).getY() - p.getWidth());
                    p.setType(1);
                    control.add(m);
                    left.list.add(m);
                    left.notifyObservers();
                    continue ;
                }

                 flyweight.updateLeft();
                
                
            }
           
              if(right.list.isEmpty()) {
                   if (clownIntersectRight(m)) {
                       System.out.println("First right here ");
                    moving.remove(m);
                   
                     Shape p = (Shape)m ;
                     if(p instanceof BombObject){
                        sound.setFile(1);
                        sound.play();
                        return false ;
                    }
                    p.setC((ImageObject) clown);
                    p.setHorizontalOnly(true);
             
                    p.setType(2);
                    control.add(m);
                    right.list.add(m);
                    right.notifyObservers();
                    continue ;
                 
             }  
            }
                else {
                    if (intersect(m, right.list.get(right.list.size() - 1))) {
                        System.out.println("Not first right");
                     
                       m.setY(right.list.get(right.list.size()-1).getY()-m.getHeight());
                    moving.remove(m);
                   // PlateObject p = (PlateObject) m;
                   Shape p = (Shape)m ;
                  if(p instanceof BombObject){
                        sound.setFile(1);
                        sound.play();
                        return false ;
                       
                    }
                    p.setC((ImageObject) clown);
                    p.setHorizontalOnly(true);
                    p.setY(right.list.get(right.list.size() - 1).getY() - p.getWidth());
                    p.setType(2);
                   
                    control.add(m);
                    right.list.add(m);
                    right.notifyObservers();
                    continue ;
                }}
            
          flyweight.updateRight();

        }


        return !timeout;
    }
    public  void moveMovingObject (GameObject m )
    {
        if(current.getNumberOfBars() == 2)
    {
         if (m.getX() + 150 < width / 2   ) { // Horizontal movement 
                m.setX((int) (m.getX() + current.getSpeed()));}

            else if(m.getX() - 150+m.getWidth() > width / 2 )
            {
                
                 m.setX((int) (m.getX() - current.getSpeed())); 
                
            }
            else{
                 m.setY((int) (m.getY()+1)) ;
            }
            
    }
    else if(current.getNumberOfBars() == 3)
    {
           if(m.getX() +300< width/2 )
            {
                m.setX((int) (m.getX() + current.getSpeed()));}
         else if (m.getX() + 150 < width / 2   ) { // Horizontal movement 
                if(m.getY()== 43)
                m.setX((int) (m.getX() + current.getSpeed()));
        else
                 m.setY((int) (m.getY()+1)) ;}

            else if(m.getX() - 150+m.getWidth() > width / 2 )
            {
                
                 m.setX((int) (m.getX() - current.getSpeed())); 
                
            }
          
            
            else{
                 m.setY((int) (m.getY()+1)) ;
            }
    }
    else
    {
              if(m.getX() +300< width/2   )
            {
                m.setX((int) (m.getX() + current.getSpeed()));
                         
            }
              
        else if (m.getX() + 150 < width / 2   ) {
            if(m.getY()== 43)
                m.setX((int) (m.getX() + current.getSpeed()));
        else
                 m.setY((int) (m.getY()+1)) ;
        }
        
          else if(m.getX() - 300 + m.getWidth() > width /2)
            {
                
                m.setX((int) (m.getX() - current.getSpeed()));  
                
            }
            else if(m.getX() - 150+m.getWidth() > width / 2 )
            {
                 if(m.getY() == 43)
                 m.setX((int) (m.getX() - current.getSpeed())); 
                 else 
                       m.setY((int) (m.getY()+1)) ;
            }
       
           
            else{
                 m.setY((int) (m.getY()+1)) ;
            }
    }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
        
        
        
  
    
    

    @Override
    public int getSpeed() {
        return 10;
    }

    @Override
    public int getControlSpeed() {
        return 20;
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getStatus() {
        return    "Score=" + Score.getScore() + "   |   Time=" + Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000);	// update status
    }

    private boolean clownIntersectleft(GameObject o) {
        ImageObject clown = (ImageObject) control.get(0);
        
        return (Math.abs(clown.getX() - o.getX()) <= o.getWidth() - 10 
                && o.getY() == control.get(0).getY() - 10);
    }

    
  
      private boolean clownIntersectRight(GameObject o) {
        ImageObject clown = (ImageObject) control.get(0);
        return (Math.abs(clown.getX() - o.getX()) <= o.getWidth() - 10+clown.getWidth()
                && o.getY() == control.get(0).getY() -10) && clown.getX()+clown.getWidth() -10 >= o.getX() &&clown.getX() <=o.getX()  ;
        
    }
      
   
       
       
       
       
       
}
