package Classes;

public class Facture {
    private double frais_chambre=0;
    private double frais_salle=0;
    private double frais_TEL=0;
    private double frais_WIFI=0; 
    private double frais_TV=0;
    private double Totale;
    private int id;
    private String Etat;

    public Facture() {
    }

    public Facture(int id,double frais_chambre, double frais_tel, double frais_WIFI,double frais_Tv,double tot,String Etat) {
        this.id=id;
        this.frais_chambre = frais_chambre;
        this.frais_TEL = frais_tel;
        this.frais_WIFI = frais_WIFI;
        this.frais_TV= frais_Tv;
        this.Totale=tot;
        this.Etat= Etat;
    }

    public Facture(int frais_salle) {
        this.frais_salle = frais_salle;
    }

    public double getFrais_chambre() {
        return frais_chambre;
    }

    public double getFrais_TEL() {
        return frais_TEL;
    }

    public double getFrais_WIFI() {
       
        return frais_WIFI;
    }

    public double getFrais_TV() {
        return frais_TV;
    }
    
    

    public double getFrais_salle() {
        return frais_salle;
    }

    public void setFrais_chambre(double frais_chambre) {
        this.frais_chambre = frais_chambre;
    }

    
    public void setFrais_salle(double frais_salle) {
        this.frais_salle = frais_salle;
    }
   
    public void setFrais_WIFI(double frais_rest) {
        this.frais_WIFI = frais_rest;
    }

    public void setFrais_TEL(double frais_TEL) {
        this.frais_TEL = frais_TEL;
    }

    public void setFrais_TV(double frais_TV) {
        this.frais_TV = frais_TV;
    }
    
    

    

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public double getTotale() {
        return Totale;
    }

    public void setTotale(double Totale) {
        this.Totale = Totale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
