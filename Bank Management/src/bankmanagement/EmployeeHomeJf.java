
package bankmanagement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class EmployeeHomeJf extends javax.swing.JFrame {
    Connection conn;  
    ResultSet rs;
    PreparedStatement pst=null;


    public EmployeeHomeJf() {
        initComponents();
        conn =javaconnect.connect();
        
        this.setIconImage(new ImageIcon(getClass().getResource
        ("BankIcon3.png")).getImage());
         
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tSearch = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblAccountId = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        bCheckBalance = new javax.swing.JButton();
        bLogout = new javax.swing.JButton();
        bViewProfile = new javax.swing.JButton();
        bSearch = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tSearchFocusGained(evt);
            }
        });
        getContentPane().add(tSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 91, 239, 40));

        lblName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 270, 32));

        lblAccountId.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(lblAccountId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 150, 32));

        lblPhone.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 240, 32));

        bCheckBalance.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bCheckBalance.setText("Withdraw or Deposit Money");
        bCheckBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCheckBalanceActionPerformed(evt);
            }
        });
        getContentPane().add(bCheckBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 397, 303, 44));

        bLogout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bLogout.setText("Log out");
        bLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(bLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 25, 89, -1));

        bViewProfile.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bViewProfile.setText("View Full Profile");
        bViewProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bViewProfileActionPerformed(evt);
            }
        });
        getContentPane().add(bViewProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 233, 221, 40));

        bSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bSearch.setText("Search");
        bSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSearchActionPerformed(evt);
            }
        });
        getContentPane().add(bSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 91, 104, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("View Account History");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 317, 221, 42));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Name :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 140, 34));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Account ID :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 140, 34));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Phone :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 140, 34));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bankmanagement/backall.png"))); // NOI18N
        bg.setText("jLabel4");
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        jButton3.setText("jButton3");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCheckBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCheckBalanceActionPerformed
        
        
        String h=lblAccountId.getText();
        
        if( h != null && !h.isEmpty())
        
        {
            //dispose();
            new EmployeeCheckBalanceJf().setVisible(true);     
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Match not found");
        }
         
    }//GEN-LAST:event_bCheckBalanceActionPerformed

    private void bLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLogoutActionPerformed
        dispose();
        new HomeJf().setVisible(true);
    }//GEN-LAST:event_bLogoutActionPerformed

    private void bViewProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bViewProfileActionPerformed
       
       
       String h=lblAccountId.getText();
 
        if(h != null && !h.isEmpty())
        {
            new EmployeeViewFullProfileJf().setVisible(true);     
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Match not found");
        }
    }//GEN-LAST:event_bViewProfileActionPerformed

    private void bSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSearchActionPerformed
        
        
        
        try {    
            
            

            int acc= Integer.parseInt(tSearch.getText());
            
            /*
            String sql="select name,account_id,phone from ACCOUNTS  a " +
                        "join customer  c " +
                         "on (a.customer_id=c.customer_id) where account_id=?";
            pst=conn.prepareStatement(sql);
            
            
            
           //pst.setInt(1,acc_id);
           pst.setInt(1,acc);
        
           rs=pst.executeQuery();    
            */
            
            String functionsql="{? = call customer_info(?)}";
                        CallableStatement cstmt2 = conn.prepareCall(functionsql);

                        cstmt2.registerOutParameter(1,oracle.jdbc.OracleTypes.CURSOR);
                         cstmt2.setString(2,tSearch.getText());
                        
                        cstmt2.execute();  
                        
                        rs=(ResultSet)cstmt2.getObject(1);
            
            
            
           if(rs.next())
           {
              lblName.setText(rs.getString("name"));
              lblAccountId.setText(tSearch.getText());
              lblPhone.setText(rs.getString("PHONE"));
               
              
              cstmt2.close();  
               
              
           }
           else
           {
               JOptionPane.showMessageDialog(null,"Not found");
           }
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Not connected to database :"+ex);

        }
    }//GEN-LAST:event_bSearchActionPerformed

    private void tSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tSearchFocusGained
        
        lblName.setText("");
         lblAccountId.setText("");
         lblPhone.setText("");
    }//GEN-LAST:event_tSearchFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
       
       String h=lblAccountId.getText();
        
        if( h != null && !h.isEmpty())
        {
            new AccountHistoryJf().setVisible(true);     
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Match not found");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


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
            java.util.logging.Logger.getLogger(EmployeeHomeJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeHomeJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeHomeJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeHomeJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeHomeJf().setVisible(true);
                
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bCheckBalance;
    private javax.swing.JButton bLogout;
    private javax.swing.JButton bSearch;
    private javax.swing.JButton bViewProfile;
    private javax.swing.JLabel bg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel lblAccountId;
    public static javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JTextField tSearch;
    // End of variables declaration//GEN-END:variables

}

