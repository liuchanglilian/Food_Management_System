/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Customer;

import Food.Order;
import Network.Network;
import business.Enterprise.Enterprise;
import business.Enterprise.Restaurant;
import business.Enterprise.SuperMarket;
import business.UserAccount.UserAccount;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import picutill.OnlineDish;
import SuperMarketItem.SuperMarketItem;
import SuperMarketItem.SuperMarketServe;
import Address.Address;
import business.WorkQueue.FoodOrderRequest;
import business.WorkQueue.SuperMarketOrderRequest;
import business.business.EcoSystem;
import java.awt.CardLayout;
import java.awt.Image;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author liuch
 */
public class ShopSuperMarket extends javax.swing.JPanel {

    /**
     * Creates new form ShopSuperMarket
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Network network;
    private ArrayList<SuperMarketServe> superMarketList;
    private boolean isCheckedOut = false;
    private Connection con;
    EcoSystem system;
    ObjectOutputStream streamOut;
    ArrayList<SuperMarketItem> list;

    public ShopSuperMarket(EcoSystem system, JPanel userProcessContainer, UserAccount userAccount, Network network, ObjectOutputStream streamOut) throws SQLException {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.network = network;
        this.system = system;
        this.streamOut = streamOut;
        superMarketList = new ArrayList<>();
        populateCombo();
        populateAddressCombo();
        if (!isCheckedOut) {
            superMarketList = new ArrayList<>();
        }
    }

    public void populateCombo() throws SQLException {
        jComboBox2.removeAllItems();
        for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (e instanceof SuperMarket) {
                jComboBox2.addItem(e);
            }
            }
        jComboBox2.setSelectedIndex(0);
        populateTable();
    }

    public void populateAddressCombo() {
        addressCombo.removeAllItems();
        for (Address address : userAccount.getAddress()) {
            addressCombo.addItem(address);
        }
    }

    public void populateTable() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        SuperMarket s = (SuperMarket) jComboBox2.getSelectedItem();
        for (SuperMarketItem item : list) {
            Object row[] = new Object[7];
            row[0] = item.getId();
            row[1] = item;
            row[2] = item.getCalorie();
            row[3] = item.getPrice();
            row[4] = item.getDiscount();
            if (item.getDiscount() != 0) {
                row[5] = item.getPrice() * item.getDiscount();
            } else {
                row[5] = item.getPrice();
            }
            row[6] = item.getInventory();
            model.addRow(row);
        }
    }

    public void refreshOrderTable() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        for (SuperMarketServe si : superMarketList) {
            Object row[] = new Object[3];
            row[0] = si;
            row[1] = si.getNumber();
            row[2] = si.getItem().getDiscount();
            model.addRow(row);
        }

    }

    public ArrayList<SuperMarketItem> userList(SuperMarket superMarket) throws SQLException {
        ArrayList<SuperMarketItem> userList = new ArrayList<>();
        String DB_URL = "jdbc:mysql://35.185.14.219:3306/new_schema";
        String DB_DRV = "com.mysql.jdbc.Driver";
        String DB_USER = "root";
        String DB_PASSWD = "8466";
        try {
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "133");
        }
       String query1 = "SELECT * FROM new_schema.`" + superMarket.getUserAccount().getUsername() + "`";
        Statement st = null;
        try {
            st = (Statement) con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "141");
        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "ee");
        }
        SuperMarketItem item;
        while (rs.next()) {
            item = new SuperMarketItem(rs.getInt("id"), rs.getString("Name"), rs.getInt("calorie"), rs.getDouble("Price"), rs.getBytes("pic"), rs.getDouble("discount"), rs.getInt("inventory"), rs.getInt("saleHistory"));

            userList.add(item);
        }
        return userList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox2 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        addressCombo = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        quantitySpinner = new javax.swing.JSpinner();
        btnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Name", "Calorie", "Original price", "Discount?", "Current Price ", "Inventory"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setText("Address:");

        addressCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        addressCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressComboActionPerformed(evt);
            }
        });

        jButton2.setText("Add Address");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food", "Number", "Discounted?"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel6.setText("Quantity:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel3.setText("Total Price:");

        jTextField1.setEditable(false);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButton3.setText("<<Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(187, 187, 187))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(205, 205, 205)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(224, 224, 224)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(800, 800, 800))
            .addGroup(layout.createSequentialGroup()
                .addGap(429, 429, 429)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(addressCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(38, 38, 38)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)))
                .addComponent(jButton2)
                .addGap(29, 29, 29)
                .addComponent(addressCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AddAddress panel = new AddAddress(userAccount, 2, network, userProcessContainer);
        userProcessContainer.add("AddAddressJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SuperMarket s = (SuperMarket) jComboBox2.getSelectedItem();
        if (superMarketList.size() > 0) {
            Date currentTime = new Date();
            SuperMarketOrderRequest request = new SuperMarketOrderRequest(s);
            request.setItemList(superMarketList);
            request.setRequestDate(currentTime);
            request.setSender(userAccount);
            request.setStatus("Sent");
            Address a = (Address) addressCombo.getSelectedItem();
            if (a == null) {
                JOptionPane.showMessageDialog(null, "Please add address first");
                return;
            }
            request.setAddress(a);
         s.getFoodOrderqueue().getWorkRequestList().add(request);
            userAccount.getTheOrderIsentoutQueue().getWorkRequestList().add(request);
            JOptionPane.showMessageDialog(null, "Order placed successfully");
            superMarketList = new ArrayList();
            try {
                streamOut.reset();
                streamOut.writeObject(system);
                streamOut.flush();
            } catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
            }
            refreshOrderTable();
            try {
                populateTable();
            } catch (SQLException ex) {
                Logger.getLogger(ShopSuperMarket.class.getName()).log(Level.SEVERE, null, ex);
            }
            isCheckedOut = true;
        } else {
            JOptionPane.showMessageDialog(null, "no order placed");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addressComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressComboActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        try {
            SuperMarket s = (SuperMarket) jComboBox2.getSelectedItem();
            if (s == null) {
                return;
            }
            this.list = userList(s);
            populateTable();
        } catch (SQLException ex) {
            Logger.getLogger(ShopSuperMarket.class.getName()).log(Level.SEVERE, null, ex);
        }
        superMarketList = new ArrayList<>();        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed
    public void printTotalPrice() {
        double totalPrice = 0;
        for (SuperMarketServe serve : superMarketList) {
            totalPrice = totalPrice + serve.getNumber() * serve.getItem().getPrice() * (1 - serve.getItem().getDiscount());
        }

        jTextField1.setText(String.valueOf(totalPrice));
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select");
            return;
        }
        SuperMarketItem item = (SuperMarketItem) jTable1.getValueAt(selectedRow, 1);
        int fetchQty = (Integer) quantitySpinner.getValue();        // TODO add your handling code here:
        if (fetchQty <= 0) {
            JOptionPane.showMessageDialog(null, "Can't be zero");
            return;
        }
        if (fetchQty > item.getInventory()) {
            JOptionPane.showMessageDialog(null, "can't be larger than inventory");
            return;
        }
        try {

            boolean alereadyPresent = false;
            for (SuperMarketServe existItem : superMarketList) {
                if (existItem.getItem().getId() == item.getId()) {
                    int oldAvail = item.getInventory();
                    JOptionPane.showMessageDialog(null, "old avai" + oldAvail);
                    int newAvail = oldAvail - fetchQty;
                    JOptionPane.showMessageDialog(null, "new avai" + newAvail);
                    item.setInventory(newAvail);
                    existItem.setNumber(existItem.getNumber() + fetchQty);
                    alereadyPresent = true;
                    populateTable();
                    refreshOrderTable();
                    printTotalPrice();
                    break;
                }
            }
            if (!alereadyPresent) {
                SuperMarketServe snew = new SuperMarketServe();
                snew.setItem(item);
                snew.setNumber(fetchQty);
                int oldAvail = item.getInventory();
                int newAvail = oldAvail - fetchQty;
                item.setInventory(newAvail);
                JOptionPane.showMessageDialog(null, "new avai" + newAvail);
                JOptionPane.showMessageDialog(null, "new avai" + item.getInventory());
                superMarketList.add(snew);
                populateTable();
                refreshOrderTable();
                printTotalPrice();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid");
            return;
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = jTable2.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "PLS SELECT A ROW");
            return;
        }
        SuperMarketServe marketServe = (SuperMarketServe) jTable2.getValueAt(row, 0);
        int oldAvail = marketServe.getItem().getInventory();
        int oldQty = marketServe.getNumber();
        int newQty = oldAvail + oldQty;
        marketServe.getItem().setInventory(newQty);
        superMarketList.remove(marketServe);
        JOptionPane.showMessageDialog(null, "OrderITem removed from the cart");

        refreshOrderTable();
        try {
            populateTable();
        } catch (SQLException ex) {
            Logger.getLogger(ShopSuperMarket.class.getName()).log(Level.SEVERE, null, ex);
        }
        printTotalPrice();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = jTable1.getSelectedRow();
        ImageIcon image1 = new ImageIcon(((SuperMarketItem) jTable1.getValueAt(i, 1)).getPic());
        Image image = image1.getImage();
        double h = 300.0 / image1.getIconHeight();
        Image newimg = image.getScaledInstance((int) (image1.getIconWidth() * h), (int) (image1.getIconHeight() * h), java.awt.Image.SCALE_SMOOTH);
        ImageIcon newone = new ImageIcon(newimg);
        jLabel8.setIcon(newone);               // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox addressCombo;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JSpinner quantitySpinner;
    // End of variables declaration//GEN-END:variables
}
