/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.NEOManager;

import business.UserAccount.UserAccount;
import business.WorkQueue.OrphaneRequest;
import business.WorkQueue.SuperMarketOrderRequest;
import business.WorkQueue.WorkRequest;
import business.business.EcoSystem;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author liuch
 */
public class MyRequestNEO extends javax.swing.JPanel {

    /**
     * Creates new form MyRequestNEO
     */
    EcoSystem system;
    UserAccount userAccount;
    JPanel userProcessContainer;
    ObjectOutputStream streamOut;
    public MyRequestNEO(EcoSystem system,UserAccount userAccount,JPanel userProcessContainer,ObjectOutputStream streamOut) {
        initComponents();
        this.system = system;
        this.userAccount = userAccount;
        this.userProcessContainer = userProcessContainer;
        this.streamOut = streamOut;
        populateTable();
    }
public void populateTable()
{
     DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
     model.setRowCount(0);
     for (WorkRequest request:userAccount.getWorkQueue().getWorkRequestList()){
            OrphaneRequest oreRequest= (OrphaneRequest) request;
            Object[] row = new Object[3];
            row[0] = oreRequest;
            row[1] = oreRequest.getStatus();
            if(oreRequest.getEnterprise()!=null)
            row[2] = oreRequest.getEnterprise().getName();
            else
                row[2] = "Not accepted yet";
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Status", "Enterprise"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Approve");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(204, 204, 204))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jButton1)
                .addGap(171, 171, 171))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  int row =jTable1.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Pls select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            OrphaneRequest p = (OrphaneRequest)jTable1.getValueAt(row, 0);
            if(p.getDeliveryMan()!=null)
            {  p.setStatus("Received");
            p.getDeliveryMan().getWorkQueue().getWorkRequestList().remove(p);
            userAccount.getWorkQueue().getWorkRequestList().remove(p);
            try{
              
               streamOut.writeObject(system);
               streamOut.flush();
                streamOut.reset();
              }catch(Exception e){
               System.out.print("Exception"+e.getMessage());
           }
            populateTable();
            JOptionPane.showMessageDialog(null,"Received");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Not send out yet be patient");
                 return;// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
