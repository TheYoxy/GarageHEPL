package Activités;

import Authenticate.Identifiable;
import People.Mecanicien;
import Vehicules.Voiture;

import java.io.Serializable;

public abstract class Travail implements Identifiable,Serializable{
    protected Voiture Car;
    protected Mecanicien Travailleur;
    protected String Id;
    protected String Libelle;
    protected String Remarque;

    protected Travail(Voiture car, Mecanicien travailleur, String libelle, String remarque) {
        Car = car;
        Travailleur = travailleur;
        Id = generateId();
        Libelle = libelle;
        Remarque = remarque;
    }

    @Override
    public String getId() {
        return Id;
    }

    public String getLibelle() {
        return Libelle;
    }

    public String getRemarque() {
        return Remarque;
    }

    public Voiture getCar() {
        return Car;
    }

    public Mecanicien getTravailleur() {
        return Travailleur;
    }

    public String generateId()
    {
        return Car + Travailleur.toString() + Libelle + Remarque;
    }
}
