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
public class Chambre {
    //private String id_ch;
    private String num_ch ;
    private String bloc;
    private String type_ch  ;
    private double prix_ch =0;
    private String disponible ;
    
    private String hasTV;
    private String hasWIFI;
    private String hasPhone;

    public Chambre() {
    }
    
    public Chambre(String num_ch, String type_ch,String bloc, int prix_ch, String disponible) {
        //this.id_ch="bloc"+"num_ch";
        this.num_ch = num_ch;
        this.type_ch = type_ch;
        this.bloc=bloc;
        this.prix_ch = prix_ch;
        this.disponible = disponible;
    }

   /* public String getid_ch(){
        return id_ch;
    }*/
    public String getNum_ch() {
        return num_ch;
    }
    public String getBloc(){
        return bloc;
    }

    public String getType_ch() {
        return type_ch;
    }

    public double getPrix_ch() {
        return prix_ch;
    }

    public String isDisponible() {
        return disponible;
    }

   /* public void setid_ch(String bloc,int num_ch){
        this.id_ch="bloc"+"num_ch";
    }*/
    public void setNum_ch(String num_ch) {
        this.num_ch = num_ch;
    }
    public void setBloc(String Bloc){
        this.bloc=Bloc;
        
    }

    public void settype_ch(String type_ch) {
        this.type_ch = type_ch;
    }

    public void setPrix_ch(int prix_ch) {
        this.prix_ch = prix_ch;
    }

    public void setDisponible(boolean disponible) {
        if(disponible==true){
            this.disponible="dispo";
           
        }else
        { this.disponible="occup";}
    }

        public String isHasTV() {
        return hasTV;
    }

    public void setHasTV(boolean hasTV) {
        if(hasTV==true){this.hasTV = "Oui";
        }else {this.hasTV = "Non";}
    }

    public String isHasWIFI() {
        return hasWIFI;
    }

    public void setHasWIFI(boolean hasWIFI) {
        if(hasWIFI==true){this.hasWIFI = "Oui";
        }else {this.hasWIFI = "Non";}
    }

    public String isHasPhone() {
        return hasPhone;
    }

    public void setHasPhone(boolean hasPhone) {
        if(hasPhone==true){this.hasPhone = "Oui";
        }else {this.hasPhone = "Non";}
    }
    
    public double PriceConsomationJ(Chambre Ch){
        
        if(Ch.isHasPhone().equals("Oui")){
            prix_ch=prix_ch+500;
        }
        if(Ch.isHasTV().equals("Oui")){
            prix_ch=prix_ch+500;
        }
        if(Ch.isHasWIFI().equals("Oui")){
            prix_ch=prix_ch+500;
        }
        return prix_ch;
    }
    
    public double PriceCHJ(String Type){
        if(Type.equals("individuelle")){
            prix_ch=prix_ch+3000;
        }else if(Type.equals("a deux")){
             prix_ch=prix_ch+5500;
        }else if(Type.equals("familiale")){
            prix_ch=prix_ch+9000;
        }
        return prix_ch;
    }
    
    @Override
    public String toString() {
        return "Chambre{" + "num_ch=" + num_ch + ", type_ch=" + type_ch + ", prix_ch=" + prix_ch + ", disponible=" + disponible + '}';
    }

    
    

}
