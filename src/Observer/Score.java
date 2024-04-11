/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

import eg.edu.alexu.csd.oop.game.sample.object.Shape;

/**
 *
 * @author zedan.net
 */
public class Score implements  Observer{
  private SubjectList left = new SubjectList() ;
    private SubjectList right = new SubjectList() ;
    private  static int score ;
    public static int getScore() {
        return score;
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


    

    @Override
    public void updateLeft() {
       // System.out.println(left.list.size());
              if (left.list.size() >= 3) {
           Shape p1 = (Shape) left.list.get(left.list.size() - 1);
            Shape p2 = (Shape) left.list.get(left.list.size() - 2);
            Shape p3 = (Shape) left.list.get(left.list.size()- 3);
            if (p1.getColor() == p2.getColor() && p2.getColor() == p3.getColor()) {
         
                score++;
            }
        }
    }

    @Override
    public void updateRight() {
         if (right.list.size() >= 3) {
           Shape p1 = (Shape) right.list.get(right.list.size() - 1);
            Shape p2 = (Shape) right.list.get(right.list.size() - 2);
            Shape p3 = (Shape) right.list.get(right.list.size()- 3);
            if (p1.getColor() == p2.getColor() && p2.getColor() == p3.getColor()) {
         
                score++;
            }
        }
    }
    
    
    
    
    
}
