/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package la.gazelle;

import Bd.ChambresBD;
import Bd.ReservationBd;
import Classes.Chambre;
import Classes.Client;
import Classes.Date;
import Classes.Facture;
import Classes.reservation_ch;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author pc
 */
public class Reservation_des_Chambres extends javax.swing.JFrame {

    Classes.reservation_ch res_ch ;
    Classes.Client client;
    Classes.Chambre chambre;
    Classes.reservation_ch reservation_ch;
    Classes.Facture facture;
    ResultSet result;
   
    //DatabaseOperation db = new DatabaseOperation();
     Bd.ReservationBd resdb = new ReservationBd();
    
    /**
     * Creates new form Reservation_des_Chambres
     */
    public Reservation_des_Chambres() {
        this.setLocation(300,80);
       
        initComponents();
       
    }
    
    
   
    
    
     private void resrvationObjectCreation()
    {
        // **************************************get information from the panel *********************
        res_ch = new reservation_ch();
        
        /*res_ch.setBloc(bloc.getSelectedItem().toString());
        res_ch.settype_ch(type_ch.getSelectedItem().toString());
        res_ch.setHasTV(check_tv.isSelected());
        res_ch.setHasWIFI(check_wifi.isSelected());
        res_ch.setHasPhone(check_phone.isSelected());
        res_ch.setPrix_ch(Integer.parseInt(prix_chambre.getText()));*/
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Client_Info_Panel = new javax.swing.JPanel();
        Addresse_client = new javax.swing.JTextField();
        Nom_client = new javax.swing.JTextField();
        prenom_client = new javax.swing.JTextField();
        N_tel_client = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bloc_ch = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        date_checkOut = new com.toedter.calendar.JDateChooser();
        date_checkIn = new com.toedter.calendar.JDateChooser();
        TV = new javax.swing.JRadioButton();
        WIFI = new javax.swing.JRadioButton();
        TEL = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        Ch_despo = new javax.swing.JComboBox();
        total = new javax.swing.JLabel();
        TypeCH = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setUndecorated(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/beed.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel2.setText("Reservation des Chambres");

        Client_Info_Panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information de la Reservation", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        Client_Info_Panel.setToolTipText("Information du reservation");

        Addresse_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Addresse_clientActionPerformed(evt);
            }
        });

        Nom_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nom_clientActionPerformed(evt);
            }
        });

        prenom_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenom_clientActionPerformed(evt);
            }
        });

        N_tel_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                N_tel_clientActionPerformed(evt);
            }
        });

        jLabel3.setText("Nom");

        jLabel4.setText("Prénom");

        jLabel5.setText("Address");

        jLabel6.setText("N°Tel");

        jLabel7.setText("Chambre");

        jLabel8.setText("Bloc");

        jLabel9.setText("Date d'entrer");

        jLabel10.setText("Date de Sortier");

        bloc_ch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D" }));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, bloc_ch, org.jdesktop.beansbinding.ELProperty.create("${selectedItem}"), bloc_ch, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        bloc_ch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bloc_chItemStateChanged(evt);
            }
        });
        bloc_ch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloc_chActionPerformed(evt);
            }
        });
        bloc_ch.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bloc_chPropertyChange(evt);
            }
        });

        date_checkIn.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date_checkInPropertyChange(evt);
            }
        });

        TV.setText("TV");
        TV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TVActionPerformed(evt);
            }
        });

        WIFI.setText("WIFI");
        WIFI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WIFIActionPerformed(evt);
            }
        });

        TEL.setText("Service Telephonique");
        TEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TELActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        jLabel15.setText("Total =");

        Ch_despo.setMaximumRowCount(50);
        Ch_despo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ch_despoActionPerformed(evt);
            }
        });

        total.setFont(new java.awt.Font("Tekton Pro Ext", 0, 12)); // NOI18N

        TypeCH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "individuelle", "familiale", "a deux" }));
        TypeCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeCHActionPerformed(evt);
            }
        });

        jLabel16.setText("Type Chambre");

        javax.swing.GroupLayout Client_Info_PanelLayout = new javax.swing.GroupLayout(Client_Info_Panel);
        Client_Info_Panel.setLayout(Client_Info_PanelLayout);
        Client_Info_PanelLayout.setHorizontalGroup(
            Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(date_checkIn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date_checkOut, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Client_Info_PanelLayout.createSequentialGroup()
                        .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                                .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TypeCH, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Ch_despo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TV, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 45, Short.MAX_VALUE))))
                    .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(N_tel_client, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(25, 25, 25)
                                .addComponent(Nom_client, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Client_Info_PanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Addresse_client, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Client_Info_PanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(prenom_client, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(48, 48, 48))
            .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(WIFI)
                            .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                                .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(bloc_ch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(20, 20, 20))))
                    .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(TEL)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Client_Info_PanelLayout.setVerticalGroup(
            Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Nom_client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(prenom_client, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(N_tel_client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(Addresse_client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TypeCH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Ch_despo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TEL)))
                    .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TV)
                            .addComponent(WIFI)))
                    .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bloc_ch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                        .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(date_checkIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)))
                            .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(Client_Info_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(Client_Info_PanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(date_checkOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/save_reservation.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/delete.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jLabel14.setText("Annuler");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jLabel12.setText("sauvegarder");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(13, 13, 13))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(9, 9, 9))
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(Client_Info_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(211, 211, 211))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(Client_Info_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addGap(26, 26, 26))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Addresse_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Addresse_clientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Addresse_clientActionPerformed

    private void Nom_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nom_clientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nom_clientActionPerformed

    private void prenom_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenom_clientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prenom_clientActionPerformed

    private void N_tel_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_N_tel_clientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_N_tel_clientActionPerformed

    private void date_checkInPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date_checkInPropertyChange
       /* if (date_checkIn.getDate() != null) {
            try {
                //System.err.println("aise");
                long date = date_checkIn.getDate().getTime() / 1000;
                System.out.println(">> "+date);
                
                ResultSet x = resdb.CheckDespoCh(date);

                while (x.next()) {
                    Ch_despo.addItem(x.getString("num_ch"));
                }
             
                 

            } catch (SQLException ex) {
                System.err.println("errrrrrrrrrrrr");
            }
        }*/
    }//GEN-LAST:event_date_checkInPropertyChange

    private void TVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TVActionPerformed

    private void WIFIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WIFIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WIFIActionPerformed

    private void bloc_chActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloc_chActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bloc_chActionPerformed

    private void TELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TELActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TELActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        setVisible(false); 
        dispose(); 

    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
       setVisible(false); 
        dispose(); 

    }//GEN-LAST:event_jLabel14MouseClicked

    private void Ch_despoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ch_despoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Ch_despoActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        client=new Client();
        chambre=new Chambre();
        reservation_ch=new reservation_ch();
        facture=new Facture();
        
        
        client.setNom(Nom_client.getText());
        client.setPrenom(prenom_client.getText());
        client.setTel(Integer.parseInt(N_tel_client.getText()));
        client.setadr(Addresse_client.getText());
        
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
        String date_E = dcn.format(date_checkIn.getDate());
        reservation_ch.setDate_d(date_E);
        System.out.println(date_E);
        
        SimpleDateFormat dc = new SimpleDateFormat("yyyy-MM-dd");
        String date_s = dc.format(date_checkOut.getDate());
        reservation_ch.setDate_f(date_s);
        System.out.println(date_s);
        
        chambre.setNum_ch(Ch_despo.getSelectedItem().toString());
        chambre.settype_ch(TypeCH.getSelectedItem().toString());
        chambre.setBloc(bloc_ch.getSelectedItem().toString());
        chambre.setDisponible(false);
        
        if(TV.isSelected()){
            chambre.setHasTV(true);
            facture.setFrais_TV(500);
        }else chambre.setHasTV(false);
        
        if(WIFI.isSelected()){
            chambre.setHasWIFI(true);
            facture.setFrais_WIFI(500);
        }else chambre.setHasWIFI(false);
        
        if(TEL.isSelected()){
            chambre.setHasPhone(true);
            facture.setFrais_TEL(500);
        }else chambre.setHasPhone(false);
        
        double prixConsomation= chambre.PriceConsomationJ(chambre);
        System.out.println("prixConsomation "+prixConsomation);
       
        double prixChJ= chambre.PriceCHJ(chambre.getType_ch());
        facture.setFrais_chambre(prixChJ);
        System.out.println("prixChJ "+prixChJ);
        
       float duration=reservation_ch.CalculaDysBetweenCH(date_E,date_s);
       double tot=(prixConsomation+prixChJ)*duration;
       //reservation_ch.setTotal_res(tot);
       facture.setTotale(tot);
       total.setText(""+tot+"DA");
       
       resdb.insertReservation(reservation_ch,client,chambre,facture);
       
    }//GEN-LAST:event_jLabel11MouseClicked

    private void bloc_chPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bloc_chPropertyChange
        
        
      
    }//GEN-LAST:event_bloc_chPropertyChange

   
    private void bloc_chItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bloc_chItemStateChanged
       if (evt.getStateChange() == ItemEvent.SELECTED) {
           
       String bloc=(bloc_ch.getSelectedItem().toString());
       String type_ch=(TypeCH.getSelectedItem().toString());
       SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
       String date_E = dcn.format(date_checkIn.getDate());
       SimpleDateFormat dc = new SimpleDateFormat("yyyy-MM-dd");
       String date_s = dc.format(date_checkOut.getDate());
       System.out.println("hana raho yreterni bloc m ComboBox____"+bloc);
        try {
            
            ResultSet rs = resdb.CheckDespoCh(bloc,type_ch,date_E,date_s);
            Ch_despo.removeAllItems();
            while(rs.next())
            {
               
                Ch_despo.addItem(rs.getString("num_ch"));
            }
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Combo Fillup failed \n ma rahch yjib les chambre dispo");
        }
    
        
        }
       
    }//GEN-LAST:event_bloc_chItemStateChanged

    private void TypeCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeCHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TypeCHActionPerformed

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
            java.util.logging.Logger.getLogger(Reservation_des_Chambres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservation_des_Chambres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservation_des_Chambres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservation_des_Chambres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservation_des_Chambres().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Addresse_client;
    private javax.swing.JComboBox Ch_despo;
    private javax.swing.JPanel Client_Info_Panel;
    private javax.swing.JTextField N_tel_client;
    private javax.swing.JTextField Nom_client;
    private javax.swing.JRadioButton TEL;
    private javax.swing.JRadioButton TV;
    private javax.swing.JComboBox<String> TypeCH;
    private javax.swing.JRadioButton WIFI;
    private javax.swing.JComboBox<String> bloc_ch;
    private com.toedter.calendar.JDateChooser date_checkIn;
    private com.toedter.calendar.JDateChooser date_checkOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField prenom_client;
    private javax.swing.JLabel total;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
