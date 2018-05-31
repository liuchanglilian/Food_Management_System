/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package userInterface.RestaurantStaff;

import Network.Network;
import business.Enterprise.BioFactory;
import business.Enterprise.Enterprise;
import business.Enterprise.Restaurant;
import business.Organization.EnterpriseLevelOrganization;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import business.WorkQueue.DisposalRequest;
import business.WorkQueue.FoodOrderRequest;
import business.WorkQueue.WorkRequest;
import business.business.EcoSystem;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sunwen
 */
public class RestaurantStaffWorkArea extends javax.swing.JPanel {

    /** Creates new form RestaurantStaffWorkArea */
    private Restaurant restaurant;
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Network network;
    private EnterpriseLevelOrganization organization;
    private EcoSystem system;
    private ObjectOutputStream streamOut;
    public RestaurantStaffWorkArea(EcoSystem system,Network network,Enterprise restaurant,Organization organization,UserAccount userAccount,JPanel userProcessContainer,ObjectOutputStream streamOut) {
        initComponents();
        this.restaurant = (Restaurant) restaurant;
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.network = network;
        this.organization = (EnterpriseLevelOrganization) organization;
        this.system = system;
        this.streamOut = streamOut;
        labelRestaurant.setText(this.restaurant.getName());
       labelLeftOver.setText("Present Leftover:"+ DecimalFormat(this.restaurant.getLeftover())+" kg");
        
        populateCombo();
        populateTable();
    }
    public String DecimalFormat(double d)
      {
         DecimalFormat df = new DecimalFormat("0.00");
         System.out.println(df.format(d));
         return df.format(d);
         
      }
    private void populateCombo()
    {
        comboBio.removeAllItems();
        System.out.println("network is "+network);
          for(Enterprise e : network.getEnterpriseDirectory().getEnterpriseList())
        {
            if(e instanceof BioFactory)
                comboBio.addItem(e);
        }
       
    }
    
    private void populateTable()
    {
        DefaultTableModel model = (DefaultTableModel) tblRequest.getModel();
        model.setRowCount(0);
        for (WorkRequest workrequest: organization.getWorkQueue().getWorkRequestList())
        {
            DisposalRequest d = (DisposalRequest) workrequest;   
            Object[] row = new Object[4];
            row[0] = d;
            row[1] = d.getWeight();
            row[2] = d.getStatus();
            row[3] = d.getReceiver();
            model.addRow(row);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelRestaurant = new javax.swing.JLabel();
        labelLeftOver = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        btnSent = new javax.swing.JButton();
        comboBio = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();

        labelRestaurant.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelRestaurant.setText("jLabel1");

        labelLeftOver.setText("jLabel1");

        jLabel1.setText("Disposal Number:");

        txtNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumberActionPerformed(evt);
            }
        });

        btnSent.setText("Send Request");
        btnSent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSentActionPerformed(evt);
            }
        });

        comboBio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Biofactory:");

        tblRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Request ID", "Leftover Weight", "Status", "Biofactory"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRequest);
        if (tblRequest.getColumnModel().getColumnCount() > 0) {
            tblRequest.getColumnModel().getColumn(0).setResizable(false);
            tblRequest.getColumnModel().getColumn(1).setResizable(false);
            tblRequest.getColumnModel().getColumn(2).setResizable(false);
            tblRequest.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(labelRestaurant))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(267, 267, 267)
                                    .addComponent(btnSent))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboBio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(labelLeftOver))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(labelRestaurant)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelLeftOver)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnSent)
                .addContainerGap(205, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberActionPerformed

    private void btnSentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSentActionPerformed
        // TODO add your handling code here:
        String waste = txtNumber.getText();
        double wei=0;
        try{
        wei = Double.parseDouble(waste);}
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please input valid number");
            return;
        }
        BioFactory biofactory = (BioFactory) comboBio.getSelectedItem();
        if(biofactory == null)
        {
            JOptionPane.showMessageDialog(null, "No Avaliable Factory in This Area!");
            return;
        }
        else
        {
            if(wei>restaurant.getLeftover())
            {
                JOptionPane.showMessageDialog(null, "Please Input a Number Less Than Restaurant Leftover!");
                return;
            }
            DisposalRequest d = new DisposalRequest(wei, biofactory);
            d.setSendRestaurant(restaurant);
            d.setSender(userAccount);
            d.setSendOrganization(organization);
            d.setStatus("Pending");
            organization.getWorkQueue().getWorkRequestList().add(d);
            biofactory.getRequestQueue().getWorkRequestList().add(d);
            d.setReceiver(biofactory);
            populateTable();
            JOptionPane.showMessageDialog(null,"Added successfully");
            
            try{
                 streamOut.reset();
                streamOut.writeObject(system);
                streamOut.flush();
            }catch(Exception e){
                System.out.println("Error:"+e.getMessage());
            }
        }
        
    }//GEN-LAST:event_btnSentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSent;
    private javax.swing.JComboBox comboBio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelLeftOver;
    private javax.swing.JLabel labelRestaurant;
    private javax.swing.JTable tblRequest;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables

}