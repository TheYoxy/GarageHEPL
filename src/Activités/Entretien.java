package Activités;

import People.Mecanicien;
import Vehicules.Voiture;

public class Entretien extends Travail {
    /**
     * @param car
     * @param travailleur
     * @param libelle
     * @param remarque
     */
    public Entretien(Voiture car, Mecanicien travailleur, String libelle, String remarque) {
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
