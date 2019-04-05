
package bankmanagement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class EmployeeLoginJf extends javax.swing.JFrame {
       Connection conn;  
       ResultSet rs;
       PreparedStatement pst=null;

    public EmployeeLoginJf() {
        initComponents();
        conn =javaconnect.connect();
        
        this.setIconImage(new ImageIcon(getClass().getResource
        ("BankIcon3.png")).getImage());
        
  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        TfUsername = new javax.swing.JTextField();
        TfPassword = new javax.swing.JPasswordField();
        lblLogin = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        Bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TfUsername.setBackground(new java.awt.Color(51, 51, 51));
        TfUsername.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TfUsername.setForeground(new java.awt.Color(204, 204, 204));
        TfUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TfUsername.setBorder(null);
        TfUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(TfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 310, 40));

        TfPassword.setBackground(new java.awt.Color(51, 51, 51));
        TfPassword.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TfPassword.setForeground(new java.awt.Color(204, 204, 204));
        TfPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TfPassword.setBorder(null);
        getContentPane().add(TfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 310, 40));

        lblLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
        });
        getContentPane().add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 80, 70));

        lblBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });
        getContentPane().add(lblBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 170, 70));

        Bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bankmanagement/Login.png"))); // NOI18N
        Bg.setAlignmentY(0.0F);
        getContentPane().add(Bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
        
        //String sql="select * from EMP_LOGIN where username=? and u_password=? ";
        try
        {
            /*pst=conn.prepareStatement(sql);
            pst.setString(1,TfUsername.getText());
            pst.setString(2,TfPassword.getText());

            rs=pst.executeQuery();*/
            
            String functionsql="{? = call e_login(?,?)}";
                        CallableStatement cstmt2 = conn.prepareCall(functionsql);

                        cstmt2.registerOutParameter(1,oracle.jdbc.OracleTypes.CURSOR);
                        cstmt2.setString(2,TfUsername.getText() );
                        cstmt2.setString(3,TfPassword.getText() );
                        cstmt2.execute();  
                        
                        rs=(ResultSet)cstmt2.getObject(1);
                        
            
            
            if(rs.next())
            {
                //JOptionPane.showMessageDialog(null,"Acces granted");
                dispose();
                new EmployeeHomeJf().setVisible(true);
                
                cstmt2.close();  

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid User name and Password");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Not connected to database :"+ex);

        }      
        
    }//GEN-LAST:event_lblLoginMouseClicked

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        
        dispose();
        new HomeJf().setVisible(true);
        
    }//GEN-LAST:event_lblBackMouseClicked

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
            java.util.logging.Logger.getLogger(EmployeeLoginJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeLoginJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeLoginJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeLoginJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeLoginJf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bg;
    public static javax.swing.JPasswordField TfPassword;
    public static javax.swing.JTextField TfUsername;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblLogin;
    // End of variables declaration//GEN-END:variables
    int emp;
    
}
