/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.RestaurantManagerRole;

import Network.Network;
import SuperMarketItem.SuperMarketItem;
import SuperMarketItem.SuperMarketServe;
import business.Enterprise.Enterprise;
import business.Enterprise.Restaurant;
import business.Enterprise.SuperMarket;
import business.UserAccount.UserAccount;
import business.WorkQueue.SuperMarketOrderRequest;
import business.business.EcoSystem;
import java.awt.CardLayout;
import java.awt.Image;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author liuch
 */
public class ShopFromMarket extends javax.swing.JPanel {

    /**
     * Creates new form ShopFromMarket
     */
    EcoSystem system;
    JPanel userProcessContainer;
    UserAccount userAccount;
    Network network;
    private boolean isCheckedOut = false;
     private ArrayList<SuperMarketServe> superMarketList;
    Restaurant restaurant;
    Connection con;
    ObjectOutputStream streamOut;
    public ShopFromMarket(EcoSystem system,JPanel userProcessContainer,UserAccount userAccount,Network network,Restaurant restaurant,ObjectOutputStream streamOut) {
        initComponents();
        this.system = system;
        this.userProcessContainer = userProcessContainer;
        this.network = network;
        this.userAccount = userAccount;
        this.restaurant = restaurant;
        this.streamOut = streamOut;
        populateCombo();
         if(!isCheckedOut)
        superMarketList = new ArrayList<>();
    }
 public void populateCombo()
    {
         jComboBox2.removeAllItems();
        for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
            if(e instanceof SuperMarket) 
            jComboBox2.addItem(e);
            System.out.println(e.getName());
        }
       populateTable();
    }
           public void populateTable() 
    {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        SuperMarket s=(SuperMarket)jComboBox2.getSelectedItem();
       try{
           ArrayList<SuperMarketItem>list= userList(s);
       
        for(SuperMarketItem item :list) {
           Object row[] = new Object[6];
           row[0] = item.getId();
           row[1] = item;
           row[2] = item.getCalorie();
           row[3] = item.getPrice();
           row[4] = item.getDiscount();
           if(item.getDiscount()!=0)
           row[5] = item.getPrice()*item.getDiscount();
           else
               row[5] = item.getPrice();
           model.addRow(row);
        
         }  
       }catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
       }
    
    }
    public ArrayList<SuperMarketItem> userList(SuperMarket superMarket) throws SQLException{
        ArrayList<SuperMarketItem> userList = new ArrayList<>();
        
           /* Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://35.185.14.219:3306;databaseName=new_schema;user=root;password=8466";
            Connection con = DriverManager.getConnection(url);*/
             String DB_URL = "jdbc:mysql://35.185.14.219:3306/new_schema";
             String DB_DRV =  "com.mysql.jdbc.Driver";
             String DB_USER = "root";
            String DB_PASSWD = "8466";
            try{
            con=DriverManager.getConnection (DB_URL,DB_USER,DB_PASSWD);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e+"133");
            }
            System.out.println(superMarket);
            System.out.println(superMarket.getUserAccount().getUsername());
            String query1 = "SELECT * FROM new_schema.`"+superMarket.getUserAccount().getUsername()+"`";
            Statement st=null;
            try{
             st = (Statement)con.createStatement();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e+"141");
            }
            ResultSet rs = null;
            try{
             rs = st.executeQuery(query1);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e+"ee");
            }
            SuperMarketItem item;
            while(rs.next()){
               item = new  SuperMarketItem(rs.getInt("id"),rs.getString("Name"),rs.getInt("calorie"),rs.getDouble("Price"),rs.getBytes("pic"),rs.getDouble("discount"),rs.getInt("inventory"),rs.getInt("saleHistory"));
                
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        quantitySpinner = new javax.swing.JSpinner();
        btnAdd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Market In this Business Circle");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Name", "Original price", "Discount?", "Current Price "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jLabel6.setText("Quantity:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
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

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel3.setText("Total Price:");

        jButton1.setFont(new java.awt.Font("Showcard Gothic", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 153, 255));
        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("My History Order>>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(387, 387, 387))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAdd))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(jButton1))
                .addGap(312, 312, 312))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(77, 77, 77))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = jTable1.getSelectedRow();
        //new ImageIcon(list.get(i).getPic());
        ImageIcon image1 = new ImageIcon(((SuperMarketItem)jTable1.getValueAt(i,1)).getPic());
        //(ImageIcon)jTable1.getValueAt(i,2);
        Image image = image1.getImage();
        double h = 300.0/image1.getIconHeight();
        Image newimg = image.getScaledInstance((int)(image1.getIconWidth()*h), (int)(image1.getIconHeight()*h),java.awt.Image.SCALE_SMOOTH);
        ImageIcon newone= new ImageIcon(newimg);
        jLabel8.setIcon(newone);               // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
     SuperMarket s  = (SuperMarket)jComboBox2.getSelectedItem();
            if(s==null) 
                return;
            populateTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed
 public void refreshOrderTable()
    {
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        model.setRowCount(0);
        for(SuperMarketServe si : superMarketList)
        {
            
                      Object row[] = new Object[3];
                      row[0] = si;
                      row[1] = si.getNumber();
                      row[2] = si.getItem().getDiscount();
                      model.addRow(row);
                
            
        }
       
    }
  public void printTotalPrice()
  {
      double totalPrice =0;
         for(SuperMarketServe serve: superMarketList)
         {
             totalPrice=totalPrice+serve.getNumber()*serve.getItem().getPrice()*(1-serve.getItem().getDiscount());
         }
       
         jTextField1.setText(String.valueOf(totalPrice));
  }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int selectedRow=jTable1.getSelectedRow();
        if(selectedRow<0)
        {
            JOptionPane.showMessageDialog(null,"Please select");
            return;
        }
        //RestaurantDish selectedDish = (RestaurantDish)jTable1.getValueAt(selectedRow,0);
        SuperMarketItem item= (SuperMarketItem)jTable1.getValueAt(selectedRow,1);
        int fetchQty=(Integer)quantitySpinner.getValue();        // TODO add your handling code here:
        if(fetchQty<=0)
        {
            JOptionPane.showMessageDialog(null,"Can't be zero");
            return;
        }
        if(fetchQty>item.getInventory())
        {
            JOptionPane.showMessageDialog(null,"Can't be larger than iventory");
            return;
        }
        try{

            boolean alereadyPresent = false;
            for(SuperMarketServe existItem : superMarketList)
            {
                if(existItem.getItem().getId() ==item.getId())
                {
                    existItem.setNumber(existItem.getNumber()+fetchQty);
                    alereadyPresent = true;
                    populateTable();
                    refreshOrderTable();
                    printTotalPrice();
                    break;
                }
            }
            if(!alereadyPresent)
            {
                SuperMarketServe snew = new SuperMarketServe();
                snew.setItem(item);
                snew.setNumber(fetchQty);
                superMarketList.add(snew);
                populateTable();
                refreshOrderTable();
                printTotalPrice();
            }

        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Invalid");
            return;
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = jTable2.getSelectedRow();
        if(row<0)
        {
            JOptionPane.showMessageDialog(null, "PLS SELECT A ROW");
            return;
        }
        SuperMarketServe marketServe = (SuperMarketServe)jTable2.getValueAt(row, 0);

        superMarketList.remove(marketServe);
        JOptionPane.showMessageDialog(null,"OrderITem removed from the cart");

        refreshOrderTable();
          populateTable();
        
        printTotalPrice();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SuperMarket s=(SuperMarket)jComboBox2.getSelectedItem();
        if(superMarketList.size() > 0)
        {
            Date currentTime= new Date();
            /*for(FoodServe fd:order.getOrderList())
            {
                fd.setDate(currentTime);
            }*/
            // System.out.println(r.getUserAccount().getPerson().getName());

            SuperMarketOrderRequest request = new SuperMarketOrderRequest(s);
            request.setItemList(superMarketList);
            request.setRequestDate(currentTime);
            request.setSender(userAccount);
            request.setStatus("Sent");
            request.setAddress(restaurant.getEnterpriseAddress());
             //r.getUserAccount().getWorkQueue().getWorkRequestList().add(request);
            s.getFoodOrderqueue().getWorkRequestList().add(request);
            System.out.println(userAccount);
            System.out.println(userAccount.getTheOrderIsentoutQueue().getWorkRequestList().size());
            userAccount.getTheOrderIsentoutQueue().getWorkRequestList().add(request);
            JOptionPane.showMessageDialog(null, "Order placed successfully");
            superMarketList = new ArrayList();

            refreshOrderTable();
          
                populateTable();
            try{
                 streamOut.reset();
                streamOut.writeObject(system);
                  streamOut.flush();
            }catch(Exception e){
                System.out.println("Error:"+e.getMessage());
            }
            isCheckedOut = true;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"no order placed");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       RestuarantOrderFromMarketHistory panel = new RestuarantOrderFromMarketHistory(system,userAccount,restaurant,userProcessContainer,streamOut);
        userProcessContainer.add("HistoryOrderJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer); // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
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
