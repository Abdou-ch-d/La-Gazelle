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
public class Client {
    private String nom,prenom,adr;
    private int num_cl,tel ;
  

   
    
    public Client(){
        
    }

    public Client(int num,String nom, String prenom, int tel,String adr) {
        this.num_cl=num;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.adr=adr;
       
    }
    
    //getters
    
    public int getNum()
    {
        return num_cl;
    }
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getadr() {
        return adr;
    }

    public void setadr(String adr) {
        this.adr = adr;
    }

   


    public int getTel() {
        return tel;
    }

  
  
    
    //setters

    public void setNum(int num_cl){
        this.num_cl=num_cl;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    
    
    public void setTel(int tel) {
        this.tel = tel;
    }
    
    
    
    /*public void afficherClient(){
        System.out.println("Nom : "+getNom()+"\n Prenom : "+getPrenom()+"\n date de naissance : "+getDate_n().toString()+
                            "\n lieu de naissance : "+getLieu_n()+"\n numero piece d'identité : "
                            +getPiece_i()+"\n type piece d'identité : "+getType_i()+"\n email : "+getEmail()+
                            "\n telephone : "+getTel()+"\n nationalité : "+getNationalité());
    }

    @Override
    public String toString() {
        return "Client{" + "nom=" + nom + ", prenom=" + prenom + ", date_n=" + getDate_n().toString() + ", lieu_n=" + lieu_n + ", piece_i=" + piece_i + ", type_i=" + type_location + ", email=" + email + ", tel=" + tel + ", nationalit\u00e9=" + nationalité + '}';
    }*/

   
    
    
}
