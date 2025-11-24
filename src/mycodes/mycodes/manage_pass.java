package mycodes;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class manage_pass extends javax.swing.JFrame {
    JLabel lb;
    
    public manage_pass() {
        initComponents();
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                 Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
       int h=(int)d.getHeight();
       int w=(int)d.getWidth();
       lb=new JLabel();
       lb.setBounds(0, 0, w, h);
       ImageIcon ic=new ImageIcon("src\\myuploads\\user_login.jpg");
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
            ResultSet rs=DBLoader.executeSql("select * from user where password='"+global.password+"'");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jp = new javax.swing.JPasswordField();
        jp1 = new javax.swing.JPasswordField();
        jp2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 51));
        jLabel1.setText("CHANGE PASSWORD");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(380, 10, 660, 50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 51));
        jLabel2.setText("CURRENT PASSWORD");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(270, 250, 280, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 51));
        jLabel3.setText("NEW PASSWORD");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(320, 360, 200, 32);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 51));
        jLabel4.setText("CONFIRM NEW PASSWORD");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(210, 480, 330, 32);

        jp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpActionPerformed(evt);
            }
        });
        getContentPane().add(jp);
        jp.setBounds(590, 240, 280, 30);
        getContentPane().add(jp1);
        jp1.setBounds(590, 360, 280, 30);
        getContentPane().add(jp2);
        jp2.setBounds(590, 480, 280, 30);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 51));
        jButton1.setText("CHANGE PASSWORD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(440, 560, 350, 39);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 0, 51));
        jButton3.setText("Forgot Password?");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(30, 610, 140, 23);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 0, 51));
        jButton2.setText("LOGIN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(30, 20, 90, 27);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jpActionPerformed

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

            ResultSet rs = DBLoader.executeSql("SELECT * FROM user WHERE password ='" + currentPassword + "'");
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Current password is incorrect.");
                return;
            }

            int updateSql = DBLoader.executeSQL("UPDATE user SET password = '" + newPassword + "' WHERE password = '" + currentPassword + "'");

            if (updateSql != -1) {
                JOptionPane.showMessageDialog(this, "Password updated successfully.");
                new user_home().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update password.");
            }

        }

        catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while updating the password.");

            Logger.getLogger(manage_pass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        otp obj=new otp();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        user_login ul= new user_login();
        ul.setVisible(true);
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
            java.util.logging.Logger.getLogger(manage_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manage_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manage_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manage_pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manage_pass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jp;
    private javax.swing.JPasswordField jp1;
    private javax.swing.JPasswordField jp2;
    // End of variables declaration//GEN-END:variables
}
