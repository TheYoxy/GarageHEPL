package Vehicules;

import Authenticate.Identifiable;

public abstract class Vehicule implements Identifiable{
    protected int nbRoue;
    protected int nbPlace;
    protected String id;

    protected Vehicule(int nbRoue, int nbPlace) {
        this.nbRoue = nbRoue;
        this.nbPlace = nbPlace;
    }
    public abstract String generateId();
}
