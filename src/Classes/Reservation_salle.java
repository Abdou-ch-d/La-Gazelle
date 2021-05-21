/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author pc
 */
public class Reservation_salle {
    
  private int id_resS;
  private Client client;
  private Salle salle;
  private String date_dS,date_fS;
  private double total_resS=0;

    public Reservation_salle(int id_resS, Client client, Salle salle, String date_dS, String date_fS, long total_resS) {
        this.id_resS = id_resS;
        this.client = client;
        this.salle = salle;
        this.date_dS = date_dS;
        this.date_fS = date_fS;
        this.total_resS = total_resS;
    }

    public Reservation_salle() {
    }

    public int getId_resS() {
        return id_resS;
    }

    public Client getClient() {
        return client;
    }

    public Salle getSalle() {
        return salle;
    }

    public String getDate_dS() {
        return date_dS;
    }
    public String getDate_fS(){
        return date_fS;
    }

    public double getTotal_resS() {
        return total_resS;
    }

    public void setId_resS(int id_resS) {
        this.id_resS = id_resS;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public void setDate_dS(String date_dS) {
        this.date_dS = date_dS;
    }

    public void setDate_fS(String date_fS) {
        this.date_fS = date_fS;
    }

    public void setTotal_resS(double total_resS) {
        this.total_resS = total_resS;
    }
    
    //calcule nbr days beten dateE & dateS for Salle reservation
    public float CalculaDysBetweenSalle(String date_e,String date_f){
        
         SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
	       java.util.Date dateBefore = myFormat.parse(date_e);
	       java.util.Date dateAfter = myFormat.parse(date_f);
	       long difference = dateAfter.getTime() - dateBefore.getTime();
	       float daysBetween = (difference / (1000*60*60*24)+1);
               
	       System.out.println("Number of Days between dates: "+daysBetween);
               return Math.abs(daysBetween) ;
	 } catch (Exception e) {
	       e.printStackTrace();
         }
        
       
        return 0 ;
    }
    
}
     
