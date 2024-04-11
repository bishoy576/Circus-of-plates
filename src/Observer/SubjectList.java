/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.sample.object.Shape;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author zedan.net
 */
public class SubjectList implements Subject{
 private ArrayList <Observer> observer = new ArrayList<>();
   public  List<GameObject> list = new LinkedList<GameObject>();
    @Override
    public void register(Observer observer) {
       this.observer.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        this.observer.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer o:observer  )
        {
            o.updateLeft();
            o.updateRight();
        }
    }
        
}
