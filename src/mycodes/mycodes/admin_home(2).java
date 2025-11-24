
package mycodes;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class admin_home extends javax.swing.JFrame {
    JLabel lb;
    public admin_home() {
        initComponents();
        setSize(800,600);
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                 Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
       int h=(int)d.getHeight();
       int w=(int)d.getWidth();
       lb=new JLabel();
       lb.setBounds(0, 0, w, h);
       ImageIcon ic=new ImageIcon("src\\myuploads\\user_home.jpg");
       Image img=ic.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
       ImageIcon im=new ImageIcon(img);
       lb.setIcon(im);
       add(lb);
       
        setSize(w, h);

    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        categories = new javax.swing.JButton();
        courses = new javax.swing.JButton();
        lectures = new javax.swing.JButton();
        password = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        categories.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        categories.setForeground(new java.awt.Color(0, 102, 102));
        categories.setText("MANAGE CATEGORIES");
        categories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriesActionPerformed(evt);
            }
        });
        getContentPane().add(categories);
        categories.setBounds(250, 220, 240, 30);

        courses.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        courses.setForeground(new java.awt.Color(0, 102, 102));
        courses.setText("MANAGE COURSES");
        courses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursesActionPerformed(evt);
            }
        });
        getContentPane().add(courses);
        courses.setBounds(730, 220, 250, 30);

        lectures.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lectures.setForeground(new java.awt.Color(0, 102, 102));
        lectures.setText("MANAGE LECTURES");
        lectures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturesActionPerformed(evt);
            }
        });
        getContentPane().add(lectures);
        lectures.setBounds(250, 420, 230, 30);

        password.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        password.setForeground(new java.awt.Color(0, 102, 102));
        password.setText("CHANGE PASSWORD");
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password);
        password.setBounds(740, 420, 250, 30);

        logout.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        logout.setForeground(new java.awt.Color(0, 102, 102));
        logout.setText("LOGOUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout);
        logout.setBounds(550, 580, 140, 40);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("WELCOME ADMIN!!!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(390, 90, 570, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriesActionPerformed
        // TODO add your handling code here:
        add_category addCategories = new add_category();
        addCategories.setVisible(true);
        this.dispose();

      
    }//GEN-LAST:event_categoriesActionPerformed

    private void coursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursesActionPerformed
        // TODO add your handling code here:
        add_courses addCourses = new add_courses();
        addCourses.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_coursesActionPerformed

    private void lecturesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturesActionPerformed
        // TODO add your handling code here:
        add_lectures addLectures = new add_lectures();
        addLectures.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lecturesActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        dispose();
        login obj=new login();
        obj.setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
        change_pass cp=new change_pass();
        cp.setVisible(true);
    }//GEN-LAST:event_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(admin_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton categories;
    private javax.swing.JButton courses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton lectures;
    private javax.swing.JButton logout;
    private javax.swing.JButton password;
    // End of variables declaration//GEN-END:variables
}
