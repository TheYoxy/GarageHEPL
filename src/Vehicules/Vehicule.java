package Vehicules;

import Authenticate.Identifiable;

import java.io.Serializable;

public abstract class Vehicule implements Identifiable,Serializable{
    protected int nbRoue;
    protected int nbPlace;
    protected String id;

    protected Vehicule(int nbRoue, int nbPlace) {
        this.nbRoue = nbRoue;
        this.nbPlace = nbPlace;
    }
    public abstract String generateId();
}
