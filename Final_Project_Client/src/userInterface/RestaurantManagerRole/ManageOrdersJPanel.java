/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.RestaurantManagerRole;

import Food.FoodServe;
import Food.Order;
import Food.RestaurantDish;
import Network.Network;
import business.Enterprise.DeliveryCompany;
import business.Enterprise.Enterprise;
import static business.Enterprise.Enterprise.EnterpriseType.DeliveryCompany;
import business.Enterprise.Restaurant;
import business.Organization.DeliveryMenOrganization;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import business.WorkQueue.FoodOrderRequest;
import business.WorkQueue.WorkRequest;
import business.business.EcoSystem;
import java.awt.CardLayout;
import java.io.ObjectOutputStream;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wen
 */
public class ManageOrdersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageOrdersJPanel
     */
    private EcoSystem system;
    private Restaurant restaurant;
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Network network;
    private ObjectOutputStream streamOut;

    public ManageOrdersJPanel(UserAccount userAccount, Network network, EcoSystem system, Restaurant restaurant, JPanel userProcessContainer,
            ObjectOutputStream streamOut) {
        initComponents();
        this.system = system;
        this.userProcessContainer = userProcessContainer;
        this.restaurant = restaurant;
        this.userAccount = userAccount;
        this.network = network;
        this.streamOut = streamOut;
        populateTable();

    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblOrder1.getModel();
        model.setRowCount(0);
        for (WorkRequest workRequest : restaurant.getFoodOrderqueue().getWorkRequestList()) {
            workRequest = (FoodOrderRequest) workRequest;
            Object[] row = new Object[3];
            row[0] = workRequest;
            row[1] = workRequest.getAddress();
            row[2] = workRequest.getStatus();
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
        tblOrder = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnApprove = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrder1 = new javax.swing.JTable();

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dish Name", "Number", "Discount?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblOrder);
        if (tblOrder.getColumnModel().getColumnCount() > 0) {
            tblOrder.getColumnModel().getColumn(0).setResizable(false);
            tblOrder.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Manage Orders");

        btnApprove.setText("Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        btnView.setText("Select and View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblOrder1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Number", "Customer Adress", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblOrder1);
        if (tblOrder1.getColumnModel().getColumnCount() > 0) {
            tblOrder1.getColumnModel().getColumn(0).setResizable(false);
            tblOrder1.getColumnModel().getColumn(1).setResizable(false);
            tblOrder1.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(btnView)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnApprove)))))
                .addContainerGap(219, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(209, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(276, 276, 276)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApprove)
                    .addComponent(btnView)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(499, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed

        int row = tblOrder1.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Pls select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            FoodOrderRequest p = (FoodOrderRequest) tblOrder1.getValueAt(row, 0);
            populateViewTable(p);

        } // TODO add your handling code here:
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        int row = tblOrder1.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Pls select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            FoodOrderRequest p = (FoodOrderRequest) tblOrder1.getValueAt(row, 0);
            if (p.getStatus().equals("Waiting for delivery Man")) {
                JOptionPane.showMessageDialog(null, "Already send request to Delivery Company,Please be patient ^-^");
                return;
            }
            p.setStatus("Accepted");
            Date food = new Date();
            for (FoodServe f : p.getOrder().getOrderList()) {
                f.setDate(food);
            }
            for (FoodServe f : p.getOrder().getDiscountFoodList()) {
                for (FoodServe foodInRestDiscount : restaurant.getUnfreshfoodList()) {
                    if (foodInRestDiscount.getDish() == f.getDish()) {
                        foodInRestDiscount.setNumber(foodInRestDiscount.getNumber() - f.getNumber());
                        break;
                    }

                }

            }
            DeliveryCompany delivery = null;
            for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (e instanceof DeliveryCompany) {
                    delivery = (DeliveryCompany) e;
                    break;
                }

            }
            if (delivery == null) {
                JOptionPane.showMessageDialog(null, "No available delivery company in this area!", "Warning", JOptionPane.WARNING_MESSAGE);
                try {
                    streamOut.reset();
                    streamOut.writeObject(system);
                    streamOut.flush();
                } catch (Exception e) {
                    System.out.println("Error:" + e.getMessage());
                }
                return;
            }
            boolean findAnDeliveryOrganization = false;
            for (Organization o : delivery.getOrganizationDirectory().getOrganizationList()) {
                if (o instanceof DeliveryMenOrganization) {
                    ((DeliveryMenOrganization) o).getWorkQueue().getWorkRequestList().add(p);
                    findAnDeliveryOrganization = true;
                    p.setStatus("Waiting for delivery Man");

                    break;
                }
            }
            if (findAnDeliveryOrganization == false) {
                JOptionPane.showMessageDialog(null, "No available organization in this company!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                streamOut.reset();
                streamOut.writeObject(system);
                streamOut.flush();
            } catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
            }

            JOptionPane.showMessageDialog(null, "Requested send out to Delivery Company");
            populateTable();
        }// TODO add your handling code here:
    }//GEN-LAST:event_btnApproveActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed
    public void populateViewTable(FoodOrderRequest p) {
        System.out.println(p);
        System.out.println(p.getOrder().getOrderList().size());
        DefaultTableModel model = (DefaultTableModel) tblOrder.getModel();
        model.setRowCount(0);
        for (FoodServe fd : p.getOrder().getOrderList()) {
            Object[] row = new Object[3];
            row[0] = fd;
            row[1] = fd.getNumber();
            row[2] = "No";
            model.addRow(row);
        }
        for (FoodServe fd : p.getOrder().getDiscountFoodList()) {
            Object[] row = new Object[3];
            row[0] = fd;
            row[1] = fd.getNumber();
            row[2] = "Yes";
            model.addRow(row);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTable tblOrder1;
    // End of variables declaration//GEN-END:variables
}
