
package mycodes;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import mycodes.myClient;

public class lec_details extends javax.swing.JFrame {
   
   // ArrayList<lectures> al;
    private String name;
    private String photo;
    private String description;
    private String trailer;
    private String video;
    JLabel lb;
    
    public lec_details() {
        initComponents();
        //al=new ArrayList<>();
       
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        
          Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
       int h=(int)d.getHeight();
       int w=(int)d.getWidth();
       lb=new JLabel();
       lb.setBounds(0, 0, w, h);
       ImageIcon ic=new ImageIcon("src\\myuploads\\t.jpg");
       Image img=ic.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
       ImageIcon im=new ImageIcon(img);
       lb.setIcon(im);
       add(lb);
       
        setSize(w, h);
        //fetchLectures();
    }


    void fetchLectures(String coursename)
    {
    
         
         System.out.println("Fetching lectures... ");
       
     
         String ans =myClient.fetch_lectures(coursename);
         StringTokenizer st = new StringTokenizer(ans, ";;");
         //al.clear();
        
         while (st.hasMoreTokens()) 
    {
        StringTokenizer st3 = new StringTokenizer(st.nextToken(), "$");
        String name = st3.nextToken();
        String photo = st3.nextToken();
        String description = st3.nextToken();
        String trailer = st3.nextToken();
        String video = st3.nextToken();
        String category = st3.nextToken();
        String courses = st3.nextToken();
       
        System.out.println("Name: " + name + ", Photo Path: " + photo + ", Description:" + description + ", Trailer:" + trailer + ", Video Path:" + video + ", Category:" + category + "Courses:" + courses);
        
        
    }
         
}
    
    public void lectureDetails(String name, String photo, String description, String trailer, String video) {

        //lectures lec=new lectures(name,photo,description,trailer,video);

        this.name = name;
        this.photo = photo;
        this.description = description;
        this.trailer = trailer;
        this.video = video;
        tf.setText(name);
        desc.setText(description);
        ImageIcon icon = new ImageIcon(photo);
        Image ic = icon.getImage().getScaledInstance(photo1.getWidth(), photo1.getHeight(), Image.SCALE_SMOOTH);
        photo1.setIcon(new ImageIcon(ic));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        photo1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        trailer1 = new javax.swing.JButton();
        lecture = new javax.swing.JButton();
        tf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        home = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 102));
        jLabel1.setText("LECTURE DETAILS.....");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(370, 20, 500, 50);

        photo1.setText(".");
        getContentPane().add(photo1);
        photo1.setBounds(40, 170, 300, 300);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 102));
        jLabel3.setText("NAME");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(470, 160, 80, 32);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 102));
        jLabel4.setText("DESCRIPTION");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(400, 280, 170, 32);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 102));
        jLabel5.setText("TRAILER");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(460, 420, 100, 20);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 102));
        jLabel6.setText("VIDEO");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(470, 520, 90, 20);

        trailer1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        trailer1.setForeground(new java.awt.Color(0, 204, 153));
        trailer1.setText("REDIRECT");
        trailer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trailer1ActionPerformed(evt);
            }
        });
        getContentPane().add(trailer1);
        trailer1.setBounds(670, 420, 100, 23);

        lecture.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lecture.setForeground(new java.awt.Color(0, 204, 153));
        lecture.setText("START LECTURE");
        lecture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lectureActionPerformed(evt);
            }
        });
        getContentPane().add(lecture);
        lecture.setBounds(650, 520, 150, 20);

        tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfActionPerformed(evt);
            }
        });
        getContentPane().add(tf);
        tf.setBounds(610, 160, 230, 30);

        desc.setColumns(20);
        desc.setRows(5);
        jScrollPane1.setViewportView(desc);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(610, 250, 234, 86);

        home.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        home.setForeground(new java.awt.Color(0, 204, 153));
        home.setText("HOME");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        getContentPane().add(home);
        home.setBounds(30, 30, 80, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void trailer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trailer1ActionPerformed
        // TODO add your handling code here:
//        System.out.println("Name: " + name);
//        System.out.println("Photo Path: " + photo);
//        System.out.println("Description: " + description);
//        System.out.println("Trailer URL: " + trailer);
//        System.out.println("Video Path: " + video);

try{
    URI uri=new URI(trailer);
    Desktop d=Desktop.getDesktop();
    d.browse(uri);
}
catch(Exception e)
{
    e.printStackTrace();
}


    }//GEN-LAST:event_trailer1ActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        // TODO add your handling code here:
        user_home home = new user_home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeActionPerformed

    private void tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfActionPerformed
        // TODO add your handling code here:
   
    }//GEN-LAST:event_tfActionPerformed

    private void lectureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lectureActionPerformed
        // TODO add your handling code here:
        File f=new File(video);
        Desktop d=Desktop.getDesktop();
        try {
            d.open(f);
        } catch (IOException ex) {
            Logger.getLogger(lec_details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lectureActionPerformed

   
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
            java.util.logging.Logger.getLogger(lec_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lec_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lec_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lec_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lec_details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea desc;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lecture;
    private javax.swing.JLabel photo1;
    private javax.swing.JTextField tf;
    private javax.swing.JButton trailer1;
    // End of variables declaration//GEN-END:variables
}
