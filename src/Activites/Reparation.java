package Activites;

import People.Mecanicien;
import Vehicules.Voiture;

public class Reparation extends Travail {

    /**
     * @param car
     * @param travailleur
     * @param libelle
     * @param remarque
     */
    public Reparation(Voiture car, Mecanicien travailleur, String libelle, String remarque) {
        super(car, travailleur, libelle, remarque);
    }

    /**
     * @param id
     */
    @Override
    public void setId(String id) {
        Id = id;
    }
}
