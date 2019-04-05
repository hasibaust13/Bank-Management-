
package bankmanagement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class EmployeeCheckBalanceJf extends javax.swing.JFrame {
    Connection conn;  
    ResultSet rs;
    PreparedStatement pst=null;
    


    public EmployeeCheckBalanceJf()  {
        initComponents();
        
        this.setIconImage(new ImageIcon(getClass().getResource
        ("BankIcon3.png")).getImage());
        
        conn =javaconnect.connect();
        
        setvalue();
        
        if(rbDeposite.isEnabled())
        {
            Operation ="Deposite";
        }
    }
    
    private void setvalue()
    {        
        String getid=EmployeeHomeJf.lblAccountId.getText();       
        lblId.setText(getid);
        
        String id=lblId.getText();      
        
        try
        {
            /*
            String sql="select name, current_balance from " +
                        "ACCOUNTS a join customer  c on (a.customer_id=c.customer_id)  " +
                        " where account_id=? ";
            pst=conn.prepareStatement(sql);
            pst.setString(1, id);
            rs=pst.executeQuery();
           
            if(rs.next())
           {
               lblName.setText(rs.getString("name"));
               getBalance=rs.getDouble("current_balance");
               String s=java.text.NumberFormat.getCurrencyInstance().format(getBalance);
               lblTotal.setText(s);
               String time = new SimpleDateFormat("dd-MMM-yyyy  HH:mm:ss").format(Calendar.getInstance().getTime());
               lblTime.setText(time);                           
           }           
            pst.close();
            
            */
            
            String time = new SimpleDateFormat("dd-MMM-yyyy  HH:mm:ss").format(Calendar.getInstance().getTime());
            lblTime.setText(time);   
            
           

            String procedurensql="{call get_name_and_current_amount(?,?,?)}";
            CallableStatement cstmt2 = conn.prepareCall(procedurensql);
            
            cstmt2.setString(1,id);
            cstmt2.registerOutParameter(2,oracle.jdbc.OracleTypes.VARCHAR);
            cstmt2.registerOutParameter(3,oracle.jdbc.OracleTypes.NUMBER);
            cstmt2.execute();  
            
            String name=cstmt2.getString(2);
            Double c_amount=cstmt2.getDouble(3);          
            
            cstmt2.close();    
            
            
            lblName.setText(name);
            
            String s=java.text.NumberFormat.getCurrencyInstance().format(c_amount);
            lblTotal.setText(s);

            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Not connected to database :"+ex);
        }
                
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblName = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        rbWithdraw = new javax.swing.JRadioButton();
        rbDeposite = new javax.swing.JRadioButton();
        bEnter = new javax.swing.JButton();
        tfBranchId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfAmount1 = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 149, 186, 34));

        lblId.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 67, 137, 34));

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        getContentPane().add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 250, 33));

        lblTime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTime.setText("Time");
        getContentPane().add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 51, 206, 31));

        buttonGroup1.add(rbWithdraw);
        rbWithdraw.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbWithdraw.setText("Withdraw");
        rbWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbWithdrawActionPerformed(evt);
            }
        });
        getContentPane().add(rbWithdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 296, 107, -1));

        buttonGroup1.add(rbDeposite);
        rbDeposite.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbDeposite.setSelected(true);
        rbDeposite.setText("Deposit");
        rbDeposite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDepositeActionPerformed(evt);
            }
        });
        getContentPane().add(rbDeposite, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 296, 95, -1));

        bEnter.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bEnter.setText("Deposit Money");
        bEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEnterActionPerformed(evt);
            }
        });
        getContentPane().add(bEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, 263, 42));

        tfBranchId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(tfBranchId, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 130, 41));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Account ID :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 67, 140, 34));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Name :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 149, 140, 34));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Enter Amount");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 150, 41));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Branch ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 150, 41));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Balance :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 120, 34));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Time :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 11, 67, -1));

        tfAmount1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(tfAmount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 263, 41));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bankmanagement/backall.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbDepositeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDepositeActionPerformed
        Operation ="Deposite"; 
        bEnter.setText("Deposite Money");
        
    }//GEN-LAST:event_rbDepositeActionPerformed

    private void rbWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbWithdrawActionPerformed
        Operation ="Withdraw";
        bEnter.setText("Withdraw Money");
    }//GEN-LAST:event_rbWithdrawActionPerformed

    private void bEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEnterActionPerformed
        
        String s=tfAmount1.getText();
         
          String time = new SimpleDateFormat
           ("dd-MMM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        
        int a=0;
                      
            try
            {
                double x=Double.parseDouble(tfBranchId.getText()); 
                
            }
            catch(Exception ex)
            {
                //JOptionPane.showMessageDialog(null,"Enter Numbers");
                a=1;
            }
    
        if(s != null && !s.isEmpty())
        {
            if(a==0)
            {
          
            
        if( Operation.equals("Deposite") )
       {
          int p=JOptionPane.showConfirmDialog(null,"Do you want to Dposite "
                   + "money in this account","Deposite Money",JOptionPane.YES_NO_OPTION);
           if(p==0)
           {
           
           try
        {
               
            String proceduresql="{call insert_into_transaction(?,?,?,?,?)}";
            CallableStatement cstmt = conn.prepareCall(proceduresql);
            
            cstmt.setInt(1, Integer.parseInt(lblId.getText()));
            cstmt.setString(2, tfBranchId.getText());
            cstmt.setString(3, time);
            cstmt.setDouble(4, Double.parseDouble(tfAmount1.getText()));
            cstmt.setString(5, Operation);
     
            cstmt.execute();          
            cstmt.close();
            

            JOptionPane.showMessageDialog(null,"Account updated"); 
            tfAmount1.setText("");
            
            this.setVisible(false); //this will close frame i.e. NewJFrame

            new EmployeeCheckBalanceJf().setVisible(true);
            
        }
           
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Not connected to database :"+ex);
        }
           }
           
       }
     

        if(Operation.equals("Withdraw") )
       {
           int j=JOptionPane.showConfirmDialog(null,"Do you want to Withdraw "
                   + "money from this account","Withdraw Money",JOptionPane.YES_NO_OPTION);

           if(j==0)
           {    
               double current_amount=0;
               double amount=Double.parseDouble(tfAmount1.getText());
               int id=Integer.parseInt(lblId.getText());

                try
                  {

                        String functionsql="{? = call get_current_amount(?)}";
                        CallableStatement cstmt2 = conn.prepareCall(functionsql);

                        cstmt2.registerOutParameter(1,oracle.jdbc.OracleTypes.NUMBER);
                        cstmt2.setInt(2, id);

                        cstmt2.execute();  

                        current_amount=cstmt2.getDouble(1);

                        cstmt2.close();     

                  }

                  catch(Exception ex)
                  {
                      JOptionPane.showMessageDialog(null,"Not connected to database :"+ex);
                  }
                
                
                if(current_amount>=amount)
                {
                    try
                    {
                        double totalam;
                        
                        
                        String proceduresql="{call insert_into_transaction(?,?,?,?,?)}";
                        CallableStatement cstmtp = conn.prepareCall(proceduresql);

                        cstmtp.setInt(1, Integer.parseInt(lblId.getText()));
                        cstmtp.setString(2, tfBranchId.getText());
                        cstmtp.setString(3, time);
                        cstmtp.setDouble(4, Double.parseDouble(tfAmount1.getText()));
                        cstmtp.setString(5, Operation);

                        cstmtp.execute();          
                        cstmtp.close();
                        
                
                    }
                    
                    catch(Exception ex)
                  {
                      JOptionPane.showMessageDialog(null,"Not connected to database :"+ex);
                  }
                    
                    JOptionPane.showMessageDialog(null,"Account updated"); 
                     tfAmount1.setText("");

            
                    this.setVisible(false); //this will close frame i.e. NewJFrame

                    new EmployeeCheckBalanceJf().setVisible(true);
                    
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null,"SORRY, You Don't have enough Money");
                }
                    
                
                
           
         }
   }
        
 }
   else
     {
       JOptionPane.showMessageDialog(null,"Must enter Numbers");
     }
        
   }
 else
   {
      JOptionPane.showMessageDialog(null,"Must enter the amount");
   }
             
    }//GEN-LAST:event_bEnterActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeCheckBalanceJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeCheckBalanceJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeCheckBalanceJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeCheckBalanceJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */   
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeCheckBalanceJf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEnter;
    private javax.swing.JLabel bg;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JRadioButton rbDeposite;
    private javax.swing.JRadioButton rbWithdraw;
    private javax.swing.JTextField tfAmount1;
    private javax.swing.JTextField tfBranchId;
    // End of variables declaration//GEN-END:variables
    
    String Operation;
    double getBalance;
}
