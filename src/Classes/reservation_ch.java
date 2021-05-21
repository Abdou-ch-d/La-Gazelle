/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import org.joda.time.Days;

/**
 *
 * @author pc
 */
public class reservation_ch {
    
    
  private int id_res;
  private Client client;
  private Chambre chambre;
  private String date_E,date_S ; 
  private double total_res=0;

    public reservation_ch(int id_res, Client client, Chambre chambre, String date_d, String date_f, double total_res) {
        this.id_res = id_res;
        this.client = client;
        this.chambre = chambre;
        this.date_E = date_d;
        this.date_S = date_f;
        this.total_res = total_res;
    }

    public reservation_ch() {
    }

    public int getId_res() {
        return id_res;
    }

    public Client getClient() {
        return client;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public String getDate_d() {
        return date_E;
    }

    public String getDate_f() {
        return date_S;
    }

    public double getTotal_res() {
        return total_res;
    }

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public void setDate_d(String date_d) {
        this.date_E = date_d;
    }

    public void setDate_f(String date_f) {
        this.date_S = date_f;
    }

    public void setTotal_res(double total_res) {
        this.total_res = total_res;
    }
  
  //calcule nbr days beten dateE & dateS for chambre reservation
    public float CalculaDysBetweenCH(String date_e,String date_f){
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
	       Date dateBefore = myFormat.parse(date_e);
	       Date dateAfter = myFormat.parse(date_f);
	       long difference = dateAfter.getTime() - dateBefore.getTime();
	       float daysBetween = (difference / (1000*60*60*24)+1);
               
	       System.out.println("Number of Days between dates: "+daysBetween);
               return Math.abs(daysBetween) ;
	 } catch (Exception e) {
	       e.printStackTrace();
         }
        
       
        return 0 ;
    }
    
   /*public long getDifferenceDays(Date d1, Date d2) {
    long diffDays  = 0;
    long diff = d2.getTime() - d1.getTime();
    diffDays= diff / (24 * 60 * 60 * 1000) + 1;
    return Math.abs(diffDays);
}*/
}
