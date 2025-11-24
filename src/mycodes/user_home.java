
package mycodes;


import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import mycodes.DBLoader;
import mycodes.myClient;


public class user_home extends javax.swing.JFrame {
    JLabel lb;
    ArrayList<category> al;
    public user_home() {
        initComponents();
        al=new ArrayList<>();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
       
        
        //fetchCourses();
       // fetchLectures();
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
       int h=(int)d.getHeight();
       int w=(int)d.getWidth();
       lb=new JLabel();
       lb.setBounds(0, 0, w, h);
       ImageIcon ic=new ImageIcon("src\\myuploads\\uh.jpg");
       Image img=ic.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
       ImageIcon im=new ImageIcon(img);
       lb.setIcon(im);
       add(lb);
       
        setSize(w, h);
        
        
        fetchCategories();
           
    }
    
    
    void fetchCategories() // String name, String photo
    {
        int x=0;
        int y=5;
        int n=0;
     //try{
        System.out.println("Fetching categories...");
        //ResultSet rs = DBLoader.executeSql("SELECT name, photo FROM category"); 
        String ans =myClient.fetch_cat();
       StringTokenizer st = new StringTokenizer(ans, ";;");
        al.clear();
     while (st.hasMoreTokens()) 
    {
        StringTokenizer st3 = new StringTokenizer(st.nextToken(), "$");
        String name = st3.nextToken();
        String photoPath = st3.nextToken();
//            while (rs.next())
//        {
//            String name = rs.getString("name");
//            String photoPath = rs.getString("photo");
            System.out.println("Name: " + name + ", Photo Path: " + photoPath);
            JButton bt=new JButton();
             bt.setBounds(x, y, 380, 250);
            ImageIcon ic=new ImageIcon(photoPath);
            Image ic1=ic.getImage().getScaledInstance(bt.getWidth(), bt.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ic2=new ImageIcon(ic1);
            bt.setIcon(ic2);
            bt.setText(name);
            
             bt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fetchCourses(name);
                }
            });
           
            y+=250;
            jp.add(bt);
            jp.repaint();
            n++;
        }
//         } catch (Exception ex) {
//        Logger.getLogger(user_home.class.getName()).log(Level.SEVERE, null, ex);
//        }
      jp.setPreferredSize(new Dimension(300,300*n));
    }
    void fetchCourses(String name1)
    {
         int x=0;
        int y=5;
        int n=0;
        jp1.removeAll();
        jp1.revalidate();
        jp1.repaint();
      //try {
        System.out.println("Fetching courses...");
        //ResultSet rs = DBLoader.executeSql("SELECT name, photo FROM courses"); 

//        while (rs.next())
//        {
//            String name = rs.getString("name");
//            String photoPath = rs.getString("photo");
         String ans =myClient.fetch_courses(name1);
         StringTokenizer st = new StringTokenizer(ans, ";;");
        al.clear();
     while (st.hasMoreTokens()) 
    {
        StringTokenizer st3 = new StringTokenizer(st.nextToken(), "$");
        String name = st3.nextToken();
        String photoPath = st3.nextToken();
            System.out.println("Name: " + name + ", Photo Path: " + photoPath);
            JButton bt1=new JButton();
             bt1.setBounds(x, y, 280, 200);
            ImageIcon ic=new ImageIcon(photoPath);
            Image ic1=ic.getImage().getScaledInstance(bt1.getWidth(), bt1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ic2=new ImageIcon(ic1);
            bt1.setIcon(ic2);
            bt1.setText(name);
            
            bt1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fetchLectures(name);
                }
            });
           
            y+=250;
            jp1.add(bt1);
       
            jp1.revalidate();
  
            jp1.repaint();
            n++;
        }
//    } catch (Exception ex) {
//        Logger.getLogger(user_home.class.getName()).log(Level.SEVERE, null, ex);
//    }  
        jp1.setPreferredSize(new Dimension(300,300*n));
    }
    void fetchLectures(String coursename)
    {
        int x=0;
        int y=5;
        int n=0;
        jp2.removeAll(); 
        jp2.revalidate();
        jp2.repaint();
      //try {
        System.out.println("Fetching lectures...");
        //ResultSet rs = DBLoader.executeSql("SELECT name, photo FROM lectures"); 
         String ans =myClient.fetch_lectures(coursename);
         StringTokenizer st = new StringTokenizer(ans, ";;");
        al.clear();
     while (st.hasMoreTokens()) 
    {
        StringTokenizer st3 = new StringTokenizer(st.nextToken(), "$");
        String name = st3.nextToken();
        String photoPath = st3.nextToken();
        String description=st3.nextToken();
         String trailer = st3.nextToken(); 
        String video = st3.nextToken();
//        while (rs.next())
//        {
//            String name = rs.getString("name");
//            String photoPath = rs.getString("photo");
            System.out.println("Name: " + name + ", Photo Path: " + photoPath);
            JButton bt2=new JButton();
             bt2.setBounds(x, y, 280, 200);
            ImageIcon ic=new ImageIcon(photoPath);
            Image ic1=ic.getImage().getScaledInstance(bt2.getWidth(), bt2.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ic2=new ImageIcon(ic1);
            bt2.setIcon(ic2);
            bt2.setText(name);
             bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
              lec_details ld = new lec_details();
              ld.lectureDetails(name, photoPath, description, trailer, video);
              ld.setVisible(true);
              dispose();
               
            }
        });
            y+=250;
            jp2.add(bt2);
            jp2.revalidate();
            jp2.repaint();
            n++;
        }
//    } catch (Exception ex) {
//        Logger.getLogger(user_home.class.getName()).log(Level.SEVERE, null, ex);
//    } 
        jp2.setPreferredSize(new Dimension(300,300*n));

    }


     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jp = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jp1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jp2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USER HOME!!!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(430, 0, 370, 60);

        jp.setBackground(new java.awt.Color(255, 255, 255));
        jp.setLayout(null);
        jScrollPane1.setViewportView(jp);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 170, 400, 440);

        jp1.setBackground(new java.awt.Color(255, 255, 255));
        jp1.setMinimumSize(new java.awt.Dimension(0, 0));
        jp1.setPreferredSize(new java.awt.Dimension(0, 0));
        jScrollPane2.setViewportView(jp1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(410, 170, 410, 440);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("SELECT A LECTURE:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(840, 130, 390, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("SELECT A CATEGORY:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 130, 260, 25);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("SELECT A COURSE:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(410, 130, 390, 20);

        jScrollPane3.setMinimumSize(new java.awt.Dimension(0, 0));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(0, 0));

        jp2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(jp2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(830, 170, 450, 440);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 255));
        jButton1.setText("EDIT PROFILE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 10, 130, 27);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        edit_profile ep= new edit_profile();
        ep.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

   
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
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user_home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jp;
    private javax.swing.JPanel jp1;
    private javax.swing.JPanel jp2;
    // End of variables declaration//GEN-END:variables
}
