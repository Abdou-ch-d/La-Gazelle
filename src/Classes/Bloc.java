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
public class Bloc {
    private int num_b;
    private int nbr_b;
    
    //getters
    public int getNum_b() {
        return num_b;
    }

    public int getNbr_b() {
        return nbr_b;
    }

    public Bloc(int num_b, int nbr_b) {
        this.num_b = num_b;
        this.nbr_b = nbr_b;
    }
    
    //setters
    public void setNum_b(int num_b) {
        this.num_b = num_b;
    }

    public void setNbr_b(int nbr_b) {
        this.nbr_b = nbr_b;
    }

    @Override
    public String toString() {
        return "Bloc{" + "num_b=" + num_b + ", nbr_b=" + nbr_b + '}';
    }

}
