
package mycodes;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class edit_profile extends javax.swing.JFrame {
     JLabel lb;
     JFileChooser jfc;
     File ph;
   
    public edit_profile() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
       Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
       int h=(int)d.getHeight();
       int w=(int)d.getWidth();
       lb=new JLabel();
       lb.setBounds(0, 0, w, h);
       ImageIcon ic=new ImageIcon("src\\myuploads\\8.jpg");
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
            ResultSet rs=DBLoader.executeSql("select * from user where email='"+global.email+"'");
            if(rs.next())
            {
                String name=rs.getString("name");
                String age=rs.getString("age");
                String department=rs.getString("department");
                String photo=rs.getString("photo");
                String contact=rs.getString("contact");
                String email=rs.getString("email");
                
                tf1.setText(name);
                tf2.setText(age);
                tf3.setText(department);
                tf4.setText(contact);
                tf5.setText(email);
                ImageIcon icon = new ImageIcon(photo);
        Image ic = icon.getImage().getScaledInstance(ph1.getWidth(), ph1.getHeight(), Image.SCALE_SMOOTH);
        ph1.setIcon(new ImageIcon(ic));
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ph1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tf1 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        tf3 = new javax.swing.JTextField();
        tf4 = new javax.swing.JTextField();
        tf5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("EDIT USER PROFILE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(430, 20, 600, 50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("NAME");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 130, 80, 32);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 153));
        jLabel3.setText("AGE");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(120, 210, 60, 32);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 153));
        jLabel4.setText("DEPARTMENT");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 280, 160, 32);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 153));
        jLabel5.setText("CONTACT");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 380, 130, 20);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 153));
        jLabel6.setText("EMAIL ID");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(80, 470, 120, 32);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 153));
        jLabel7.setText("PHOTO");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(800, 290, 90, 32);

        ph1.setText(".");
        getContentPane().add(ph1);
        ph1.setBounds(910, 220, 180, 180);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 204));
        jButton1.setText("UPDATE PROFILE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(520, 570, 230, 39);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 204));
        jButton2.setText("CHOOSE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1100, 300, 110, 20);
        getContentPane().add(tf1);
        tf1.setBounds(290, 130, 210, 30);

        tf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf2ActionPerformed(evt);
            }
        });
        getContentPane().add(tf2);
        tf2.setBounds(290, 210, 210, 30);
        getContentPane().add(tf3);
        tf3.setBounds(290, 290, 210, 30);
        getContentPane().add(tf4);
        tf4.setBounds(290, 380, 210, 30);
        getContentPane().add(tf5);
        tf5.setBounds(290, 470, 210, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Wanna Change Existing Password??");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(910, 610, 210, 20);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 204));
        jButton3.setText("MANAGE PASSWORD");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(1120, 610, 160, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
           JFileChooser jfc=new JFileChooser();
        int ans=jfc.showOpenDialog(this);
        if(ans==JFileChooser.APPROVE_OPTION)
        {
           ph=jfc.getSelectedFile();
            ImageIcon ic=new ImageIcon(ph.getPath());
            Image ic1=ic.getImage().getScaledInstance(ph1.getWidth(), ph1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ic2=new ImageIcon(ic1);
            ph1.setIcon(ic2);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                                              
//    String name = tf1.getText();
//    String age = tf2.getText();
//    String department = tf3.getText();
//    String contact = tf4.getText();
//    String email = tf5.getText();
//    
//    System.out.println("Name: " + name);
//    System.out.println("Age: " + age);
//    System.out.println("Department: " + department);
//    System.out.println("Contact: " + contact);
//    System.out.println("Email: " + email);
//    System.out.println("Photo File: " + ph.getPath());
//    
//        String ans = myClient.editprofile(name, age, department, ph, contact,email);
//
//
//        
//      if ("success".equals(ans)) {
//    JOptionPane.showMessageDialog(this, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
//} else if ("fail".equals(ans)) {
//    JOptionPane.showMessageDialog(this, "Update failed: No rows were updated.", "Error", JOptionPane.ERROR_MESSAGE);
//} else {
//    JOptionPane.showMessageDialog(this, "Update failed due to a server error: " + ans, "Error", JOptionPane.ERROR_MESSAGE);
//}



    String name = tf1.getText();
    String age = tf2.getText();
    String department = tf3.getText();
    String contact = tf4.getText();
    String email = tf5.getText();
    String photoPath = "src/myuploads/" + ph.getName();


    
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Department: " + department);
    System.out.println("Contact: " + contact);
    System.out.println("Email: " + email);
    System.out.println("Photo File: "+photoPath);

  
    String sql = "UPDATE user SET age = '" + age + "', department = '" + department + "', contact = '" + contact + "', email = '" + email + "' ,photo = '" + photoPath + "' WHERE name = '" + name + "'";


    try {
       
        int rowsUpdated = DBLoader.executeSQL(sql);

        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            new user_home().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Update failed: No rows were updated.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "An error occurred while updating the profile.");

        Logger.getLogger(manage_pass.class.getName()).log(Level.SEVERE, null, ex);
    }




    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        manage_pass mp= new manage_pass();
        mp.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(edit_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(edit_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(edit_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(edit_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new edit_profile().setVisible(true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel ph1;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    // End of variables declaration//GEN-END:variables
}
