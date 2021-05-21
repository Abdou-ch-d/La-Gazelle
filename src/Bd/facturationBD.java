/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import la.gazelle.LaGazelle;

/**
 *
 * @author pc
 */
public class facturationBD {
    
    
    Connection conn = la.gazelle.LaGazelle.connectTODB();
    PreparedStatement statement = null;
    ResultSet result = null;
    
    
    
  //Calculer le totale a paier
    public long TotalMonte(Classes.reservation_ch resCh,Classes.Reservation_salle resSalle){
        long Total=0;
        try {
            String qr="select * from reservation_ch where ";
            Connection konn=LaGazelle.connectTODB();
            Statement S=konn.createStatement();
            ResultSet R=S.executeQuery(qr);  
            result=R;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "\n error coming from returning a reservation function");
        }
  
        
        
        
        return Total;
    }
    
    
    public ResultSet searchAnUserFacture(String Nom,String Prenom){
        
         try {
            String qr="select id_cl from client where nom_cl='"+Nom+"' and prenom_cl='"+Prenom+"'";
            Connection konn=LaGazelle.connectTODB();
            Statement S=konn.createStatement();
            ResultSet R=S.executeQuery(qr);
            
            while(R.next()){
            String id=R.getString("id_cl");
            System.out.println("___655__"+id);
            
            
            String getfactur = "select * from facture where id_cl="+id;
            statement = conn.prepareStatement(getfactur);
            result = statement.executeQuery();
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n Nouveau Client ");
            
        }
         
        return result;
        
        
    }
    
    
}
