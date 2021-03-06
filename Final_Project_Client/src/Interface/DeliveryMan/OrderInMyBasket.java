/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DeliveryMan;

import Network.Network;
import business.Enterprise.Enterprise;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import business.WorkQueue.FoodOrderRequest;
import business.WorkQueue.WorkRequest;
import business.WorkQueue.WorkRequest.RequestType;
import business.business.EcoSystem;
import java.awt.CardLayout;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author liuch
 */
public class OrderInMyBasket extends javax.swing.JPanel {

    /**
     * Creates new form OrderInMyBasket
     */
    UserAccount account;
    Network network;
    EcoSystem system;
    JPanel userProcessContainer;
    ObjectOutputStream streamOut;

    public OrderInMyBasket(UserAccount account, Network network, EcoSystem system, JPanel userProcessContainer, ObjectOutputStream streamOut) {
        initComponents();
        this.account = account;
        this.system = system;
        this.userProcessContainer = userProcessContainer;
        this.streamOut = streamOut;
        populateTable();
        populateTable2();
    }

    public String toTimeString(Date dt) {
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        return myFmt.format(dt);
    }

    public boolean checkFresh(FoodOrderRequest food) {
        Date now = new Date();
        if ((now.getTime() - food.getOrder().getOrderList().get(0).getDate().getTime()) > 0.5 * 60 * 1000) {
            return false;
        } else {
            return true;
        }

    }

    public boolean checkDiscountedFood(FoodOrderRequest food) {
        Date now = new Date();
        if ((now.getTime() - food.getOrder().getOrderList().get(0).getDate().getTime()) > 0.5 * 60 * 1000) {
            return false;
        } else {
            return true;
        }
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (WorkRequest f : account.getWorkQueue().getWorkRequestList()) {
         if(f.getRequestType()==RequestType.FoodOrderRequest)
         { FoodOrderRequest food = (FoodOrderRequest) f;
            Object[] row = new Object[4];
            row[0] = food;
            row[1] = food.getSender();
            if ((food.getOrder().getOrderList().size() != 0) && food.getOrder().getDiscountFoodList().size() == 0) {
                row[2] = toTimeString(food.getOrder().getOrderList().get(0).getDate());
            } else {
                row[2] = "Here contains discount food";
            }
            if (food.getOrder().getOrderList().size() != 0) {
                if (checkFresh(food) == false) {
                    row[3] = "Expired";
                } else {
                    row[3] = "Food is still fresh";
                }
            } else {
                row[3] = "discounted food";
            }

            model.addRow(row);
        }
        }
    }
public void populateTable2() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        for (WorkRequest f : account.getWorkQueue().getWorkRequestList()) {
         if(f.getRequestType()!=RequestType.FoodOrderRequest)
         { 
            Object[] row = new Object[3];
            row[0] = f.getRequestType();
            row[1] = f.getSender();
            row[2] = f.getReceiver();
            

            model.addRow(row);
        }
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
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Order ID", "Customer Name", "Food Released Time", "More Than two Hour?"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Send back unfresh food to restaurant");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Sender", "Receiver"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Restaurant Order Table:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Other Tasks:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jButton2)
                        .addGap(69, 69, 69)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(71, 71, 71))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int row = jTable1.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Pls select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            FoodOrderRequest p = (FoodOrderRequest) jTable1.getValueAt(row, 0);
            if (p.getOrder().getDiscountFoodList().size() == 0) {
                if (checkFresh(p) == true) {
                    JOptionPane.showMessageDialog(null, "The food is still fresh, you can't do that", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                p.setStatus("The food went bad before arrive, please make a new order");
                account.getWorkQueue().getWorkRequestList().remove(p);
                p.getReceiver().addToUnfreshList(p.getOrder().getOrderList());
                try {
                    streamOut.reset();
                    streamOut.writeObject(system);
                    streamOut.flush();
                } catch (Exception e) {
                    System.out.println("Error:" + e.getMessage());
                }
                populateTable();

            } else {
                JOptionPane.showMessageDialog(null, "Order of discount food", "Inane error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
