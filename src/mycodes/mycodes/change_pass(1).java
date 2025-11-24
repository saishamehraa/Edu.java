
package mycodes;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class change_pass extends javax.swing.JFrame {

    JLabel lb;
    
    public change_pass() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
       int h=(int)d.getHeight();
       int w=(int)d.getWidth();
       lb=new JLabel();
       lb.setBounds(0, 0, w, h);
       ImageIcon ic=new ImageIcon("src\\myuploads\\admin_login.jpg");
       Image img=ic.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
       ImageIcon im=new ImageIcon(img);
       lb.setIcon(im);
       add(lb);
       
        setSize(w, h);
        call();
    }

    void call()
{
        try {
            ResultSet rs=DBLoader.executeSql("select * from admin where password='"+global.password+"'");
            if(rs.next())
            {
                String password=rs.getString("password");
                String new_password=rs.getString("new password");
                String confirm=rs.getString("confirm new password");
                jp.getText();
                jp1.getText();
                jp2.getText();
            }
        } catch (Exception ex) {
            Logger.getLogger(edit_profile.class.getName()).log(Level.SEVERE, null, ex);
        }
}
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jp = new javax.swing.JPasswordField();
        jp1 = new javax.swing.JPasswordField();
        jp2 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CHANGE PASSWORD");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(410, 20, 490, 60);
        getContentPane().add(jp);
        jp.setBounds(670, 230, 230, 30);
        getContentPane().add(jp1);
        jp1.setBounds(670, 330, 230, 30);
        getContentPane().add(jp2);
        jp2.setBounds(670, 430, 230, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("CONFIRM NEW PASSWORD");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(260, 410, 320, 60);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("CURRENT PASSWORD");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(320, 210, 260, 60);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("NEW PASSWORD");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(370, 310, 210, 60);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("UPDATE PASSWORD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(480, 520, 280, 39);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("HOME");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(30, 40, 72, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                                           
    String currentPassword = new String(jp.getPassword());
    String newPassword = new String(jp1.getPassword());
    String confirmPassword = new String(jp2.getPassword());
    
    if (currentPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled in.");
        return;
    }
    
    if (!newPassword.equals(confirmPassword)) {
        JOptionPane.showMessageDialog(this, "New password and confirmation do not match.");
        return;
    }
    
    try {
  
        ResultSet rs = DBLoader.executeSql("SELECT * FROM admin WHERE password ='" + currentPassword + "'");
        if (!rs.next()) {
            JOptionPane.showMessageDialog(this, "Current password is incorrect.");
            return;
        }
        
    
        int updateSql = DBLoader.executeSQL("UPDATE admin SET password = '" + newPassword + "' WHERE password = '" + currentPassword + "'");

    
        if (updateSql != -1) {
            JOptionPane.showMessageDialog(this, "Password updated successfully.");
            new admin_home().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update password.");
        }
        
        }
        
       catch (Exception ex) {
               ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "An error occurred while updating the password.");
               
            Logger.getLogger(change_pass.class.getName()).log(Level.SEVERE, null, ex);
        }


  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        admin_home ah=new admin_home();
        ah.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


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
            java.util.logging.Logger.getLogger(change_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(change_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(change_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(change_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new change_pass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jp;
    private javax.swing.JPasswordField jp1;
    private javax.swing.JPasswordField jp2;
    // End of variables declaration//GEN-END:variables
}
