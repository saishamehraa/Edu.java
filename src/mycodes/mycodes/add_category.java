package mycodes;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import mycodes.category;


public class add_category extends javax.swing.JFrame {
JFileChooser jfc;
     File ph;
mytablemodel tm;
ArrayList<category>al;
JLabel lb;
  
    public add_category() {
        jfc=new JFileChooser();
        al=new ArrayList();
        tm=new mytablemodel();
        initComponents();
       jTable2.setModel(tm);
          jTable2.setRowHeight(100);
       jTable2.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());
        setSize(800,600);
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
       int h=(int)d.getHeight();
       int w=(int)d.getWidth();
       lb=new JLabel();
       lb.setBounds(0, 0, w, h);
       ImageIcon ic=new ImageIcon("src\\myuploads\\v.jpg");
       Image img=ic.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
       ImageIcon im=new ImageIcon(img);
       lb.setIcon(im);
       add(lb);
       
        setSize(w, h);

        fetch_category();
     
    }
void fetch_category()
{
     al.clear(); 
     String ans=myClient.fetch_cat();
        System.out.println(ans);
        StringTokenizer st=new StringTokenizer(ans, ";;");
        int count=st.countTokens();
        for(int i=0;i<count;i++)
        {
        String row=st.nextToken();
        StringTokenizer st1=new StringTokenizer(row, "$");
        String name=st1.nextToken();
        String photo=st1.nextToken();
        al.add(new category(name, photo));
        }
        tm.fireTableDataChanged();
    }


class ImageRenderer extends DefaultTableCellRenderer {
        JLabel lbl = new JLabel();
        ImageIcon icon = new ImageIcon();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
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
            return 2;
        }

        @Override
        public Object getValueAt(int i, int j) {
            
            category c1=al.get(i);
            if(j==0)
            {
            return c1.name;
            }
            else if(j==1)
            {
            return c1.photo;
            }
            else
            {
            return null;
            }
        }

        @Override
        public String getColumnName(int column) {
            String col[]={"Name","Photo"};
            return col[column];
        }
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        photo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 153));
        jLabel1.setText("ADD CATEGORIES!!!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(420, 20, 520, 50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("NAME");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(270, 220, 90, 32);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 255));
        jLabel3.setText("PHOTO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(250, 390, 110, 30);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(440, 220, 260, 40);

        photo.setText(".");
        getContentPane().add(photo);
        photo.setBounds(440, 320, 240, 180);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 153));
        jButton1.setText("ADD CATEGORY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(520, 590, 260, 39);

        refresh.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        refresh.setForeground(new java.awt.Color(102, 0, 153));
        refresh.setText("REFRESH");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        getContentPane().add(refresh);
        refresh.setBounds(920, 120, 80, 20);

        jScrollPane2.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane2.setForeground(new java.awt.Color(102, 102, 255));

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
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(920, 140, 320, 420);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 0, 153));
        jButton3.setText("BROWSE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(730, 390, 90, 20);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 0, 153));
        jButton2.setText("ADMIN HOME");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(20, 30, 130, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         String name=jTextField1.getText();
        String ans=myClient.add_cat(ph, name);
        if(ans.equals("success"))
        {
            JOptionPane.showMessageDialog(this, "Category Added Successfully");
        }
        else if(ans.equals("fail"))
        {
        JOptionPane.showMessageDialog(this, "Category already Exist");
        }
        else
        {
        JOptionPane.showMessageDialog(this, ans);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
             fetch_category();
    }//GEN-LAST:event_refreshActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc=new JFileChooser();
        int ans=jfc.showOpenDialog(this);
        if(ans==JFileChooser.APPROVE_OPTION)
        {
           ph=jfc.getSelectedFile();
            ImageIcon ic=new ImageIcon(ph.getPath());
            Image ic1=ic.getImage().getScaledInstance(photo.getWidth(), photo.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ic2=new ImageIcon(ic1);
            photo.setIcon(ic2);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        admin_home ah=new admin_home();
        ah.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(add_category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_category().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel photo;
    private javax.swing.JButton refresh;
    // End of variables declaration//GEN-END:variables
}
