package Vehicules;

import Authenticate.Identifiable;

import java.io.Serializable;

public abstract class Vehicule implements Identifiable,Serializable{
    /**
     *
     */
    private int NbRoue;
    /**
     *
     */
    private int NbPlace;
    /**
     *
     */
    protected String Id;

    /**
     * @param nbRoue
     * @param nbPlace
     */
    protected Vehicule(int nbRoue, int nbPlace) {
        this.NbRoue = nbRoue;
        this.NbPlace = nbPlace;
    }

    /**
     * @return
     */
    public abstract String generateId();
}
