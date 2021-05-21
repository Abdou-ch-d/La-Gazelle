/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Crash
 */
public class Salle {
    private String num_s ;
    private String type_s  ;
    private double prix_s=0 ;
    private String disponible ;

    public Salle() {
    }

    public Salle(String num_s, String type_s, int prix_s, String disponible) {
        this.num_s = num_s;
        this.type_s = type_s;
        this.prix_s = prix_s;
        this.disponible = disponible;
    }

    public String getNum_s() {
        return num_s;
    }

    public String getType_s() {
        return type_s;
    }

    public double getPrix_s() {
        return prix_s;
    }

    public String isDisponible() {
        return disponible;
    }

    public void setNum_s(String num_s) {
        this.num_s = num_s;
    }

    public void setType_s(String type_s) {
        this.type_s = type_s;
    }

    public void setPrix_s(int prix_s) {
        this.prix_s = prix_s;
    }

    public void setDisponible(boolean disponible) {
         if(disponible==true){
            this.disponible="despo";
        }else  { this.disponible="occup";}
    }

    
    public double PrixSalleJ(String Typesalle){
        if(Typesalle.equals("salle des fetes")){
            prix_s=prix_s+1500000;
        }else if (Typesalle.equals("salle des congrès")){
             prix_s=prix_s+800000;
        }else if(Typesalle.equals("Auditorium")){
            prix_s=prix_s+500000;
        }
        
        return prix_s;
    }
    @Override
    public String toString() {
        return "Salle{" + "num_s=" + num_s + ", type_s=" + type_s + ", prix_s=" + prix_s + ", disponible=" + disponible + '}';
    }
    
}
