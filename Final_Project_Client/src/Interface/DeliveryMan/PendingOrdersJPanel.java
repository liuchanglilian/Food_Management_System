/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DeliveryMan;

import Food.RestaurantDish;
import Network.Network;
import business.Enterprise.Enterprise;
import business.Organization.DeliveryMenOrganization;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import business.WorkQueue.FoodOrderRequest;
import business.WorkQueue.OrphaneRequest;
import business.WorkQueue.WorkRequest;
import business.business.EcoSystem;
import java.awt.CardLayout;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author liuch
 */
public class PendingOrdersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PendingOrdersJPanel
     */
    UserAccount account;
    Network network;
    EcoSystem system;
    Enterprise enterprise;
    DeliveryMenOrganization organization;
    JPanel userProcessContainer;
    ObjectOutputStream streamOut;

    public PendingOrdersJPanel(UserAccount account, Network network, EcoSystem system, Enterprise enterprise, Organization organization, JPanel userProcessContainer, ObjectOutputStream streamOut) {
        initComponents();
        this.account = account;
        this.network = network;
        this.system = system;
        this.enterprise = enterprise;
        this.organization = (DeliveryMenOrganization) organization;
        this.userProcessContainer = userProcessContainer;
        this.streamOut = streamOut;
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        System.out.println(organization.getWorkQueue().getWorkRequestList().size());
        for (WorkRequest f : organization.getWorkQueue().getWorkRequestList()) {
            //  FoodOrderRequest food =(FoodOrderRequest) f;
            Object[] row = new Object[4];
            row[0] = f;
            row[1] = f.getSender();
            row[2] = f.getAddress();
            row[3] = f.returnSize();
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Order ID", "Customer Name", "Address", "Food Serve"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Assign To me");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
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
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(328, 328, 328)
                        .addComponent(jButton1)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(129, 129, 129))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int row = jTable1.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Pls select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            WorkRequest p = (WorkRequest) jTable1.getValueAt(row, 0);
            account.getWorkQueue().getWorkRequestList().add(p);
            organization.getWorkQueue().getWorkRequestList().remove(p);
            p.getReceiverWorkQueue().getWorkRequestList().remove(p);
            populateTable();
            p.setDeliveryMan(account);
            p.setStatus("Collected by Delivery Man" + account.getPerson());
            try {
                streamOut.reset();
                streamOut.writeObject(system);
                streamOut.flush();
            } catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Assigned to me");
            // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
