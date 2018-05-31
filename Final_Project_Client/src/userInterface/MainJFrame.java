/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import Business.DB4OUtil.DB4OUtil;
import Network.Network;
import SignupJPanel.Signup;
import business.Enterprise.Enterprise;
import business.Enterprise.Restaurant;
import business.Organization.EnterpriseLevelOrganization;
import business.Organization.Organization;
import business.Person.Person;
import business.UserAccount.UserAccount;
import business.business.ConfigureASystem;
import business.business.EcoSystem;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import picutill.NewJPanel;

/**
 *
 * @author liuch
 */
public class MainJFrame extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form MainJFrame
     */
    private EcoSystem system;
    private Socket socket = null;
    private Thread thread = null;
    private ObjectOutputStream streamOut = null;
    private ChatClientThread client = null;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    private volatile boolean running = true;

    public MainJFrame(String serverName, int serverPort) {
        setConnect(serverName, serverPort);
        initComponents();
        system = dB4OUtil.retrieveSystem();
        setAnimation();
        Timer timer = new Timer();
        timer.schedule(new TimerTaskTest(), 1000, 1000 * 60);
        MainJFrame that = this;
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                try {
                    streamOut.writeObject("Bye");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Close failed");
                }
                that.stop();
            }
        });
    }

    public void setAnimation() {
        URL url = this.getClass().getResource("Donut.gif");
        Icon myImgIcon = new ImageIcon(url);
        jLabel4.setIcon(myImgIcon);
    }

    public void setConnect(String serverName, int serverPort) {
        System.out.println("Establising connection,please wait..");
        try {
            //socket = new Socket(serverName, serverPort);
            socket = new Socket("10.110.43.47", serverPort);
            socket.setTcpNoDelay(true);
            System.out.println("Connected:" + socket);
            start();
        } catch (UnknownHostException uhe) {
            System.out.println("Host unknown:" + uhe.getMessage());
        } catch (IOException ioe) {
            System.out.println("Unexcepted exception:" + ioe.getMessage());
        }

    }

    public void setStop() {
        running = false;
    }

    public void run() {
        if (running) {
            while (thread != null) {
                {
                    try {
                        streamOut.flush();

                    } catch (IOException ioe) {
                        System.out.println("Sending error:" + ioe.getMessage());

                    }
                }
            }
        }
    }

    public void handle(EcoSystem msg) {
        system = msg;
    }

    public void start() throws IOException {
        streamOut = new ObjectOutputStream(socket.getOutputStream());
        if (thread == null) {
            System.out.println("1");
            client = new ChatClientThread(this, socket);
            System.out.println("lalallaSSS");
            thread = new Thread(this);
            thread.start();
        }
    }

    public void stop() {
        System.out.println("clossinnnng");
        if (thread != null) {
            thread = null;
        }
        try {
            if (streamOut != null) {
                streamOut.close();
            }
            if (socket != null) {
                socket.close();
            }

        } catch (IOException ioe) {
            System.out.println("Entering close");
        }
        if (client != null) {
            client.close();
            client.setStop();
        }
    }

    public class TimerTaskTest extends java.util.TimerTask {

        @Override
        public void run() {
            for (Network network : system.getNetworkList()) {
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    if (enterprise instanceof Restaurant) {
                        Restaurant r = (Restaurant) enterprise;
                        r.setLeftover(r.getLeftover() + (double) Math.round(Math.random() * 100) / 100);
                        System.out.println(r.getName() + r.getLeftover());
                    }
                }
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

        jSplitPane1 = new javax.swing.JSplitPane();
        container = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userNameJTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        loginJButton = new javax.swing.JButton();
        logoutJButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 1200));

        container.setOpaque(false);
        container.setPreferredSize(new java.awt.Dimension(1000, 1000));
        container.setLayout(new java.awt.CardLayout());
        container.add(jLabel3, "card2");

        jSplitPane1.setRightComponent(container);

        jPanel2.setPreferredSize(new java.awt.Dimension(149, 1000));

        jLabel1.setText("User Name");

        jLabel2.setText("Password");

        loginJButton.setText("Login");
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });

        logoutJButton.setText("Logout");
        logoutJButton.setEnabled(false);
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });

        jButton1.setText("CustomerSignup");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(userNameJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(loginJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(logoutJButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                        .addComponent(passwordField, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(475, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(38, 38, 38))
        );

        jSplitPane1.setLeftComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJButtonActionPerformed

        String userName = userNameJTextField.getText();
        char[] passwordCharArray = passwordField.getPassword();
        String password = String.valueOf(passwordCharArray);
        UserAccount userAccount = system.authanticate(userName, password);
        Network inNetwork = null;
        Enterprise inEnterprise = null;
        Organization inOrganization = null;
        if (userAccount == null) {
            //Step2: Go inside each network to check each enterprise
            for (Network network : system.getNetworkList()) {
                userAccount = network.authanticate(userName, password);
                if (userAccount == null) {
                    for (UserAccount ua : network.getUserList().getUserAccountList()) {
                        if (ua.getUsername().equals(userName) && (ua.getPassword().equals(password))) {
                            userAccount = ua;
                        }
                    }

                }
                if (userAccount == null) {
                    for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                        userAccount = enterprise.authanticate(userName, password);
                        System.out.println(userAccount);
                        System.out.println(enterprise.getUserAccount().getUsername());
                        if (userAccount == null) {
                            for (EnterpriseLevelOrganization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                                for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                                    userAccount = ua.checkAccount(userName, password);

                                    if (userAccount != null) {
                                        inEnterprise = enterprise;
                                        inNetwork = network;
                                        inOrganization = organization;
                                        System.out.println("i AM BREAKING HERE");
                                        System.out.println(userAccount.getUsername());
                                        break;
                                    }

                                }
                                if (inOrganization != null) {
                                    break;
                                }
                            }
                            if (inEnterprise != null) {
                                break;
                            }
                        } else {
                            inNetwork = network;
                            inEnterprise = enterprise;
                            break;
                        }
                    }


    }//GEN-LAST:event_loginJButtonActionPerformed
                else {
                    inNetwork = network;
                    break;
                }
                if (inNetwork != null) {
                    break;
                }
            }

        }
        if (userAccount == null) {
            System.out.println("ISSSS NONE");
            JOptionPane.showMessageDialog(null, "Invalid Credentails!");
            return;
        } else {
            CardLayout layout = (CardLayout) container.getLayout();
            container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inNetwork, inEnterprise, inOrganization, system, streamOut));
            layout.next(container);
        }
        loginJButton.setEnabled(false);
        jButton1.setEnabled(false);
        logoutJButton.setEnabled(true);
        userNameJTextField.setEnabled(false);
        passwordField.setEnabled(false);
    }

    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
        logoutJButton.setEnabled(false);
        userNameJTextField.setEnabled(true);
        passwordField.setEnabled(true);
        loginJButton.setEnabled(true);
        jButton1.setEnabled(true);
        userNameJTextField.setText("");
        passwordField.setText("");

        container.removeAll();
        JPanel blankJP = new JPanel();
        container.add("blank", blankJP);
        CardLayout crdLyt = (CardLayout) container.getLayout();
        crdLyt.next(container);
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_logoutJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Signup signPage = new Signup(system, streamOut);
        container.add("manageOrganizationJPanel", signPage);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(
                new Runnable() {

            public void run() {
                try {
                    UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
                } catch (Exception e) {
                }

                MainJFrame client1 = null;
                client1 = new MainJFrame("localhost", 8467);
                client1.setSize(647, 410);
                client1.setLocationRelativeTo(null);
                client1.setVisible(true);
                client1.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
                client1.getRootPane().setFont(UIManager.getFont("SystemFont"));
                client1.getRootPane().putClientProperty("Quaqua.RootPane.isVertical", Boolean.FALSE);
                client1.getRootPane().putClientProperty("Quaqua.RootPane.isPalette", Boolean.FALSE);
                JFrame.setDefaultLookAndFeelDecorated(true);

                JDialog.setDefaultLookAndFeelDecorated(true);

                client1.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton loginJButton;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userNameJTextField;
    // End of variables declaration//GEN-END:variables
}
