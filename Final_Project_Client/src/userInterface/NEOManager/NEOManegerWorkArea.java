/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.NEOManager;

import Network.Network;
import business.Enterprise.Enterprise;
import business.Enterprise.Orphane;
import business.Enterprise.Restaurant;
import business.UserAccount.UserAccount;
import business.WorkQueue.OrphaneRequest;
import business.business.EcoSystem;
import java.awt.CardLayout;
import java.io.ObjectOutputStream;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import userInterface.SuperMarketManager.ManageDiscountJPanel;

/**
 *
 * @author liuch
 */
public class NEOManegerWorkArea extends javax.swing.JPanel {

    EcoSystem system;
    JPanel userProcessContainer;
    UserAccount userAccount;
    Network network;
    Orphane enterprise;
    ObjectOutputStream streamOut;

    public NEOManegerWorkArea(EcoSystem system, JPanel userProcessContainer, UserAccount userAccount, Network network, Enterprise enterprise, ObjectOutputStream streamOut) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.network = network;
        this.enterprise = (Orphane) enterprise;
        this.system = system;
        this.streamOut = streamOut;
        lableNGOName.setText(enterprise.getName());
        System.out.println(network);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lableNGOName = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("Number Of Food:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Send request for food");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lableNGOName.setText("jLabel2");

        jButton2.setText("My request");
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
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lableNGOName)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(576, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lableNGOName)
                .addGap(152, 152, 152)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addComponent(jButton1)
                .addGap(64, 64, 64)
                .addComponent(jButton2)
                .addContainerGap(247, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int orderFood = 0;
        try {
            String a = jTextField1.getText();
            orderFood = Integer.parseInt(a);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invilid number");
            return;
        }
        OrphaneRequest request = new OrphaneRequest(network, enterprise);
        Date current = new Date();
        request.setRequestDate(current);
        request.setSender(userAccount);
        request.setNumberOfFood(orderFood);
        request.setStatus("Send to restaurant");
        request.setAddress(enterprise.getEnterpriseAddress());
      //  request.setAddress(enterprise);
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        network.getQueueOphan().getWorkRequestList().add(request);
        JOptionPane.showMessageDialog(null, "Request Send out");
        try {
            streamOut.writeObject(system);
            streamOut.flush();
            streamOut.reset();
        } catch (Exception e) {
            System.out.print("Exception" + e.getMessage());
        }
        System.out.println(network.getQueueOphan().getWorkRequestList().size());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MyRequestNEO panel = new MyRequestNEO(system, userAccount, userProcessContainer, streamOut);
        userProcessContainer.add("MyrequestNEOJPanelJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lableNGOName;
    // End of variables declaration//GEN-END:variables
}