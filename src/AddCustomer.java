
import java.awt.Frame;
import javax.swing.JDialog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shubham
 */
public class AddCustomer extends JDialog{
    
    AddCustomer(Frame frame, String title){
        super(frame, title,true);
        setSize(500,600);
        AddCustomerPanel jp = new AddCustomerPanel();
        add(jp);
        setVisible(true);
    }
    
}
