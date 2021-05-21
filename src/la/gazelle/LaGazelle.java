  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package la.gazelle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class LaGazelle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        frame1 f=new frame1();
        f.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                f.setVisible(true);
                
               connectTODB();
            
    }
    
    //Connection to or databas
   public static Connection connectTODB(){
        try{
            String driver="com.mysql.jdbc.Driver";
            String Url="jdbc:mysql://localhost:3306/hotel";
            String UserName="Abdou";
            String Passworld="MSbYn-IA(-jb.rp6";
            Class.forName(driver);
            
            Connection conn = DriverManager.getConnection(Url,UserName,Passworld);
           
            System.out.println("Connected");
            return conn;
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            System.out.println("Not Connected!!!!!!!!");
            return null;
        }
        
    }
    
    
   /* public static Connection connectTODB()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?zeroDateTimeBehavior=convertToNull");
            System.out.println("Connected");
            JOptionPane.showMessageDialog(null, "Connection Establishment");
            return conn;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            System.out.println("Not Connected!!!!!!!!");
            return null;
        }
        
        
    }*/
    
    
   
}
