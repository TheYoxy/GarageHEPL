package Activités;

import Authenticate.Identifiable;
import People.Mecanicien;
import Vehicules.Voiture;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public abstract class Travail implements Identifiable,Serializable{
    /**
     *
     */
    private Voiture Car;
    /**
     *
     */
    private Mecanicien Travailleur;
    /**
     *
     */
    protected String Id;
    /**
     *
     */
    private String Libelle;
    /**
     *
     */
    private String Remarque;

    /**
     * @param car
     * @param travailleur
     * @param libelle
     * @param remarque
     */
    protected Travail(Voiture car, Mecanicien travailleur, String libelle, String remarque) {
        Car = car;
        Travailleur = travailleur;
        Id = generateId();
        Libelle = libelle;
        Remarque = remarque;
    }

    /**
     * @return
     */
    @Override
    public String getId() {
        return Id;
    }

    /**
     * @return
     */
    public String getLibelle() {
        return Libelle;
    }

    /**
     * @return
     */
    public String getRemarque() {
        return Remarque;
    }

    /**
     * @return
     */
    public Voiture getCar() {
        return Car;
    }

    /**
     * @return
     */
    public Mecanicien getTravailleur() {
        return Travailleur;
    }

    /**
     * @return
     */
    @NotNull
    private String generateId()
    {
        return Car + Travailleur.toString() + Libelle + Remarque;
    }
}
