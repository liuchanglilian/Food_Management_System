/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picutill;

//import java.beans.Statement;


import java.awt.Image;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author liuch
 */
public class NewJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    Connection con;
    public NewJPanel() throws SQLException {
        initComponents();
        
        show_user();
    }
    
    public ArrayList<OnlineDish> userList(){
        ArrayList<OnlineDish> userList = new ArrayList<>();
        try{
           /* Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://35.185.14.219:3306;databaseName=new_schema;user=root;password=8466";
            Connection con = DriverManager.getConnection(url);*/
             String DB_URL = "jdbc:mysql://35.185.14.219:3306/new_schema";
             String DB_DRV =  "com.mysql.jdbc.Driver";
             String DB_USER = "root";
            String DB_PASSWD = "8466";
            con=DriverManager.getConnection (DB_URL,DB_USER,DB_PASSWD);
             String query1 = "SELECT * FROM new_schema.Pic";
            Statement st = (Statement)con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            OnlineDish user;
            while(rs.next()){
              //  user = new OnlineDish(rs.getInt("id"),rs.getString("Name"),rs.getBytes("pic"));
                
                //suserList.add(user);
            }
    }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return userList;
    }
   public void show_user(){
       ArrayList<OnlineDish> list = userList();
      // jTable1.getColumnModel().getColumn(2).setCellRenderer(jTable1.getDefaultRenderer(ImageIcon.class));
       DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
       //if(list.size()>1)
           
      // jLabel4.setIcon(new ImageIcon(list.get(1).getPic()));
      /* {ImageIcon a = new ImageIcon(list.get(1).getPic());
        Image image = a.getImage();
        double h = 100.0/a.getIconHeight();
        Image newimg = image.getScaledInstance((int)(a.getIconWidth()*h), (int)(a.getIconHeight()*h),java.awt.Image.SCALE_SMOOTH);
        ImageIcon newone= new ImageIcon(newimg);
        jLabel4.setIcon(newone);
       }*/
       Object[] row = new Object[3];
       for(int i=0;i<list.size();i++)
       {
           row[0] = list.get(i).getId();
           row[1] = list.get(i);
        //   row[2] = new ImageIcon(list.get(i).getPic());
          // row[2] = new ImageIcon([B@72d5d89e);
           //System.out.println("after read"+list.get(i).getPic());
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

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("Image Description:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Image:");

        jLabel3.setText("jLabel3");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Load Image");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Insert");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jTable1.setRowHeight(105);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setText("jLabel3");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addComponent(jButton2)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     int id = 21;
    String name = jTextField1.getText();
    byte[] pic = PicUtil.readImage();
    System.out.println("byte is "+pic);
    //String query = "INSERT INTO new_schema.Pic ('Name','pic') VALUES (?,?)";
    String query = "INSERT INTO `new_schema`.`Pic`  (`Name`,`pic`) VALUES (?,?)";
    PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) con.prepareStatement(query);
            //pstmt.setInt(1, id);
            pstmt.setString(1, name);
             pstmt.setBytes(2, pic);
            pstmt.execute();
            JOptionPane.showMessageDialog(null,"Uploaded");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex);
        }

    

    System.out.println(pic);
       
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        jLabel3.setIcon(PicUtil.getImage());

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

   int i = jTable1.getSelectedRow();
   //new ImageIcon(list.get(i).getPic());
   ImageIcon image1 = new ImageIcon(((OnlineDish)jTable1.getValueAt(i,1)).getPic());
           //(ImageIcon)jTable1.getValueAt(i,2);
  Image image = image1.getImage();
   double h = 100.0/image1.getIconHeight();
    Image newimg = image.getScaledInstance((int)(image1.getIconWidth()*h), (int)(image1.getIconHeight()*h),java.awt.Image.SCALE_SMOOTH);
   ImageIcon newone= new ImageIcon(newimg);
   jLabel4.setIcon(newone);

        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
