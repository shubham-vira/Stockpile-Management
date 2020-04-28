
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shubham
 */

public class SalesForm extends javax.swing.JPanel {

    /**
     * Creates new form SalesForm
     */
    public SalesForm(){
        initComponents();
        conn = MySqlConnect.connectDB();
//        cn = GlazedLists.eventListOf();
        
        //AutoCompleteSupport.install(jcbCustomerName,cn);
//        c = new CustProdPanel();
//        pp = new PaymentPanel();
  //      pnlTop.add(c,new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1820, 1080));  
        pn = GlazedLists.eventListOf();
        AutoCompleteSupport.install(jcbProductName,pn);
       // pnlTop.add(pp);
        //pp.setVisible(false);
        pnlTop.validate();    
        paymentPanel.setVisible(false);
        lblChequeNum.setVisible(false);
        txtChequeNum.setVisible(false);
        jspChequeNum.setVisible(false);
        btnBack.setEnabled(false);
    }
    
    void refreshProductNames(){
        try {
            pn.removeAll(pn);
            sql = "SELECT productname FROM product";
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            while(rs.next()){
                pn.add(rs.getString(1));
            }
            jcbProductName.setSelectedIndex(-1);
        } catch (Exception e) {
        }finally{
            try {
                rs.close();
                statement.close();
            } catch (Exception e) {
            }
        }
    }
    
    private void clearProducts(){
        jcbProductName.setSelectedItem(null);
        txtQuantity.setText("");
        txtMRP.setText("");
        spnrQuantity.setValue(1);
    }
    private void clearFields(){
        txtCustContact.setText("");
        txtEmail.setText("");
        txtCustName.setText("");
        txtGST.setText("");
        txtChequeNum.setText("");
        
        
    }
    
    private void fetching(){
        try {
            if(txtCustContact.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter a Contact Number");
            }else{
                sql = "SELECT * FROM customer WHERE contactno = ?";
                preparedStatement = conn.prepareStatement(sql);

                preparedStatement.setString(1, txtCustContact.getText());

                rs = preparedStatement.executeQuery();
                if(rs.next()){
                    txtCustName.setText(rs.getString("customername"));
                    txtEmail.setText(rs.getString("email"));
                    txtGST.setText(rs.getString("gst"));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Customer does not exist, please add it as a new customer");
                    AddCustomer ac = new AddCustomer(null, "Add new Customer");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    private int getCustID(String phone) throws SQLException{
        sql = "SELECT customerid from customer WHERE contactno = '" + phone + "'";
        rs = conn.createStatement().executeQuery(sql);
        rs.next();
        return rs.getInt("customerid");
    }
    
    private void initDatabase() {
        try {
            preparedStatement = conn.prepareStatement("INSERT INTO bill(cgst,sgst,igst,discount,total,date) VALUES (0,0,0,0,0,?)");
            preparedStatement.setString(1,new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
            preparedStatement.execute();
            rs = conn.createStatement().executeQuery("SELECT billid FROM bill");
            rs.last();
            this.billid = rs.getInt("billid");
            rs = conn.createStatement().executeQuery("SELECT * FROM cart");
            while(rs.next()) { 
                sql = "INSERT INTO sell(billid, productid, quantity) VALUES (?,?,?)";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1,this.billid);
                preparedStatement.setInt(2, rs.getInt("productid"));
                preparedStatement.setInt(3, rs.getInt("quantity"));
                preparedStatement.execute();
            }
            conn.createStatement().execute("INSERT INTO custtosell(billid, customerid) VALUES ('" + this.billid + "','" + getCustID(txtCustContact.getText()) + "')");
            preparedStatement = conn.prepareStatement("UPDATE bill SET bill.total = (SELECT SUM(product.mrp * cart.quantity) FROM product,cart WHERE product.productid = cart.productid) WHERE bill.billid = ?");
            preparedStatement.setInt(1,this.billid);
            preparedStatement.execute();
            conn.createStatement().execute("TRUNCATE TABLE cart");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbData = new javax.swing.JTable();
        btnConfirmCart = new javax.swing.JButton();
        pnlTop = new javax.swing.JPanel();
        paymentPanel = new javax.swing.JPanel();
        rbtnCash = new javax.swing.JRadioButton();
        rbtnCheque = new javax.swing.JRadioButton();
        txtChequeNum = new javax.swing.JTextField();
        jspChequeNum = new javax.swing.JSeparator();
        lblChequeNum = new javax.swing.JLabel();
        btnGenerateBill = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblCustomerName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblMRP = new javax.swing.JLabel();
        lblGST = new javax.swing.JLabel();
        lblProductName = new javax.swing.JLabel();
        lblContact = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        jcbProductName = new javax.swing.JComboBox<>();
        txtQuantity = new javax.swing.JTextField();
        jspQuantity = new javax.swing.JSeparator();
        txtEmail = new javax.swing.JTextField();
        jspEmail = new javax.swing.JSeparator();
        txtGST = new javax.swing.JTextField();
        jspGST = new javax.swing.JSeparator();
        txtMRP = new javax.swing.JTextField();
        jspMRP = new javax.swing.JSeparator();
        txtCustName = new javax.swing.JTextField();
        jspContact = new javax.swing.JSeparator();
        btnAddCustomer = new javax.swing.JButton();
        lblQuantity1 = new javax.swing.JLabel();
        spnrQuantity = new javax.swing.JSpinner();
        btnAdd1 = new javax.swing.JButton();
        btnAddProduct = new javax.swing.JButton();
        btnFetchDetails = new javax.swing.JButton();
        txtCustContact = new javax.swing.JTextField();
        jspContact1 = new javax.swing.JSeparator();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(29, 35, 59));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 0, 153));

        jtbData.setBackground(new java.awt.Color(29, 35, 59));
        jtbData.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jtbData.setForeground(new java.awt.Color(255, 250, 255));
        jtbData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "productid", "product name", "mass", "mrp", "quantity"
            }
        ));
        jtbData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbData);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 1780, 370));

        btnConfirmCart.setBackground(new java.awt.Color(29, 35, 59));
        btnConfirmCart.setFont(new java.awt.Font("Share Tech Mono", 0, 20)); // NOI18N
        btnConfirmCart.setForeground(new java.awt.Color(0, 246, 237));
        btnConfirmCart.setText("Confirm Cart");
        btnConfirmCart.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 246, 237), 1, true));
        btnConfirmCart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfirmCartMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConfirmCartMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnConfirmCartMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnConfirmCartMouseReleased(evt);
            }
        });
        btnConfirmCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmCartActionPerformed(evt);
            }
        });
        add(btnConfirmCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 920, 170, 50));

        pnlTop.setBackground(new java.awt.Color(29, 35, 59));
        pnlTop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paymentPanel.setBackground(new java.awt.Color(29, 35, 59));
        paymentPanel.setForeground(new java.awt.Color(0, 246, 237));
        paymentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rbtnCash.setBackground(new java.awt.Color(29, 35, 59));
        buttonGroup1.add(rbtnCash);
        rbtnCash.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        rbtnCash.setForeground(new java.awt.Color(0, 246, 237));
        rbtnCash.setSelected(true);
        rbtnCash.setText("Cash");
        rbtnCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCashActionPerformed(evt);
            }
        });
        paymentPanel.add(rbtnCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        rbtnCheque.setBackground(new java.awt.Color(29, 35, 59));
        buttonGroup1.add(rbtnCheque);
        rbtnCheque.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        rbtnCheque.setForeground(new java.awt.Color(0, 246, 237));
        rbtnCheque.setText("Cheque");
        rbtnCheque.setToolTipText("");
        rbtnCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnChequeActionPerformed(evt);
            }
        });
        paymentPanel.add(rbtnCheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, -1, -1));

        txtChequeNum.setBackground(new java.awt.Color(29, 35, 59));
        txtChequeNum.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        txtChequeNum.setForeground(new java.awt.Color(0, 246, 237));
        txtChequeNum.setBorder(null);
        paymentPanel.add(txtChequeNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 240, 30));
        paymentPanel.add(jspChequeNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 240, 10));

        lblChequeNum.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        lblChequeNum.setForeground(new java.awt.Color(255, 250, 255));
        lblChequeNum.setText("Cheque Number :");
        paymentPanel.add(lblChequeNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        btnGenerateBill.setBackground(new java.awt.Color(29, 35, 59));
        btnGenerateBill.setFont(new java.awt.Font("Share Tech Mono", 0, 20)); // NOI18N
        btnGenerateBill.setForeground(new java.awt.Color(0, 246, 237));
        btnGenerateBill.setText("Generate Bill");
        btnGenerateBill.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 246, 237), 1, true));
        btnGenerateBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGenerateBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGenerateBillMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGenerateBillMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnGenerateBillMouseReleased(evt);
            }
        });
        btnGenerateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateBillActionPerformed(evt);
            }
        });
        paymentPanel.add(btnGenerateBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 200, 220, 40));

        pnlTop.add(paymentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1790, 510));

        jPanel1.setBackground(new java.awt.Color(29, 35, 59));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCustomerName.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        lblCustomerName.setForeground(new java.awt.Color(255, 250, 255));
        lblCustomerName.setText("Contact");
        jPanel1.add(lblCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 150, -1, -1));

        lblEmail.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 250, 255));
        lblEmail.setText("Email");
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 270, -1, -1));

        lblMRP.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        lblMRP.setForeground(new java.awt.Color(255, 250, 255));
        lblMRP.setText("MRP");
        jPanel1.add(lblMRP, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, -1));

        lblGST.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        lblGST.setForeground(new java.awt.Color(255, 250, 255));
        lblGST.setText("GST");
        jPanel1.add(lblGST, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 330, -1, -1));

        lblProductName.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        lblProductName.setForeground(new java.awt.Color(255, 250, 255));
        lblProductName.setText("Product Name ");
        jPanel1.add(lblProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));

        lblContact.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        lblContact.setForeground(new java.awt.Color(255, 250, 255));
        lblContact.setText("Customer Name");
        jPanel1.add(lblContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 210, -1, -1));

        lblQuantity.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(255, 250, 255));
        lblQuantity.setText("Quantity");
        jPanel1.add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        jcbProductName.setBackground(new java.awt.Color(29, 35, 59));
        jcbProductName.setForeground(new java.awt.Color(0, 246, 237));
        jcbProductName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbProductName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbProductNameItemStateChanged(evt);
            }
        });
        jcbProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProductNameActionPerformed(evt);
            }
        });
        jPanel1.add(jcbProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 240, 30));

        txtQuantity.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        txtQuantity.setForeground(new java.awt.Color(0, 246, 237));
        txtQuantity.setBorder(null);
        txtQuantity.setCaretColor(new java.awt.Color(0, 246, 237));
        txtQuantity.setEnabled(false);
        txtQuantity.setOpaque(false);
        txtQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQuantityFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantityFocusLost(evt);
            }
        });
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        jPanel1.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 240, -1));

        jspQuantity.setBackground(new java.awt.Color(255, 250, 255));
        jspQuantity.setForeground(new java.awt.Color(255, 250, 255));
        jPanel1.add(jspQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 242, 240, -1));

        txtEmail.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 246, 237));
        txtEmail.setBorder(null);
        txtEmail.setCaretColor(new java.awt.Color(0, 246, 237));
        txtEmail.setEnabled(false);
        txtEmail.setOpaque(false);
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 270, 240, -1));

        jspEmail.setBackground(new java.awt.Color(255, 250, 255));
        jspEmail.setForeground(new java.awt.Color(255, 250, 255));
        jPanel1.add(jspEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 300, 240, -1));

        txtGST.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        txtGST.setForeground(new java.awt.Color(0, 246, 237));
        txtGST.setBorder(null);
        txtGST.setCaretColor(new java.awt.Color(0, 246, 237));
        txtGST.setEnabled(false);
        txtGST.setOpaque(false);
        txtGST.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtGSTFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGSTFocusLost(evt);
            }
        });
        txtGST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGSTActionPerformed(evt);
            }
        });
        jPanel1.add(txtGST, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 330, 240, -1));

        jspGST.setBackground(new java.awt.Color(255, 250, 255));
        jspGST.setForeground(new java.awt.Color(255, 250, 255));
        jPanel1.add(jspGST, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 360, 240, -1));

        txtMRP.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        txtMRP.setForeground(new java.awt.Color(0, 246, 237));
        txtMRP.setBorder(null);
        txtMRP.setCaretColor(new java.awt.Color(0, 246, 237));
        txtMRP.setEnabled(false);
        txtMRP.setOpaque(false);
        txtMRP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMRPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMRPFocusLost(evt);
            }
        });
        txtMRP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMRPActionPerformed(evt);
            }
        });
        jPanel1.add(txtMRP, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 240, -1));

        jspMRP.setBackground(new java.awt.Color(255, 250, 255));
        jspMRP.setForeground(new java.awt.Color(255, 250, 255));
        jPanel1.add(jspMRP, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 240, -1));

        txtCustName.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        txtCustName.setForeground(new java.awt.Color(0, 246, 237));
        txtCustName.setBorder(null);
        txtCustName.setCaretColor(new java.awt.Color(0, 246, 237));
        txtCustName.setEnabled(false);
        txtCustName.setOpaque(false);
        txtCustName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustNameFocusLost(evt);
            }
        });
        txtCustName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtCustName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 210, 240, -1));

        jspContact.setBackground(new java.awt.Color(255, 250, 255));
        jspContact.setForeground(new java.awt.Color(255, 250, 255));
        jPanel1.add(jspContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 240, 240, -1));

        btnAddCustomer.setBackground(new java.awt.Color(29, 35, 59));
        btnAddCustomer.setFont(new java.awt.Font("Share Tech Mono", 0, 20)); // NOI18N
        btnAddCustomer.setForeground(new java.awt.Color(0, 246, 237));
        btnAddCustomer.setText("Add New Customer");
        btnAddCustomer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 246, 237), 1, true));
        btnAddCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddCustomerMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAddCustomerMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAddCustomerMouseReleased(evt);
            }
        });
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 200, 220, 40));

        lblQuantity1.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        lblQuantity1.setForeground(new java.awt.Color(255, 250, 255));
        lblQuantity1.setText("Quantity");
        jPanel1.add(lblQuantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        spnrQuantity.setValue(1);
        jPanel1.add(spnrQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 50, 30));

        btnAdd1.setBackground(new java.awt.Color(29, 35, 59));
        btnAdd1.setFont(new java.awt.Font("Share Tech Mono", 0, 20)); // NOI18N
        btnAdd1.setForeground(new java.awt.Color(0, 246, 237));
        btnAdd1.setText(" ADD");
        btnAdd1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 246, 237), 1, true));
        btnAdd1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdd1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAdd1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAdd1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAdd1MouseReleased(evt);
            }
        });
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 140, 50));

        btnAddProduct.setBackground(new java.awt.Color(29, 35, 59));
        btnAddProduct.setFont(new java.awt.Font("Share Tech Mono", 0, 20)); // NOI18N
        btnAddProduct.setForeground(new java.awt.Color(0, 246, 237));
        btnAddProduct.setText("Add Product");
        btnAddProduct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 246, 237), 1, true));
        btnAddProduct.setOpaque(false);
        btnAddProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAddProductMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAddProductMouseReleased(evt);
            }
        });
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, 160, 40));

        btnFetchDetails.setBackground(new java.awt.Color(29, 35, 59));
        btnFetchDetails.setFont(new java.awt.Font("Share Tech Mono", 0, 20)); // NOI18N
        btnFetchDetails.setForeground(new java.awt.Color(0, 246, 237));
        btnFetchDetails.setText("Fetch Details");
        btnFetchDetails.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 246, 237), 1, true));
        btnFetchDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFetchDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFetchDetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFetchDetailsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnFetchDetailsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnFetchDetailsMouseReleased(evt);
            }
        });
        btnFetchDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFetchDetailsActionPerformed(evt);
            }
        });
        jPanel1.add(btnFetchDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 140, 220, 40));

        txtCustContact.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        txtCustContact.setForeground(new java.awt.Color(0, 246, 237));
        txtCustContact.setBorder(null);
        txtCustContact.setCaretColor(new java.awt.Color(0, 246, 237));
        txtCustContact.setOpaque(false);
        txtCustContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustContactFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustContactFocusLost(evt);
            }
        });
        txtCustContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustContactActionPerformed(evt);
            }
        });
        jPanel1.add(txtCustContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 150, 240, -1));

        jspContact1.setBackground(new java.awt.Color(255, 250, 255));
        jspContact1.setForeground(new java.awt.Color(255, 250, 255));
        jPanel1.add(jspContact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 180, 240, -1));

        pnlTop.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 520));

        add(pnlTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1800, 530));

        btnBack.setBackground(new java.awt.Color(29, 35, 59));
        btnBack.setFont(new java.awt.Font("Share Tech Mono", 0, 20)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 246, 237));
        btnBack.setText("Back");
        btnBack.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 246, 237), 1, true));
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBackMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnBackMouseReleased(evt);
            }
        });
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 920, 170, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmCartMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmCartMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmCartMousePressed

    private void btnConfirmCartMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmCartMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmCartMouseReleased

    private void btnConfirmCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmCartActionPerformed
        //pnlTop.add(pp,new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1820, 1080));
        //this.validate();
        //pnlTop.validate();
        //pp.validate();
        //pp.setVisible(true);
        btnBack.setEnabled(true);
        btnConfirmCart.setEnabled(false);
        if(txtCustContact.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter a customer1");
        }
        else{
            jPanel1.setVisible(false);
            paymentPanel.setVisible(true);
            
        }
        
//        c.setVisible(false);
    }//GEN-LAST:event_btnConfirmCartActionPerformed
    
    private void jcbProductNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbProductNameItemStateChanged
        try {
            if(!jcbProductName.getEditor().getItem().equals("") || jcbProductName.getEditor().getItem() != null){
                sql = "SElECT mass, mrp FROM product WHERE productname = '" + jcbProductName.getSelectedItem() + "'";
                statement = conn.createStatement();
                rs = statement.executeQuery(sql);

                while(rs.next()){
                    txtQuantity.setText(rs.getString(1));
                    txtMRP.setText(rs.getString(2));
                }
            }else{
                txtQuantity.setText("");
                txtMRP.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Some error from Product Combo: " + e);
        }finally{
            try {
                rs.close();
                statement.close();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jcbProductNameItemStateChanged

    private void jcbProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbProductNameActionPerformed

    private void txtQuantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusGained
        jspQuantity.setBackground(Constants.LIGHT_BLUE);
        jspQuantity.setForeground(Constants.LIGHT_BLUE);
        lblQuantity.setForeground(Constants.LIGHT_BLUE);
    }//GEN-LAST:event_txtQuantityFocusGained

    private void txtQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusLost
        jspQuantity.setBackground(Constants.WHITE);
        jspQuantity.setForeground(Constants.WHITE);
        lblQuantity.setForeground(Constants.WHITE);
    }//GEN-LAST:event_txtQuantityFocusLost

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        jspEmail.setBackground(Constants.LIGHT_BLUE);
        jspEmail.setForeground(Constants.LIGHT_BLUE);
        lblEmail.setForeground(Constants.LIGHT_BLUE);
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost

        jspEmail.setBackground(Constants.WHITE);
        jspEmail.setForeground(Constants.WHITE);
        lblEmail.setForeground(Constants.WHITE);
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtGSTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGSTFocusGained
        jspGST.setBackground(Constants.LIGHT_BLUE);
        jspGST.setForeground(Constants.LIGHT_BLUE);
        lblGST.setForeground(Constants.LIGHT_BLUE);
    }//GEN-LAST:event_txtGSTFocusGained

    private void txtGSTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGSTFocusLost

        jspGST.setBackground(Constants.WHITE);
        jspGST.setForeground(Constants.WHITE);
        lblGST.setForeground(Constants.WHITE);
    }//GEN-LAST:event_txtGSTFocusLost

    private void txtGSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGSTActionPerformed

    private void txtMRPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMRPFocusGained
        jspMRP.setBackground(Constants.LIGHT_BLUE);
        jspMRP.setForeground(Constants.LIGHT_BLUE);
        lblMRP.setForeground(Constants.LIGHT_BLUE);
    }//GEN-LAST:event_txtMRPFocusGained

    private void txtMRPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMRPFocusLost

        jspMRP.setBackground(Constants.WHITE);
        jspMRP.setForeground(Constants.WHITE);
        lblMRP.setForeground(Constants.WHITE);
    }//GEN-LAST:event_txtMRPFocusLost

    private void txtMRPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMRPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMRPActionPerformed

    private void txtCustNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustNameFocusGained
        jspContact.setBackground(Constants.LIGHT_BLUE);
        jspContact.setForeground(Constants.LIGHT_BLUE);
        lblContact.setForeground(Constants.LIGHT_BLUE);
    }//GEN-LAST:event_txtCustNameFocusGained

    private void txtCustNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustNameFocusLost
        jspContact.setBackground(Constants.WHITE);
        jspContact.setForeground(Constants.WHITE);
        lblContact.setForeground(Constants.WHITE);
    }//GEN-LAST:event_txtCustNameFocusLost

    private void txtCustNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustNameActionPerformed

    private void btnAddCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCustomerMouseEntered
        btnAddCustomer.setBackground(Constants.LIGHT_BLUE);
        btnAddCustomer.setForeground(Constants.ACCENT_BLUE);
    }//GEN-LAST:event_btnAddCustomerMouseEntered

    private void btnAddCustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCustomerMouseExited
        btnAddCustomer.setBackground(Constants.ACCENT_BLUE);
        btnAddCustomer.setForeground(Constants.LIGHT_BLUE);
    }//GEN-LAST:event_btnAddCustomerMouseExited

    private void btnAddCustomerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCustomerMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddCustomerMousePressed

    private void btnAddCustomerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCustomerMouseReleased

    }//GEN-LAST:event_btnAddCustomerMouseReleased

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        AddCustomer ap = new AddCustomer(null, "Add Customer");
        //        refreshCustomerNames();
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    private void btnAdd1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdd1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd1MousePressed

    private void btnAdd1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdd1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd1MouseReleased
    private void updateTableData()
    {
        try
        {
            jtbData.setModel(DbUtils.resultSetToTableModel(conn.createStatement().executeQuery("SELECT product.productid,product.productname,product.mass,product.mrp,cart.quantity FROM product,cart where product.productid = cart.productid")));
//            int id = rs.getInt("productid");
//            jtbData.setModel(DbUtils.resultSetToTableModel(conn.createStatement().executeQuery("SELECT * FROM product WHERE productid = '" + id + "'")));
        }catch(Exception e){}
    }
    //
    private int getProductId(String productName) throws SQLException { 
        sql = "SELECT productid FROM product WHERE productname = '" + productName + "'";
        rs = conn.createStatement().executeQuery(sql);
        rs.next();
        return rs.getInt("productid");
    }
    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        
        
        
        try {
            
            int quan = (int) spnrQuantity.getValue();
            preparedStatement = conn.prepareStatement("SELECT stock from product where productname = '" + jcbProductName.getSelectedItem() + "'");
            rs = preparedStatement.executeQuery();
            rs.next();
            int temp = rs.getInt("stock");
            
            if (temp > 0 && temp < quan) {
                JOptionPane.showMessageDialog(null, "insufficient quantity in stocks");
            } else {
                rs = conn.createStatement().executeQuery("SELECT * FROM cart WHERE productid = '" + getProductId(jcbProductName.getSelectedItem()+"") + "'");
            
                if(rs.next()) {
                   sql = "UPDATE cart SET quantity = '" + (((Integer)spnrQuantity.getValue()) + rs.getInt("quantity")) + "' WHERE productid = '" + rs.getInt("productid")  + "'";
                   conn.createStatement().execute(sql);
                }
                else {


                    sql = "INSERT INTO cart(productid, quantity) VALUES (?,?)";
                    preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setInt(1, getProductId(jcbProductName.getSelectedItem()+""));
                    preparedStatement.setInt(2, Integer.parseInt(spnrQuantity.getValue() + ""));
                    preparedStatement.execute();
                }   
                updateTableData();
                clearProducts();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnAddProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddProductMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddProductMousePressed

    private void btnAddProductMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddProductMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddProductMouseReleased

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        AddProduct ap = new AddProduct(null, "ADD PRODUCT");
        refreshProductNames();
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnFetchDetailsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFetchDetailsMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFetchDetailsMousePressed

    private void btnFetchDetailsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFetchDetailsMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFetchDetailsMouseReleased

    private void btnFetchDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFetchDetailsActionPerformed
        fetching();
    }//GEN-LAST:event_btnFetchDetailsActionPerformed

    private void txtCustContactFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustContactFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustContactFocusGained

    private void txtCustContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustContactFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustContactFocusLost

    private void txtCustContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustContactActionPerformed
        fetching();
    }//GEN-LAST:event_txtCustContactActionPerformed

    private void jtbDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbDataMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbDataMouseClicked

    private void rbtnCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCashActionPerformed
        lblChequeNum.setVisible(false);
        txtChequeNum.setVisible(false);
        jspChequeNum.setVisible(false);
        this.isCheque = false;
    }//GEN-LAST:event_rbtnCashActionPerformed

    private void rbtnChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnChequeActionPerformed
        lblChequeNum.setVisible(true);
        txtChequeNum.setVisible(true);
        jspChequeNum.setVisible(true);
        this.isCheque = true;
    }//GEN-LAST:event_rbtnChequeActionPerformed

    private void btnGenerateBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerateBillMouseEntered
        btnGenerateBill.setBackground(Constants.LIGHT_BLUE);
        btnGenerateBill.setForeground(Constants.ACCENT_BLUE);
    }//GEN-LAST:event_btnGenerateBillMouseEntered

    private void btnGenerateBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerateBillMouseExited
        btnGenerateBill.setBackground(Constants.ACCENT_BLUE);
        btnGenerateBill.setForeground(Constants.LIGHT_BLUE);
    }//GEN-LAST:event_btnGenerateBillMouseExited

    private void btnGenerateBillMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerateBillMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerateBillMousePressed

    private void btnGenerateBillMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerateBillMouseReleased

    }//GEN-LAST:event_btnGenerateBillMouseReleased
    private Loading loading;
    private boolean isCheque;
    private void btnGenerateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateBillActionPerformed
        initDatabase();
        loading  = new Loading();
        loading.setVisible(true);
        Timer timer = new Timer(2000,new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               loadingAction();
           }
       }); 
        timer.start();
        timer.setRepeats(false);
        btnBack.setEnabled(false);
        btnConfirmCart.setEnabled(true);
        rbtnCash.setSelected(true);
    }//GEN-LAST:event_btnGenerateBillActionPerformed
   private void loadingAction() {
       loading.setVisible(false);
       generateBill();
   }
    private void generateBill() {
        GenerateInvoice invoice;
        String chequenum = txtChequeNum.getText();
        try{
        if(this.isCheque)
        {
            invoice = new GenerateInvoice(this.billid,this.txtChequeNum.getText());   
            conn.createStatement().execute("INSERT INTO cheque_info(status, bill_id,chequenum) VALUES ('" + 0 + "','" + this.billid + "','" + chequenum +"' )");
        }
        else
            invoice = new GenerateInvoice(this.billid,"-");
            
            File path = new File("Bill " + this.billid + ".pdf");
            preparedStatement = conn.prepareStatement("SELECT product.productname,product.mass,product.cost,product.cgst,product.igst,product.sgst,product.mrp,sell.quantity FROM sell,product WHERE product.productid = sell.productid AND billid = ?");
            preparedStatement.setInt(1, this.billid);
            rs = preparedStatement.executeQuery();
            if(rs == null) {
                JOptionPane.showMessageDialog(null,"GenerateBullActioNPerforned rs is null");
            }
            
            invoice.createPDF(path, rs,txtCustName.getText(), txtCustContact.getText(),txtGST.getText(), txtEmail.getText());
            
            paymentPanel.setVisible(false);
            jPanel1.setVisible(true);
            clearFields();
            
            rs = conn.createStatement().executeQuery("SELECT sell.sellid FROM sell WHERE sell.billid = " + this.billid) ;
            
            while (rs.next()){
                int sellID = rs.getInt("sellid");
        	conn.createStatement().execute("UPDATE product SET product.stock = product.stock - (SELECT sell.quantity FROM sell WHERE sell.sellid = '" + sellID + "') WHERE product.productid = (SELECT sell.productid FROM sell WHERE sell.sellid = '" + sellID + "')");
            }
            
//                Desktop.getDesktop().open(new File("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\"+this.billid + ".pdf"));
            if (Desktop.isDesktopSupported()) {
            
                
                File myFile = new File("C:\\Users\\shubham\\Documents\\NetBeansProjects\\InventorySystem\\dist\\Bill " + this.billid + ".pdf");
                Desktop.getDesktop().open(myFile);
            }
             
           // sql = "SELECT * FROM cart";
            updateTableData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Some error in generate bill "+ e);
        }
    }
    private void btnAdd1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdd1MouseEntered
        btnAdd1.setForeground(Constants.ACCENT_BLUE);
        btnAdd1.setBackground(Constants.LIGHT_BLUE);
    }//GEN-LAST:event_btnAdd1MouseEntered

    private void btnAdd1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdd1MouseExited
        btnAdd1.setForeground(Constants.LIGHT_BLUE);
        btnAdd1.setBackground(Constants.ACCENT_BLUE);
    }//GEN-LAST:event_btnAdd1MouseExited

    private void btnFetchDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFetchDetailsMouseEntered
        btnFetchDetails.setForeground(Constants.ACCENT_BLUE);
        btnFetchDetails.setBackground(Constants.LIGHT_BLUE);
    }//GEN-LAST:event_btnFetchDetailsMouseEntered

    private void btnFetchDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFetchDetailsMouseExited
        btnFetchDetails.setForeground(Constants.LIGHT_BLUE);
        btnFetchDetails.setBackground(Constants.ACCENT_BLUE);
    }//GEN-LAST:event_btnFetchDetailsMouseExited

    private void btnConfirmCartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmCartMouseEntered
        btnConfirmCart.setBackground(Constants.LIGHT_BLUE);
        btnConfirmCart.setForeground(Constants.ACCENT_BLUE);
    }//GEN-LAST:event_btnConfirmCartMouseEntered

    private void btnConfirmCartMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmCartMouseExited
        btnConfirmCart.setBackground(Constants.ACCENT_BLUE);
        btnConfirmCart.setForeground(Constants.LIGHT_BLUE);
    }//GEN-LAST:event_btnConfirmCartMouseExited

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackMouseExited

    private void btnBackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackMousePressed

    private void btnBackMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackMouseReleased

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        jPanel1.setVisible(true);
        paymentPanel.setVisible(false);
        btnBack.setEnabled(false);
        btnConfirmCart.setEnabled(true);
    }//GEN-LAST:event_btnBackActionPerformed

    public JTable getJtbData() {
        return jtbData;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConfirmCart;
    private javax.swing.JButton btnFetchDetails;
    private javax.swing.JButton btnGenerateBill;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbProductName;
    private javax.swing.JSeparator jspChequeNum;
    private javax.swing.JSeparator jspContact;
    private javax.swing.JSeparator jspContact1;
    private javax.swing.JSeparator jspEmail;
    private javax.swing.JSeparator jspGST;
    private javax.swing.JSeparator jspMRP;
    private javax.swing.JSeparator jspQuantity;
    private javax.swing.JTable jtbData;
    private javax.swing.JLabel lblChequeNum;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGST;
    private javax.swing.JLabel lblMRP;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblQuantity1;
    private javax.swing.JPanel paymentPanel;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JRadioButton rbtnCash;
    private javax.swing.JRadioButton rbtnCheque;
    private javax.swing.JSpinner spnrQuantity;
    private javax.swing.JTextField txtChequeNum;
    private javax.swing.JTextField txtCustContact;
    private javax.swing.JTextField txtCustName;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGST;
    private javax.swing.JTextField txtMRP;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
    private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    private Statement statement;
    private EventList cn = null, pn = null;
//    private PaymentPanel pp = null;
    private String sql = null;
    private int billid = 0;
}
