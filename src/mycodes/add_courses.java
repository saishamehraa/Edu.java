package mycodes;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JComboBox;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.sql.*;
import javax.swing.JFrame;
import mycodes.courses;
import mycodes.DBLoader;
import mycodes.myClient;

public class add_courses extends javax.swing.JFrame {
        
         File ph;
         JFileChooser jfc;
        String description;
        String category;
        mytablemodel tm;
        ArrayList<courses> al;
        JLabel lb;
    
    public add_courses() {
       
         initComponents();
        al=new ArrayList<>();
        tm=new mytablemodel();
        jfc= new JFileChooser();
       jTable2.setModel(tm);
          jTable2.setRowHeight(100);
       jTable2.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());

        setSize(1198,610);
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                     Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
       int h=(int)d.getHeight();
       int w=(int)d.getWidth();
       lb=new JLabel();
       lb.setBounds(0, 0, w, h);
       ImageIcon ic=new ImageIcon("src\\myuploads\\l.jpg");
       Image img=ic.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
       ImageIcon im=new ImageIcon(img);
       lb.setIcon(im);
       add(lb);
       
        setSize(w, h);

        fetchCategories();
    }
    
    void fetchCategories() {
    try {
      
        ResultSet rs = DBLoader.executeSql("SELECT name FROM category");
        
   
        cb.removeAllItems();
        
    
        while (rs.next()) {
            String name = rs.getString("name");
            cb.addItem(name);
            cb2.addItem(name);
}
        rs.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error fetching categories.");
    }
}

    
    void fetch_courses(String name1) {
    
//    try {
//        String sql = "SELECT name, photo, description, category FROM courses";
//        ResultSet rs = DBLoader.executeSql(sql);
//
//        while (rs.next()) {
//            String name = rs.getString("name");
//            String photo = rs.getString("photo");
//            String description = rs.getString("description");
//            String category = rs.getString("category");
//            al.add(new courses(name, photo, description));
//        }
//        tm.fireTableDataChanged();
//
//        rs.close();
//    } catch (Exception ex) {
//        ex.printStackTrace();
//        JOptionPane.showMessageDialog(this, "Error fetching courses.");
//    }
String ans=myClient.fetch_courses(name1);
StringTokenizer st=new StringTokenizer(ans, ";;");
while(st.hasMoreTokens())
{
    StringTokenizer st2=new StringTokenizer(st.nextToken(), "$");
                String name = st2.nextToken();
            String photo = st2.nextToken();
            String description = st2.nextToken();
            String category = st2.nextToken();
            al.add(new courses(name, photo, description));
    
}

tm.fireTableDataChanged();


}


    


class ImageRenderer extends DefaultTableCellRenderer {
        JLabel lbl = new JLabel();
        ImageIcon icon = new ImageIcon();

        @Override
        public Component getTableCellRendererComponent(JTable jTable2, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof String) {
                String photoPath = (String) value;
                System.out.println("Photo Path "+photoPath);
                icon = new ImageIcon(photoPath);
                Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                lbl.setIcon(new ImageIcon(img));
            } else {
                lbl.setIcon(null);
            }
            return lbl;
        }
    }

    class mytablemodel extends AbstractTableModel
    {
        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int i, int j) {
            
            courses c2=al.get(i);
            if(j==0)
            {
            return c2.name;
            }
            else if(j==1)
            {
            return c2.photo;
            }
            else if(j==2)
            {
            return c2.description;
            }
            else
            {
            return null;
            }
        }

        @Override
        public String getColumnName(int column) {
            String col[]={"Name","Photo","Description"};
            return col[column];
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        cb = new javax.swing.JComboBox<>();
        cb2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        photo1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("ADD COURSES!!!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(440, 20, 390, 50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 153));
        jLabel2.setText("Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 190, 70, 25);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 153));
        jLabel3.setText("Description");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 280, 110, 25);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 153));
        jLabel4.setText("Category");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 380, 100, 25);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 153));
        jLabel5.setText("Photo");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 520, 70, 20);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 153));
        jButton1.setText("ADD COURSES");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(500, 590, 220, 39);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(670, 210, 540, 320);

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category" }));
        cb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbItemStateChanged(evt);
            }
        });
        cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActionPerformed(evt);
            }
        });
        getContentPane().add(cb);
        cb.setBounds(120, 380, 230, 30);

        cb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categories" }));
        cb2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb2ItemStateChanged(evt);
            }
        });
        cb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb2ActionPerformed(evt);
            }
        });
        getContentPane().add(cb2);
        cb2.setBounds(670, 160, 540, 30);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(120, 190, 230, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(120, 260, 234, 86);

        photo1.setText(".");
        getContentPane().add(photo1);
        photo1.setBounds(120, 460, 160, 140);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 51, 153));
        jButton2.setText("BROWSE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(310, 520, 90, 20);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 51, 153));
        jButton3.setText("ADMIN HOME");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(20, 30, 140, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActionPerformed
        // TODO add your handling code here:  

        
    }//GEN-LAST:event_cbActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc=new JFileChooser();
        int ans=jfc.showOpenDialog(this);
        if(ans==JFileChooser.APPROVE_OPTION)
        {
             ph = jfc.getSelectedFile();
            ImageIcon ic=new ImageIcon(ph.getPath());
             Image ic1=ic.getImage().getScaledInstance(photo1.getWidth(), photo1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ic2=new ImageIcon(ic1);
            photo1.setIcon(ic2);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String name=jTextField1.getText();
         String description =jTextArea1.getText();
         String category = (String) cb.getSelectedItem();
        String ans=myClient.add_courses(ph, name,description,category);
        if(ans.equals("success"))
        {
            JOptionPane.showMessageDialog(this, "Course Added Successfully");
        }
        else if(ans.equals("fail"))
        {
        JOptionPane.showMessageDialog(this, "Course already Exist");
        }
        else
        {
        JOptionPane.showMessageDialog(this, ans);
        }
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbItemStateChanged
        // TODO add your handling code here:
 


    }//GEN-LAST:event_cbItemStateChanged

    private void cb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb2ActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_cb2ActionPerformed

    private void cb2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb2ItemStateChanged
        // TODO add your handling code here:
          al.clear();
       String name=cb2.getSelectedItem().toString();
        fetch_courses(name);
        System.out.println(name);
        tm.fireTableDataChanged();
    }//GEN-LAST:event_cb2ItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        admin_home ah= new admin_home();
        ah.setVisible(true);
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
            java.util.logging.Logger.getLogger(add_courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_courses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel photo1;
    // End of variables declaration//GEN-END:variables
}
