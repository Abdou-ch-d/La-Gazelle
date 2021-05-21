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
public class SallesBD {
    
    Connection conn = la.gazelle.LaGazelle.connectTODB();
    PreparedStatement statement = null;
    ResultSet result = null;
    
    //Instert salle
        public void insertSalle(Classes.Salle salle) {
        try { 
            String insertQuery = "INSERT INTO salle (num_s,type_s,prix) VALUES('"
                    +salle.getNum_s()
                    +"','"+ salle.getType_s()
                    +"','"+ salle.getPrix_s()+"')";
                    //+ ")";
            statement = conn.prepareStatement(insertQuery);
            statement.execute();
           
            System.out.println(">>>>>>>>>> "+ salle.getNum_s());
            JOptionPane.showMessageDialog(null, "inséré avec succès une nouvelle salle ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "ma rahch y'insiri");
        }
        finally
        {
            flushStatmentOnly();
            System.out.println("Insert Completed.");
        
        }
    }
        
//Update salle
        public void updateSalle(Classes.Salle salle)
    {
         try {
            String updateQuery ="UPDATE salle set "  
                    + "num_ch = '"+salle.getNum_s()+""
                    + ", type_ch = '"+salle.getType_s()
                    + "', disponibilité= '"+salle.isDisponible()
                    + "', prix= '"+salle.getPrix_s()
                    ;
                    

            System.out.println(">>>>>>>>>> "+ updateQuery);
            //System.out.println(updateQuery);
            statement = conn.prepareStatement(updateQuery);

            //System.out.println(updateQuery);
            statement.execute();

            JOptionPane.showMessageDialog(null, "mis à jour de la salle avec succès"+salle.getNum_s());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Échec de la requête de mise à jour");
        }
         finally
         {
             flushStatmentOnly();
         }

    }
        
        
        //Delete salle
         public void deleteSalle(int num_s) {

        try {
            String deleteQuery = "delete from  salle where num_s="+num_s;
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Salle supprumé ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Échec de la suppression de la salle ");
        }
        finally
        {
            flushStatmentOnly();
        }
        
    }
         
         
        public ResultSet getSalles() {
        try {
            String query = "select * from salle";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n erreur provenant du retour de toutes les opérations de la base de données de la salle");
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

