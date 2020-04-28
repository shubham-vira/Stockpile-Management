
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shubham
 */
public class AddProduct extends JDialog{
    
    AddProduct(Frame frame, String title){
       super(frame, title,true);
       setSize(750, 780);
        AddProductPanel jp = new AddProductPanel();
        add(jp);
        setVisible(true);
    }
   
}
