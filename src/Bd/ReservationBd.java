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
public class ReservationBd {
    Connection conn = la.gazelle.LaGazelle.connectTODB();
    PreparedStatement statement = null;
    ResultSet result = null;
    
    //Instert Reservation
        public void insertReservation(Classes.reservation_ch res_ch,Classes.Client client,Classes.Chambre chambre,Classes.Facture facture) {
        try {
            
            //Remarques
            
           
            //Facrturation and delet Reservaton from tables
            //information Client
            
            
            ResultSet Serch_Clinet=searchAnUser(client.getNom(), client.getPrenom());
         
            if(Serch_Clinet.next()==false){
                //Client dont existe 
                String insertClient="INSERT INTO client (id_cl,nom_cl,prenom_cl,tel,Vile_Client) VALUES('"
                    +client.getNum()
                    +"', '"+ client.getNom()
                     +"', '"+ client.getPrenom()
                     +"', '"+ client.getTel()
                     +"', '"+client.getadr()
                     +"')";
             statement = conn.prepareStatement(insertClient);
             statement.execute();
             System.out.println(" raho  y'insiri Client     "+client.getNom());
             JOptionPane.showMessageDialog(null, "successfully inserted a new Client ");
             
            }
            
            
            String qr="select id_cl from client where nom_cl='"+client.getNom()+"'";
            Connection konn=LaGazelle.connectTODB();
            Statement S=konn.createStatement();
            ResultSet R=S.executeQuery(qr);
            
            while(R.next()){
            String id=R.getString("id_cl");
            System.out.println("___655__"+id);
            
            String insertQuery = "INSERT INTO reservation_ch (id_res,id_cl,num_ch,num_bloc,date_d,date_f) VALUES('"
                    +res_ch.getId_res()
                    +"', '"+id
                    +"', '"+chambre.getNum_ch()
                    +"', '"+chambre.getBloc() 
                    +"', '"+res_ch.getDate_d()
                    +"', '"+res_ch.getDate_f()
                    
                    +"')";
                   
            statement = conn.prepareStatement(insertQuery);
            statement.execute();
            JOptionPane.showMessageDialog(null, "successfully inserted a new reservation");
            
            
            String insertFacture="INSERT INTO facture (num_f,id_cl,frais_Tel,frais_TV,frais_WIFI,frais_chambre,Totale_a_paier) VALUES('"
                   +facture.getId()
                   +"', '"+id
                   +"', '"+facture.getFrais_TEL()
                   +"', '"+facture.getFrais_TV()
                   +"', '"+facture.getFrais_WIFI()
                   +"', '"+facture.getFrais_chambre()
                   +"', '"+facture.getTotale()
                   +"')";
            statement = conn.prepareStatement(insertFacture);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Facture Ajouter");
            
            }
             
            String updatedispo="UPDATE chambre set disponibilité = '"+chambre.isDisponible()
                    +"', TV='"+chambre.isHasTV()
                    +"',WIFI='"+chambre.isHasWIFI()
                    +"',Service_Telephonique='"+chambre.isHasPhone()
                    +"' where num_ch="+chambre.getNum_ch()
                    ;
            statement = conn.prepareStatement(updatedispo);
            statement.execute();
            System.out.println("________MAJ Dispo Done succufully_____");
           
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "ma rahch y'insiri -___-");
        }
        finally
        {
            flushStatmentOnly();
            System.out.println("Insert Completed.");
        
        }
    }
    
        
        
         //Instert Reservation Salle
        public void insertReservationSalle(Classes.Reservation_salle res_S ,Classes.Client client,Classes.Salle salle,Classes.Facture facture) {
        try { 
            ResultSet Serch_Clinet=searchAnUser(client.getNom(), client.getPrenom());
             if(Serch_Clinet.next()==false){
                 String insertClient="INSERT INTO client (id_cl,nom_cl,prenom_cl,tel,Vile_Client) VALUES('"
                     +client.getNum()
                     +"', '"+ client.getNom()
                     +"', '"+ client.getPrenom()
                     +"', '"+ client.getTel()
                     +"', '"+ client.getadr()
                     +"')";
             statement = conn.prepareStatement(insertClient);
             statement.execute();
             System.out.println(" raho  y'insiri Client"+client.getNom());
             JOptionPane.showMessageDialog(null, "successfully inserted a new Client ");
                 
             }
            
            String qr="select id_cl from client where nom_cl='"+client.getNom()+"'";
            Connection konn=LaGazelle.connectTODB();
            Statement S=konn.createStatement();
            ResultSet R=S.executeQuery(qr);
            
            while(R.next()){
            String id=R.getString("id_cl");
            System.out.println("___655__"+id);
            
            String insertQuery = "INSERT INTO reservation_salle (id_ressalle,id_cl,num_s,date_d,date_f) VALUES('"
                    +res_S.getId_resS()
                    +"', '"+id
                    +"', '"+salle.getNum_s()
                    +"', '"+res_S.getDate_dS()
                    +"', '"+res_S.getDate_fS()
                    
                    +"')";
                   
            statement = conn.prepareStatement(insertQuery);
            statement.execute();
            
            
             String insertFacture="INSERT INTO facture (num_f,id_cl,frais_salle,Totale_a_paier) VALUES('"
                   +facture.getId()
                   +"', '"+id
                   +"', '"+facture.getFrais_salle()
                   +"', '"+facture.getTotale()
                   +"')";
            statement = conn.prepareStatement(insertFacture);
            statement.execute();
            }
             
            String updatedispo="UPDATE salle set disponibilité = '"+salle.isDisponible()
                    //+"'prix='"+chambre.getPrix_ch()
                    +"' where num_s="+salle.getNum_s()
                    ;
            statement = conn.prepareStatement(updatedispo);
            statement.execute();
            System.out.println("________MAJ Dispo Done succufully_____");
           
            JOptionPane.showMessageDialog(null, "successfully inserted a new reservation");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "ma rahch y'insiri -___-");
        }
        finally
        {
            flushStatmentOnly();
            System.out.println("Insert Completed.");
        
        }
    }
    
        
        
        
        
        
        
        
        
       
    //Update Reservation
        public void updateReservation(Classes.Chambre room ,Classes.Client client)
    {
         try {
            String updateQuery ="UPDATE reservation_ch set " 
                    + "', id_cl = '"+client.getNum()
                    + "', num_bloc="+room.getBloc()
                    + "num_ch = '"+room.getNum_ch()
                    + ", type_ch = '"+room.getType_ch()
                    + "', date_d = '"+room.getPrix_ch()
                    + "', date_f= '"+room.getPrix_ch()
                    ;
                    

            System.out.println(">>>>>>>>>> "+ updateQuery);
            //System.out.println(updateQuery);
            statement = conn.prepareStatement(updateQuery);

            //System.out.println(updateQuery);
            statement.execute();

            JOptionPane.showMessageDialog(null, "mis à jour de la chambre avec succès"+room.getNum_ch());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Échec de la requête de mise à jour");
        }
         finally
         {
             flushStatmentOnly();
         }
    }
        
    //Delete reservation Chambres
         public void deleteReservation(int id_res) {

        try {
           String deleteQuery = "delete from reservation_ch  where id_res="+id_res;
           statement = conn.prepareStatement(deleteQuery);
           statement.execute();
           
           
           String resrvation="Select * from reservation_ch where id_res="+id_res;
           Connection konn=LaGazelle.connectTODB();
           Statement S=konn.createStatement();
           ResultSet u=S.executeQuery(resrvation);
           
           
           while(u.next()){
           String num_ch=u.getString("num_ch");
           String bloc=u.getString("num_bloc");
           String id_cl=u.getString("id_cl");
           System.out.println("Chambre_num:"+num_ch+"\n bloc:"+bloc+"\n Client N° :"+id_cl);
           
           String UpdateDispo="UPDATE chambre set"  
                    + "', disponibilité =despo'"
                    +" where num_ch="+num_ch+"and num_bloc='"+bloc+"' " ;
                   
            statement = conn.prepareStatement(UpdateDispo);
            statement.execute();
            JOptionPane.showMessageDialog(null, " Chambre"+num_ch+"libre");
            
          
           }
           
           
          JOptionPane.showMessageDialog(null, "Reservation supprumé \n Chambre libre \n Client Supp");
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Échec de la suppression de Reservation ");
        }
        finally
        {
            flushStatmentOnly();
        }
    }
       //Delete reservation
         public void deleteReservationSalle(int id_res) {

        try {
            String deleteQuery = "delete from reservation_salle  where id_ressalle="+id_res;
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();
           JOptionPane.showMessageDialog(null, "Reservation supprumé ");
           
           String salleid="Select num_s from reservation_salle where id_ressalle="+id_res;
           Connection konn=LaGazelle.connectTODB();
           Statement S=konn.createStatement();
           ResultSet u=S.executeQuery(salleid);
           System.out.println("uuuuuuuuuuuuu"+salleid);
           
           while(u.next()){
           String num_s=u.getString("num_s");
           
           System.out.println("Salle_num:"+num_s);
           String UpdateDispo="UPDATE salle set"  
                    + "', disponibilité =despo'"
                    +"' where num_s="+num_s;
                   
            statement = conn.prepareStatement(UpdateDispo);
            statement.execute();
            JOptionPane.showMessageDialog(null, " Chambre"+num_s+"libre");
           }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Échec de la suppression de Reservation ");
        }
        finally
        {
            flushStatmentOnly();
        }
    }  
         
         
         
     
    //get All reservaton
    public ResultSet getAllReservaton() {
        try {
            String query = "select * from reservation_ch";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "auccun reservation a été effectué ");
        }
        
        return result;
    }
    
    
    public ResultSet CheckDespoCh(String bloc,String type,String check_inTime ,String check_outTime ){
         try {
          
           //String despoQuery = "select * from  chambre where  num_bloc='"+bloc+"' and type_ch ='"+type+"'and disponibilité='dispo' ";  
           // String query = "SELECT num_ch FROM chambre LEFT OUTER JOIN reservation_ch ON chambre.num_ch = reservation_ch.num_ch WHERE reservation_ch.num_ch is null or "+check_inTime+"< reservation_ch.date_d " +"or reservation_ch.date_f <"+check_inTime+" group by chambre.num_ch  order by num_ch ";

           String despoQuery="SELECT * FROM chambre WHERE num_ch NOT IN (SELECT num_ch FROM reservation_ch WHERE date_d <='"+check_outTime+"'\n"+
           "AND date_f>='"+check_inTime+"')AND  num_bloc='"+bloc+"' AND type_ch='"+type+"'";
           
           
            statement = conn.prepareStatement(despoQuery);
            result = statement.executeQuery();
           
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Tout les chambres reserver");
        }
        return result;
         
    }
    
    public ResultSet  CheckSalleDispo(String type_Salle,String check_inTime ,String check_outTime ){
         try {
           // String despoQuery = "select * from  salle where type_s='"+type_Salle+"' and disponibilité='despo'";
            
            String despoQuery="SELECT * FROM salle WHERE num_s NOT IN (SELECT num_s FROM reservation_salle WHERE date_d <='"+check_outTime+"'\n"+
           "AND date_f>='"+check_inTime+"')AND  type_s='"+type_Salle+"'";
            statement = conn.prepareStatement(despoQuery);
            result = statement.executeQuery();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Tout les Salle reserver");
        }
        
      
       return result; 
    }
    
    
    public ResultSet searchAnUser(String Nom,String Prenom){
        try {
            String query = "select * from client where nom_cl='"+Nom+"' and prenom_cl='"+Prenom+"'";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n Nouveau Client ");
            
        }
            //System.out.println("fetching something");
        return result;
        
    }
    
    public ResultSet serchAllReservationCl(String id_cl){
        try {
            String qr="select * from reservation_ch where id_cl='"+id_cl+"'";
            Connection konn=LaGazelle.connectTODB();
            Statement S=konn.createStatement();
            ResultSet R=S.executeQuery(qr);
             return R;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "\n error coming from returning a reservation function");
        }
  
        return null;
    }
    
    
    
    
    
   
    
   public void flushAll()
    {
        {
                        try
                        {
                            statement.close();
                            result.close();
                        }
                        catch(SQLException ex)
                        {System.err.print(ex.toString()+" >> CLOSING DB");}
                    }
    }
     //Clossing BD
        private void flushStatmentOnly()
    {
        {
                        try
                        {
                            statement.close();
                        }
                        catch(SQLException ex)
                        {System.err.print(ex.toString()+" >> CLOSING DB");}
                    }
    }
    
    
}






