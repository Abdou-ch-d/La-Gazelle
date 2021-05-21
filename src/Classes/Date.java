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
public class Date {
    private int jour ;
    private int mois ;
    private int annee ;
    
    public Date() {
    
    }
    public Date(int jour , int mois , int annee){
        this.jour = jour ;
        this.mois = mois ;
        this.annee = annee ;
    }

    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    @Override
    public String toString() {
        return "Date{" + "jour=" + jour + ", mois=" + mois + ", annee=" + annee + '}';
    }
    
    public void afficherDate(){
        System.out.println(getJour()+" - "+getMois()+" - "+getAnnee());
    }
}
