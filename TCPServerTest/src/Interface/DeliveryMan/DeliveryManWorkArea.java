/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DeliveryMan;

import Network.Network;
import business.Enterprise.Enterprise;
import business.Organization.EnterpriseLevelOrganization;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import business.business.EcoSystem;
import java.awt.CardLayout;
import java.io.ObjectOutputStream;
import javax.swing.JPanel;
import userInterface.RestaurantManagerRole.ManageOrdersJPanel;

/**
 *
 * @author liuch
 */
public class DeliveryManWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form DeliveryManWorkArea
     */
    JPanel userProcessContainer;
    Network network;
    EcoSystem system;
    Enterprise enterprise;
    EnterpriseLevelOrganization organization;
    UserAccount account;
    ObjectOutputStream streamOut;
    public DeliveryManWorkArea(JPanel userProcessContainer,Network network,EcoSystem system,Enterprise enterprise,Organization organization,UserAccount account,ObjectOutputStream streamOut) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.network = network;
        this.system = system;
        this.enterprise = enterprise;
        this.organization = (EnterpriseLevelOrganization)organization;
        this.account = account;
        this.streamOut = streamOut;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("Look for Pending order");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Orders in my basket");
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
                .addGap(155, 155, 155)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(272, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(200, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      PendingOrdersJPanel panel = new PendingOrdersJPanel(account,network,system,enterprise,organization,userProcessContainer,streamOut);
      userProcessContainer.add("ManageOrdersJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      OrderInMyBasket panel = new OrderInMyBasket(account,network,system,userProcessContainer,streamOut);
      userProcessContainer.add("OrderInMyBasket", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
