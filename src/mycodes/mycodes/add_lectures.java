package mycodes;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JComboBox;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.io.File;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import mycodes.DBLoader;
import mycodes.lectures;
import mycodes.myClient;

public class add_lectures extends javax.swing.JFrame {
        File ph;
        File vd;
        String trailer;
        JFileChooser jfc;
        String description;
        String category;
        String courses;
        mytablemodel tm;
        ArrayList<lectures> al;
        JLabel lb;

    public add_lectures() {
        jfc= new JFileChooser();
         initComponents();
        al=new ArrayList<>();
        tm=new mytablemodel();
       
       jTable1.setModel(tm);
          jTable1.setRowHeight(100);
       jTable1.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());

        setSize(1198,680);
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                
                 Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
       int h=(int)d.getHeight();
       int w=(int)d.getWidth();
       lb=new JLabel();
       lb.setBounds(0, 0, w, h);
       ImageIcon ic=new ImageIcon("src\\myuploads\\m2.jpg");
       Image img=ic.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
       ImageIcon im=new ImageIcon(img);
       lb.setIcon(im);
       add(lb);
       
        setSize(w, h);

        fetchCategories();
        //fetchCourses();
    }
    
     void fetchCategories() 
    {
    try 
    {
//        cb3.removeAllItems();
//        cb5.removeAllItems();
       ResultSet rs = DBLoader.executeSql("SELECT * FROM category");
        while (rs.next())
    {
            String name = rs.getString("Name");
            cb3.addItem(name);
            cb5.addItem(name);
        }
    }
    catch (Exception ex) 
    {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error fetching categories.");
    }
}

void fetchCourses(String name1) 
    {
     String ans=myClient.fetch_courses(name1);
     StringTokenizer st=new StringTokenizer(ans, ";;");
     while(st.hasMoreTokens())
     {
         StringTokenizer st2=new StringTokenizer(st.nextToken(), "$");
         String name=st2.nextToken();
         String ph=st2.nextToken();
         String desc=st2.nextToken();
         String cat=st2.nextToken();
         cb6.addItem(name);
     }
    
}
void fetchCourses1(String name1) 
    {
        cb4.removeAllItems();
     String ans=myClient.fetch_courses(name1);
     StringTokenizer st=new StringTokenizer(ans, ";;");
     while(st.hasMoreTokens())
     {
         StringTokenizer st2=new StringTokenizer(st.nextToken(), "$");
         String name=st2.nextToken();
         String ph=st2.nextToken();
         String desc=st2.nextToken();
         String cat=st2.nextToken();
         cb4.addItem(name);
     }
    
}


void fetch_lectures(String coursename)
    {
   
    String ans = myClient.fetch_lectures(coursename);
   
    StringTokenizer st = new StringTokenizer(ans, ";;");
    al.clear();
    while (st.hasMoreTokens()) 
    {
        StringTokenizer st3 = new StringTokenizer(st.nextToken(), "$");
        String name = st3.nextToken();
        String photo = st3.nextToken();
        String description = st3.nextToken();
        String trailer = st3.nextToken();
        String video = st3.nextToken();
        al.add(new lectures(name, photo, description, trailer, video));
      
    }
    tm.fireTableDataChanged();

}

    class ImageRenderer extends DefaultTableCellRenderer {
        JLabel lbl = new JLabel();
        ImageIcon icon = new ImageIcon();

        @Override
        public Component getTableCellRendererComponent(JTable jTable1, Object value,
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
            return 5;
        }

        @Override
        public Object getValueAt(int i, int j) {
            
            lectures c3=al.get(i);
            if(j==0)
            {
            return c3.name;
            }
            else if(j==1)
            {
            return c3.photo;
            }
            else if(j==2)
            {
            return c3.description;
            }
             else if(j==3)
            {
            return c3.trailer;
            }
             else if(j==4)
            {
            return c3.video;
            }
            
            else
            {
            return null;
            }
        }

        @Override
        public String getColumnName(int column) {
            String col[]={"Name","Photo","Description","Trailer","Video"};
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cb3 = new javax.swing.JComboBox<>();
        cb4 = new javax.swing.JComboBox<>();
        cb5 = new javax.swing.JComboBox<>();
        cb6 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        delete = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Category");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 120, 90, 25);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Courses");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 160, 110, 25);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 220, 80, 25);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Description");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 310, 110, 25);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Trailer");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 400, 60, 16);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Video");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 460, 60, 25);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Photo");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 540, 60, 16);

        cb3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Category" }));
        cb3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb3ItemStateChanged(evt);
            }
        });
        getContentPane().add(cb3);
        cb3.setBounds(170, 120, 230, 22);

        cb4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Courses" }));
        cb4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb4ItemStateChanged(evt);
            }
        });
        getContentPane().add(cb4);
        cb4.setBounds(170, 160, 230, 22);

        cb5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Category" }));
        cb5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb5ItemStateChanged(evt);
            }
        });
        getContentPane().add(cb5);
        cb5.setBounds(660, 130, 130, 22);

        cb6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Courses" }));
        cb6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb6ItemStateChanged(evt);
            }
        });
        getContentPane().add(cb6);
        cb6.setBounds(830, 130, 150, 22);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("ADD LECTURES");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(430, 600, 220, 30);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("ADD LECTURES!!!");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(440, 10, 430, 50);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(660, 190, 470, 380);

        delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(0, 153, 102));
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete);
        delete.setBounds(1010, 130, 120, 20);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(170, 220, 230, 30);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(170, 390, 230, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(170, 280, 234, 86);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 102));
        jButton2.setText("CHOOSE");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(220, 460, 80, 20);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 153, 102));
        jButton3.setText("BROWSE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(360, 530, 90, 20);

        jLabel9.setText(".");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(170, 490, 170, 140);

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 153, 102));
        jButton4.setText("ADMIN HOME");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(10, 20, 130, 27);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
         int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) 
    {
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected lecture?", "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (response == JOptionPane.YES_OPTION) 
        {
            al.remove(selectedRow);
            tm.fireTableRowsDeleted(selectedRow, selectedRow);
        }
    } 
    else 
    {
        JOptionPane.showMessageDialog(this, "Please select a lecture to delete.");
    }
    }//GEN-LAST:event_deleteActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
          JFileChooser jfc=new JFileChooser();
        int ans=jfc.showOpenDialog(this);
        if(ans==JFileChooser.APPROVE_OPTION)
        {
             ph = jfc.getSelectedFile();
            ImageIcon ic=new ImageIcon(ph.getPath());
             Image ic1=ic.getImage().getScaledInstance(jLabel9.getWidth(), jLabel9.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ic2=new ImageIcon(ic1);
            jLabel9.setIcon(ic2);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser();
         jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
         int ans = jfc.showOpenDialog(this);
         if (ans == JFileChooser.APPROVE_OPTION) 
        {
         vd = jfc.getSelectedFile();
        }
        
         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:                                       
    String name = jTextField1.getText();
    String description = jTextArea1.getText();
    String trailer = jTextField2.getText();
    String selectedCategory = (String) cb3.getSelectedItem();
    String selectedCourse = (String) cb4.getSelectedItem();
    
    if (name.isEmpty() || description.isEmpty() || trailer.isEmpty() || selectedCategory == null || selectedCourse == null) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields and select a category and course.");
        return;
    }

    if (ph == null) 
    {
        JOptionPane.showMessageDialog(this, "Please select a photo.");
        return;
    }
    
    if (vd == null) 
    {
        JOptionPane.showMessageDialog(this, "Please select a video.");
        return;
    }
    String ans = myClient.add_lectures(ph, name, description, trailer, vd, selectedCategory, selectedCourse);
    
    if (ans.equals("success")) 
    {
        JOptionPane.showMessageDialog(this, "Lecture Added Successfully");
    }
    else if (ans.equals("fail")) 
    {
        JOptionPane.showMessageDialog(this, "Lecture already exists.");
    }
    else 
    {
        JOptionPane.showMessageDialog(this, ans);
    }
   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb3ItemStateChanged
        // TODO add your handling code here:
        String name=cb3.getSelectedItem().toString();
      
        fetchCourses1(name);
    }//GEN-LAST:event_cb3ItemStateChanged

    private void cb5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb5ItemStateChanged
        // TODO add your handling code here:
         if (evt.getStateChange() == ItemEvent.SELECTED) 
        {

         String name=cb5.getSelectedItem().toString();
         //cb6.removeAllItems();
        
           fetchCourses(name);
        }
    }//GEN-LAST:event_cb5ItemStateChanged

    private void cb4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb4ItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cb4ItemStateChanged
       
    private void cb6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb6ItemStateChanged
         
        // TODO add your handling code here:
         if (evt.getStateChange() == ItemEvent.SELECTED) 
        {

            String name1=cb6.getSelectedItem().toString();
            //al.clear();
          
            fetch_lectures(name1);
           
            //tm.fireTableDataChanged();
        }
       
    }//GEN-LAST:event_cb6ItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        admin_home ah= new admin_home();
        ah.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed
     
   
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
            java.util.logging.Logger.getLogger(add_lectures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_lectures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_lectures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_lectures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_lectures().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb3;
    private javax.swing.JComboBox<String> cb4;
    private javax.swing.JComboBox<String> cb5;
    private javax.swing.JComboBox<String> cb6;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
