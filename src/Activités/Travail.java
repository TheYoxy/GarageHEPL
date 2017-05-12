package Activités;

import Authenticate.Identifiable;
import People.Mecanicien;
import Vehicules.Voiture;

import java.io.Serializable;

public abstract class Travail implements Identifiable,Serializable{
    private Voiture _car;
    private Mecanicien _travailleur;
    protected String _id;
    private String _libelle;
    private String _remarque;

    protected Travail(Voiture car, Mecanicien travailleur, String libelle, String remarque) {
        _car = car;
        _travailleur = travailleur;
        _id = generateId();
        _libelle = libelle;
        _remarque = remarque;
    }

    @Override
    public String getId() {
        return _id;
    }

    public String getLibelle() {
        return _libelle;
    }

    public String getRemarque() {
        return _remarque;
    }

    public Voiture getCar() {
        return _car;
    }

    public Mecanicien getTravailleur() {
        return _travailleur;
    }

    public String generateId()
    {
        return _car + _travailleur.toString() + _libelle + _remarque;
    }
}
