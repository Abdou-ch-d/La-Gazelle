package la.gazelle;

import Bd.ChambresBD;
import Classes.Chambre;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
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
public class RoomsPanel extends javax.swing.JFrame {

    /**
     * Creates new form RoomsPanel
     */
    Classes.Chambre room = new Chambre();
    
    ResultSet result;
    ArrayList<String> roomClass = new ArrayList<>();
   
    
    //DatabaseOperation db = new DatabaseOperation();
    Bd.ChambresBD roomdb = new ChambresBD();
    
    
    public RoomsPanel() {
        this.setLocation(250,150);
        initComponents();
        listed();
        roomClass.add("individuelle");
        roomClass.add("a deux");
        roomClass.add("familiale");
        //populateCombo();
        //populateRoomTable();
     
        
    }
    
        public void listed(){
            DefaultTableModel table=new DefaultTableModel();
            
            table.addColumn("num_ch");
            table.addColumn("num_bloc");
            table.addColumn("type_ch");
            table.addColumn("disponibilité");
            table.addColumn("TV");
            table.addColumn("WIFI");
            table.addColumn("Service_Telephonique");
            table.addColumn("prix");
            
            
            try{
             Connection konn=LaGazelle.connectTODB();
             String sql="SELECT * FROM `chambre`";
             Statement S=konn.createStatement();
             ResultSet R=S.executeQuery(sql);
             
             while(R.next()){
                 table.addRow(new Object[]{
                     R.getString(1),
                     R.getString(2),
                     R.getString(3),
                     R.getString(4),
                     R.getString(5),
                     R.getString(6),
                     R.getString(7),
                     R.getString(8),
                     //R.getString(9),
                 });
             }table_rooms.setModel(table);
            }catch(Exception e){
                System.out.println("hnaa");
            }
            
        }
        
    private void populateRoomTable()
    {
        result = roomdb.getRooms();
        table_rooms.setModel(DbUtils.resultSetToTableModel(result));
        roomdb.flushAll();
        
        
    }
    
      private void populateCombo()
    {
        try {
            ResultSet rs = roomdb.getRoomType();
            while(rs.next())
            {
               // roomClass.add(rs.getString("type_ch"));
                type_ch.addItem(rs.getString("type_ch"));
                
            }
          
        } catch (SQLException ex) {
            System.out.println("Farouuuuuk");
            JOptionPane.showMessageDialog(this, "Combo Fillup failed");
        }
    
    }
   
    private void roomObjectCreation()
    {
        // **************************************get information from the panel *********************
        room = new Chambre();
        room.setNum_ch(Num_ch.getText().toString());
        room.setBloc(bloc.getSelectedItem().toString());
        room.settype_ch(type_ch.getSelectedItem().toString());
        room.setHasTV(check_tv.isSelected());
        room.setHasWIFI(check_wifi.isSelected());
        room.setHasPhone(check_phone.isSelected());
        room.setPrix_ch(Integer.parseInt(prix_chambre.getText()));
      
    }
    
    //resste filds
    private void clearRoomPanel()
    {
        room = new Chambre();
        table_rooms.clearSelection();
        Num_ch.setText("");
        type_ch.setSelectedIndex(0);
        bloc.setSelectedIndex(0);
        check_phone.setSelected(false);
        check_tv.setSelected(false);
        check_wifi.setSelected(false);
        prix_chambre.setText("");
       
       
    }
    
    //return ComboSelected
     private int getComboSearchIndex(String item)
      {
          for( int i=0;i<roomClass.size() ; i++)
          {
              if(item.equals(roomClass.get(i)))
              {
                  return i;
              }
          }
         return 1;
      }
     
    //Show selected row 
    private void displayToRoomTextField(int row)
    {
       // for(int i=0; combo_roomType.)
        Num_ch.setText(table_rooms.getModel().getValueAt(row, 0)+"");
        int indxType = getComboSearchIndex(table_rooms.getModel().getValueAt(row, 1)+"");  
        type_ch.setSelectedIndex(indxType);
        int indxBloc = getComboSearchIndex(table_rooms.getModel().getValueAt(row, 2)+"");
        bloc.setSelectedIndex(indxBloc);
        check_tv.setSelected((table_rooms.getModel().getValueAt(row, 4)+"").equals("Oui") ? true:false);
        check_wifi.setSelected((table_rooms.getModel().getValueAt(row, 5)+"").equals("Oui") ? true:false);
        check_phone.setSelected((table_rooms.getModel().getValueAt(row, 6)+"").equals("Oui") ? true:false);
        prix_chambre.setText(table_rooms.getModel().getValueAt(row, 7)+"");
        
       
    }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Update = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Edite = new javax.swing.JLabel();
        Delete = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_rooms = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        check_phone = new javax.swing.JCheckBox();
        check_tv = new javax.swing.JCheckBox();
        check_wifi = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        bloc = new javax.swing.JComboBox<>();
        type_ch = new javax.swing.JComboBox<>();
        prix_chambre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Edit_reservation2 = new javax.swing.JLabel();
        Edit_reservation = new javax.swing.JLabel();
        Edit_reservation1 = new javax.swing.JLabel();
        addtxt = new javax.swing.JLabel();
        edittxt = new javax.swing.JLabel();
        AddRoom = new javax.swing.JLabel();
        DeletRoom = new javax.swing.JLabel();
        deletxt = new javax.swing.JLabel();
        EditRoom = new javax.swing.JLabel();
        Num_ch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Reffreshe = new javax.swing.JLabel();

        Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/updated.png"))); // NOI18N

        jLabel11.setForeground(new java.awt.Color(0, 153, 51));
        jLabel11.setText("Update");

        jLabel12.setForeground(new java.awt.Color(0, 102, 255));
        jLabel12.setText("Modifier");

        Edite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit.png"))); // NOI18N

        Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/delete.png"))); // NOI18N

        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Supprimer");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        table_rooms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_Ch", "type_ch", "Disponibilité", "Tv", "WIFI", "Service Téléphonique", "Prix/nuit(DA)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_rooms.setGridColor(new java.awt.Color(255, 255, 255));
        table_rooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_roomsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_rooms);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setText("Nos Chambres");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/hotel.png"))); // NOI18N

        jLabel3.setText("Type Chambre");

        check_phone.setText("Service Téléphonique");
        check_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_phoneActionPerformed(evt);
            }
        });

        check_tv.setText("TV");
        check_tv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_tvActionPerformed(evt);
            }
        });

        check_wifi.setText("WIFI");
        check_wifi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_wifiActionPerformed(evt);
            }
        });

        jLabel7.setText("Bloce");

        bloc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E" }));
        bloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blocActionPerformed(evt);
            }
        });

        type_ch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "individuelle", "a deux", "familiale" }));
        type_ch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_chActionPerformed(evt);
            }
        });

        prix_chambre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prix_chambreActionPerformed(evt);
            }
        });

        jLabel2.setText("Prix/nuit");

        jLabel4.setText("DA");

        addtxt.setForeground(new java.awt.Color(0, 153, 51));
        addtxt.setText("Ajouter");

        edittxt.setForeground(new java.awt.Color(0, 102, 255));
        edittxt.setText("Modifier");

        AddRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Add.png"))); // NOI18N
        AddRoom.setToolTipText("");
        AddRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddRoomMouseClicked(evt);
            }
        });

        DeletRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/delete.png"))); // NOI18N
        DeletRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeletRoomMouseClicked(evt);
            }
        });

        deletxt.setForeground(new java.awt.Color(255, 0, 0));
        deletxt.setText("Supprimer");

        EditRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit.png"))); // NOI18N
        EditRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditRoomMouseClicked(evt);
            }
        });

        Num_ch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Num_chActionPerformed(evt);
            }
        });

        jLabel5.setText("N°Chambre");

        Reffreshe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sginout.png"))); // NOI18N
        Reffreshe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReffresheMouseClicked(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(check_tv, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(check_wifi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(check_phone)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(prix_chambre, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(Num_ch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(type_ch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(bloc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(53, 53, 53)
                                .addComponent(Edit_reservation1)
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(addtxt)
                                    .addComponent(AddRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(edittxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(deletxt, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(EditRoom)
                                        .addGap(27, 27, 27)
                                        .addComponent(DeletRoom)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                                .addComponent(Edit_reservation)
                                .addGap(0, 0, 0)
                                .addComponent(Edit_reservation2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Reffreshe)
                                .addContainerGap())))
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Reffreshe)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Edit_reservation, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Edit_reservation1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Edit_reservation2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(type_ch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(Num_ch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(bloc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(check_wifi)
                                        .addComponent(check_tv)
                                        .addComponent(check_phone))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(prix_chambre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(AddRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(addtxt))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DeletRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(EditRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(deletxt)
                                        .addComponent(edittxt)))))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void type_chActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_chActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_type_chActionPerformed

    private void prix_chambreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prix_chambreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prix_chambreActionPerformed

    private void check_wifiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_wifiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check_wifiActionPerformed

    private void check_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check_phoneActionPerformed

    private void check_tvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_tvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check_tvActionPerformed

    private void AddRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddRoomMouseClicked
       roomObjectCreation();
       roomdb.insertRoom(room);
       populateRoomTable();
       clearRoomPanel();
       System.out.println("prblm f l'ajoute");
    }//GEN-LAST:event_AddRoomMouseClicked

    private void EditRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditRoomMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)table_rooms.getModel();
        int index=table_rooms.getSelectedRow();
        displayToRoomTextField(index);
        roomObjectCreation();
        roomdb.updateRoom(room);
        populateRoomTable();
        clearRoomPanel();
       
    }//GEN-LAST:event_EditRoomMouseClicked

    private void DeletRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeletRoomMouseClicked
        DefaultTableModel model=(DefaultTableModel)table_rooms.getModel();
        try{
            //deleting row from table "View" 
            int index=table_rooms.getSelectedRow();
            model.removeRow(index);
            //delet the row from DB
            int value=Integer.parseInt(model.getValueAt(index,0).toString());
            roomdb.deleteRoom(value);
           
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex+ "\n" + "sélectionner une ligne s'il vous plait");
        }
       
        //populateRoomTable();
        //clearRoomPanel();
    }//GEN-LAST:event_DeletRoomMouseClicked

    private void Num_chActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Num_chActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Num_chActionPerformed

    private void blocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blocActionPerformed

    private void table_roomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_roomsMouseClicked
        // TODO add your handling code here:
        room = new Chambre();
        EditRoom.setEnabled(true);
        DeletRoom.setEnabled(true);deletxt.setEnabled(true);
        AddRoom.setEnabled(false);addtxt.setEnabled(false);
        int row = table_rooms.getSelectedRow();
        displayToRoomTextField(row);
       // System.out.println(table_rooms.getValueAt(row, 1)+"");
        //System.out.println(">>>>>>> "+row );
    }//GEN-LAST:event_table_roomsMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        EditRoom.setEnabled(true);edittxt.setEnabled(true);
        DeletRoom.setEnabled(true);deletxt.setEnabled(true);
        AddRoom.setEnabled(true);addtxt.setEnabled(true);
    }//GEN-LAST:event_formMouseClicked

    private void ReffresheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReffresheMouseClicked
                setVisible(false); 
        dispose(); 

    }//GEN-LAST:event_ReffresheMouseClicked

    
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
            java.util.logging.Logger.getLogger(RoomsPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomsPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomsPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomsPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomsPanel().setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddRoom;
    private javax.swing.JLabel DeletRoom;
    private javax.swing.JLabel Delete;
    private javax.swing.JLabel EditRoom;
    private javax.swing.JLabel Edit_reservation;
    private javax.swing.JLabel Edit_reservation1;
    private javax.swing.JLabel Edit_reservation2;
    private javax.swing.JLabel Edite;
    private javax.swing.JTextField Num_ch;
    private javax.swing.JLabel Reffreshe;
    private javax.swing.JLabel Update;
    private javax.swing.JLabel addtxt;
    private javax.swing.JComboBox<String> bloc;
    private javax.swing.JCheckBox check_phone;
    private javax.swing.JCheckBox check_tv;
    private javax.swing.JCheckBox check_wifi;
    private javax.swing.JLabel deletxt;
    private javax.swing.JLabel edittxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField prix_chambre;
    private javax.swing.JTable table_rooms;
    private javax.swing.JComboBox<String> type_ch;
    // End of variables declaration//GEN-END:variables
}
