/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class View {
    
    private String[] Levels;
    private String selected;

    public View() {
        Levels = new String [3];
    }
    
    public void setLevels(String[] selected)
    {
        this.Levels=selected;
    }
    public void showGUI()
    {
        JComboBox comboBox = new JComboBox(Levels);
        int chosenOption  =JOptionPane.showConfirmDialog(null, comboBox, "Choose Difficulty", JOptionPane.OK_CANCEL_OPTION);
        this.selected=(String)comboBox.getSelectedItem();
        
              if( chosenOption == -1 ||  chosenOption == 2 ){
          System.exit(0);
      }
//        int selectedIndex = comboBox.getSelectedIndex() ;
//       String selected = levels [selectedIndex] ;
       
    }
    public String SelectedItem()
    {
        return this.selected;
    }
}
