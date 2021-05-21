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
public class ClientBd {
    
    Connection conn = la.gazelle.LaGazelle.connectTODB();
    PreparedStatement statement = null;
    ResultSet result = null;
    
    //Instert salle
    
        public void insertClient(Classes.Client Client) {
        try { 
            String insertQuery = "INSERT INTO client (id_cl,nom_cl,prenom_cl,tel,Vile_Client) VALUES('"
                    +Client.getNum()
                    +"','"+ Client.getNom()
                    +"','"+ Client.getPrenom()
                    +"','"+ Client.getTel()
                    +"','"+ Client.getadr()
                   +"')";
                    //+ ")";
            statement = conn.prepareStatement(insertQuery);
            statement.execute();
           
            System.out.println(">>>>>>>>>> "+ Client.getNum());
            JOptionPane.showMessageDialog(null, "inséré avec succès un nv Client ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "ma rahch y'insiri");
        }
        finally
        {
            flushStatmentOnly();
            System.out.println("Insert Completed.");
        
        }
    }
        
        
        
         //Update Client
    public void updateClient(Classes.Client client)
    {
         try {
            String updateQuery ="UPDATE client set "  
                    + "id_cl = '"+client.getNum()+""
                    + "', nom_cl="+client.getNom()
                    + ", prenom_cl = '"+client.getPrenom()
                    + "', tel= '"+client.getTel()
                    + "', Vile_Client= '"+client.getadr()
                    ;
                    

            System.out.println(">>>>>>>>>> "+ updateQuery);
            //System.out.println(updateQuery);
            statement = conn.prepareStatement(updateQuery);

            //System.out.println(updateQuery);
            statement.execute();

            JOptionPane.showMessageDialog(null, "mis à jour de Client avec succès"+client.getNum());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Échec de la requête de mise à jour");
        }
         finally
         {
             flushStatmentOnly();
         }

    }
        
        
        //Delete Room
         public void deleteclient(int num_cl,String type_loc) {
          if(type_loc.equals("salle")){
            try {
                     String DeletresSalleCilentN="delete from  reservation_salle where id_cl="+num_cl;
                     statement = conn.prepareStatement(DeletresSalleCilentN);
                     statement.execute();
                
                     String deleteQuery = "delete from  client where id_cl="+num_cl;
                     statement = conn.prepareStatement(deleteQuery);
                     statement.execute();
                     
                     JOptionPane.showMessageDialog(null, "Client supprumé ");
                }catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Échec de la suppression du Client ");
                }
            finally{
                      flushStatmentOnly();
                     }
            }else if(type_loc.equals("chambre")){
                 try {
                     String DeletresChCilentN="delete from  reservation_ch where id_cl="+num_cl;
                     statement = conn.prepareStatement(DeletresChCilentN);
                     statement.execute();
                     
                     String deleteQuery = "delete from  client where id_cl="+num_cl;
                     statement = conn.prepareStatement(deleteQuery);
                     statement.execute();
                     
                     JOptionPane.showMessageDialog(null, "Client supprumé ");
                }catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Échec de la suppression du Client ");
                }
            finally{
                      flushStatmentOnly();
                     }
                
            }
             
         
    }
         
         //Sherch Client
         public ResultSet serchClient(String Nom,String prenom){
             try {
            String getClient = "select * from  client where nom_cl='"+Nom+"' and prenom_cl='"+prenom+"'";
             statement = conn.prepareStatement(getClient);
            result = statement.executeQuery();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Client non trouver ");
        }
       return result;
             
         }
         
         
    public ResultSet getClients() {
        try {
            String query = "select * from client";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n erreur provenant du retour de toutes les opérations de la base de données du Client");
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
