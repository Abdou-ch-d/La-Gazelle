package la.gazelle;

import Bd.ChambresBD;
import Bd.ClientBd;
import Classes.Chambre;
import Classes.Client;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class ClientPanel extends javax.swing.JFrame {

    /**
     * Creates new form ClientPanel
     */
    
    
    Classes.Client client = new Client();
    
    ResultSet result;
    Bd.ClientBd Clientdb = new ClientBd();
    
    public ClientPanel() {
        this.setLocation(250,150);
        
        initComponents();
        listed();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void listed(){
            DefaultTableModel table=new DefaultTableModel();
            
            table.addColumn("num_cl");
            table.addColumn("nom_cl");
            table.addColumn("prenom_cl");
            table.addColumn("tel");
            table.addColumn("adr");
            
            
            try{
             Connection konn=LaGazelle.connectTODB();
             String sql="SELECT * FROM `client`";
             Statement S=konn.createStatement();
             ResultSet R=S.executeQuery(sql);
             
             while(R.next()){
                 table.addRow(new Object[]{
                     R.getString(1),
                     R.getString(2),
                     R.getString(3),
                     R.getString(4),
                     R.getString(5),
                    
                   
                 });
             }ClientsTab.setModel(table);
            }catch(Exception e){
                System.out.println("hnaa");
            }
            
        }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ClientsTab = new javax.swing.JTable();
        Edit_reservation = new javax.swing.JLabel();
        Edit_reservation1 = new javax.swing.JLabel();
        Edit_reservation2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Edit_reservation3 = new javax.swing.JLabel();
        Edite = new javax.swing.JLabel();
        Delete = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        Update = new javax.swing.JLabel();
        addtxt = new javax.swing.JLabel();
        serch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel1.setText("Informations des Clients");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/kyc.png"))); // NOI18N

        ClientsTab.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        ClientsTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Client", "Nom/prenom", "N°Tel"
            }
        ));
        ClientsTab.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(ClientsTab);

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setText("Modifier");

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Supprimer");

        Edite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit.png"))); // NOI18N
        Edite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditeMouseClicked(evt);
            }
        });

        Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/delete.png"))); // NOI18N
        Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteMouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/facturation.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        jLabel6.setText("facturation");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sginout.png"))); // NOI18N
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/updated.png"))); // NOI18N
        Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateMouseClicked(evt);
            }
        });

        addtxt.setForeground(new java.awt.Color(0, 153, 51));
        addtxt.setText("Refrichire");

        serch.setFont(new java.awt.Font("Tekton Pro Ext", 0, 12)); // NOI18N
        serch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        serch.setText("Entrer le Nom de Client");
        serch.setBorder(null);
        serch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serchActionPerformed(evt);
            }
        });
        serch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                serchKeyPressed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/blackSerch.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 494, Short.MAX_VALUE)
                        .addComponent(Edit_reservation1)
                        .addGap(0, 0, 0)
                        .addComponent(Edit_reservation)
                        .addGap(52, 52, 52)
                        .addComponent(Edit_reservation2)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator3)
                                    .addComponent(serch, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(353, 353, 353))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(14, 14, 14)))
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Edite, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(8, 8, 8))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel4)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Update)
                                            .addComponent(addtxt)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49))))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(455, 455, 455)
                    .addComponent(Edit_reservation3)
                    .addContainerGap(529, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(82, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(serch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Edit_reservation, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Edit_reservation1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Edit_reservation2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Edite, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Update))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(addtxt)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(227, 227, 227)
                    .addComponent(Edit_reservation3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(302, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        
        setVisible(false); 
        dispose(); 
        
    }//GEN-LAST:event_jLabel22MouseClicked

    private void DeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseClicked
        DefaultTableModel model=(DefaultTableModel)ClientsTab.getModel();
        try{
            //deleting row from table "View" 
            int index=ClientsTab.getSelectedRow();
            model.removeRow(index);
            //delet the row from DB
            int id_cl=Integer.parseInt(model.getValueAt(index,0).toString());
            String type_loc=model.getValueAt(index,4).toString();
            Clientdb.deleteclient(id_cl,type_loc);
           
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex+ "\n" + "sélectionner une ligne s'il vous plait");
        }
       
    }//GEN-LAST:event_DeleteMouseClicked
     
    
    private void EditeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditeMouseClicked
       /* DefaultTableModel model=(DefaultTableModel)ClientsTab.getModel();
        int index=ClientsTab.getSelectedRow();
        ClientObjectCreation();
        Clientdb.updateClient(client);
        populateClientTable();*/
        
    }//GEN-LAST:event_EditeMouseClicked

    private void UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseClicked
        listed();
    }//GEN-LAST:event_UpdateMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
       
        DefaultTableModel model=(DefaultTableModel)ClientsTab.getModel();
        try{
            int index=ClientsTab.getSelectedRow();
            int id_cl=Integer.parseInt(model.getValueAt(index,0).toString());
            Facturation facturation=new Facturation(id_cl);
            facturation.setVisible(true);
            setVisible(false); 
            dispose(); 
           
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex+ "\n" + "sélectionner une ligne s'il vous plait");
        }
       
    }//GEN-LAST:event_jLabel5MouseClicked

    private void serchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serchActionPerformed

    }//GEN-LAST:event_serchActionPerformed

    private void serchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serchKeyPressed

        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
           String Nom_prenoCl =serch.getText();
           
          if(Nom_prenoCl!=null){
           if(!Nom_prenoCl.contains(" ")){
              JOptionPane.showMessageDialog(null, "no users found, try adding a new user");
            }else{
             
              String [] Nom_prenom=Nom_prenoCl.split(" ");
              String Nom=Nom_prenom[0];
              String Prenom=Nom_prenom[1];
              System.out.println("Nom.>> " + Nom+"  Prenom.>>"+Prenom);
              
              ResultSet client = Clientdb.serchClient(Nom,Prenom);
           try{
            DefaultTableModel table=new DefaultTableModel();
             table.addColumn("num_cl");
            table.addColumn("nom_cl");
            table.addColumn("prenom_cl");
            table.addColumn("tel");
            table.addColumn("adr");
            
            while(client.next()){
            table.addRow(new Object[]{
                     client.getString(1),
                     client.getString(2),
                     client.getString(3),
                     client.getString(4),
                     client.getString(5),
                 });
                }
               ClientsTab.setModel(table);
           } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "err from displaying to board");
        }
          
            } 
         
         }
     } else listed();
    }//GEN-LAST:event_serchKeyPressed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked

    }//GEN-LAST:event_jLabel9MouseClicked

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
            java.util.logging.Logger.getLogger(ClientPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ClientsTab;
    private javax.swing.JLabel Delete;
    private javax.swing.JLabel Edit_reservation;
    private javax.swing.JLabel Edit_reservation1;
    private javax.swing.JLabel Edit_reservation2;
    private javax.swing.JLabel Edit_reservation3;
    private javax.swing.JLabel Edite;
    private javax.swing.JLabel Update;
    private javax.swing.JLabel addtxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField serch;
    // End of variables declaration//GEN-END:variables
}
