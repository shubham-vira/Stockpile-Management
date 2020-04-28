
import java.awt.Color;
import javax.swing.ImageIcon;
import jiconfont.IconCode;
import jiconfont.icons.Elusive;
import jiconfont.icons.FontAwesome;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shubham
 */
public interface Constants {
    
        /**********************************Constant for Label Icons******************************************************************/
        //Icons for Customer
        ImageIcon CUSTOMER_BUTTON_ROLLOVER = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\customer_hover.png");
        ImageIcon CUSTOMER_BUTTON_PRESSED = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\customer_clicked.png");
        ImageIcon CUSTOMER_BUTTON = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\customer.png");
        
        //Icons for invoice
        ImageIcon INVOICE_BUTTON_ROLLOVER = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\invoice_hover.png");
        ImageIcon INVOICE_BUTTON_PRESSED = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\invoice_clicked.png");
        ImageIcon INVOICE_BUTTON = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\invoice.png");
        
        //Icons for reports
        ImageIcon REPORTS_BUTTON_ROLLOVER = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\reports_hover.png ");
        ImageIcon REPORTS_BUTTON_PRESSED = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\reports_clicked.png");
        ImageIcon REPORTS_BUTTON = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\reports.png");
        
        //Icons for stocks
        ImageIcon SALES_BUTTON_ROLLOVER = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\sales_hover.png");
        ImageIcon SALES_BUTTON_PRESSED = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\sales_clicked.png");
        ImageIcon SALES_BUTTON = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\sales.png");
        
        //Icons for stocks
        ImageIcon STOCKS_BUTTON_ROLLOVER = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\stocks_hover.png");
        ImageIcon STOCKS_BUTTON_PRESSED = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\stocks_clicked.png");
        ImageIcon STOCKS_BUTTON = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\stocks.png");
        
        //Icons for home
        ImageIcon HOME_BUTTON_ROLLOVER = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\home_hover.png");
        ImageIcon HOME_BUTTON_PRESSED = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\home_clicked.png");
        ImageIcon HOME_BUTTON = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\home.png");
        
        //Icons for logout
        ImageIcon LOGOUT_BUTTON_ROLLOVER = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\logout_hover.png");
        ImageIcon LOGOUT_BUTTON_PRESSED = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\logout_clicked.png");
        ImageIcon LOGOUT_BUTTON = new ImageIcon("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\src\\inventory logos\\logout.png");
        
        
        /**********************************Constant for Colors******************************************************************/
        //Color Red(for email validation)
        Color RED = new Color(238,66,102);
        
        //Color LightBlue for font foreground
        Color LIGHT_BLUE = new Color(0,246,237);
        
        //Color for background
        Color ACCENT_BLUE = new Color(29,35,59);
        
        //Color for white
        Color WHITE = new Color(255,250,255);
        
        /**********************************Constant for Button Icon************************************************************/
     
       IconCode addButton = FontAwesome.PLUS;
       IconCode updateButton = FontAwesome.ARROW_UP;
       IconCode deleteButton = FontAwesome.MINUS;
       IconCode clearButton = Elusive.BROOM;
       IconCode rightShift = FontAwesome.ANGLE_DOUBLE_RIGHT;
       IconCode leftShift = FontAwesome.ANGLE_DOUBLE_LEFT;
       
       int EMPLOYEE = 1;
       int ADMIN = 2;
}
