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
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class ChambresBD {
    
    Connection conn = la.gazelle.LaGazelle.connectTODB();
    PreparedStatement statement = null;
    ResultSet result = null;
    
    //Instert Room
        public void insertRoom(Classes.Chambre room) {
        try { 
            String insertQuery = "INSERT INTO chambre (num_ch,num_bloc,type_ch,TV,WIFI,Service_Telephonique,prix) VALUES('"
                    +room.getNum_ch()
                    +"', '"+room.getBloc() 
                    +"', '"+ room.getType_ch() 
                    +"', '"+ room.isHasTV() 
                    +"', '"+ room.isHasWIFI() 
                    +"', '"+ room.isHasPhone() 
                    +"', '"+ room.getPrix_ch()+"')";
                    //+ ")";
          
            statement = conn.prepareStatement(insertQuery);
            System.out.println("ma rahch y'insiri");
            statement.execute();
           
            System.out.println(">>>>>>>>>> "+ room.getNum_ch());
            JOptionPane.showMessageDialog(null, "successfully inserted a new Room ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "ma rahch y'insiri");
        }
        finally
        {
            flushStatmentOnly();
            System.out.println("Insert Completed.");
        
        }
    }
        
        //Update Rooms
        public void updateRoom(Classes.Chambre room)
    {
         try {
            String updateQuery ="UPDATE chambre set "  
                    + "num_ch = '"+room.getNum_ch()+""
                    + "', num_bloc="+room.getBloc()
                    + ", type_ch = '"+room.getType_ch()
                    + "', disponibilité= '"+room.isDisponible()
                    + "', TV = '"+room.isHasTV()
                    + "', WIFI = '"+room.isHasWIFI()
                    + "', Service_Telephonique= '"+room.isHasPhone()
                    + "', prix= '"+room.getPrix_ch()
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
        
        
        //Delete Room
         public void deleteRoom(int num_ch) {

        try {
            String deleteQuery = "delete from  chambre where num_ch="+num_ch;
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Chambre supprumé ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Échec de la suppression de la chambre ");
        }
        finally
        {
            flushStatmentOnly();
        }
    }
         
         
         public ResultSet getRooms() {
        try {
            String query = "select * from chambre";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n erreur provenant du retour de toutes les opérations de la base de données de la chambre");
        }
        
        return result;
    }
         
         public int getNoOfRooms()
    {
        int rooms = -1;
        try {
            String query = "select count(id_ch)  as noRoom from chambre";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
            while(result.next())
            {
                rooms = result.getInt("noRoom");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n Erreur de comptage à venir Fonctionnement de la base de données de la chambre");
        }
        
        return rooms;
    }
    
    public ResultSet getAllRoomNames()
    {
         try {
            String query = "select num_ch from chambre";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all id_ch  ROOM DB Operation");
        }
        
        return result;
    }
    
    public ResultSet getRoomType() {
        try {
            String query = "select * from type_ch";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all Room Type DB Operation");
        }

        return result;
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
